package me.jetmoney.response.info.vtb.current;

import me.jetmoney.response.info.BaseInfoResponse;
import me.jetmoney.response.info.vtb.BaseVtbData;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by toroptsev on 29.09.16.
 */
@XmlRootElement(name = "result")
public class VtbCurrentInfoResponse extends BaseInfoResponse {

    @XmlElement(name = "data")
    private VtbCurrentData data;

    @Override
    public VtbCurrentData getData() {
        return data;
    }

    public void setData(VtbCurrentData data) {
        this.data = data;
    }
}
