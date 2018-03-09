package com.essenceglobal.bdd.apple.stepdefinitions;

import com.essenceglobal.bdd.apple.pageobjects.*;
import com.essenceglobal.bdd.apple.utilityclasses.AssertionUtilities;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import com.cucumber.listener.Reporter;

import java.util.Map;

public class BuyMacBookProSteps {

    private WebDriver driver;
    private TestBase testBase;
    private AppleHomepage appleHomepage;
    private MacHomepage macHomepage;
    private MacBookProHomepage macBookProHomepage;
    private BuyMacPage buyMacPage;
    private MacBookProCustomizePage macBookProCustomizePage;
    private AccessoriesPage accessoriesPage;
    private BagPage bagPage;
    private String modelFromFeatureFile;
    private String screenSizeFromFeatureFile;
    private String processorSpeedFromFeatureFile;
    private String colorFromFeatureFile;
    private String selectedSoftwareFromFeatureFile;
    private String selectedAccessoriesFromFeatureFile;
    private String totalPriceFromFeatureFile;
    private String vatFromFeatureFile;


    public BuyMacBookProSteps(TestBase testBase) {
        this.testBase = testBase;
        driver = testBase.getDriver();
    }

    @And("^I choose to browse Mac$")
    public void i_choose_to_browse_Mac() throws Throwable {
        appleHomepage = new AppleHomepage(driver);
        macHomepage =appleHomepage.navigateToMacHompage();
        Reporter.addStepLog("Navigated to Apple Homepage Successfully");
    }

    @And("^I select MacBookPro$")
    public void i_select_MacBookPro() throws Throwable {
       macBookProHomepage = macHomepage.navigateToMacBookProHomepage();
        Reporter.addStepLog("Navigated to MacBook Pro Homepage Successfully");

    }

    @And("^I initiate buying a MacBookPro$")
    public void i_initiate_buying_a_MacBookPro() throws Throwable {
       buyMacPage= macBookProHomepage.navigateToBuyMacPage();
       Reporter.addStepLog("Navigated to Buy Mac Page Successfully");

    }

    @And("^I select screen size color and processor options as below to navigate to customize page$")
    public void i_select_screen_size_color_and_processor_options_as_below_to_navigate_to_customize_page(DataTable customizationOptions) throws Throwable {
       Map<String, String> customizationOptionsMap = customizationOptions.asMap(String.class, String.class);
       screenSizeFromFeatureFile = customizationOptionsMap.get("Screen");
       processorSpeedFromFeatureFile = customizationOptionsMap.get("Processor");
       modelFromFeatureFile = customizationOptionsMap.get("Model");
       colorFromFeatureFile = customizationOptionsMap.get("Colour");
       macBookProCustomizePage = buyMacPage.selectScreenSizeModelColorAndNavigateToCustomizePage();
        Reporter.addStepLog("Customized My MacBook Pro Successfully");

    }

    @And("^I select additional software as below and add to bag to navigate to accessories page$")
    public void i_select_additional_software_as_below_and_add_to_bag_to_navigate_to_accessories_page(DataTable additionalSoftware) throws Throwable {
     Map<String, String> selectedSoftwareMap = additionalSoftware.asMap(String.class, String.class);
     selectedSoftwareFromFeatureFile = selectedSoftwareMap.get("Software");
     macBookProCustomizePage.customize();
     accessoriesPage = macBookProCustomizePage.addToCartAndNavigateToAccessoriesPage();
     Reporter.addStepLog("Added Additional Software Successfully");

    }

    @And("^I add accessories as below$")
    public void i_add_accessories_as_below(DataTable accessories) throws Throwable {
        Map<String, String> selectedAccessoriesMap = accessories.asMap(String.class, String.class);
        selectedAccessoriesFromFeatureFile = selectedAccessoriesMap.get("DisplayAdapter");
        accessoriesPage.addAccessories();
        bagPage = accessoriesPage.navigateToReviewBagPage();
        Reporter.addStepLog("Added Accessories Successfully");

    }

    @Then("^I navigate to review bag page to place the order and verify order$")
    public void i_navigate_to_review_bag_page_to_place_the_order_and_verify_order() throws Throwable {
       System.out.println("Title is "+bagPage.returnTitle());
       System.out.println("Processor is "+bagPage.extractProcessorDetails());
       System.out.println("Software has "+bagPage.extractLogicProXSelectedSoftware());
       System.out.println("Bag contains "+bagPage.returnMainItemsInTheBag().toString());
       Map<String, String> bagContents = bagPage.returnMainItemsInTheBag();
       String processorFromBagPage = bagPage.extractProcessorDetails();
       String softwareFromBagPage = bagPage.extractLogicProXSelectedSoftware();
       String modelFromBagPage = bagContents.get("Model");
       String accessoriesFromBagPage = bagContents.get("Accessories");
       AssertionUtilities.assertTrue(processorFromBagPage.contains(processorSpeedFromFeatureFile), "Expected Processor from feature file "+processorSpeedFromFeatureFile + " Matches with that in the application "+processorFromBagPage, "Expected Processor from feature file "+processorSpeedFromFeatureFile + " Does not match with that in the application "+processorFromBagPage );
       AssertionUtilities.assertStringEquals(selectedSoftwareFromFeatureFile, softwareFromBagPage, "Expected Software from feature file "+selectedSoftwareFromFeatureFile + " Matches with the application "+ softwareFromBagPage, "Expected Software from feature file "+selectedSoftwareFromFeatureFile + " Does not match with the application "+ softwareFromBagPage);
       AssertionUtilities.assertTrue(modelFromBagPage.contains(colorFromFeatureFile), "Expected colour from feature file "+colorFromFeatureFile+ " Matches with the application "+modelFromBagPage, "Expected colour from feature file "+colorFromFeatureFile+ " Does not match with the application "+modelFromBagPage );
       AssertionUtilities.assertTrue(modelFromBagPage.contains(modelFromFeatureFile), "Expected model from feature file "+modelFromFeatureFile+ " Matches with the application "+modelFromBagPage, "Expected model from feature file "+modelFromFeatureFile+ " Does not match with the application "+modelFromBagPage );
       AssertionUtilities.assertTrue(modelFromBagPage.contains(screenSizeFromFeatureFile), "Expected screen size from feature file "+screenSizeFromFeatureFile+ " Matches with the application "+modelFromBagPage, "Expected screen size from feature file "+screenSizeFromFeatureFile+ " Does not match with the application "+modelFromBagPage );
       AssertionUtilities.assertStringEquals(selectedAccessoriesFromFeatureFile, accessoriesFromBagPage, "Expected accessories from feature file "+selectedAccessoriesFromFeatureFile+ " Matches with the application "+accessoriesFromBagPage, "Expected accessories from feature file "+selectedAccessoriesFromFeatureFile+ " Does not match with the application "+accessoriesFromBagPage);
       Reporter.addStepLog("Validated Bag Page Successfully");

    }

    @Then("^I validate the total price and VAT of the items in my bag$")
    public void i_validate_the_total_price_and_VAT_of_the_items_in_my_bag(DataTable priceAndVatTable) throws Throwable {
        Map<String, String> priceAndVATAsMap = priceAndVatTable.asMap(String.class, String.class);
        totalPriceFromFeatureFile = priceAndVATAsMap.get("TotalPrice");
        vatFromFeatureFile = priceAndVATAsMap.get("VAT");
        String totalPriceFromBagPage =bagPage.extractTotalPrice();
        String vatFromBagPage = bagPage.extractVAT();
        AssertionUtilities.assertStringEquals(totalPriceFromFeatureFile, totalPriceFromBagPage, "Expected total price from feature file "+totalPriceFromFeatureFile+ " Matches with the price in the application "+totalPriceFromBagPage,"Expected total price from feature file "+totalPriceFromFeatureFile+ " Does not match with the price in the application "+totalPriceFromBagPage );
        AssertionUtilities.assertStringEquals(vatFromFeatureFile, vatFromBagPage, "Expected VAT from feature file "+ vatFromFeatureFile + " Matches with the VAT from application "+vatFromBagPage, "Expected VAT from feature file "+ vatFromFeatureFile + " Does not match with the VAT from application "+vatFromBagPage);
        Reporter.addStepLog("Validated Price and VAT Successfully");
    }

}
