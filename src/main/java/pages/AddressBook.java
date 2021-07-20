package pages;

import core.PageObject;
import core.WaitUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressBook extends PageObject {

    public AddressBook(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath ="//div[@class = 'col-md-12']//a[@class = 'c-sectionHeader__btn']")
    private WebElement addAddressLink;

    @FindBy(xpath = "//span[@class = 'action-links glyphicon glyphicon-remove']")
    private WebElement addressBookCleaner;

    @FindBy(xpath = "//div[@id= 'colorbox']//a[@class = 'button button--primary button--block']")
    private WebElement deleteButtonForAddress;

    @FindBy(xpath = "//div[@id = 'mcxContainer']//a[@id = 'declineSurvey']")
    private WebElement feedbackPopUpCloser;

    public void clickOnAddressLink(){
        addAddressLink.click();
    }

    public void deleteAllTheAddresses(){
        try {
            while (addressBookCleaner.isDisplayed()) {
                addressBookCleaner.click();
                WaitUtils.waitUntilElementIsClickable(deleteButtonForAddress);
                deleteButtonForAddress.click();
                WaitUtils.waitUntilElementIsDisplayed(addressBookCleaner, 1);
            }
        }catch(NoSuchElementException | TimeoutException ignored){ }
    }

    public void clickOnFeedBackPopUpCloser(){
        try{
            WaitUtils.waitUntilElementIsDisplayed(feedbackPopUpCloser, 2);
            feedbackPopUpCloser.click();
        } catch(TimeoutException ignored){}
    }

}
