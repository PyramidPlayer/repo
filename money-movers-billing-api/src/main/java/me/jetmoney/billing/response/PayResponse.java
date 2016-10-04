package me.jetmoney.billing.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by toroptsev on 23.09.16.
 */
public class PayResponse implements Serializable {

    @JsonProperty
    private String operationId;

    public PayResponse() {}

    public PayResponse(String operationId) {
        this.operationId = operationId;
    }

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }
}
