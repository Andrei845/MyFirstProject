package pages;

import core.*;
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

//   @FindBy(xpath = "//div[@class = 'nav__right utility-nav--container']//a[@class = 'login-link ']")
    @FindBy(xpath = "//a[@href = '/store/usassessments/en/login']")
    private WebElement signInRegisterLink;

//    @FindBy(xpath = "//div[@class = 'nav__right utility-nav--container']//a[@title = 'Store']")
//    private WebElement storeLink;

    @FindBy(xpath = "//li[@class = 'dropdown  mega-nav-full-width']//a[@aria-controls= 'menu-item--assessmentssolutions']")
    private WebElement assessmentsSolutionsLink;

    @FindBy(xpath = "//div[@id = 'mcxCenter']//a[@id = 'declineSurvey']")
    private WebElement feedBackPopUpCloser;

//    @FindBy(xpath = "//div[@class = 'header']//button[@class = 'js-context-switcher']")
    @FindBy(xpath = "//button[@class = 'userNav__button jsUserSignedInIdentifier']/span")
    private WebElement myAccountButton;

//    @FindBy(xpath = "//div[@class = 'header']//div[@class = 'context-menu']//a[@title = 'Address Book']")
    @FindBy(xpath = "//ul[@id= 'userNav']//a[@title= 'Address Book']")
    private WebElement addressBookLink;

    @FindBy(xpath = "//ul[@id = 'mn-professionalassessments']//a[contains(@href, 'products/products-by-acronym')]")
    private WebElement productAToZLink;


    @FindBy(xpath = "//ul[@id= 'userNav']")
    private WebElement menuDisplayedUnderMyAccountButton;

    public void openHomePage(){
        driver.get(HOME_PAGE_URL);
        Wait.waitUntilPageIsLoaded(driver);
    }

    public void waitAndCheckIfPageIsLoaded(){
        Wait.waitUntilPageIsLoaded(driver);
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

    public void goToTheProductList(){
        assessmentsSolutionsLink.click();
        Wait.waitUntilElementIsDisplayed(productAToZLink);
        productAToZLink.click();
    }

    public void clickMyAccountButton() throws InterruptedException{
        Thread.sleep(4000);
        myAccountButton.click();
    }

    public void clickOnAddressBookLink(){
        Wait.waitUntilElementIsDisplayed(addressBookLink);
        addressBookLink.click();
    }

}
