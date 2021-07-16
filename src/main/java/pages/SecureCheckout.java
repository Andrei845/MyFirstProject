package pages;

import core.ClickWithJavaScript;
import core.PageObject;
import core.Scroller;
import core.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SecureCheckout extends PageObject {

    public SecureCheckout(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//label[@for = 'addNewAddress']/span[@class = 'c-radiobtn__check']")
    private WebElement addNewAddressRadioButton;

    @FindBy(xpath = "//div[@class = 'c-select-wrapper']/select[@id = 'address.country']")
    private Select countryDropdown;

    @FindBy(xpath = "//div[@class = 'c-select-wrapper']//option[@value = 'AR']")
    private WebElement optionFromCountryDropdown;

    @FindBy(xpath = "//div[@class = 'c-select-wrapper']/select[@id = 'address.title']")
    private WebElement titleDropdown;

    @FindBy(xpath = "//div[@class = 'c-select-wrapper']//option[@value = 'phd']")
    private WebElement optionFromTitleDropdown;

    @FindBy(xpath = "//input[@id ='address.firstName']")
    private WebElement firstNameInputField;

    @FindBy(xpath = "//div[@class = 'form-group has-error']/input[@id ='address.firstName']")
    private WebElement firstNameErrorInputField;

    @FindBy(xpath = "//input[@id ='address.surname']")
    private WebElement lastNameInputField;

    @FindBy(xpath = "//input[@id ='address.line1']")
    private WebElement streetAddressInputField;

    @FindBy(xpath = "//input[@id ='address.line2']")
    private WebElement apartmentInputField;

    @FindBy(xpath = "//input[@id ='address.townCity']")
    private WebElement cityInputField;

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

    @FindBy(xpath = "//div[@class = 'c-select-wrapper']/select[@id = 'address.region']")
    private WebElement stateProvinceDropdown;

    @FindBy(xpath = "//option[@value = 'US-AL']")
    private WebElement optionFromStateProvinceDropdown;

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

    public void waitAddressFormToBeDisplayed(){
        WaitUtils.waitUntilElementIsDisplayed(addressForm);
    }

    public void clickAddNewAddress() {
        Scroller.scroll(driver, addNewAddressRadioButton);
        addNewAddressRadioButton.click();
    }

    public void clickOnCountryDropdown() {
        countryDropdown.click();
    }

    public void clickOptionFromCountryDropdown(String country){
        countryDropdown.selectByVisibleText(country);
        WaitUtils.waitUntilElementIsDisplayed(optionFromCountryDropdown);
        optionFromCountryDropdown.click();

    }

    public void clickTitleDropdown() {
        addNewAddressRadioButton.click();
    }

    public void clickOptionFromTitleDropdown() {
        WaitUtils.waitUntilElementIsDisplayed(optionFromTitleDropdown);
        optionFromTitleDropdown.click();
    }

    public void typeFirstName(String firstName) {
        if(firstNameInputField.getText().equals(firstName)) return;
        firstNameInputField.click();
        firstNameInputField.clear();
        typeIfInputFirstNameHasAnError(firstName);
    }

    private void typeIfInputFirstNameHasAnError(String firstNameError){
        firstNameErrorInputField.sendKeys(firstNameError);
    }


    public void typeLastName(String lastName) {
        if(lastNameInputField.getText().equals(lastName)) return;
        lastNameInputField.click();
        lastNameInputField.clear();
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
        Scroller.scroll(driver, cityInputField);
        if(cityInputField.getText().equals(cityName))return;
        cityInputField.click();
        cityInputField.clear();
        cityInputField.sendKeys(cityName);
    }

    public void chooseOptionFromStateProvinceDropdown(){
        stateProvinceDropdown.click();
        WaitUtils.waitUntilElementIsDisplayed(optionFromStateProvinceDropdown);
        optionFromStateProvinceDropdown.click();
    }

    public void clickZipCodeAndType(String zip) {
        zipCodeInputField.clear();
        zipCodeInputField.click();
        zipCodeInputField.sendKeys(zip);
    }

    public void clickEmailAddressInputFieldAndType(String email) {
        Scroller.scroll(driver, emailAddressInputField);
        emailAddressInputField.click();
        emailAddressInputField.sendKeys(email);
    }

    public void clickPhoneNumberInputFieldAndType(String phone) {
        Scroller.scroll(driver, phoneNumberInputField);
        phoneNumberInputField.click();
        phoneNumberInputField.sendKeys(phone);
    }

    public void clickSaveShippingAddressCheckbox() {
        saveShippingAddressCheckbox.click();
    }

    public void clickNextButtonFromShippingAddress() {
        Scroller.scroll(driver, nextButtonFromShippingAddress);
        nextButtonFromShippingAddress.click();
    }

    public void clickNextButtonFromShippingMethod() {
        WaitUtils.waitUntilElementIsDisplayed(nextButtonFromShippingMethod);
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
        WaitUtils.waitUntilElementIsDisplayed(optionFromExpiryMonthDropdown);
        optionFromExpiryMonthDropdown.click();
    }

    public void clickExpiryYearDropdown() {
        expiryYearDropdown.click();
    }

    public void clickOptionFromExpiryYearDropdown() {
        WaitUtils.waitUntilElementIsDisplayed(optionFromExpiryYearDropdown);
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
        WaitUtils.waitUntilElementIsDisplayed(formShippingAddress);
        return formShippingAddress.isDisplayed();
    }

    public void clickPrivacyPolicyAndTermsOfUseCheckbox() {
        ClickWithJavaScript.clickElement(privacyPolicyAndTermsOfUseCheckbox);
    }

    public boolean isClickablePlaceOrderButton() {
        Scroller.scroll(driver, placeOrderButton);
        WaitUtils.waitUntilElementIsClickable(placeOrderButton);
        return placeOrderButton.isEnabled();
    }


}
