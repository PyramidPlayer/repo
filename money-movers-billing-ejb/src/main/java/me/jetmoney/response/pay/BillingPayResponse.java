package me.jetmoney.response.pay;


import me.jetmoney.response.BillingAmount;
import me.jetmoney.response.BillingError;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by vk on 15.09.16.
 */

@XmlRootElement(name = "result")
@XmlAccessorType(XmlAccessType.FIELD)
public class BillingPayResponse implements Serializable {

    @XmlElement(name = "error")
    private BillingError error;

    @XmlElement(name = "amount")
    private BillingAmount amount;

    @XmlElement(name = "user")
    private String user;

    @XmlElement(name = "service")
    private String service;

    @XmlElement(name = "operationid")
    private String operationid;

    @XmlElement(name = "data")
    private BillingPayData data;

    public BillingAmount getAmount() {
        return amount;
    }

    public void setAmount(BillingAmount amount) {
        this.amount = amount;
    }

    public BillingError getError() {
        return error;
    }

    public void setError(BillingError error) {
        this.error = error;
    }

    public String getOperationid() {
        return operationid;
    }

    public void setOperationid(String operationid) {
        this.operationid = operationid;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public BillingPayData getData() {
        return data;
    }

    public void setData(BillingPayData data) {
        this.data = data;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "ClassPojo [amount = " + amount + ", error = " + error + ", operationid = " + operationid + ", service = " + service + ", data = " + data + ", user = " + user + "]";
    }

}
