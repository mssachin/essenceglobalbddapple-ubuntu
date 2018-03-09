package com.essenceglobal.bdd.apple.pageobjects;

import com.essenceglobal.bdd.apple.utilityclasses.WebUtilityFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BagPage {

    private WebDriver driver;
    private static final By hardwareSectionLocator = By.cssSelector("div[class$='grid-1of2']");
    private static final By softwareSectionLocator = By.cssSelector("div[class$='gs-last']");
    private static final By mainItemsInTheBagHeadingsLocator = By.cssSelector("a[id^='cart-items-item-']");
    private static final By processorDetailsLocator = By.cssSelector("ul[class$='text-alt'] > li:nth-of-type(2)");
    private static final By logicProXSoftwareDetailsLocator = By.cssSelector("ul[class$='text-alt'] > li:nth-of-type(4)");
    private static final By offerTotalValueLocator = By.cssSelector("td[class^='offer-total-value'");
    private static final By offerVATLocator = By.cssSelector("td[class='total-message'] > span:nth-of-type(2)");




    public BagPage(WebDriver driver) {
        this.driver = driver;
    }

    public String returnTitle(){
        return driver.getTitle();
    }

    public String extractProcessorDetails() {
        WebElement hardwareSectionElement = WebUtilityFunctions.returnWebElement(driver, hardwareSectionLocator);
        WebElement processorDetailsElement = WebUtilityFunctions.returnWebElementInsideElement(hardwareSectionElement, processorDetailsLocator);
        return processorDetailsElement.getText();
    }

    public String extractLogicProXSelectedSoftware(){
        WebElement softwareSectionElement = WebUtilityFunctions.returnWebElement(driver, softwareSectionLocator);
        WebElement logicProXSoftwareDetailsElement = WebUtilityFunctions.returnWebElementInsideElement(softwareSectionElement, logicProXSoftwareDetailsLocator);
        return logicProXSoftwareDetailsElement.getText();
    }

    public Map<String, String> returnMainItemsInTheBag(){
        Map<String, String> itemsInTheBagAsMap = new HashMap<>();
        List<WebElement> itemsElements = WebUtilityFunctions.returnWebElements(driver, mainItemsInTheBagHeadingsLocator);
        for (WebElement element: itemsElements) {
            String itemText = element.getText();
            if(itemText.contains("MacBook")){
                itemsInTheBagAsMap.put("Model", itemText);
            }else if(itemText.contains("USB")){
                itemsInTheBagAsMap.put("Accessories", itemText);
            }

        }
        return itemsInTheBagAsMap;

        }

      public String extractTotalPrice(){
        WebElement totalPriceElement = WebUtilityFunctions.returnWebElement(driver, offerTotalValueLocator);
        return totalPriceElement.getText();
      }

      public String extractVAT(){
        WebElement vatElement = WebUtilityFunctions.returnWebElement(driver, offerVATLocator);
        return vatElement.getText();
      }

}
