package com.essenceglobal.bdd.apple.utilityclasses;

import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebUtilityFunctions {



    public static void linkOrButtonClick(WebDriver driver, By locator){
        WebElement buttonElement = fluentWaitForAnElement(driver, locator);
        buttonElement.click();
    }

    public static void clickWebElement(WebElement element){
        element.click();
    }
    public static List<WebElement> returnWebElements(WebDriver driver, By locator){
        List<WebElement> elements = null;
        try {
            elements = driver.findElements(locator);
        }catch (Exception e){
            e.printStackTrace();
        }
        return elements;
    }

    public static WebElement returnWebElement(WebDriver driver, By locator){
        WebElement element;
        element =fluentWaitForAnElement(driver,locator);
        return element;
    }

    public static WebElement returnWebElementInsideElement(WebElement elementParent, By locator){
        WebElement element = null;
        try{
            element = elementParent.findElement(locator);
        }catch (Exception e){
            e.printStackTrace();
        }
        return element;
    }

    public static void jsExecutorClickElement(WebDriver driver, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public static void jsExecutorScrollToElement(WebDriver driver, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static WebElement fluentWaitForAnElement(WebDriver driver, final By locator){

        Wait wait = new FluentWait(driver)
                .withTimeout(10, TimeUnit.SECONDS)
                .pollingEvery(500, TimeUnit.MILLISECONDS)
                .ignoring(WebDriverException.class)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementNotVisibleException.class)
                .ignoring(ElementNotInteractableException.class);

        Function<WebDriver, WebElement> function = new Function<WebDriver, WebElement>() {
            WebElement elementToReturn = null;
            WebElement element = null;
            public WebElement apply(WebDriver driver) {
                try {
                    element  = driver.findElement(locator);

                }catch (Exception e){
                    e.printStackTrace();
                }
                if (element.isDisplayed() && element != null) {
                    elementToReturn = element;
                    return elementToReturn;
                }
                return elementToReturn;
            }
        };

        wait.until(function);

        return function.apply(driver);
    }



}
