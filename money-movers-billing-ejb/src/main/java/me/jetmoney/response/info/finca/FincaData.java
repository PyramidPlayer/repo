package me.jetmoney.response.info.finca;

import me.jetmoney.response.info.BaseData;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by toroptsev on 27.09.16.
 */
@XmlRootElement
public class FincaData extends BaseData {

    @XmlElement(name = "userinfo")
    private String userInfo;

    @XmlElement(name = "canpay")
    private String canPay;

    @XmlElement(name = "accountList")
    private FincaAccountList accountList;

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

    public FincaAccountList getAccountList() {
        return accountList;
    }

    public void setAccountList(FincaAccountList accountList) {
        this.accountList = accountList;
    }
}
