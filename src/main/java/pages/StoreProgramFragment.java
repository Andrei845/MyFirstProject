package pages;

import core.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@FindBy(xpath = "//li[@class = 'product__list--item']")
public class StoreProgramFragment extends PageObject {


    @FindBy(xpath = ".//a[@class = 'product__list--name']")
    private WebElement nameOfTheProgram;

    public StoreProgramFragment(WebDriver driver) {
        super(driver);
    }

    public WebElement getTitle(){
        return nameOfTheProgram;
    }

    public void click(){
        nameOfTheProgram.click();
    }




}
