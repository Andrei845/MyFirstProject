package pages;

import core.PageObject;
import core.ScrollerAndClicker;
import core.WaitUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static core.Utils.HOME_PAGE_URL;

public class HomePage extends PageObject {

    public HomePage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//div[contains(@class, 'cookie-notification')]//a[contains(@id, 'policy-accept-continue')]")
    private WebElement cookiesAcceptLink;

    @FindBy(xpath = "//button[@class='pop-up-close']")
    private WebElement closePopUpOurStores;

    @FindBy(xpath = "//div[@class = 'nav__right utility-nav--container']//a[@class = 'login-link ']")
    private WebElement signInRegisterLink;

    @FindBy(xpath = "//div[@class = 'nav__right utility-nav--container']//a[@title = 'Store']")
    private WebElement storeLink;

    @FindBy(xpath = "//div[@id = 'mcxCenter']//a[@id = 'declineSurvey']")
    private WebElement feedBackPopUpCloser;

    @FindBy(xpath = "//div[@class = 'header']//button[@class = 'js-context-switcher']")
    private WebElement myAccountButton;

    @FindBy(xpath = "//div[@class = 'header']//div[@class = 'context-menu']//a[@title = 'Address Book']")
    private WebElement addressBookLink;

    public void openHomePage(){
        driver.get(HOME_PAGE_URL);
        WaitUtils.waitUntilPageIsLoaded(driver);
    }

    public void waitAndCheckIfPageIsLoaded(){
        WaitUtils.waitUntilPageIsLoaded(driver);
        Assert.assertEquals("You are not on Home page!",HOME_PAGE_URL, driver.getCurrentUrl());
    }

    public void maximizeWindow(){
        driver.manage().window().maximize();
    }

    public void closePopUps(){
        closePopUpOurStores.click();
        cookiesAcceptLink.click();
    }

    public void clickOnSignInRegisterLink() {
        ScrollerAndClicker.scrollAndClick(signInRegisterLink);
    }

    public void checkIfPageIsLoaded(){
        WaitUtils.waitUntilPageIsLoaded(driver);
        Assert.assertEquals("You are not on the Home page", HOME_PAGE_URL, driver.getCurrentUrl());
    }

    public void clickOnStoreLink(){
        storeLink.click();
    }

    public void clickMyAccountButton(){
        myAccountButton.click();
    }

    public void clickOnAddressBookLink(){
        addressBookLink.click();
    }



}
