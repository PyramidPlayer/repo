package me.jetmoney.response.info.ksb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by toroptsev on 29.09.16.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class KsbAccount implements Serializable {

    @XmlElement
    private String accountId;

    @XmlElement
    private String account;

    @XmlElement
    private String currency;

    @XmlElement
    private String type;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
