package me.jetmoney.response.info.bta;

import me.jetmoney.response.info.BaseData;

import javax.xml.bind.JAXB;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.StringWriter;

/**
 * Created by toroptsev on 20.09.16.
 */
@XmlRootElement(name = "data")
public class BtaData extends BaseData {

    @XmlElement(name = "accounts")
    private BtaAccounts accounts;

    @XmlElement(name = "canpay")
    private String canPay;

    @XmlElement(name = "userinfo")
    private String userInfo;

    public BtaAccounts getAccounts ()
    {
        return accounts;
    }

    public void setAccounts (BtaAccounts accounts)
    {
        this.accounts = accounts;
    }

    public String getCanPay ()
    {
        return canPay;
    }

    public void setCanPay (String canPay)
    {
        this.canPay = canPay;
    }

    public String getUserInfo()
    {
        return userInfo;
    }

    public void setUserInfo(String userInfo)
    {
        this.userInfo = userInfo;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [accounts = "+accounts+", canpay = "+canPay+", userInfo = "+ userInfo +"]";
    }

    public static void main(String[] args) {
        BtaData d = new BtaData();
        d.userInfo = "ხარაძე გიორგი";
        d.canPay = "1";
        d.setNationalRate("1");
        d.setRate("1");
        d.setCurrency("GEL");
        d.setGeneratedAmount("5");
        d.accounts = new BtaAccounts();

        d.accounts.setAccount(new BtaAccount[2]);

        d.accounts.getAccount()[0] = new BtaAccount();
        d.accounts.getAccount()[0].setFull("GE06BT0360000267110002GEL");
        d.accounts.getAccount()[0].setContent("******************0002GEL");

        d.accounts.getAccount()[1] = new BtaAccount();
        d.accounts.getAccount()[1].setFull("GE06BT0360000267110002USD");
        d.accounts.getAccount()[1].setContent("******************0002USD");



        StringWriter sw = new StringWriter();
        JAXB.marshal(d, sw);
        System.out.println(sw.toString());
    }
}
