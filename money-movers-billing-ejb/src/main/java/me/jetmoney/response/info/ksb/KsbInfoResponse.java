package me.jetmoney.response.info.ksb;

import me.jetmoney.response.info.BaseInfoResponse;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by toroptsev on 29.09.16.
 */
@XmlRootElement(name = "result")
public class KsbInfoResponse extends BaseInfoResponse {

    @XmlElement(name = "data")
    private KsbData data;

    @Override
    public KsbData getData() {
        return data;
    }

    public void setData(KsbData data) {
        this.data = data;
    }
}
