package com.essenceglobal.bdd.apple.pageobjects;

import com.essenceglobal.bdd.apple.utilityclasses.WebUtilityFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AppleHomepage {

    private WebDriver driver;
    private static final By macLinkLocator = By.linkText("Mac");

    public AppleHomepage(WebDriver driver) {
        this.driver = driver;
    }

    public MacHomepage navigateToMacHompage(){
        WebUtilityFunctions.linkOrButtonClick(driver, macLinkLocator);
        return new MacHomepage(driver);
    }


}
