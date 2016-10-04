package me.jetmoney.processor.basis;

import me.jetmoney.billing.response.Account;
import me.jetmoney.billing.response.InfoResponse;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by toroptsev on 29.09.16.
 */
public class BasisBankInfoProcessor {

    public InfoResponse process(BigDecimal amount) {
        InfoResponse result = new InfoResponse();
        if (amount != null) {
            result.setGeneratedAmount(amount.multiply(new BigDecimal("0.985")));
        }

        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account("101", "Megocard"));
        accounts.add(new Account("102", "Discovery Card"));
        accounts.add(new Account("103", "Geocell Visa Card"));
        accounts.add(new Account("104", "VISA ELECTRON"));
        accounts.add(new Account("105", "VISA CLASSIC"));
        accounts.add(new Account("106", "VISA GOLD"));
        accounts.add(new Account("107", "MINUTECARD"));

        accounts.add(new Account("201", "Credit Megocard"));
        accounts.add(new Account("202", "Credit Geocell Visa Card"));
        accounts.add(new Account("203", "Credit VISA ELECTRON"));
        accounts.add(new Account("204", "Credit VISA CLASSIC"));
        accounts.add(new Account("205", "Credit VISA GOLD"));
        accounts.add(new Account("206", "Credit LADY CARD"));
        accounts.add(new Account("207", "Credit Current Account"));

        result.setAccounts(accounts);
        return result;
    }
}
