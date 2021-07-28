package pages;

import core.ClickWithJavaScript;
import core.PageObject;
import core.ScrollerAndClicker;
import core.Wait;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SecureCheckout extends PageObject {

    public SecureCheckout(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//form[@name = 'searchAddressForm']/input[@type = 'search']")
    private WebElement searchAddressInputField;

    @FindBy(xpath = "//div[@class = 'search-address-data ui-menu-item-wrapper']")
    private WebElement resultFromSearch;

    @FindBy(xpath = "//label[@for = 'addNewAddress']/span[@class = 'c-radiobtn__check']")
    private WebElement addNewAddressRadioButton;

    @FindBy(xpath = "//div[@class = 'c-select-wrapper']/select[@id = 'address.country']")
    private WebElement countryDropdown;

    @FindBy(xpath = "//div[@class = 'c-select-wrapper']/select[@id = 'address.title']")
    private WebElement titleDropdown;

    @FindBy(xpath = "//div[@class = 'c-select-wrapper']//option[@value = 'phd']")
    private WebElement optionFromTitleDropdown;

    @FindBy(xpath = "//input[@id ='address.firstName']")
    private WebElement firstNameInputField;

    @FindBy(xpath = "//input[@id ='address.surname']")
    private WebElement lastNameInputField;

    @FindBy(xpath = "//input[@id ='address.line1']")
    private WebElement streetAddressInputField;

    @FindBy(xpath = "//input[@id ='address.line2']")
    private WebElement apartmentInputField;

    @FindBy(xpath = "//input[@id ='address.townCity']")
    private WebElement cityInputField;

    @FindBy(xpath = "//div[@class = 'c-select-wrapper']/select[@id = 'address.region']")
    private WebElement stateProvinceDropdown;

    @FindBy(xpath = "//input[@id ='address.postcode']")
    private WebElement zipCodeInputField;

    @FindBy(xpath = "//input[@id ='address.email']")
    private WebElement emailAddressInputField;

    @FindBy(xpath = "//input[@id = 'address.phone']")
    private WebElement phoneNumberInputField;

    @FindBy(xpath = "//label[@class = 'c-checkbox add-address-left-label']/span[@class = 'c-checkbox__check']")
    private WebElement saveShippingAddressCheckbox;

    @FindBy(xpath = "//button[@id = 'addressSubmit']")
    private WebElement nextButtonFromShippingAddress;

    @FindBy(xpath = "//option[@value = 'AW']")
    private WebElement arubaOption;

    @FindBy(xpath = "//div[@class = 'control c-select-wrapper']//select[@id = 'delivery_method']")
    private WebElement shippingMethodDropdown;

    @FindBy(xpath = "//option[@selected = 'selected']")
    private WebElement optionFromShippingMethodDropdown;

    @FindBy(xpath = "//div[@class = 'checkout-shipping']/button[@id = 'deliveryMethodSubmit']")
    private WebElement nextButtonFromShippingMethod;

    @FindBy(xpath = "//div[@class = 'form-group']/input[@id = 'card_accountNumber']")
    private WebElement cardNumberInputField;

    @FindBy(xpath = "//div[@class = 'c-select-wrapper']/select[@id = 'ExpiryMonth']")
    private WebElement expiryMonthDropdown;

    @FindBy(xpath = "//select[@id= 'ExpiryMonth']/option[@value = '2']")
    private WebElement optionFromExpiryMonthDropdown;

    @FindBy(xpath = "//div[@class = 'c-select-wrapper']/select[@id = 'ExpiryYear']")
    private WebElement expiryYearDropdown;

    @FindBy(xpath = "//select[@id = 'ExpiryYear']/option[@value = '2025']")
    private WebElement optionFromExpiryYearDropdown;

    @FindBy(xpath = "//div[@class = 'form-group']/input[@name = 'card_cvNumber']")
    private WebElement securityCodeInputField;

    @FindBy(xpath = "//div[@id = 'card_save_payment_infoError']//span[@class = 'c-checkbox__check']")
    private WebElement saveCardCheckbox;

    @FindBy(xpath = "//form[@id= 'addressForm']")
    private WebElement formShippingAddress;

    @FindBy(xpath = "//label[@class = 'c-checkbox']")
    private WebElement privacyPolicyAndTermsOfUseCheckbox;

    @FindBy(xpath = "//button[@id = 'placeOrder']")
    private WebElement placeOrderButton;

    @FindBy(xpath = "//div[contains(@class, 'add-new-address')]")
    private WebElement addressForm;

    @FindBy(xpath = "//ol[@class = 'c-breadcrumb__list show-children--all']//a")
    private WebElement backToCart;

    public void waitAddressFormToBeDisplayed(){
        Wait.waitUntilElementIsDisplayed(addressForm);
    }

    public void typeInSearchAddressInputField(String search){
        searchAddressInputField.click();
        searchAddressInputField.sendKeys(search);
    }

    public WebElement getResultFromSearch(){
        Wait.waitUntilElementIsDisplayed(resultFromSearch);
        return resultFromSearch;
    }

    public void chooseTheAccordingAddress(String addressFragment){
        while(!this.getResultFromSearch().getText().contains(addressFragment)) {
            searchAddressInputField.sendKeys(Keys.ARROW_DOWN);
        }
        resultFromSearch.click();
    }

    public void clickAddNewAddress() {
        ScrollerAndClicker.scrollAndClick(addNewAddressRadioButton);
    }

    public void clickOptionFromCountryDropdown(String country){
        Select countryDrop = new Select(countryDropdown);
        countryDrop.selectByVisibleText(country);
    }

    public void waitFormToBeRefreshed(){
        Wait.waitUntilRefreshed(addressForm);
    }

    public void clickTitleDropdown() {
        addNewAddressRadioButton.click();
    }

    public void clickOptionFromTitleDropdown() {
        Wait.waitUntilElementIsDisplayed(optionFromTitleDropdown);
        optionFromTitleDropdown.click();
    }

    public void typeFirstName(String firstName) {
        if(firstNameInputField.getText().equals(firstName)) return;
        firstNameInputField.click();
        firstNameInputField.clear();
        firstNameInputField.sendKeys(firstName);
    }

    public void typeLastName(String lastName) {
        if(lastNameInputField.getText().equals(lastName)) return;
        lastNameInputField.click();
        lastNameInputField.clear();
        lastNameInputField.sendKeys(lastName);
    }

    public void clickStreetAddressInputFieldAndType(String address) {
        if(streetAddressInputField.getText().equals(address))return;
        streetAddressInputField.click();
        streetAddressInputField.clear();
        streetAddressInputField.sendKeys(address);
    }

    public void clickApartmentInputFieldAndType(String apartment) {
        if(apartmentInputField.getText().equals(apartment)) return;
        apartmentInputField.click();
        apartmentInputField.clear();
        apartmentInputField.sendKeys(apartment);
    }

    public void clickCityInputFieldAndType(String cityName) {
        ScrollerAndClicker.scrollAndClick(cityInputField);
        if(cityInputField.getText().equals(cityName))return;
        cityInputField.clear();
        cityInputField.sendKeys(cityName);
    }

    public void chooseWashingtonFromStateProvinceDropdown(String state){
        Select select = new Select(stateProvinceDropdown);
        select.selectByVisibleText(state);
    }

    public void clickZipCodeAndType(String zip) {
        zipCodeInputField.clear();
        zipCodeInputField.click();
        zipCodeInputField.sendKeys(zip);
    }

    public void clickEmailAddressInputFieldAndType(String email) {
        ScrollerAndClicker.scrollAndClick(emailAddressInputField);
        emailAddressInputField.sendKeys(email);
    }

    public void clickPhoneNumberInputFieldAndType(String phone) {
        ScrollerAndClicker.scrollAndClick(phoneNumberInputField);
        phoneNumberInputField.sendKeys(phone);
    }

    public void clickNextButtonFromShippingAddress() {
        Wait.waitUntilElementIsClickable(nextButtonFromShippingAddress);
        ScrollerAndClicker.scrollAndClick(nextButtonFromShippingAddress);
    }

    public void clickNextButtonFromShippingMethod() {
        Wait.waitUntilElementIsDisplayed(nextButtonFromShippingMethod);
        nextButtonFromShippingMethod.click();
    }

    public void clickAndInsertCardNumber(String cardNumber) {
        cardNumberInputField.click();
        cardNumberInputField.sendKeys(cardNumber);
    }

    public void clickExpiryMonthDropdown() {
        expiryMonthDropdown.click();
    }

    public void clickOptionFromExpiryMonthDropdown() {
        Wait.waitUntilElementIsDisplayed(optionFromExpiryMonthDropdown);
        optionFromExpiryMonthDropdown.click();
    }

    public void clickExpiryYearDropdown() {
        expiryYearDropdown.click();
    }

    public void clickOptionFromExpiryYearDropdown() {
        Wait.waitUntilElementIsDisplayed(optionFromExpiryYearDropdown);
        optionFromExpiryYearDropdown.click();
    }

    public void insertSecurityCodeInputField(String securityCode) {
        securityCodeInputField.click();
        securityCodeInputField.sendKeys(securityCode);
    }

    public void clickSaveCardCheckbox() {
        saveCardCheckbox.click();
    }

    public boolean isFormShippingAddressDisplayed() {
        Wait.waitUntilElementIsDisplayed(formShippingAddress);
        return formShippingAddress.isDisplayed();
    }

    public void clickPrivacyPolicyAndTermsOfUseCheckbox() {
        ClickWithJavaScript.clickElement(privacyPolicyAndTermsOfUseCheckbox);
    }

    public boolean isClickablePlaceOrderButton() {
        ScrollerAndClicker.scrollToElement(placeOrderButton);
        Wait.waitUntilElementIsClickable(placeOrderButton);
        return placeOrderButton.isEnabled();
    }

    public void clickBackToCartButton(){
        backToCart.click();
    }

}
