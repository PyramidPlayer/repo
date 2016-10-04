package me.jetmoney.processor.capital.angarishi;

import me.jetmoney.billing.response.Account;
import me.jetmoney.billing.response.InfoResponse;
import me.jetmoney.processor.BaseInfoProcessor;
import me.jetmoney.response.info.BaseInfoResponse;
import me.jetmoney.response.info.capital.angarishi.CapitalAccount;
import me.jetmoney.response.info.capital.angarishi.CapitalInfoResponse;
import me.jetmoney.response.info.capital.angarishi.CapitalData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by toroptsev on 27.09.16.
 */
public class CapitalAccountProcessor extends BaseInfoProcessor {

    @Override
    public InfoResponse process(BaseInfoResponse response) {
        InfoResponse result = super.process(response);
        CapitalData data = ((CapitalInfoResponse)response).getData();
        List<Account> accounts = new ArrayList<>();
        for (CapitalAccount account: data.getAccounts()) {
            accounts.add(new Account(account.getAccountID(), account.getAccountType() + " " + account.getAccountName() + " " + account.getAccountCurrency()));
        }
        result.setAccounts(accounts);
        return result;
    }
}
