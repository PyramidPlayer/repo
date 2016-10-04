package me.jetmoney.response.info.vtb.card;

import me.jetmoney.response.info.vtb.BaseVtbAccount;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by toroptsev on 29.09.16.
 */
@XmlRootElement
public class VtbCardAccount extends BaseVtbAccount {

    @XmlElement(name = "cardname")
    private String cardName;

    @XmlElement(name = "cardnumber")
    private String cardNumber;

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getDescription() {
        return cardNumber + " " + cardName;
    }
}
