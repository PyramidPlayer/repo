package me.jetmoney.response.info.procredit;

import me.jetmoney.response.info.BaseData;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by toroptsev on 29.09.16.
 */
@XmlRootElement
public class ProCreditData extends BaseData { // TODO возможно он не наследует тех полей!!!

    @XmlElement(name = "account")
    private ProCreditAccount[] accounts;

    @XmlElement(name = "userInfo")
    private String userInfo;

    @XmlElement(name = "can_pay")
    private String canPay;

    @XmlElement(name = "session_id")
    private String sessionId;

    public ProCreditAccount[] getAccounts() {
        return accounts;
    }

    public void setAccounts(ProCreditAccount[] accounts) {
        this.accounts = accounts;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    public String getCanPay() {
        return canPay;
    }

    public void setCanPay(String canPay) {
        this.canPay = canPay;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
