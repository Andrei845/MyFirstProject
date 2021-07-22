package Fragments;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormatCardFragment {

    @FindBy(xpath = ".//h5[@class = 'preferred-format__card-title']")
    public WebElement title;

    @FindBy(xpath = ".//span[@class = 'preferred-format__card-price'")
    public WebElement price;



}
