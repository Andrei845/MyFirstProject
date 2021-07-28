package StepsDef;

import core.DriverInitiator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class HomePageStepDef{
    WebDriver driver = DriverInitiator.instantiateDriver();
    HomePage homePage = new HomePage(driver);

    @Given("^Home page is loaded, window is maximized and pop-ups are closed$")
    public void homePageIsLoadedWindowIsMaximizedAndPopUpsAreClosed(){
        homePage.openHomePage();
        homePage.waitAndCheckIfPageIsLoaded();
        homePage.maximizeWindow();
        homePage.closePopUps();
    }

    @When("^User clicks on the Sign in link$")
    public void userClicksOnSignInRegisterLink(){
        homePage.clickOnSignInRegisterLink();
    }

    @Then("^Home page is loaded$")
    public void checkIfHomePageIsLoaded(){
        homePage.waitAndCheckIfPageIsLoaded();
    }

    @And("^User navigates to \"(.*)\"$")
    public void userNavigatesToProductByAcronym(String name) throws InterruptedException{
        homePage.goToTheLinkFromAssessmentSolution(name);
    }

    @And("User clicks on My Account button")
    public void clickOnMyAccountButton(){
        homePage.waitAndCheckIfPageIsLoaded();
        homePage.clickMyAccountButton();
    }

    @And("User clicks on Address Book link")
    public void clickOnAddressBookLink(){
        homePage.clickOnAddressBookLink();
    }

    @And("User clicks on Qualifications link")
    public void userClicksOnQualificationsLink(){
        homePage.clickQualificationsLink();
    }
}