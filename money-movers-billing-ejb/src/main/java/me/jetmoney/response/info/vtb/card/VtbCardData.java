package me.jetmoney.response.info.vtb.card;

import me.jetmoney.response.info.vtb.BaseVtbData;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by toroptsev on 29.09.16.
 */
@XmlRootElement
public class VtbCardData extends BaseVtbData {

    @XmlElement(name = "accounts")
    private VtbCardAccountList accountList;

    public VtbCardAccountList getAccountList() {
        return accountList;
    }

    public void setAccountList(VtbCardAccountList accountList) {
        this.accountList = accountList;
    }
}
