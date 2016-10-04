package me.jetmoney.response.info.finca;

import me.jetmoney.response.info.BaseInfoResponse;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by toroptsev on 27.09.16.
 */
@XmlRootElement(name = "result")
public class FincaInfoResponse extends BaseInfoResponse {

    @XmlElement(name = "data")
    private FincaData data;

    @Override
    public FincaData getData() {
        return data;
    }

    public void setData(FincaData data) {
        this.data = data;
    }
}
