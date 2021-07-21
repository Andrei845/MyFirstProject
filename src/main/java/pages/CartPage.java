package pages;

import core.PageObject;
import core.ScrollerAndClicker;
import core.WaitUtils;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static core.Utils.CART_PAGE_URL;

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

    @FindBy(xpath = "//div[@class = 'item__quantity']//input[@id = 'quantity_0']")
    private WebElement quantityInputField;

    @FindBy(xpath = "//div[@class = 'col-xs-12 col-sm-4 col-md-4 pull-right']/button[contains(@class,  'js-continue-checkout-button')]")
    private WebElement checkoutButton;

    @FindBy(xpath = "//div[@class = 'col-sm-8 col-md-8']//button[@class = 'js-context-switcher']")
    private WebElement myAccountCartPageButton;

    @FindBy(xpath = "//div[@class = 'js-context-account-menu context-account-menu']//a[@title= 'Address Book']")
    private WebElement addressBookLink;

    @FindBy(xpath = "//div[@class = 'btn-group js-cartItemDetailGroup']/button[@type = 'button']")
    private WebElement xToDeleteProductFromCart;

    @FindBy(xpath = "//li[@class = 'js-execute-entry-action-button']/a[@class = 'js-track-removecartitem']")
    private WebElement removeProductFromCartLink;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void waitAndCheckIfPageIsLoaded(){
        WaitUtils.waitUntilPageIsLoaded(driver);
        Assert.assertEquals("You are not on the cart page",CART_PAGE_URL, driver.getCurrentUrl());
    }

    public void insertQuantity(String quantity){
        quantityInputField.clear();
        quantityInputField.sendKeys(quantity);
    }


    public void clickCheckoutButton(){
        ScrollerAndClicker.scrollAndClick(checkoutButton);
    }

    public void clickMyAccountCartPageButton(){
        myAccountCartPageButton.click();
    }

    public void clickAddressBookLink(){
        addressBookLink.click();
    }

    public void removeAllProductsFromCart(){
        try{
            while(xToDeleteProductFromCart.isDisplayed()){
                xToDeleteProductFromCart.click();
                WaitUtils.waitUntilElementIsDisplayed(removeProductFromCartLink);
                removeProductFromCartLink.click();
                WaitUtils.waitUntilElementIsDisplayed(xToDeleteProductFromCart, 3);
            }
        } catch (NoSuchElementException | TimeoutException ignored){}
    }


}
