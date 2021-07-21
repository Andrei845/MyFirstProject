package pages;

import core.PageObject;
import core.ScrollerAndClicker;
import core.WaitUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static core.Utils.ACCOUNTS_FOR_CHECKOUT_PAGE_URL;

public class AccountsForCheckoutPage extends PageObject {

    @FindBy(xpath = "//div[@class='js-personalQualifiedUserStep']//span[contains(@class, 'js-cartQualificationLevel')]")
    private WebElement itemsInCartQualificationLabel;

    @FindBy(xpath = "//div[@class='js-personalQualifiedUserStep']//span[contains(@class, 'js-customerQualificationLevel')]")
    private WebElement accountQualificationLabel;

    @FindBy(xpath = "//div[@id = 'contextSelector']/label[@for= 'context-unit-b6bcce8a32164e9b944dbc66d62e01a1']")
    private WebElement myAccountRadioBox;

    @FindBy(xpath = "//div[@id = 'digitalAccountsFragmentStepContent']//div[@class= 'title']")
    private WebElement chooseQualifiedUserLabel;

    @FindBy(xpath = "//div[@class='js-cartQualificationNotMatched']//child::a[contains(@href, '/my-account/my-qualifications')]")
    private WebElement increaseQualificationLevelLink;

    @FindBy(xpath = "//div[@class= 'js-cartQualificationMatched']//p[@class = 'c-alert__text']")
    private WebElement accountAllowedToBuyParagraph;

    @FindBy(xpath = "//div[@id = 'digitalAccountFormSubmitID']/button[@type = 'submit']")
    private WebElement continueButton;
    
    public AccountsForCheckoutPage(WebDriver driver) {

        super(driver);
    }

    public void waitAndCheckIfPageIsLoaded(){
        WaitUtils.waitUntilPageIsLoaded(driver);
        Assert.assertEquals("You are not on the accounts for checkout page", ACCOUNTS_FOR_CHECKOUT_PAGE_URL, driver.getCurrentUrl());
    }

    public void clickMyAccountRadioBox() {

        myAccountRadioBox.click();
    }
    
    public void clickContinueButton(){

        ScrollerAndClicker.scrollAndClick(continueButton);
    }

}