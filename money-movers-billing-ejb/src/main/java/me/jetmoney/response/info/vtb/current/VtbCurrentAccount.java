package me.jetmoney.response.info.vtb.current;

import me.jetmoney.response.info.vtb.BaseVtbAccount;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by toroptsev on 29.09.16.
 */
@XmlRootElement
public class VtbCurrentAccount extends BaseVtbAccount {

    @XmlElement(name = "accountname")
    private String accountName;

    @XmlElement(name = "accountnumber")
    private String accountNumber;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getDescription() {
        return accountNumber + " " + accountName;
    }
}
