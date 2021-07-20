package StepsDef;

import core.DriverInitiator;
import core.WaitUtils;
import io.cucumber.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.StorePage;
import pages.StoreProgramFragment;

import java.util.List;

public class StorePageStepDef {
    WebDriver driver = DriverInitiator.instantiateDriver();
    StorePage storePage = new StorePage(driver);

    @And("Store page is loaded")
    public void storePageIsLoaded() throws InterruptedException {
        Thread.sleep(2000);
        WaitUtils.waitUntilPageIsLoaded(driver);
        Assert.assertEquals("You are not on the Store page","https://www.pearsonassessments.com/store/usassessments/en/Store/c/store", driver.getCurrentUrl());
    }

    @And("^User clicks on \"(.*)\" program link$")
    public void userClicksOnABASProgramLink(String title) {
        storePage.clickOnTheProgram(title);
    }

}
