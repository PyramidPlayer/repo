package me.jetmoney.processor.bta;

import me.jetmoney.billing.response.Account;
import me.jetmoney.billing.response.InfoResponse;
import me.jetmoney.processor.BaseInfoProcessor;
import me.jetmoney.response.info.BaseInfoResponse;
import me.jetmoney.response.info.bta.BtaAccount;
import me.jetmoney.response.info.bta.BtaInfoResponse;
import me.jetmoney.response.info.bta.BtaData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by toroptsev on 21.09.16.
 */
public class BtaAccountProcessor extends BaseInfoProcessor {

    @Override
    public InfoResponse process(BaseInfoResponse response) {
        InfoResponse result = super.process(response);
        BtaData data = ((BtaInfoResponse)response).getData();
        List<Account> accounts = new ArrayList<>();
        for (BtaAccount account: data.getAccounts().getAccount()) {
            accounts.add(new Account(account.getFull(), account.getContent()));
        }
        result.setAccounts(accounts);
        return result;
    }
}
