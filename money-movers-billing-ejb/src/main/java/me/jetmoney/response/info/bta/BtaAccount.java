package me.jetmoney.response.info.bta;

import javax.xml.bind.annotation.*;

/**
 * Created by toroptsev on 20.09.16.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class BtaAccount {

    @XmlValue
    private String content;

    @XmlAttribute(name = "full")
    private String full;

    public String getContent ()
    {
        return content;
    }

    public void setContent (String content)
    {
        this.content = content;
    }

    public String getFull ()
    {
        return full;
    }

    public void setFull (String full)
    {
        this.full = full;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [content = "+content+", full = "+full+"]";
    }
}
