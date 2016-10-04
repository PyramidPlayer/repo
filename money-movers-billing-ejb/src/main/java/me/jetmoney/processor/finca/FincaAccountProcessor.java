package me.jetmoney.processor.finca;

import me.jetmoney.billing.response.Account;
import me.jetmoney.billing.response.InfoResponse;
import me.jetmoney.processor.BaseInfoProcessor;
import me.jetmoney.response.info.BaseInfoResponse;
import me.jetmoney.response.info.finca.FincaAccount;
import me.jetmoney.response.info.finca.FincaInfoResponse;
import me.jetmoney.response.info.finca.FincaData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by toroptsev on 27.09.16.
 */
public class FincaAccountProcessor extends BaseInfoProcessor {
    @Override
    public InfoResponse process(BaseInfoResponse response) {
        InfoResponse result = super.process(response);
        FincaData data = ((FincaInfoResponse)response).getData();
        List<Account> accounts = new ArrayList<>();
        for (FincaAccount account : data.getAccountList().getAccounts()) {
            accounts.add(new Account(account.getValue(), account.getContent()));
        }
        result.setAccounts(accounts);
        return result;
    }
}
