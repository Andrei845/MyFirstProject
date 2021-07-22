package StepsDef;

import core.DriverInitiator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.CartPage;

public class CartPageStepDef {

    WebDriver driver = DriverInitiator.instantiateDriver();
    CartPage cartPage = new CartPage(driver);

    @Then("Check if According page is loaded")
    public void checkIfAccordingPageIsLoaded() {
        cartPage.waitAndCheckIfPageIsLoaded();
    }

    @And("^User modifies the quantity of the product with ISBN \"(.*)\" to \"(.*)\"$")
    public void userModifiesTheQuantityOfTheProductTo(String isbnCode, String quantity) {
        cartPage.changeQuantityOfTheProduct(isbnCode, quantity);
    }

    @And("^User removes the product with ISBN \"(.*)\" from cart$")
    public void userRemovesTheProductWithIsbn(String isbnCode) throws InterruptedException {
        cartPage.removeTheProductFromCartByIsbn(isbnCode);
    }

    @When("User clicks on the Checkout button")
    public void userClicksOnTheCheckoutButton() {
        cartPage.clickCheckoutButton();
    }

    @And("User clicks on My Account button from Cart page")
    public void clickMyAccountButton() {
        cartPage.clickMyAccountCartPageButton();
    }

    @And("User clicks on Address Book link from Cart page")
    public void clickAddressBookLink() {
        cartPage.clickAddressBookLink();
    }

    @And("User removes all the products remained in cart")
    public void removesAllProductsFromCart() {
        cartPage.removeAllProductsFromCart();
    }


}
