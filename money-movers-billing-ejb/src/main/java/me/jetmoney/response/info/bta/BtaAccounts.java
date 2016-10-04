package me.jetmoney.response.info.bta;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by toroptsev on 20.09.16.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class BtaAccounts {

    @XmlElement(name = "account")
    private BtaAccount[] account;

    public BtaAccount[] getAccount ()
    {
        return account;
    }

    public void setAccount (BtaAccount[] account)
    {
        this.account = account;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [account = "+account+"]";
    }
}
