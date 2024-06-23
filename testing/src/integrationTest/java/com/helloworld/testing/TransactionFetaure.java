package com.helloworld.testing;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;


public class TransactionFetaure {


    @Given("a precondition")
    public void a_precondition () {
        // Setup precondition
    }

    @When("an action is performed")
    public void an_action_is_performed () {
    }

    @Then("an expected result is observed")
    public void an_expected_result_is_observed () {

        Assertions.assertNull ( null );

    }

}
