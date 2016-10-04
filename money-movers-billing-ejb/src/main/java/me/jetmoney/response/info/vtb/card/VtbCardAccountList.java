package me.jetmoney.response.info.vtb.card;

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
public class VtbCardAccountList implements Serializable {

    @XmlElement(name = "account")
    private VtbCardAccount[] accounts;

    public VtbCardAccount[] getAccounts() {
        return accounts;
    }

    public void setAccounts(VtbCardAccount[] accounts) {
        this.accounts = accounts;
    }
}
