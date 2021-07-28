package StepsDef;

import core.DriverInitiator;
import core.Wait;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.SecureCheckout;

public class SecureCheckoutStepDef {

    WebDriver driver = DriverInitiator.instantiateDriver();
    SecureCheckout secureCheckout = new SecureCheckout(driver);
    
    @Then("Secure checkout page is loaded")
    public void userIsRedirectedToSecureCheckoutPage() {
        Wait.waitUntilPageIsLoaded(driver);
        Assert.assertEquals("You are not on the secure checkout page","https://www.pearsonassessments.com/store/usassessments/en/checkout/multi/delivery-address/add", driver.getCurrentUrl());
    }

    @And("^User types \"(.*)\" in the search input field$")
    public void userTypesInTheSearchInputField(String address){
        secureCheckout.typeInSearchAddressInputField(address);
    }

    @And("^User chooses from the results the address that matches \"(.*)\"$")
    public void userChoosesFromTheResultTheAccordingAddress(String address){
        secureCheckout.chooseTheAccordingAddress(address);
    }

    @When("User clicks on the Add a new address radio button")
    public void clickOnTheRadioButtonAddNewAddress() {
        secureCheckout.clickAddNewAddress();
    }

    @Then("The form address Form is displayed")
    public void theFormAddressFormIsDisplayed(){
        Assert.assertTrue("The form shipping address is not displayed ",secureCheckout.isFormShippingAddressDisplayed());
    }


    @And("^User clicks on \"(.*)\" from Country dropdown$")
    public void userClicksOnArgentinaFromCountryDropdown(String country){
        secureCheckout.clickOptionFromCountryDropdown(country);
        secureCheckout.waitFormToBeRefreshed();
    }

    @And("User clicks on the dropdown Title\\(optional)")
    public void userClicksOnTheDropdownTitleOptional() {
        secureCheckout.clickTitleDropdown();
    }

    @And("User clicks on PHD from Title\\(optional) dropdown")
    public void userClicksOnFromTitleOptionalDropdown() {
        secureCheckout.clickOptionFromTitleDropdown();
    }

    @And("^User clicks on the input field First name and types \"(.*)\"$")
    public void userTypesFirstName(String firstName) {
        secureCheckout.typeFirstName(firstName);
    }

    @And("^User clicks on the input field Last name and types \"(.*)\"$")
    public void userClicksOnTheInputFieldLastNameAndType(String lastName){
        secureCheckout.typeLastName(lastName);
    }

    @And("User clicks on the input field Street address and types \"(.*)\"$")
    public void userClicksOnTheInputFieldStreetAddressAndType(String address) {
        secureCheckout.clickStreetAddressInputFieldAndType(address);
    }

    @And("User clicks on the input field City and types '(.*)'$")
    public void userClicksOnTheInputFieldCityAndTypeBuenosAires(String city) {
        secureCheckout.clickCityInputFieldAndType(city);
    }

    @And("^User chooses \"(.*)\" from State\\/Province dropdown$")
    public void userChoosesAnOptionFromStateProvinceDropdown(String state) {
        secureCheckout.chooseWashingtonFromStateProvinceDropdown(state);
    }

    @And("^User types \"(.*)\" in the Postal Code input field$")
    public void userTypesInThePostalCodeInputField(String zip){
        secureCheckout.clickZipCodeAndType(zip);
    }

    @And("^User clicks on the input field Email address\\(optional\\) and types \"(.*)\"$")
    public void userClicksOnTheInputFieldEmailAddressOptionalAndTypes(String emailAddress) {
        secureCheckout.clickEmailAddressInputFieldAndType(emailAddress);
    }

    @And("^User types valid phone number \"(.*)\" in the field Phone number\\(optional\\)$")
    public void userTypesValidPhoneNumberInTheFieldPhoneNumberOptional(String phone) {
        secureCheckout.clickPhoneNumberInputFieldAndType(phone);
    }

    @And("User clicks on Next button from the form addressForm")
    public void userClicksOnNextButtonFromTheFormAddressForm() {
        secureCheckout.clickNextButtonFromShippingAddress();
    }

    @And("User clicks on the Next button")
    public void userClicksOnTheButton() {
        secureCheckout.clickNextButtonFromShippingMethod();
    }

    @And("User types valid details in the form Payment and billing")
    public void userTypesValidDetailsInTheFormPaymentAndBilling(){
        String cardNumber = "5102783165639128";
        String securityCode = "999";
        secureCheckout.clickAndInsertCardNumber(cardNumber);
        secureCheckout.clickExpiryMonthDropdown();
        secureCheckout.clickOptionFromExpiryMonthDropdown();
        secureCheckout.clickExpiryYearDropdown();
        secureCheckout.clickOptionFromExpiryYearDropdown();
        secureCheckout.insertSecurityCodeInputField(securityCode);
        secureCheckout.clickSaveCardCheckbox();
    }

    @And("User checks the checkbox privacy policy and terms of use")
    public void userChecksTheCheckboxPrivacyPolicyAndTermsOfUse() {
        secureCheckout.clickPrivacyPolicyAndTermsOfUseCheckbox();
    }

    @Then("The button Place order becomes enabled")
    public void theButtonBecomesEnabled() {
        Assert.assertTrue("The button is not enabled",secureCheckout.isClickablePlaceOrderButton());
    }

    @When("User clicks on button Back to cart")
    public void userClicksOnButtonBackToCart() {
        secureCheckout.clickBackToCartButton();
    }
}
