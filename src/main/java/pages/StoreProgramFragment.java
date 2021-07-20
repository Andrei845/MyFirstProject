package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//@FindBy(xpath = "//li[@class = 'product__list--item']")
public class StoreProgramFragment {


    @FindBy(xpath = ".//a[@class = 'product__list--name']")
    private WebElement nameOfTheProgram;

    public WebElement getTitle(){
        return nameOfTheProgram;
    }

    public void click(){
        nameOfTheProgram.click();
    }




}
