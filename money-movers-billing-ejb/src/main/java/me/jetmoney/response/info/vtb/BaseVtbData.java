package me.jetmoney.response.info.vtb;

import me.jetmoney.response.info.BaseData;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by toroptsev on 29.09.16.
 */
@XmlRootElement
public class BaseVtbData extends BaseData {

    @XmlElement(name = "userinfo")
    private String userInfo;

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }
}
