package me.jetmoney.entity;

import javax.persistence.*;

/**
 * Created by Denis Murzin
 *      on 27.09.16.
 */
@Entity
@Table(name = "bank_bic_jm")
public class BankBic extends BaseEntity {

    @Column(name = "country_name")
    private String countryName;

    @Column(name = "country_alpha2code")
    private String countryAlpha2Code;

    @Column(name = "country_numcode")
    private String countryNumCode;

    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "bank_bic")
    private String bankBic;

    @Column(name = "bank_code")
    private String bankCode;


    public String getCountryName() {
        return countryName;
    }
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryAlpha2Code() {
        return countryAlpha2Code;
    }
    public void setCountryAlpha2Code(String countryAlpha2Code) {
        this.countryAlpha2Code = countryAlpha2Code;
    }

    public String getCountryNumCode() {
        return countryNumCode;
    }
    public void setCountryNumCode(String countryNumCode) {
        this.countryNumCode = countryNumCode;
    }

    public String getBankName() {
        return bankName;
    }
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankBic() {
        return bankBic;
    }
    public void setBankBic(String bankBic) {
        this.bankBic = bankBic;
    }

    public String getBankCode() {
        return bankCode;
    }
    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

}
