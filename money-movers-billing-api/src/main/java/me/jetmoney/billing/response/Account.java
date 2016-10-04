package me.jetmoney.billing.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by toroptsev on 20.09.16.
 */
public class Account {

    @JsonProperty
    private String id;

    @JsonProperty
    private String description;

    public Account() {}

    public Account(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Account(id=" + id + ";description=" + description + ")";
    }
}
