package StepsDef;

import core.DriverInitiator;
import core.Wait;
import io.cucumber.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.StorePage;

public class StorePageStepDef {
    WebDriver driver = DriverInitiator.instantiateDriver();
    StorePage storePage = new StorePage(driver);

    @And("Store page is loaded")
    public void storePageIsLoaded(){
        Wait.waitUntilPageIsLoaded(driver);
        Wait.implicitWait(5);
        Assert.assertEquals("You are not on the Store page","https://www.pearsonassessments.com/store/usassessments/en/Store/c/store", driver.getCurrentUrl());
    }

    @And("^User clicks on \"(.*)\" program link$")
    public void userClicksOnABASProgramLink(String title) {
        storePage.clickOnTheProgram(title);
    }

}
