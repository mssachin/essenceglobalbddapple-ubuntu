package com.essenceglobal.bdd.apple.pageobjects;

import com.essenceglobal.bdd.apple.utilityclasses.WebUtilityFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccessoriesPage {

    private WebDriver driver;
    private static final By reviewBagButtonLocator = By.xpath("//*[@id='summaryheader-form']/div/span/button");
    private static final By usbAdapterAddToBagButtonLocator = By.cssSelector("button[value='MJ1M2ZM/A']");

    public AccessoriesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addAccessories(){
        WebElement usbElement =WebUtilityFunctions.returnWebElement(driver, usbAdapterAddToBagButtonLocator);
        WebElement usbAdapterAddToBagElement = WebUtilityFunctions.returnWebElement(driver, usbAdapterAddToBagButtonLocator);
        WebUtilityFunctions.jsExecutorScrollToElement(driver, usbAdapterAddToBagElement);
        WebUtilityFunctions.jsExecutorClickElement(driver, usbElement);

           }

    public BagPage navigateToReviewBagPage(){
        WebElement reviewBagButtonElement = WebUtilityFunctions.returnWebElement(driver, reviewBagButtonLocator);
        WebUtilityFunctions.jsExecutorScrollToElement(driver, reviewBagButtonElement);
        WebUtilityFunctions.linkOrButtonClick(driver, reviewBagButtonLocator);
        return new BagPage(driver);
    }
}
