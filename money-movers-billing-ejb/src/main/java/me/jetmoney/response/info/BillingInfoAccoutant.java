package me.jetmoney.response.info;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by vk on 15.09.16.
 */


@XmlRootElement(name = "accoutant")
@XmlAccessorType(XmlAccessType.FIELD)
public class BillingInfoAccoutant implements Serializable {

    @XmlElement(name = "agentCommission")
    private String agentCommission;

    @XmlElement(name = "clientCommission")
    private String clientCommission;

    @XmlElement(name = "agentBenefit")
    private String agentBenefit;

    public String getAgentCommission() {
        return agentCommission;
    }

    public void setAgentCommission(String agentCommission) {
        this.agentCommission = agentCommission;
    }

    public String getClientCommission() {
        return clientCommission;
    }

    public void setClientCommission(String clientCommission) {
        this.clientCommission = clientCommission;
    }

    public String getAgentBenefit() {
        return agentBenefit;
    }

    public void setAgentBenefit(String agentBenefit) {
        this.agentBenefit = agentBenefit;
    }

    @Override
    public String toString() {
        return "ClassPojo [agentCommission = " + agentCommission + ", clientCommission = " + clientCommission + ", agentBenefit = " + agentBenefit + "]";
    }

}
