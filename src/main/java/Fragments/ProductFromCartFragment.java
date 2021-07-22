package Fragments;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductFromCartFragment {

    @FindBy(xpath = ".//div[@class = 'program_name']/a")
    public WebElement name;

    @FindBy(xpath = ".//div[@class = 'item__code no-phone']")
    public WebElement isbnCode;

    @FindBy(xpath = ".//button[@class= 'btn btn-default js-cartItemDetailBtn']")
    public WebElement xToRemoveTheProduct;

    @FindBy(xpath = ".//a[@class= 'js-track-removecartitem']")
    public WebElement removeProductLink;

    @FindBy(xpath = ".//div[@class = 'item__quantity']//input[@name = 'quantity']")
    public WebElement productQuantityInput;

}
