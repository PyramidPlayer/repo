package me.jetmoney.billing.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by toroptsev on 20.09.16.
 */
public class InfoResponse implements Serializable {

    @JsonProperty
    private BigDecimal generatedAmount;

    @JsonProperty("accounts")
    private List<Account> accounts = new ArrayList<>();

    @JsonProperty
    private String sessionId;

    public InfoResponse() {}

    public InfoResponse(String generatedAmount, List<Account> accounts) {
        this.generatedAmount = new BigDecimal(generatedAmount);
        this.accounts = accounts;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public BigDecimal getGeneratedAmount() {
        return generatedAmount;
    }

    public void setGeneratedAmount(BigDecimal generatedAmount) {
        this.generatedAmount = generatedAmount;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionId() {
        return sessionId;
    }
}
