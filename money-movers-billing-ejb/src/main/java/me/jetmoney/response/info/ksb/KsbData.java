package me.jetmoney.response.info.ksb;

import me.jetmoney.response.info.BaseData;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by toroptsev on 29.09.16.
 */
@XmlRootElement
public class KsbData extends BaseData {

    @XmlElement(name = "accounts")
    private KsbAccountList accountList;

    @XmlElement(name = "client")
    private String client;

    public KsbAccountList getAccountList() {
        return accountList;
    }

    public void setAccountList(KsbAccountList accountList) {
        this.accountList = accountList;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }
}
