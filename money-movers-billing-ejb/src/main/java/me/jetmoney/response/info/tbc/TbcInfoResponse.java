package me.jetmoney.response.info.tbc;

import me.jetmoney.response.info.BaseInfoResponse;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by toroptsev on 27.09.16.
 */
@XmlRootElement(name = "result")
public class TbcInfoResponse extends BaseInfoResponse {

    @XmlElement
    private TbcData data;

    public TbcData getData() {
        return data;
    }

    public void setData(TbcData data) {
        this.data = data;
    }
}
