package pages;

import Fragments.FormatCardFragment;
import Fragments.ProductFromProgramPageFragment;
import core.GetBy;
import core.PageObject;
import core.ScrollerAndClicker;
import core.Wait;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static core.Utils.ABAS_PAGE_URL;

public class AdaptiveBehaviorAssessmentSystemPage extends PageObject {

    public AdaptiveBehaviorAssessmentSystemPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//li[@class = 'preferred-format__card']")
    private List<WebElement> formatCardsList;

    @FindBy(xpath = "//li[@class = 'program-page__item']")
    private List<WebElement> productsToBeAddedToCart;

    @FindBy(xpath = "//div[@id = 'mcxContainer']//a[@id = 'declineSurvey']")
    private WebElement feedbackPopUpCloser;

    @FindBy(xpath = "//div[@class = 'c-modal-actions']/a[@href='/store/usassessments/en/cart']")
    private WebElement viewCartButton;

    @FindBy(xpath = "//div[@id = 'colorbox']")
    private WebElement addToCartPopUp;

    @FindBy(xpath = "//div[@id = 'cboxContent']/button[@id = 'cboxClose']")
    private WebElement popUpAddToCartCloser;

    public void waitAndCheckIfPageIsLoaded(){
        Wait.waitUntilPageIsLoaded(driver);
        Assert.assertEquals("You are not on the program page ABAS3", ABAS_PAGE_URL, driver.getCurrentUrl());
    }

    public void clickViewCartButton() {

        viewCartButton.click();
    }

    public boolean isAddToCartPopUpDisplayed() {
        Wait.waitUntilElementIsDisplayed(addToCartPopUp);
        return addToCartPopUp.isDisplayed();
    }

    public boolean addToCartPopUpWasClosed() {
        Wait.waitUntilElementIsNotDisplayed(addToCartPopUp);
        return !addToCartPopUp.isDisplayed();
    }

    private WebElement getTileByTitle(String tileName){
        By title = GetBy.getBy("title", FormatCardFragment.class);

        return formatCardsList
                .stream()
                .filter(iterator -> iterator.findElement(title).getText().trim().contains(tileName))
                .findFirst()
                .orElseThrow (() -> new IllegalStateException("Program with the title "+tileName+" was not found"));
    }

    public void clickOnTheTile(String tileName){
        getTileByTitle(tileName).click();
    }

    private WebElement getProductBy(String isbn){
        By isbnNumber = GetBy.getBy("isbnNumber", ProductFromProgramPageFragment.class);
        By addToCartButton = GetBy.getBy("addToCartButton", ProductFromProgramPageFragment.class);

        return productsToBeAddedToCart
                .stream()
                .filter(item -> item.findElement(isbnNumber).getText().trim().contains(isbn))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("The product with isbn "+isbn+" was not found")).findElement(addToCartButton);
    }

    public void clickOnAddToCart(String isbn){
        Wait.waitUntilElementIsDisplayed(getProductBy(isbn));
        ScrollerAndClicker.scrollAndClick(getProductBy(isbn));
    }


    public void clickPopUpAddToCartCloser() {

        popUpAddToCartCloser.click();
    }

    public void clickFeedbackPopUpCloser(){
        try {
            Wait.waitUntilElementIsDisplayed(feedbackPopUpCloser, 2);
            feedbackPopUpCloser.click();
        } catch (TimeoutException ignored){ }
    }

}
