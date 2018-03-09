package com.essenceglobal.bdd.apple.pageobjects;

import com.essenceglobal.bdd.apple.utilityclasses.WebUtilityFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MacBookProCustomizePage {

    private WebDriver driver;
    private static  final By softwareCategoryLocator = By.cssSelector("div[class*='categorypresoftware']");
    private static final By logicProXLocator = By.cssSelector("input[value='065-C29H']");
    private static final By addToCartButtonLocator = By.name("add-to-cart");


    public MacBookProCustomizePage(WebDriver driver) {
        this.driver = driver;
    }

    public void customize() {
        WebElement softwareCategoryElement = WebUtilityFunctions.returnWebElement(driver, softwareCategoryLocator);
        WebUtilityFunctions.jsExecutorScrollToElement(driver, softwareCategoryElement);
        WebElement logicProElement = WebUtilityFunctions.returnWebElementInsideElement(softwareCategoryElement, logicProXLocator);
        WebUtilityFunctions.jsExecutorClickElement(driver, logicProElement);

    }

    public AccessoriesPage addToCartAndNavigateToAccessoriesPage(){
        WebUtilityFunctions.linkOrButtonClick(driver, addToCartButtonLocator);
        return new AccessoriesPage(driver);
    }
}
