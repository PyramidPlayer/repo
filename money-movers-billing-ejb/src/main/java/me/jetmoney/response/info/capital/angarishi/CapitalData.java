package me.jetmoney.response.info.capital.angarishi;

import me.jetmoney.response.info.BaseData;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by toroptsev on 20.09.16.
 */
@XmlRootElement
public class CapitalData extends BaseData {

    @XmlElement(name = "account")
    private CapitalAccount[] accounts;

    @XmlElement(name = "clientInfo")
    private String clientInfo;

    public CapitalAccount[] getAccounts ()
    {
        return accounts;
    }

    public void setAccounts (CapitalAccount[] accounts)
    {
        this.accounts = accounts;
    }

    public String getClientInfo ()
    {
        return clientInfo;
    }

    public void setClientInfo (String clientInfo)
    {
        this.clientInfo = clientInfo;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [rate = "+ getRate() +", nationalRate = "+ getNationalRate() +", currency = "+ getCurrency() +", generatedAmount = "+ getGeneratedAmount() +", account = "+ accounts + ", clientInfo = "+clientInfo+"]";
    }

//    public static void main(String[] args) {
//        CapitalData d = new CapitalData();
//        d.clientInfo = "ხარაძე გიორგი";
//        d.nationalRate = "1";
//        d.rate = "1";
//        d.currency = "GEL";
//        d.generatedAmount = "5";
//        d.accounts = new CapitalAccount[2];
//
//        d.accounts[0] = new CapitalAccount();
//        d.accounts[0].setId("3");
//        d.accounts[0].setAccountName("*******************041");
//        d.accounts[0].setAccountType("მიმდინარე");
//        d.accounts[0].setAccountCurrency("GEL");
//        d.accounts[0].setAccountAddress("ს.ს. \"კაპიტალ ბანკი\"");
//        d.accounts[0].setAccountID("GE61IN0000000003601041");
//        d.accounts[0].setCommercialRate("1.0000");
//
//        d.accounts[1] = new CapitalAccount();
//        d.accounts[1].setId("4");
//        d.accounts[1].setAccountName("*******************901");
//        d.accounts[1].setAccountType("MasterCard Gold");
//        d.accounts[1].setAccountCurrency("GEL");
//        d.accounts[1].setAccountAddress("ს.ს. \"კაპიტალ ბანკი\"");
//        d.accounts[1].setAccountID("GE63IN0036910000016901");
//        d.accounts[1].setCommercialRate("1.0000");
//
//        StringWriter sw = new StringWriter();
//        JAXB.marshal(d, sw);
//        System.out.println(sw.toString());
//    }
}
