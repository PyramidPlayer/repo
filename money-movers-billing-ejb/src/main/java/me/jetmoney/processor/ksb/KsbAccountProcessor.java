package me.jetmoney.processor.ksb;

import me.jetmoney.billing.response.Account;
import me.jetmoney.billing.response.InfoResponse;
import me.jetmoney.processor.BaseInfoProcessor;
import me.jetmoney.response.info.BaseInfoResponse;
import me.jetmoney.response.info.ksb.KsbAccount;
import me.jetmoney.response.info.ksb.KsbData;
import me.jetmoney.response.info.ksb.KsbInfoResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by toroptsev on 29.09.16.
 */
public class KsbAccountProcessor extends BaseInfoProcessor {
    @Override
    public InfoResponse process(BaseInfoResponse response) {
        InfoResponse result = super.process(response);
        KsbData data = ((KsbInfoResponse)response).getData();
        List<Account> accounts = new ArrayList<>();
        for (KsbAccount account : data.getAccountList().getAccounts()) {
            accounts.add(new Account(account.getAccountId(), account.getType() + " " + account.getAccount() + " " + account.getCurrency()));
        }
        result.setAccounts(accounts);
        return result;
    }
}
