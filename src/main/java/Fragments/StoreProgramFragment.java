package Fragments;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StoreProgramFragment {

    @FindBy(xpath = ".//a[@class = 'product__list--name']")
    public WebElement nameOfTheProgram;


}
