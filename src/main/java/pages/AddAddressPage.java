package pages;

import core.DriverInitiator;
import core.PageObject;
import core.WaitUtils;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddAddressPage extends PageObject {
    WebDriver driver = DriverInitiator.instantiateDriver();

    public AddAddressPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//div[@id = 'mcxContainer']//a[@id = 'declineSurvey']")
    private WebElement feedbackPopUpCloser;

    @FindBy(xpath = "//form[@id= 'addressForm']")
    private WebElement formShippingAddress;

    @FindBy(xpath = "//div[@class = 'c-select-wrapper']/select[@id = 'address.country']")
    private WebElement countryDropdown;

    @FindBy(xpath = "//div[@class = 'c-select-wrapper']/select[@id = 'address.title']")
    private WebElement titleDropdown;

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

    @FindBy(xpath = "//div[@class = 'col-sm-6 col-sm-push-6']/button")
    private WebElement saveButton;

    public boolean isFormShippingAddressDisplayed() {
        WaitUtils.waitUntilElementIsDisplayed(formShippingAddress);
        return formShippingAddress.isDisplayed();
    }

    public void selectCountryFromDropDown(String country){
        Select select = new Select(countryDropdown);
        select.selectByVisibleText(country);
    }

    public void selectTitleFromDropDown(String title){
        Select select = new Select(titleDropdown);
        select.selectByVisibleText(title);
    }

    public void insertFirstName(String firstName){
        firstNameInputField.sendKeys(firstName);
    }

    public void insertLastName(String lastName){
        lastNameInputField.sendKeys(lastName);
    }

    public void insertStreetAddress(String address){
        streetAddressInputField.sendKeys(address);
    }

    public void insertApartment(String apartment){
        apartmentInputField.sendKeys(apartment);
    }

    public void insertCity(String city){
        cityInputField.sendKeys(city);
    }

    public void selectStateProvince(String stateProvince){
        Select select = new Select(stateProvinceDropdown);
        select.selectByVisibleText(stateProvince);
    }

    public void insertZipPostalCode(String zip){
        zipCodeInputField.sendKeys(zip);
    }

    public void insertEmailAddress(String emailAddress){
        emailAddressInputField.sendKeys(emailAddress);
    }

    public void insertPhoneNumber(String phoneNumber){
        phoneNumberInputField.sendKeys(phoneNumber);
    }

    public void clickSaveButton(){
        WaitUtils.waitUntilElementIsClickable(saveButton);
        saveButton.click();
    }

    public void clickFeedBackPopUpCloser(){
        try {
            WaitUtils.waitUntilElementIsDisplayed(feedbackPopUpCloser, 2);
            feedbackPopUpCloser.click();
        } catch(TimeoutException ignored){ }
    }
}
