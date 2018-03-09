package com.essenceglobal.bdd.apple.runners;

import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        features={"src/test/resources/features/"},
        glue = {"com.essenceglobal.bdd.apple.stepdefinitions"},
        plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html", "pretty"}
)
public class TestRunner {

    @BeforeClass
    public static void setUp() {
        ExtentProperties extentProperties = ExtentProperties.INSTANCE;
        extentProperties.setProjectName("Apple MacBook Pro Journey");
    }



    @AfterClass
    public static void tearDown() {
        Reporter.loadXMLConfig(new File(System.getProperty("user.dir")+"//extent-config.xml"));
        Reporter.setSystemInfo("os", "Windows 10");
        Reporter.setSystemInfo("Browser", "Chrome");
        Reporter.setSystemInfo("Browser Version", "64.0.3282.186");
        Reporter.setTestRunnerOutput("Essence Global BDD Execution Report");
    }

}