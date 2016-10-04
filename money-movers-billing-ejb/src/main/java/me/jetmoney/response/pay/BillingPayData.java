package me.jetmoney.response.pay;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by vk on 15.09.16.
 */

@XmlRootElement(name = "data")
@XmlAccessorType(XmlAccessType.FIELD)
public class BillingPayData {

    @XmlElement(name = "RATE")
    private String rate;

    @XmlElement(name = "CURRENCY")
    private String currency;

    @XmlElement(name = "avance")
    private String avance;

    @XmlElement(name = "GENERATED_AMOUNT")
    private String generatedAmount;

    @XmlElement(name = "date")
    private String date;

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAvance() {
        return avance;
    }

    public void setAvance(String avance) {
        this.avance = avance;
    }

    public String getGeneratedAmount() {
        return generatedAmount;
    }

    public void setGeneratedAmount(String generatedAmount) {
        this.generatedAmount = generatedAmount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ClassPojo [rate = " + rate + ", currency = " + currency + ", avance = " + avance + ", generatedAmount = " + generatedAmount + ", date = " + date + "]";
    }

}
