package com.helloworld.testing.validation;

import com.helloworld.testing.entity.Account;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {

    public Boolean isAccountElligible ( Account account ) {
        return Boolean.TRUE;
    }

}
