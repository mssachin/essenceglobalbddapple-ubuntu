package com.essenceglobal.bdd.apple.pageobjects;

import com.essenceglobal.bdd.apple.utilityclasses.WebUtilityFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MacBookProHomepage {

    private WebDriver driver;
    private static final By buyLinkLocator = By.className("ac-ln-button");

    public MacBookProHomepage(WebDriver driver) {
        this.driver = driver;
    }

    public BuyMacPage navigateToBuyMacPage(){
        WebUtilityFunctions.linkOrButtonClick(driver, buyLinkLocator);
        return new BuyMacPage(driver);
    }
}
