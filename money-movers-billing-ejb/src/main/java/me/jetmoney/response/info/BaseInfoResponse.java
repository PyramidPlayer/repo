package me.jetmoney.response.info;

import me.jetmoney.response.BillingAmount;
import me.jetmoney.response.BillingError;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;

/**
 * Created by vk on 15.09.16.
 */

//@XmlRootElement(name = "result")
@XmlAccessorType(XmlAccessType.FIELD)
public class BaseInfoResponse implements Serializable {

    @XmlElement(name = "amount")
    private BillingAmount amount;

    @XmlElement(name = "error")
    private BillingError error;

    @XmlElement(name = "avance")
    private String avance;

    @XmlElement(name = "service")
    private BillingInfoService[] service;

    @XmlElement(name = "accoutant")
    private BillingInfoAccoutant accoutant;

    @XmlElement(name = "operationStatus")
    private String operationStatus;

    @XmlElement(name = "user")
    private String user;

    public BillingAmount getAmount ()
    {
        return amount;
    }

    public void setAmount (BillingAmount amount)
    {
        this.amount = amount;
    }

    public BillingError getError ()
    {
        return error;
    }

    public void setError (BillingError error)
    {
        this.error = error;
    }

    public String getAvance ()
    {
        return avance;
    }

    public void setAvance (String avance)
    {
        this.avance = avance;
    }

    public BillingInfoService[] getService ()
    {
        return service;
    }

    public void setService (BillingInfoService[] service)
    {
        this.service = service;
    }

    public BillingInfoAccoutant getAccoutant ()
    {
        return accoutant;
    }

    public void setAccoutant (BillingInfoAccoutant accoutant)
    {
        this.accoutant = accoutant;
    }

    public String getOperationStatus()
    {
        return operationStatus;
    }

    public void setOperationStatus(String operationStatus)
    {
        this.operationStatus = operationStatus;
    }

    public String getUser ()
    {
        return user;
    }

    public void setUser (String user)
    {
        this.user = user;
    }

    public BaseData getData() {
        return null;
    }

    public void setData(BaseData data) {
    }

    @Override
    public String toString()
    {
        return "ClassPojo [amount = "+amount+", error = "+error+", avance = "+avance+", service = "+service+", accoutant = "+accoutant+", operationStatus = "+ operationStatus +", user = "+user+"]";
    }

}
