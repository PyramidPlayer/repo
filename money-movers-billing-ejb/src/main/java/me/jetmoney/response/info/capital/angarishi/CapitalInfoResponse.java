package me.jetmoney.response.info.capital.angarishi;

import me.jetmoney.response.info.BaseInfoResponse;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by toroptsev on 27.09.16.
 */
@XmlRootElement(name = "result")
public class CapitalInfoResponse extends BaseInfoResponse {

    @XmlElement(name = "data")
    private CapitalData data;

    @Override
    public CapitalData getData() {
        return data;
    }

    public void setData(CapitalData data) {
        this.data = data;
    }
}
