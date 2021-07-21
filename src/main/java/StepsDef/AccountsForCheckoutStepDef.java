package StepsDef;

import core.DriverInitiator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.AccountsForCheckoutPage;

public class AccountsForCheckoutStepDef {

    WebDriver driver = DriverInitiator.instantiateDriver();
    AccountsForCheckoutPage accountsForCheckoutPage = new AccountsForCheckoutPage(driver);

    @Then("Accounts for checkout page is loaded")
    public void userIsRedirectedToTheAccountsForCheckoutPage(){
        accountsForCheckoutPage.waitAndCheckIfPageIsLoaded();
    }

    @When("User clicks on My Account radio button")
    public void userClicksOnMyAccountRadioButton() {
        accountsForCheckoutPage.clickMyAccountRadioBox();
    }

    @And("User clicks on the button Continue")
    public void userClicksOnTheButtonContinue() {
        accountsForCheckoutPage.clickContinueButton();
    }


}
