package StepsDef;

import core.DriverInitiator;
import core.Utils;
import core.Wait;
import io.cucumber.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.ProductsByAcronymPage;

public class ProductsByAcronymStepDef {
    WebDriver driver = DriverInitiator.instantiateDriver();
    ProductsByAcronymPage productsByAcronymPage = new ProductsByAcronymPage(driver);

    @And("Products by Acronym page is loaded")
    public void productsByAcronymPageIsLoaded(){
        Wait.waitUntilPageIsLoaded(driver);
        Assert.assertEquals("You are not on the Products by Acronym page", Utils.PRODUCTS_BY_ACRONYM_URL, driver.getCurrentUrl());
    }

    @And("^User clicks on \"(.*)\" program link$")
    public void userClicksOnABASProgramLink(String title) {
        productsByAcronymPage.clickOnAbasLink();
    }

}
