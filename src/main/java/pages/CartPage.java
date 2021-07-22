package pages;

import Fragments.ProductFromCartFragment;
import core.GetBy;
import core.PageObject;
import core.ScrollerAndClicker;
import core.Wait;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static core.Utils.CART_PAGE_URL;

public class CartPage extends PageObject {

    @FindBy(xpath = "//div[@class = 'col-xs-12 col-sm-4 col-md-4 pull-right']/button[contains(@class,  'js-continue-checkout-button')]")
    private WebElement checkoutButton;

    @FindBy(xpath = "//div[@class = 'col-sm-8 col-md-8']//button[@class = 'js-context-switcher']")
    private WebElement myAccountCartPageButton;

    @FindBy(xpath = "//div[@class = 'js-context-account-menu context-account-menu']//a[@title= 'Address Book']")
    private WebElement addressBookLink;

    @FindBy(xpath = "//li[@class = 'item__list--item--wrapper']")
    private List<WebElement> productsFromCart;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private WebElement filterBy(List<WebElement> list, By by, String toBeContained) {
        return list
                .stream()
                .filter(iterator -> iterator.findElement(by).getText().trim().contains(toBeContained))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("The product with isbn code " + toBeContained + " was not found"));

    }

    public void removeTheProductFromCartByIsbn(String isbnCode) {
        By isbn = GetBy.getBy("isbnCode", ProductFromCartFragment.class);
        By removeProductLink = GetBy.getBy("removeProductLink", ProductFromCartFragment.class);
        By xToRemoveTheProduct = GetBy.getBy("xToRemoveTheProduct", ProductFromCartFragment.class);

        filterBy(productsFromCart, isbn, isbnCode).findElement(xToRemoveTheProduct).click();
        filterBy(productsFromCart, isbn, isbnCode).findElement(removeProductLink).click();
    }

    private WebElement getTheProductWithISBN(String isbnCode) {
        By isbn = GetBy.getBy("isbnCode", ProductFromCartFragment.class);
        return filterBy(productsFromCart, isbn, isbnCode);
    }

    public void changeQuantityOfTheProduct(String isbnCode, String newQuantity) {
        By productQuantity = GetBy.getBy("productQuantityInput", ProductFromCartFragment.class);
        getTheProductWithISBN(isbnCode).findElement(productQuantity).sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE, newQuantity, Keys.ENTER);
    }

    public void waitAndCheckIfPageIsLoaded() {
        Wait.waitUntilPageIsLoaded(driver);
        Assert.assertEquals("You are not on the cart page", CART_PAGE_URL, driver.getCurrentUrl());
    }

    public void clickCheckoutButton() {
        ScrollerAndClicker.scrollAndClick(checkoutButton);
    }

    public void clickMyAccountCartPageButton() {
        myAccountCartPageButton.click();
    }

    public void clickAddressBookLink() {
        addressBookLink.click();
    }


//    public void removeAllProductsFromCart(){
//        try{
//            while(xToDeleteProductFromCart.isDisplayed()){
//                xToDeleteProductFromCart.click();
//                Wait.waitUntilElementIsDisplayed(removeProductFromCartLink);
//                removeProductFromCartLink.click();
//                Wait.waitUntilElementIsDisplayed(xToDeleteProductFromCart, 3);
//            }
//        } catch (NoSuchElementException | TimeoutException ignored){}
//    }

    public void removeAllProductsFromCart() {
        By xToRemoveTheProduct = GetBy.getBy("xToRemoveTheProduct", ProductFromCartFragment.class);
        By removeProductLink = GetBy.getBy("removeProductLink", ProductFromCartFragment.class);
        try {
            int i = 0;
            while (i < 99999) {
                productsFromCart
                        .stream()
                        .filter(iterator -> iterator.findElement(xToRemoveTheProduct).isDisplayed())
                        .findFirst()
                        .orElseThrow(() -> new IllegalStateException("")).findElement(xToRemoveTheProduct).click();

                productsFromCart
                        .stream()
                        .filter(iterator -> iterator.findElement(removeProductLink).isDisplayed())
                        .findFirst()
                        .orElseThrow(() -> new IllegalStateException("")).findElement(removeProductLink).click();
                i++;
            }

        } catch (NoSuchElementException | IllegalStateException ignored) { }

    }


}
