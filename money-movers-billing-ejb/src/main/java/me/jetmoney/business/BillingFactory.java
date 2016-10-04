package me.jetmoney.business;

import me.jetmoney.billing.request.BillingRequest;
import me.jetmoney.dao.BankBicDAO;
import me.jetmoney.data.Service;
import me.jetmoney.entity.BankBic;
import me.jetmoney.processor.BaseInfoProcessor;
import me.jetmoney.processor.bta.BtaAccountProcessor;
import me.jetmoney.processor.capital.angarishi.CapitalAccountProcessor;
import me.jetmoney.processor.finca.FincaAccountProcessor;
import me.jetmoney.processor.ksb.KsbAccountProcessor;
import me.jetmoney.processor.procredit.ProCreditAccountProcessor;
import me.jetmoney.processor.tbc.TbcAccountProcessor;
import me.jetmoney.processor.vtb.VtbCardAccountProcessor;
import me.jetmoney.processor.vtb.VtbCurrentAccountProcessor;
import me.jetmoney.response.info.DefaultInfoResponse;
import me.jetmoney.response.info.bta.BtaInfoResponse;
import me.jetmoney.response.info.capital.angarishi.CapitalInfoResponse;
import me.jetmoney.response.info.finca.FincaInfoResponse;
import me.jetmoney.response.info.ksb.KsbInfoResponse;
import me.jetmoney.response.info.procredit.ProCreditInfoResponse;
import me.jetmoney.response.info.tbc.TbcInfoResponse;
import me.jetmoney.response.info.vtb.card.VtbCardInfoResponse;
import me.jetmoney.response.info.vtb.current.VtbCurrentInfoResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.text.ParseException;
import java.util.Date;


/**
 * Created by toroptsev on 20.09.16.
 */
@Stateless
public class BillingFactory {

    @Inject
    private Logger logger;

    @EJB
    private BankBicDAO bankBicDAO;


    public String getServiceSubId(BillingRequest request) {
        Service service = Service.getById(request.getService());
        if (service == null) {
            logger.info("Failed to find service with id " + request.getService());
            return "0";
        }

        if (service == Service.LIBERTY_BANK_OUT) {
            BankBic bankBic = bankBicDAO.findByCode( StringUtils.substring(request.getUser(), 4, 6) );
            if(bankBic == null || bankBic.getBankBic() == null) {
                logger.error("ServiceSubId: not found BIC for user=" + request.getUser());
                return "0";
            }
            return bankBic.getBankBic();
        }

        if (service == Service.LIBERTY_BANK_IN) {
            return request.getServiceSubId();
        }

        if (request.getServiceSubId() == null) {
            return "0";
        }

        String pattern;
        switch (service) {
            case CAPITAL_BANK_MIMDINARE_ANGARISHI:
            case CAPITAL_BANK_SABARATE_ANGARISHI: pattern = "yyyy-MM-dd";
                break;
            case BASIS_BANK_ACCOUNT:
            case TBC_BANK_ACCOUNT:
            case BTA_ACCOUNT:
            case FINCA_BANK_ACCOUNT:
            case KSB_BANK:
            case PRO_CREDIT_BANK_ACCOUNT:
            case VTB_CARD_ACCOUNT:
            case VTB_CURRENT_ACCOUNT:
            default: pattern = "dd/MM/yyyy";
        }

        try {
            Date date = DateUtils.parseDate(request.getServiceSubId(), "yyyy-MM-dd");
            return DateFormatUtils.format(date, pattern);
        } catch (ParseException e) {
            logger.error("Failed to parse date in service_sub_id: " + e.getMessage());
        }

        return "0";
    }


    public Class<?> getResponseClass(String serviceId) {
        Service service = Service.getById(serviceId);
        if (service == null) {
            logger.warn("Failed to find service with id " + serviceId);
            return DefaultInfoResponse.class;
        }

        switch (service) {
            case TBC_BANK_ACCOUNT: return TbcInfoResponse.class;
            case BTA_ACCOUNT: return BtaInfoResponse.class;
            case FINCA_BANK_ACCOUNT: return FincaInfoResponse.class;
            case CAPITAL_BANK_MIMDINARE_ANGARISHI:
            case CAPITAL_BANK_SABARATE_ANGARISHI: return CapitalInfoResponse.class;
            case KSB_BANK: return KsbInfoResponse.class;
            case PRO_CREDIT_BANK_ACCOUNT: return ProCreditInfoResponse.class;
            case VTB_CARD_ACCOUNT: return VtbCardInfoResponse.class;
            case VTB_CURRENT_ACCOUNT: return VtbCurrentInfoResponse.class;
            default: return DefaultInfoResponse.class;
        }
    }


    public BaseInfoProcessor getBankResponseHandler(String serviceId) {
        Service service = Service.getById(serviceId);
        if (service == null) {
            logger.warn("Failed to find service with id " + serviceId);
            return null;
        }

        switch (service) {
            case TBC_BANK_ACCOUNT: return new TbcAccountProcessor();
            case BTA_ACCOUNT: return new BtaAccountProcessor();
            case FINCA_BANK_ACCOUNT: return new FincaAccountProcessor();
            case CAPITAL_BANK_MIMDINARE_ANGARISHI:
            case CAPITAL_BANK_SABARATE_ANGARISHI: return new CapitalAccountProcessor();
            case KSB_BANK: return new KsbAccountProcessor();
            case PRO_CREDIT_BANK_ACCOUNT: return new ProCreditAccountProcessor();
            case VTB_CARD_ACCOUNT: return new VtbCardAccountProcessor();
            case VTB_CURRENT_ACCOUNT: return new VtbCurrentAccountProcessor();
            default: return null;
        }
    }
}
