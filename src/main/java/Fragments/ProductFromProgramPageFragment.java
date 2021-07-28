package Fragments;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductFromProgramPageFragment {

    @FindBy(xpath = ".//h6[@class = 'product-title']")
    public WebElement titleOfTheProduct;

    @FindBy(xpath = ".//span[@class = 'product-number']")
    public WebElement isbnNumber;

    @FindBy(xpath = ".//button[@data-modal-title = 'Add to cart']")
    public WebElement addToCartButton;
}
