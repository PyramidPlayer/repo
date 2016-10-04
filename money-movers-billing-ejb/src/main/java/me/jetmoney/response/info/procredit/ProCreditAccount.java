package me.jetmoney.response.info.procredit;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

/**
 * Created by toroptsev on 29.09.16.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ProCreditAccount implements Serializable {

    @XmlAttribute(name = "currency")
    private String currency;

    @XmlValue
    private String content;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
