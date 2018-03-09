package com.essenceglobal.bdd.apple.pageobjects;

import com.essenceglobal.bdd.apple.utilityclasses.WebUtilityFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BuyMacPage {

    private WebDriver driver;
    private static final By _15inchButtonLocator = By.cssSelector("button[data-tab-urllink='15-inch']");
    private static final By silverColorLocator = By.cssSelector("label[for='colorOptionGridGroup_MPTV2B/A']");
    private static final By buttonContainerLocator = By.cssSelector("form[data-part-number='MPTV2B/A']");
    private static final By proceedToConfigureButtonLocator = By.cssSelector("button[title='Proceed to Configuration page']");



    public BuyMacPage(WebDriver driver) {
        this.driver = driver;
    }

    public MacBookProCustomizePage selectScreenSizeModelColorAndNavigateToCustomizePage() throws InterruptedException {
        WebUtilityFunctions.linkOrButtonClick(driver,_15inchButtonLocator);
        WebElement silverColorElement = WebUtilityFunctions.returnWebElement(driver, silverColorLocator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebUtilityFunctions.jsExecutorClickElement(driver,silverColorElement);
        WebElement buttonContainerElement = WebUtilityFunctions.returnWebElement(driver, buttonContainerLocator);
        WebElement proceedToConfigureButtonElement = WebUtilityFunctions.returnWebElementInsideElement(buttonContainerElement, proceedToConfigureButtonLocator);
        WebUtilityFunctions.jsExecutorClickElement(driver, proceedToConfigureButtonElement);

        return new MacBookProCustomizePage(driver);

    }

}
