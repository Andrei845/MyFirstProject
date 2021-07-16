package StepsDef;

import core.DriverInitiator;
import core.WaitUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.AccountsForCheckoutPage;

public class AccountsForCheckoutStepDef {

    WebDriver driver = DriverInitiator.instantiateDriver();
    AccountsForCheckoutPage accountsForCheckoutPage = new AccountsForCheckoutPage(driver);

    @Then("Accounts for checkout page is loaded")
    public void userIsRedirectedToTheAccountsForCheckoutPage(){
        WaitUtils.waitUntilPageIsLoaded(driver);
        Assert.assertEquals("You are not on the accounts for checkout page","https://www.pearsonassessments.com/store/usassessments/en/digital-accounts", driver.getCurrentUrl());
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
