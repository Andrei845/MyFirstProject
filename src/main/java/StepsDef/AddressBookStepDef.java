package StepsDef;

import core.DriverInitiator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.AddressBook;

public class AddressBookStepDef {

    WebDriver driver = DriverInitiator.instantiateDriver();
    AddressBook addressBook = new AddressBook(driver);

    @Then("^Address book page is loaded$")
    public void checkIfAddressBookPageIsLoaded(){
        addressBook.waitAndCheckIfPageIsLoaded();
    }

    @And("^User deletes all the addresses containing \"(.*)\" on the page$")
    public void removeDisplayedAddresses(String toBeDeleted){
        addressBook.deleteAllTheAddressesContaining(toBeDeleted);
        addressBook.clickOnFeedBackPopUpCloser();
    }

    @And("^User clicks on Add Address link$")
    public void userClicksOnAddAddressLink(){
        addressBook.clickOnAddressLink();
    }
}
