package me.jetmoney.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by vk on 15.09.16.
 */
@XmlRootElement(name = "amount")
@XmlAccessorType(XmlAccessType.FIELD)
public class BillingAmount implements Serializable {

    @XmlElement(name = "gel")
    private String gel;

    public String getGel() {
        return gel;
    }

    public void setGel(String gel) {
        this.gel = gel;
    }

    @Override
    public String toString() {
        return "ClassPojo [gel = " + gel + "]";
    }

}
