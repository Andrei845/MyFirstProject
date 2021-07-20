package pages;

import core.PageObject;
import core.ScrollerAndClicker;
import core.WaitUtils;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdaptiveBehaviorAssessmentSystemPage extends PageObject {

    public AdaptiveBehaviorAssessmentSystemPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@id = 'mcxContainer']//a[@id = 'declineSurvey']")
    private WebElement feedbackPopUpCloser;

    @FindBy(xpath = "//li[@class = 'preferred-format__card']/button[@value = 'ALL_PRODUCTS']")
    private WebElement allProductsFormatCard;

    @FindBy(xpath = "//div[@class = 'c-modal-actions']/a[@href='/store/usassessments/en/cart']")
    private WebElement viewCartButton;

    @FindBy(xpath = "//div[@id = 'colorbox']")
    private WebElement addToCartPopUp;

    @FindBy(xpath = "//form[@id = 'addToCartForm0158009150']/button[@type = 'submit']")
    private WebElement addToCartFirstProduct;

    @FindBy(xpath = "//form[@id = 'addToCartForm0158009231']/button[@type='submit']")
    private WebElement addToCartpenultimateButton;

    @FindBy(xpath = "//div[@id = 'cboxContent']/button[@id = 'cboxClose']")
    private WebElement popUpAddToCartCloser;

    public void clickAllProductsFormatCard() {

        allProductsFormatCard.click();
    }

    public void clickViewCartButton() {

        viewCartButton.click();
    }

    public boolean isAddToCartPopUpDisplayed() {
        WaitUtils.waitUntilElementIsDisplayed(addToCartPopUp);
        return addToCartPopUp.isDisplayed();
    }

    public boolean addToCartPopUpWasClosed() {
        WaitUtils.waitUntilElementIsNotDisplayed(addToCartPopUp);
        return !addToCartPopUp.isDisplayed();
    }

    public void clickAddToCartFirstProduct() {

        addToCartFirstProduct.click();
    }

    public void clickPopUpAddToCartCloser() {

        popUpAddToCartCloser.click();
    }

    public void clickAddToCartPenultimateProduct() {
        ScrollerAndClicker.scrollAndClick(addToCartpenultimateButton);
    }

    public void clickFeedbackPopUpCloser(){
        try {
            WaitUtils.waitUntilElementIsDisplayed(feedbackPopUpCloser, 2);
            feedbackPopUpCloser.click();
        } catch (TimeoutException ignored){ }
    }
}
