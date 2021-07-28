package StepsDef;

import core.DriverInitiator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.AddAddressPage;

public class AddAddressStepDef {
    WebDriver driver = DriverInitiator.instantiateDriver();
    AddAddressPage addressPage = new AddAddressPage(driver);

    @Then("Add Address page is loaded")
    public void addAddressPageIsLoaded(){
        addressPage.clickFeedBackPopUpCloser();
    }

    @And("Address Form is displayed")
    public void isAddressFormDisplayed(){
        Assert.assertTrue("Form Shipping Address is not displayed",addressPage.isFormShippingAddressDisplayed());
    }

    @And("^User chooses \"(.*)\" from Country dropdown$")
    public void userChoosesUnitedStatedFromCountryDrop(String country){
        addressPage.selectCountryFromDropDown(country);
    }

    @And("^User chooses \"(.*)\" from Title dropdown$")
    public void userChoosesPHDFromTitleDrop(String title){
        addressPage.selectTitleFromDropDown(title);
    }

    @And("^User types \"(.*)\" in the First name input field$")
    public void typeFirstName(String firstName){
        addressPage.insertFirstName(firstName);
    }

    @And("^User types \"(.*)\" in the Last name input field$")
    public void typeLastName(String lastName){
        addressPage.insertLastName(lastName);
    }

    @And("^User types \"(.*)\" in the field Street address$")
    public void typeStreetAddress(String street){
        addressPage.insertStreetAddress(street);
    }

    @And("^User types \"(.*)\" in the field Apartment$")
    public void typeApartment(String apartment){
        addressPage.insertApartment(apartment);
    }

    @And("^User types \"(.*)\" in the input field City$")
    public void typeCity(String city){
        addressPage.insertCity(city);
    }

    @And("^User chooses the option \"(.*)\" from State/Province dropdown$")
    public void choseStateProvince(String state){
        addressPage.selectStateProvince(state);
    }

    @And("^User types \"(.*)\" in the Zip Code input field$")
    public void insertZip(String zip){
        addressPage.insertZipPostalCode(zip);
    }

    @And("^User types \"(.*)\" in the input field Email address\\(optional\\)$")
    public void typeEmailAddress(String emailAddress){
        addressPage.insertEmailAddress(emailAddress);
    }

    @And("^User types phone number \"(.*)\" in the field Phone number\\(optional\\)$")
    public void typePhoneNumber(String phoneNumber){
        addressPage.insertPhoneNumber(phoneNumber);
    }

    @And("^User clicks on Save button$")
    public void clickSaveButton(){
        addressPage.clickSaveButton();
    }
}
