package com.helloworld.testing.transaction;

import com.helloworld.testing.entity.Account;
import com.helloworld.testing.validation.ValidationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;


class TransactionTest {


    @Test
    void shouldThrowExceptionForInvalidAccount () {

        //GIVEN
        ValidationService validationService = Mockito.mock ( ValidationService.class );
        TransactionService transactionService = new TransactionService ( validationService );
        Account invalidAccount = Mockito.mock ( Account.class );

        //WHEN
        Mockito.when ( validationService.isAccountElligible ( Mockito.any ( Account.class ) ) ).thenReturn ( Boolean.FALSE );

        //THEN
        Assertions.assertThrows ( RuntimeException.class, () -> transactionService.addBalanceToSavingsAccount ( invalidAccount, new BigDecimal ( 100 ) ) );

    }

}
