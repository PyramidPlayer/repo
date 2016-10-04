package me.jetmoney.processor.tbc;

import me.jetmoney.billing.response.Account;
import me.jetmoney.billing.response.InfoResponse;
import me.jetmoney.processor.BaseInfoProcessor;
import me.jetmoney.response.info.BaseInfoResponse;
import me.jetmoney.response.info.tbc.TbcAccNum;
import me.jetmoney.response.info.tbc.TbcInfoResponse;
import me.jetmoney.response.info.tbc.TbcData;
import me.jetmoney.response.info.tbc.TbcDesc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by toroptsev on 27.09.16.
 */
public class TbcAccountProcessor extends BaseInfoProcessor {

    @Override
    public InfoResponse process(BaseInfoResponse response) {
        InfoResponse result = super.process(response);
        TbcData data = ((TbcInfoResponse)response).getData();
        List<Account> accounts = new ArrayList<>();
        for (TbcAccNum accNum : data.getAccNumList()) {
            Optional<TbcDesc> optionalDesc = Arrays.stream(data.getDescList()).filter(tbcDesc -> tbcDesc.getId().equals(accNum.getId())).findFirst();
            String accountDesc = optionalDesc.isPresent() ? optionalDesc.get().getContent() : accNum.getContent();
            accounts.add(new Account(accNum.getContent(), accountDesc));
        }
        result.setAccounts(accounts);
        return result;
    }
}
