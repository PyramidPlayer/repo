package me.jetmoney.response.info.vtb.card;

import me.jetmoney.response.info.BaseInfoResponse;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by toroptsev on 29.09.16.
 */
@XmlRootElement(name = "result")
public class VtbCardInfoResponse extends BaseInfoResponse {

    @XmlElement(name = "data")
    private VtbCardData data;

    @Override
    public VtbCardData getData() {
        return data;
    }

    public void setData(VtbCardData data) {
        this.data = data;
    }
}
