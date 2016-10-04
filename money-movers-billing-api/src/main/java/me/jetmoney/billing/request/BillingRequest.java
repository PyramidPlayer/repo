package me.jetmoney.billing.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.math.BigDecimal;

public class BillingRequest implements Serializable {

    @JsonProperty
    private String id;
    @JsonProperty
    private String date;
    @JsonProperty
    private String service;
    @JsonProperty
    private String serviceSubId;
    @JsonProperty
    private String serviceSecondSubId;
    @JsonProperty
    private String user;
    @JsonProperty
    private BigDecimal amount;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServiceSubId() {
        return serviceSubId;
    }

    public void setServiceSubId(String serviceSubId) {
        this.serviceSubId = serviceSubId;
    }

    public String getServiceSecondSubId() {
        return serviceSecondSubId;
    }

    public void setServiceSecondSubId(String serviceSecondSubId) {
        this.serviceSecondSubId = serviceSecondSubId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
