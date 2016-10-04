package me.jetmoney.response.info.finca;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

/**
 * Created by toroptsev on 27.09.16.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class FincaAccount implements Serializable {

    @XmlAttribute(name = "value")
    private String value;

    @XmlValue
    private String content;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
