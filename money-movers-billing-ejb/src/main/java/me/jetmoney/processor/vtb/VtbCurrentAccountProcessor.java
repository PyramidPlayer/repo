package me.jetmoney.processor.vtb;

import me.jetmoney.billing.response.Account;
import me.jetmoney.billing.response.InfoResponse;
import me.jetmoney.processor.BaseInfoProcessor;
import me.jetmoney.response.info.BaseInfoResponse;
import me.jetmoney.response.info.vtb.current.VtbCurrentAccount;
import me.jetmoney.response.info.vtb.current.VtbCurrentData;
import me.jetmoney.response.info.vtb.current.VtbCurrentInfoResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by toroptsev on 29.09.16.
 */
public class VtbCurrentAccountProcessor extends BaseInfoProcessor {

    @Override
    public InfoResponse process(BaseInfoResponse response) {
        InfoResponse result = super.process(response);
        VtbCurrentData data = ((VtbCurrentInfoResponse)response).getData();
        List<Account> accounts = new ArrayList<>();
        for (VtbCurrentAccount account : data.getAccountList().getAccounts()) {
            accounts.add(new Account(account.getId(), account.getDescription()));
        }
        result.setAccounts(accounts);
        return result;
    }
}
