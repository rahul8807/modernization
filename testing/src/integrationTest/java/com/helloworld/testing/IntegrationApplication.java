package com.helloworld.testing;

import com.helloworld.testing.validation.ValidationService;
import io.cucumber.core.options.Constants;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.jupiter.api.Test;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Profile("integration")
@TestPropertySource(locations = "classpath:application-integration.properties")
@Suite
@SelectClasspathResource("features")
@CucumberContextConfiguration
@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME, value = "com.helloworld.testing")
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME, value = "pretty, json:build/reports/cucumber/cucumber-report.json, html:build/reports/cucumber/cucumber-report.html")
class IntegrationApplication {

    @Autowired
    private ValidationService validationService;

    @Test
    void test () {
        //Assertions.assertNotNull ( validationService,"Validation Service Initialised" );
    }

}
