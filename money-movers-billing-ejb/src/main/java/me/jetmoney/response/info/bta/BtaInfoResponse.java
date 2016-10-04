package me.jetmoney.response.info.bta;

import me.jetmoney.response.info.BaseInfoResponse;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by toroptsev on 21.09.16.
 */
@XmlRootElement(name = "result")
public class BtaInfoResponse extends BaseInfoResponse {

    @XmlElement
    private BtaData data;

    public BtaData getData() {
        return data;
    }

    public void setData(BtaData data) {
        this.data = data;
    }
}
