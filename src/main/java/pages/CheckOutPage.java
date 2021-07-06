package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends PageObject{

    @FindBy(xpath = "//div[@class=\"js-personalQualifiedUserStep\"]//span[contains(@class, \"js-cartQualificationLevel\")]")
    private WebElement itemsInCartQualificationLabel;

    @FindBy(xpath = "//div[@class=\"js-personalQualifiedUserStep\"]//span[contains(@class, \"jjs-customerQualificationLevel\")]")
    private WebElement accountQualificationLabel;

    @FindBy(xpath = "//label[@class =\"c-radiobtn c-boxed selected\"]//input[contains(@id, 'b6bcce8a32164e9b944dbc66d62e01a1')]")
    private WebElement myAccountRadioBox;

    public CheckOutPage(WebDriver driver){
        super(driver);
    }

    public void clickMyAccountRadioBox(){
        myAccountRadioBox.click();
    }
    public char[] getItemsInCartQualificationLabel(){
        return itemsInCartQualificationLabel.getText().toCharArray();
    }

    public String getAccountQualificationLabel(){
        System.out.println(accountQualificationLabel.getText());
//        return accountQualificationLabel.getText().toCharArray();
        return null;
    }

}
