package StepsDef;

import core.DriverInitiator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.SignInRegisterPage;

public class SignInRegisterPageStepDef {
    WebDriver driver = DriverInitiator.instantiateDriver();
    SignInRegisterPage signInRegisterPage = new SignInRegisterPage(driver);

    @Then("^Sign in/Register page is loaded$")
    public void signInRegisterPageIsLoaded(){
        signInRegisterPage.checkIfPageIsLoaded();
    }

    @When("^User types valid username, \"(.*)\" and password, \"(.*)\"$")
    public void userTypesValidUsernameAndPassword(String username, String password){
        signInRegisterPage.enterUsername(username);
        signInRegisterPage.enterCurrentPassword(password);

    }

    @And("^User clicks on the sign in button$")
    public void userClicksOnTheSignInButton(){
        signInRegisterPage.clickSignInButton();
    }
}
