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
public class KsbAccountList implements Serializable {

    @XmlElement(name = "account")
    private KsbAccount[] accounts;

    public KsbAccount[] getAccounts() {
        return accounts;
    }

    public void setAccounts(KsbAccount[] accounts) {
        this.accounts = accounts;
    }
}
