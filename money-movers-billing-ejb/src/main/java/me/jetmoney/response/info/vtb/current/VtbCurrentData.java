package me.jetmoney.response.info.vtb.current;

import me.jetmoney.response.info.vtb.BaseVtbData;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by toroptsev on 29.09.16.
 */
@XmlRootElement
public class VtbCurrentData extends BaseVtbData {

    @XmlElement(name = "accounts")
    private VtbCurrentAccountList accountList;

    public VtbCurrentAccountList getAccountList() {
        return accountList;
    }

    public void setAccountList(VtbCurrentAccountList accountList) {
        this.accountList = accountList;
    }
}
