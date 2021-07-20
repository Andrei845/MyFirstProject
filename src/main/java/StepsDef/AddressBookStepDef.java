package StepsDef;

import core.DriverInitiator;
import core.WaitUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.AddressBook;

public class AddressBookStepDef {

    WebDriver driver = DriverInitiator.instantiateDriver();
    AddressBook addressBook = new AddressBook(driver);

    @Then("^Address book page is loaded$")
    public void checkIfAddressBookPageIsLoaded(){
        WaitUtils.waitUntilPageIsLoaded(driver);
        Assert.assertEquals("You are not on the address book page","https://www.pearsonassessments.com/store/usassessments/en/my-account/address-book", driver.getCurrentUrl());

    }

    @And("^User deletes any addresses present here, if any$")
    public void closePresentAddressesIfAny(){
        addressBook.deleteAllTheAddresses();
        addressBook.clickOnFeedBackPopUpCloser();
    }

    @And("^User clicks on Add Address link$")
    public void userClicksOnAddAddressLink(){
        addressBook.clickOnAddressLink();
    }
}
