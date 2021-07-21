package StepsDef;

import core.DriverInitiator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.AdaptiveBehaviorAssessmentSystemPage;

public class AdaptiveBehaviorAssessmentSystemPageStepDef {

    WebDriver driver = DriverInitiator.instantiateDriver();
    AdaptiveBehaviorAssessmentSystemPage abas = new AdaptiveBehaviorAssessmentSystemPage(driver);

    @Then("^The program page is displayed$")
    public void theProgramPageIsDisplayed() {
        abas.waitAndCheckIfPageIsLoadedLoaded();
    }

    @And("^User closes the feedback pop-up$")
    public void userClosesTheFeedbackPopUp(){
        abas.clickFeedbackPopUpCloser();
    }

    @When("User adds a product in the cart")
    public void userAddsAProductInTheCart() {
        abas.clickAllProductsFormatCard();
        abas.clickAddToCartFirstProduct();
    }

    @Then("The pop-up Add to cart is displayed")
    public void thePopUpAddToCartIsDisplayed(){
        Assert.assertTrue("Add to cart pop-up is not displayed",abas.isAddToCartPopUpDisplayed());
    }

    @When("User clicks X from the pop-up")
    public void userClicksXFromThePopUp() {
        abas.clickPopUpAddToCartCloser();
    }

    @Then("The pop-up Add to cart is closed")
    public void thePopUpAddToCartIsClosed() {
        Assert.assertTrue("Add to cart pop-up is still displayed", abas.addToCartPopUpWasClosed());
    }

    @When("User adds a second product in the cart")
    public void userAddsASecondProductInTheCart() {
        abas.clickAddToCartPenultimateProduct();
    }

    @When("User clicks on View cart from the pop-up Add to cart")
    public void clickOnViewCartFromThePopUpAddToCart() {
        abas.clickViewCartButton();
    }

}
