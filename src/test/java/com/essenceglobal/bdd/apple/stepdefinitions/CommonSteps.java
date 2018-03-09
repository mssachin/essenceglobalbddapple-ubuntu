package com.essenceglobal.bdd.apple.stepdefinitions;

import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;

public class CommonSteps {

    private WebDriver driver;
    private TestBase testBase;

    public CommonSteps(TestBase testBase) {
        this.testBase = testBase;
        driver = testBase.getDriver();
    }

    @Given("^I navigate to Apple website$")
    public void i_navigate_to_Apple_website() throws Throwable {
        driver.get("https://www.apple.com/uk/");
    }
}
