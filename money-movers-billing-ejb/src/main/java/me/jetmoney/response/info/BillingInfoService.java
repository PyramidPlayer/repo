package me.jetmoney.response.info;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by vk on 15.09.16.
 */
@XmlRootElement(name = "service")
@XmlAccessorType(XmlAccessType.FIELD)
public class BillingInfoService implements Serializable {

    @XmlElement(name = "min_amount")
    private String minAmount;

    @XmlElement(name = "max_amount")
    private String maxAmount;

    @XmlElement(name = "currency")
    private String currency;

    public String getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(String minAmount) {
        this.minAmount = minAmount;
    }

    public String getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(String max_amount) {
        this.maxAmount = max_amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "ClassPojo [min_amount = " + minAmount + ", max_amount = " + maxAmount + ", currency = " + currency + "]";
    }

}
