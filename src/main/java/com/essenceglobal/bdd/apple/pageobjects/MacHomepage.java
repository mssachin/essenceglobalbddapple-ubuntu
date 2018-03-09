package com.essenceglobal.bdd.apple.pageobjects;

import com.essenceglobal.bdd.apple.utilityclasses.WebUtilityFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MacHomepage {

    private WebDriver driver;
    private static final By macBookProLinkLocator = By.linkText("MacBook Pro");

    public MacHomepage(WebDriver driver) {
        this.driver = driver;
    }


    public MacBookProHomepage navigateToMacBookProHomepage(){
        WebUtilityFunctions.linkOrButtonClick(driver, macBookProLinkLocator);
        return new MacBookProHomepage(driver);
    }


}
