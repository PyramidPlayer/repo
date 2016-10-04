package me.jetmoney.processor.vtb;

import me.jetmoney.billing.response.Account;
import me.jetmoney.billing.response.InfoResponse;
import me.jetmoney.processor.BaseInfoProcessor;
import me.jetmoney.response.info.BaseInfoResponse;
import me.jetmoney.response.info.vtb.card.VtbCardAccount;
import me.jetmoney.response.info.vtb.card.VtbCardData;
import me.jetmoney.response.info.vtb.card.VtbCardInfoResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by toroptsev on 29.09.16.
 */
public class VtbCardAccountProcessor extends BaseInfoProcessor {

    @Override
    public InfoResponse process(BaseInfoResponse response) {
        InfoResponse result = super.process(response);
        VtbCardData data = ((VtbCardInfoResponse)response).getData();
        List<Account> accounts = new ArrayList<>();
        for (VtbCardAccount account : data.getAccountList().getAccounts()) {
            accounts.add(new Account(account.getId(), account.getDescription()));
        }
        result.setAccounts(accounts);
        return result;
    }
}
