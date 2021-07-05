package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends PageObject {

    @FindBy(xpath = "//div[@class = 'item__ISBN']/div[@class ='item__code no-phone']")
    private WebElement productCode;

    @FindBy(xpath = "//div[@class ='c-cart-voucher js-voucher-respond']//label/following-sibling::em")
    private WebElement discountsNotApplicableForDistributedProductsLabel;

    @FindBy(xpath = "//div[@class = 'col-xs-12 notice']/em")
    private WebElement shippingAndTaxInformationLabel;

    @FindBy(xpath = "//div[@class = 'js-cart-totals row']/div[@class = 'col-xs-4 col-md-6 cart-totals-right text-right']")
    private WebElement estimatedOrderTotal;


    @FindBy(xpath = "//div[@class = 'js-cart-totals row']/div[@class = 'col-xs-5 col-md-6 cart-totals-right text-right grand-total js-total-price']")
    private WebElement grandTotal;

    @FindBy(xpath = "//div[@class = 'col-xs-12 col-sm-4 col-md-4 pull-right']/button[contains(@class,  'js-continue-checkout-button')]")
    private WebElement checkoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void clickCheckoutButton(){
        checkoutButton.click();
    }

    public WebElement getCheckoutButton(){
        return checkoutButton;
    }
}
