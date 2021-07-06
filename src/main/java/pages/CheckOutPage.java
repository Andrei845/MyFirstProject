package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends PageObject {

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

    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    public void clickMyAccountRadioBox() {
        myAccountRadioBox.click();
    }

    public WebElement getMyAccountRadioBox() {
        return myAccountRadioBox;
    }

    public String getItemsInCartQualificationLabel() {

        return itemsInCartQualificationLabel.getText();
    }

    public String getItemsInTheCartQualificationLevel() {
        return itemsInCartQualificationLabel.getText();
    }

    public String getAccountQualificationLabel() {

        return accountQualificationLabel.getText();
    }

    public WebElement getChooseQualifiedUserLabel() {

        return chooseQualifiedUserLabel;
    }

    private boolean isIncreaseQualificationLevelLinkDisplayed() {
        boolean isLinkDisplayed = false;
        try {
            isLinkDisplayed = increaseQualificationLevelLink.isDisplayed();
        } catch (NoSuchElementException ex){
            ex.getStackTrace();
        } finally {
            return isLinkDisplayed;
        }
    }

    public boolean isAccountAllowedToBuyParagraphDisplayed() {
        boolean isParagraphDisplayed = false;
        try {
            isParagraphDisplayed = accountAllowedToBuyParagraph.isDisplayed();
        } catch (NoSuchElementException ex){
            ex.getStackTrace();
        } finally {
            return isParagraphDisplayed;
        }
    }


    private boolean isAccountQualifiedForProducts() {
        boolean isQualified = false;
        if ((this.getAccountQualificationLabel().compareTo(this.getItemsInCartQualificationLabel())) >= 0) {
            isQualified = true;
        } else {
            isQualified = false;
        }
        return isQualified;
    }


    public boolean isAppropriateMessageDisplayedForQualifications() {
        boolean isMessageAppropriate = false;
        if (this.isAccountQualifiedForProducts() == this.isAccountAllowedToBuyParagraphDisplayed() &&
                this.isAccountQualifiedForProducts() != this.isIncreaseQualificationLevelLinkDisplayed())
        {
            isMessageAppropriate = true;
        } else if (this.isAccountQualifiedForProducts() != this.isAccountAllowedToBuyParagraphDisplayed() &&
                this.isAccountQualifiedForProducts() == this.isIncreaseQualificationLevelLinkDisplayed())
        {
            isMessageAppropriate = true;
        } else {
            isMessageAppropriate = false;
        }
        return isMessageAppropriate;
    }
}