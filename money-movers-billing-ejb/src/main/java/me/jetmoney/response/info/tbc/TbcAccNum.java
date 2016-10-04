package me.jetmoney.response.info.tbc;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

/**
 * Created by toroptsev on 27.09.16.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class TbcAccNum implements Serializable {

    @XmlAttribute(name = "id")
    private String id;

    @XmlValue
    private String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
