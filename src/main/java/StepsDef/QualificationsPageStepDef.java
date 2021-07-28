package StepsDef;

import core.DriverInitiator;
import core.Utils;
import core.Wait;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.QualificationsPage;

public class QualificationsPageStepDef {

    WebDriver driver = DriverInitiator.instantiateDriver();
    QualificationsPage qualificationsPage = new QualificationsPage(driver);


    @Then("^Qualifications page is loaded accordingly$")
    public void instantiatePageAndWaitUntilIsLoaded(){
        Wait.waitUntilPageIsLoaded(driver);
        Assert.assertEquals(Utils.QUALIFICATIONS_PAGE_URL, driver.getCurrentUrl());
    }

    @And("^User clicks on Edit button from \"(.*)\" section$")
    public void userClicksEditButton(String section){
        qualificationsPage.clickEditForQualificationGroupNamed(section);
    }
}
