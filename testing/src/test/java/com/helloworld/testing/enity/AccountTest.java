package helloworld.testing.enity;


import com.helloworld.testing.entity.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class AccountTest {

    private Account account = new Account ( "1", new BigDecimal ( 100 ) );


    @Test
    void getAccountId () {
        Assertions.assertNotNull ( account.getAccountId ( ), "Valid Account with ID" );
    }

}
