package me.jetmoney.data;

import java.util.Arrays;
import java.util.Optional;

/**
 * Created by toroptsev on 28.09.16.
 */
public enum Service {

    TBC_BANK_ACCOUNT("176"),
    BASIS_BANK_ACCOUNT("177"),
    LIBERTY_BANK_IN("193"),
    LIBERTY_BANK_OUT("194"),
    CAPITAL_BANK_MIMDINARE_ANGARISHI("222"),
    CAPITAL_BANK_SABARATE_ANGARISHI("226"),
    FINCA_BANK_ACCOUNT("333"),
    PRO_CREDIT_BANK_ACCOUNT("351"),
    VTB_CARD_ACCOUNT("370"),
    VTB_CURRENT_ACCOUNT("371"),
    BTA_ACCOUNT("383"),
    KSB_BANK("432");

    private String serviceId;

    Service(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public static Service getById(String serviceId) {
        if (serviceId == null) {
            return null;
        }
        Optional<Service> serviceOptional = Arrays.stream(values()).filter(service -> service.serviceId.equals(serviceId)).findFirst();
        return serviceOptional.isPresent() ? serviceOptional.get() : null;
    }
}
