package StepsDef;

import core.DriverInitiator;
import core.WaitUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.CartPage;

public class CartPageStepDef {

    WebDriver driver = DriverInitiator.instantiateDriver();
    CartPage cartPage = new CartPage(driver);

    @Then("Check if According page is loaded")
    public void checkIfAccordingPageIsLoaded() {
        WaitUtils.waitUntilPageIsLoaded(driver);
        Assert.assertEquals("You are not on the cart page","https://www.pearsonassessments.com/store/usassessments/en/cart", driver.getCurrentUrl());
    }

    @When("User clicks on the Checkout button")
    public void userClicksOnTheCheckoutButton() {
        cartPage.clickCheckoutButton();
    }

}
