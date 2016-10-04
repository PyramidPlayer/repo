package me.jetmoney.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by vk on 15.09.16.
 */
@XmlRootElement(name = "error")
@XmlAccessorType(XmlAccessType.FIELD)
public class BillingError implements Serializable {

    @XmlElement(name = "errorru")
    private String errorRu;

    @XmlElement(name = "erroren")
    private String errorEn;

    @XmlElement(name = "line")
    private String line;

    @XmlElement(name = "errorcode")
    private String errorCode;

    @XmlElement(name = "errorge")
    private String errorGe;

    public String getErrorRu() {
        return errorRu;
    }

    public void setErrorRu(String errorRu) {
        this.errorRu = errorRu;
    }

    public String getErrorEn() {
        return errorEn;
    }

    public void setErrorEn(String errorEn) {
        this.errorEn = errorEn;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorGe() {
        return errorGe;
    }

    public void setErrorGe(String errorGe) {
        this.errorGe = errorGe;
    }

    @Override
    public String toString() {
        return "ClassPojo [errorRu = " + errorRu + ", errorEn = " + errorEn + ", line = " + line + ", errorCode = " + errorCode + ", errorGe = " + errorGe + "]";
    }

}
