package me.jetmoney.response.info.vtb.current;

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
public class VtbCurrentAccountList implements Serializable {

    @XmlElement(name = "account")
    private VtbCurrentAccount[] accounts;

    public VtbCurrentAccount[] getAccounts() {
        return accounts;
    }

    public void setAccounts(VtbCurrentAccount[] accounts) {
        this.accounts = accounts;
    }
}
