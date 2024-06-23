package com.helloworld.testing.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @GetMapping
    public String getAppDetails () {
        return "Hello, This is Transaction Controller 2.0";
    }

}
