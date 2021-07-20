package StepsDef;

import core.DriverInitiator;
import core.WaitUtils;
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
        WaitUtils.waitUntilPageIsLoaded(driver);
        Assert.assertEquals("You are not on the program page ABAS3","https://www.pearsonassessments.com/store/usassessments/en/Store/Professional-Assessments/Behavior/Brief/" +
                "Adaptive-Behavior-Assessment-System-%7C-Third-Edition/p/100001262.html", driver.getCurrentUrl());
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

    @When("Click on View cart from the pop-up Add to cart")
    public void clickOnViewCartFromThePopUpAddToCart() {
        abas.clickViewCartButton();
    }

}
