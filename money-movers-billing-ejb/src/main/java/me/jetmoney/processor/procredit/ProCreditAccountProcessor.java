package me.jetmoney.processor.procredit;

import me.jetmoney.billing.response.Account;
import me.jetmoney.billing.response.InfoResponse;
import me.jetmoney.processor.BaseInfoProcessor;
import me.jetmoney.response.info.BaseInfoResponse;
import me.jetmoney.response.info.procredit.ProCreditAccount;
import me.jetmoney.response.info.procredit.ProCreditData;
import me.jetmoney.response.info.procredit.ProCreditInfoResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by toroptsev on 29.09.16.
 */
public class ProCreditAccountProcessor extends BaseInfoProcessor {

    @Override
    public InfoResponse process(BaseInfoResponse response) {
        InfoResponse result = super.process(response);
        ProCreditData data = ((ProCreditInfoResponse)response).getData();
        List<Account> accounts = new ArrayList<>();
        for (ProCreditAccount account : data.getAccounts()) {
            accounts.add(new Account(account.getContent(), account.getContent()));
        }
        result.setAccounts(accounts);
        result.setSessionId(data.getSessionId());
        return result;
    }
}
