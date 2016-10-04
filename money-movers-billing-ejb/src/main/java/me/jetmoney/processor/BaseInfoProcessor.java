package me.jetmoney.processor;

import me.jetmoney.billing.response.InfoResponse;
import me.jetmoney.response.info.BaseInfoResponse;

import java.math.BigDecimal;

/**
 * Created by toroptsev on 21.09.16.
 */
public class BaseInfoProcessor {

    public InfoResponse process(BaseInfoResponse response) {
        InfoResponse result = new InfoResponse();
        result.setGeneratedAmount(new BigDecimal(response.getData().getGeneratedAmount()));
        return result;
    }
}
