package com.helloworld.testing.transaction;

import com.helloworld.testing.entity.Account;
import com.helloworld.testing.validation.ValidationService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransactionService {

    public ValidationService validationService;

    public TransactionService ( ValidationService validationService ) {
        this.validationService = validationService;
    }

    public BigDecimal addBalanceToSavingsAccount ( Account account, BigDecimal amount ) {
        if (validationService.isAccountElligible ( account )) {
            BigDecimal newBalance = account.getBalance ( ).add ( amount );
            account.setBalance ( newBalance );
            return account.getBalance ( );
        } else {
            throw new RuntimeException ( "Account Not Elligible For Transaction" );
        }
    }

}
