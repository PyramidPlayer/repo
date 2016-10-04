package me.jetmoney.response.info.capital.angarishi;

import javax.xml.bind.annotation.*;

/**
 * Created by toroptsev on 20.09.16.
 */
@XmlRootElement(name = "account")
@XmlAccessorType(XmlAccessType.FIELD)
public class CapitalAccount {

    @XmlAttribute(name = "id")
    private String id;

    @XmlElement(name = "accountName")
    private String accountName;

    @XmlElement(name = "AccountID")
    private String accountID;

    @XmlElement(name = "AccountCurrency")
    private String accountCurrency;

    @XmlElement(name = "CommercialRate")
    private String commercialRate;

    @XmlElement(name = "AccountType")
    private String accountType;

    @XmlElement(name = "AccountAddress")
    private String accountAddress;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getAccountName ()
    {
        return accountName;
    }

    public void setAccountName (String accountName)
    {
        this.accountName = accountName;
    }

    public String getAccountID ()
    {
        return accountID;
    }

    public void setAccountID (String AccountID)
    {
        this.accountID = AccountID;
    }

    public String getAccountCurrency ()
    {
        return accountCurrency;
    }

    public void setAccountCurrency (String AccountCurrency)
    {
        this.accountCurrency = AccountCurrency;
    }

    public String getCommercialRate ()
    {
        return commercialRate;
    }

    public void setCommercialRate (String CommercialRate)
    {
        this.commercialRate = CommercialRate;
    }

    public String getAccountType ()
    {
        return accountType;
    }

    public void setAccountType (String AccountType)
    {
        this.accountType = AccountType;
    }

    public String getAccountAddress ()
    {
        return accountAddress;
    }

    public void setAccountAddress (String AccountAddress)
    {
        this.accountAddress = AccountAddress;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", accountName = "+accountName+", accountID = "+ accountID +", accountCurrency = "+ accountCurrency +", commercialRate = "+ commercialRate +", accountType = "+ accountType +", accountAddress = "+ accountAddress +"]";
    }
}
