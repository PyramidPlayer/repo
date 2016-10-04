package me.jetmoney.response.info;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by vk on 15.09.16.
 */
@XmlRootElement(name = "date")
@XmlAccessorType(XmlAccessType.FIELD)
public class BaseData implements Serializable {

    @XmlElement(name = "RATE")
    private String rate;

    @XmlElement(name = "NationalRate")
    private String nationalRate;

    @XmlElement(name = "CURRENCY")
    private String currency;

    @XmlElement(name = "GENERATED_AMOUNT")
    private String generatedAmount;

    public String getRate()
    {
        return rate;
    }

    public void setRate(String rate)
    {
        this.rate = rate;
    }

    public String getNationalRate ()
    {
        return nationalRate;
    }

    public void setNationalRate (String NationalRate)
    {
        this.nationalRate = NationalRate;
    }

    public String getCurrency()
    {
        return currency;
    }

    public void setCurrency(String currency)
    {
        this.currency = currency;
    }

    public String getGeneratedAmount()
    {
        return generatedAmount;
    }

    public void setGeneratedAmount(String generatedAmount)
    {
        this.generatedAmount = generatedAmount;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [rate = "+ rate +", nationalRate = "+ nationalRate +", currency = "+ currency +", generatedAmount = "+ generatedAmount +"]";
    }

}
