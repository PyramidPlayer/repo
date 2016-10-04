package me.jetmoney.business;

import com.jetmoney.common.model.core.JetMoneyResponse;
import com.jetmoney.common.model.core.JetMoneyResponseCode;
import me.jetmoney.billing.request.BillingRequest;
import me.jetmoney.billing.response.PayResponse;
import me.jetmoney.data.Service;
import me.jetmoney.processor.BaseInfoProcessor;
import me.jetmoney.processor.basis.BasisBankInfoProcessor;
import me.jetmoney.request.MoneyMoversRequest;
import me.jetmoney.response.info.BaseInfoResponse;
import me.jetmoney.response.pay.BillingPayResponse;
import me.jetmoney.util.DateFormats;
import me.jetmoney.util.HashUtils;
import me.jetmoney.util.QueryBuilder;
import me.jetmoney.util.SystemProperty;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.http.HttpHost;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.SchemePortResolver;
import org.apache.http.conn.UnsupportedSchemeException;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.net.ssl.SSLContext;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.ParseException;
import java.util.Date;

/**
 * Created by toroptsev on 19.09.16.
 */
@Stateless
public class BillingBusiness {

    private static final String INFO_PAGE = "/info.php";
    private static final String PAY_PAGE = "/pay.php";

    @EJB
    private BillingFactory factory;

    @Inject
    private Logger logger;

    @Inject
    @SystemProperty("money.movers.url")
    private String serviceUrl;

    @Inject
    @SystemProperty("money.movers.port")
    private String servicePort;

    @Inject
    @SystemProperty("money.movers.secret")
    private String secret;

    @Inject
    @SystemProperty("money.movers.agent")
    private String agent;

    public JetMoneyResponse info(BillingRequest request) {
        try {
            // Basis Bank обрабатываем по-особенному, потому что он не возвращает список счетов
            if (Service.BASIS_BANK_ACCOUNT.getServiceId().equals(request.getService())) {
                BasisBankInfoProcessor infoProcessor = new BasisBankInfoProcessor();
                return new JetMoneyResponse<>(infoProcessor.process(request.getAmount()));
            }

            MoneyMoversRequest moneyMoversRequest = prepareMoneyMoversRequest(request);
            logger.info(moneyMoversRequest.toString());
            String url = getBaseUrl() + INFO_PAGE + QueryBuilder.getQueryString(moneyMoversRequest);
            logger.info(url);

            Class<?> responseClass = factory.getResponseClass(request.getService());
            JetMoneyResponse<BaseInfoResponse> response = (JetMoneyResponse<BaseInfoResponse>) call(url, responseClass);

            if (response.isSuccess()) {
                if ("0".equals(response.getResponseBody().getError().getErrorCode())) {
                    BaseInfoProcessor accountHandler = factory.getBankResponseHandler(request.getService());
                    if (accountHandler != null) {
                        return new JetMoneyResponse<>(accountHandler.process(response.getResponseBody()));
                    }
                } else {
                    response.setResponseCode(JetMoneyResponseCode.FAIL);
                    response.setResponseMessage(response.getResponseBody().getError().getErrorEn());
                }
            }

            return response;
        } catch (Exception e) {
            logger.error("Fail to process info request", e);
            return new JetMoneyResponse(JetMoneyResponseCode.FAIL, e.getMessage());
        }
    }


    public JetMoneyResponse pay(BillingRequest request) {
        try {
            MoneyMoversRequest moneyMoversRequest = prepareMoneyMoversRequest(request);
            logger.info(moneyMoversRequest.toString());
            String url = getBaseUrl() + PAY_PAGE + QueryBuilder.getQueryString(moneyMoversRequest);
            logger.info(url);

            JetMoneyResponse<BillingPayResponse> response = call(url, BillingPayResponse.class);

            if (response.isSuccess()) {
                if ("0".equals(response.getResponseBody().getError().getErrorCode())) {
                    String operationId = response.getResponseBody().getOperationid();
                    return new JetMoneyResponse<>(new PayResponse(operationId));
                } else {
                    response.setResponseCode(JetMoneyResponseCode.FAIL);
                    response.setResponseMessage(response.getResponseBody().getError().getErrorEn());
                }
            }

            return response;
        } catch (Exception e) {
            logger.error("Failed to process pay request", e);
            return new JetMoneyResponse(JetMoneyResponseCode.FAIL, e.getMessage());
        }
    }


    private String getBaseUrl() {
        String baseUrl = serviceUrl;
        if (StringUtils.isNotBlank(servicePort)) {
            baseUrl += ":" + servicePort;
        }
        return baseUrl;
    }


    private int getPort() {
        if (StringUtils.isNoneBlank(servicePort) && StringUtils.isNumeric(servicePort)) {
            return Integer.parseInt(servicePort);
        }
        return 80;
    }


    private <T> JetMoneyResponse<T> call(String url, Class<T> resultClass) {
        JetMoneyResponse<T> jetMoneyResponse = new JetMoneyResponse<>();

        HttpGet httpGet = new HttpGet(url);

        CloseableHttpClient httpClient = prepareCloseableHttpClient();
        if (httpClient == null) {
            return new JetMoneyResponse<>(JetMoneyResponseCode.FAIL, "Internal error");
        }

        try {

            CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            logger.info("statusCode: " + statusCode);
            String entity = EntityUtils.toString(httpResponse.getEntity());
            logger.info(entity);
            jetMoneyResponse.setResponseCode(isValidResponse(statusCode) ? JetMoneyResponseCode.SUCCESS : JetMoneyResponseCode.FAIL);

            try {

                JAXBContext jaxbContext = JAXBContext.newInstance(resultClass);
                Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

                T billingResponse = (T) unmarshaller.unmarshal(new StringReader(entity));

                logger.info(billingResponse.toString());
                jetMoneyResponse.setResponseBody(billingResponse);

            } catch (JAXBException e) {
                logger.error("Failed to parse xml", e);
            }

        } catch (Exception e) {
            logger.error("Failed to send request to " + url, e);
            jetMoneyResponse.setResponseCode(JetMoneyResponseCode.FAIL);
            jetMoneyResponse.setResponseMessage(e.getMessage());
        }
        return jetMoneyResponse;
    }


    private CloseableHttpClient prepareCloseableHttpClient() {
        SSLContext sslContext;
        try {
            sslContext = SSLContextBuilder.create().loadTrustMaterial(TrustSelfSignedStrategy.INSTANCE).build();
        } catch (NoSuchAlgorithmException | KeyStoreException | KeyManagementException e) {
            logger.error("Failed to create SSL context", e);
            return null;
        }
        SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE);
        return HttpClientBuilder.create().setSSLSocketFactory(csf).setSchemePortResolver(host -> getPort()).build();
    }


    private boolean isValidResponse(int statusCode) {
        return statusCode >= 200 && statusCode < 300;
    }


    private MoneyMoversRequest prepareMoneyMoversRequest(BillingRequest request) {
        MoneyMoversRequest moneyMoversRequest = new MoneyMoversRequest();

        moneyMoversRequest.setId(request.getId());
        moneyMoversRequest.setAgent(agent);
        moneyMoversRequest.setService(request.getService());
        moneyMoversRequest.setServiceSubId(factory.getServiceSubId(request));
        if (request.getServiceSecondSubId() != null) {
            moneyMoversRequest.setServiceSecondSubId(request.getServiceSecondSubId());
        }
        moneyMoversRequest.setUser(request.getUser());
        moneyMoversRequest.setAmount(request.getAmount().toString());

        try {
            Date date = DateUtils.parseDate(request.getDate(), DateFormats.JETMONEY_DATETIME_FORMAT);
            moneyMoversRequest.setDate(DateFormatUtils.format(date, DateFormats.MONEY_MOVERS_DATETIME_FORMAT));
        } catch (ParseException e) {
            logger.error("Failed to parse date", e);
        }

        // always 0
        moneyMoversRequest.setCanal("0");

        moneyMoversRequest.setHash(HashUtils.calc(moneyMoversRequest, secret));
        return moneyMoversRequest;
    }
}
