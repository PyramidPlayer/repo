package me.jetmoney.response.info.tbc;

import me.jetmoney.response.info.BaseData;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by toroptsev on 27.09.16.
 */
@XmlRootElement
public class TbcData extends BaseData {

    @XmlElement(name = "acc_num")
    private TbcAccNum[] accNumList;

    @XmlElement(name = "desc")
    private TbcDesc[] descList;

    @XmlElement(name = "can_pay")
    private String canPay;

    @XmlElement(name = "client")
    private String client;

    public TbcAccNum[] getAccNumList() {
        return accNumList;
    }

    public void setAccNumList(TbcAccNum[] accNumList) {
        this.accNumList = accNumList;
    }

    public TbcDesc[] getDescList() {
        return descList;
    }

    public void setDescList(TbcDesc[] descList) {
        this.descList = descList;
    }

    public String getCanPay() {
        return canPay;
    }

    public void setCanPay(String canPay) {
        this.canPay = canPay;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }
}
