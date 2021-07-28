package pages;

import Fragments.AddressCardFragment;
import core.GetBy;
import core.PageObject;
import core.Wait;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static core.Utils.ADDRESS_BOOK_PAGE_URL;

public class AddressBook extends PageObject {

    public AddressBook(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@id = 'buttonAddAddress']")
    private WebElement addAddressLink;

    @FindBy(xpath = "//span[@class = 'action-links glyphicon glyphicon-remove']")
    private WebElement addressBookCleaner;

    @FindBy(xpath = "//div[@id= 'colorbox']//a[@class = 'button button--primary button--block']")
    private WebElement deleteButtonForAddress;

    @FindBy(xpath = "//div[@id = 'mcxContainer']//a[@id = 'declineSurvey']")
    private WebElement feedbackPopUpCloser;

    @FindBy(xpath = "//li[@class = 'address-card white-card ']")
    private List<WebElement> listOfAddresses;

    public void waitAndCheckIfPageIsLoaded() {
        Wait.waitUntilPageIsLoaded(driver);
        Assert.assertEquals("You are not on the address book page", ADDRESS_BOOK_PAGE_URL, driver.getCurrentUrl());
    }

    public void clickOnAddAddressLink() {
        addAddressLink.click();
    }

    public void deleteAllTheAddressesContaining(String toBeDeleted) {
        By textInsideAddress = GetBy.getBy("textInsideAddress", AddressCardFragment.class);
        By xToRemoveTheAddress = GetBy.getBy("xToRemoveTheAddress", AddressCardFragment.class);

        try {
            while (true) {
                listOfAddresses
                        .stream()
                        .filter(i -> i.findElement(textInsideAddress).getText().trim().contains(toBeDeleted))
                        .findFirst()
                        .orElseThrow(() -> new IllegalStateException("")).findElement(xToRemoveTheAddress).click();
                        deleteButtonForAddress.click();
            }

        } catch (NoSuchElementException | IllegalStateException ignored) {
        }
    }


    public void clickOnFeedBackPopUpCloser() {
        try {
            Wait.waitUntilElementIsDisplayed(feedbackPopUpCloser, 2);
            feedbackPopUpCloser.click();
        } catch (TimeoutException ignored) {
        }
    }

}
