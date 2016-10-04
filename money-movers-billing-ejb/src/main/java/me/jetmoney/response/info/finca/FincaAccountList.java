package me.jetmoney.response.info.finca;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by toroptsev on 27.09.16.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class FincaAccountList implements Serializable {

    @XmlElement(name = "account")
    private FincaAccount[] accounts;

    public FincaAccount[] getAccounts() {
        return accounts;
    }

    public void setAccounts(FincaAccount[] accounts) {
        this.accounts = accounts;
    }
}
