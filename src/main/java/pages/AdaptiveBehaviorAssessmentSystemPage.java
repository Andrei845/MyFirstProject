package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdaptiveBehaviorAssessmentSystemPage extends PageObject{

    public AdaptiveBehaviorAssessmentSystemPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//li[@class = 'preferred-format__card']/button[@value = 'ALL_PRODUCTS']")
    private WebElement allProductsFormatCard;

    @FindBy(xpath = "//div[@class = 'c-modal-actions']/a[@href='/store/usassessments/en/cart']")
    private WebElement viewCartButton;

    public WebElement getAllProductsFormatCard(){
        return allProductsFormatCard;
    }

    public void clickAllProductsFormatCard(){
        allProductsFormatCard.click();
    }

    public void clickViewCartButton() {
        viewCartButton.click();
    }
}
