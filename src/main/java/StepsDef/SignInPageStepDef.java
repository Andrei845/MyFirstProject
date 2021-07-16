package StepsDef;

import core.DriverInitiator;
import core.WaitUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.SignInPage;

public class SignInPageStepDef {
    WebDriver driver = DriverInitiator.instantiateDriver();
    SignInPage singInPage = new SignInPage(driver);


    @Given("Sign in page is loaded, window is maximized and pop-ups are closed")
    public void singInPageIsLoadedWindowIsMaximizedAndPopUpsAreClosed(){
        singInPage.openPage(driver);
        driver.manage().window().maximize();
        WaitUtils.waitUntilPageIsLoaded(driver);
        WaitUtils.implicitWait(15);
        singInPage.clickClosePopUp();
        singInPage.clickClosePopUpOurStores();
    }

    @When("^User types valid username, \"(.*)\" and password, \"(.*)\"$")
    public void userTypesValidUsernameAndPassword(String username, String password){
        singInPage.enterUsername(username);
        singInPage.enterCurrentPassword(password);
    }

    @And("User clicks on the sign in button")
    public void userClicksOnTheSignInButton(){
        singInPage.clickSignInButton();
    }
}
