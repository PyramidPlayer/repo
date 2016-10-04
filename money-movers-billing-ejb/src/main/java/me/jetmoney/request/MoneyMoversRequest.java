package me.jetmoney.request;

/**
 * Created by toroptsev on 19.09.16.
 */
@ParamHashBase(fields = {"agent", "service", "amount", "id", "user", "#secret"}, algorithm = "SHA-256", separator = "")
public class MoneyMoversRequest {

    @Param(value = "service")
    private String service;
    @Param(value = "service_sub_id")
    private String serviceSubId = "0";
    @Param(value = "service_second_sub_id")
    private String serviceSecondSubId = "0";
    @Param(value = "service_third_sub_id")
    private String serviceThirdSubId = "0";
    @Param(value = "amount")
    private String amount;
    @Param(value = "id")
    private String id;
    @Param(value = "user")
    private String user;
    @Param(value = "date")
    private String date;
    @Param(value = "hash")
    private String hash;
    @Param(value = "agent")
    private String agent;
    @Param(value = "canal")
    private String canal = "0";

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
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

    public String getServiceThirdSubId() {
        return serviceThirdSubId;
    }

    public void setServiceThirdSubId(String serviceThirdSubId) {
        this.serviceThirdSubId = serviceThirdSubId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getCanal() {
        return canal;
    }

    public void setCanal(String canal) {
        this.canal = canal;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MoneyMoversRequest{");
        sb.append("service='").append(service).append('\'');
        sb.append(", serviceSubId='").append(serviceSubId).append('\'');
        sb.append(", serviceSecondSubId='").append(serviceSecondSubId).append('\'');
        sb.append(", serviceThirdSubId='").append(serviceThirdSubId).append('\'');
        sb.append(", amount='").append(amount).append('\'');
        sb.append(", id='").append(id).append('\'');
        sb.append(", user='").append(user).append('\'');
        sb.append(", date='").append(date).append('\'');
        sb.append(", hash='").append(hash).append('\'');
        sb.append(", agent='").append(agent).append('\'');
        sb.append(", canal='").append(canal).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
