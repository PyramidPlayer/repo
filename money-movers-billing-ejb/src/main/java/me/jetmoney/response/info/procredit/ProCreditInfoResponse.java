package me.jetmoney.response.info.procredit;

import me.jetmoney.response.info.BaseInfoResponse;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by toroptsev on 29.09.16.
 */
@XmlRootElement(name = "result")
public class ProCreditInfoResponse extends BaseInfoResponse {

    @XmlElement(name = "data")
    private ProCreditData data;

    @Override
    public ProCreditData getData() {
        return data;
    }

    public void setData(ProCreditData data) {
        this.data = data;
    }
}
