package pages;

import Fragments.AssessmentSolutionsFragment;
import Fragments.HeaderFragment;
import core.ClickWithJavaScript;
import core.PageObject;
import core.Wait;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static core.Utils.HOME_PAGE_URL;

public class HomePage extends PageObject {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[contains(@class, 'cookie-notification')]//a[contains(@id, 'policy-accept-continue')]")
    private WebElement cookiesAcceptLink;

    @FindBy(xpath = "//button[@class='pop-up-close']")
    private WebElement closePopUpOurStores;

    @FindBy(xpath = "//li[@class = 'dropdown  mega-nav-full-width']//a[@aria-controls= 'menu-item--assessmentssolutions']")
    private WebElement assessmentsSolutionsMenu;

    @FindBy(xpath = "//div[@id = 'mcxCenter']//a[@id = 'declineSurvey']")
    private WebElement feedBackPopUpCloser;

    @FindBy(xpath = "//button[contains(@class, 'jsUserSignedInIdentifier')]")
    private WebElement myAccountButton;

    @FindBy(xpath = "//li//a[contains(@href,'addresses')]")
    private WebElement addressBookLink;

    @FindBy(xpath = "//ul[@id = 'mn-professionalassessments']//a[contains(@href, 'products/products-by-acronym')]")
    private WebElement productAToZLink;

    @FindBy(xpath = "//ul[@id = 'menu-item--assessmentssolutions']")
    private WebElement formDisplayedByAssessmentsSolutions;

    @FindBy(xpath = "//div[@class = 'par-header parsys']")
    private WebElement headerFragment;
    HeaderFragment header = new HeaderFragment();

    @FindBy(xpath ="//ul[@id = 'mn-professionalassessments']//li")
    public List<WebElement> assessmentSolutionsLinks;
    AssessmentSolutionsFragment assessmentSolutionsFragment = new AssessmentSolutionsFragment();

    @FindBy(xpath = "//ul[@id= 'userNav']")
    private WebElement menuDisplayedUnderMyAccountButton;

    @FindBy(xpath = "//li[@role = 'none']/a[contains(@href, '/my-qualifications')]")
    private WebElement qualificationsLink;

    public void openHomePage() {
        driver.get(HOME_PAGE_URL);
        Wait.waitUntilPageIsLoaded(driver);
    }

    public void waitAndCheckIfPageIsLoaded() {
        Wait.waitUntilPageIsLoaded(driver);
        Assert.assertEquals("You are not on Home page!", HOME_PAGE_URL, driver.getCurrentUrl());
    }

    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public void closePopUps() {
        closePopUpOurStores.click();
        cookiesAcceptLink.click();
    }

    public void clickOnSignInRegisterLink() {
        headerFragment.findElement(header.bySignInLink).click();
    }

    public void goToTheLinkFromAssessmentSolution(String text){
        assessmentsSolutionsMenu.click();

        assessmentSolutionsLinks
                .stream()
                .filter(i -> i.findElement(assessmentSolutionsFragment.byAssessmentSolutionsLink).getText().trim().contains(text))
                .findFirst()
                .orElseThrow(()->new IllegalStateException("No link named "+text+" was found")).findElement(assessmentSolutionsFragment.byAssessmentSolutionsLink).click();

    }

    public void clickMyAccountButton() {
        ClickWithJavaScript.clickElement(myAccountButton);
    }

    public void clickOnAddressBookLink() {
        ClickWithJavaScript.clickElement(addressBookLink);
    }

    public void clickQualificationsLink(){
        ClickWithJavaScript.clickElement(qualificationsLink);
    }
}