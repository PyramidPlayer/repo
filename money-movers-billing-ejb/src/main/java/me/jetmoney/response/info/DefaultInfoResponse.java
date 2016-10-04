package me.jetmoney.response.info;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by toroptsev on 21.09.16.
 */
@XmlRootElement(name = "result")
public class DefaultInfoResponse extends BaseInfoResponse {

    @XmlElement(name = "data")
    private BaseData data;

    public BaseData getData() {
        return data;
    }

    public void setData(BaseData data) {
        this.data = data;
    }
}
