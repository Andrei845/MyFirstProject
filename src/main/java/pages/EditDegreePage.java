package pages;

import core.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class EditDegreePage extends PageObject {

    public EditDegreePage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//select[@id = 'degree']")
    private WebElement degreeDropDown;

    @FindBy(xpath = "//input[@id = 'majorField']")
    private WebElement majorFieldInput;

    @FindBy(xpath = "//input[@id = 'institution']")
    private WebElement institutionInputField;

    public void selectOptionFromDegreeDropdown(String visibleText){
        Select select = new Select(degreeDropDown);
        select.selectByVisibleText(visibleText);
    }

    public void typeInMajorFieldInput(String major){
        majorFieldInput.clear();
        majorFieldInput.sendKeys(major);
    }

    public void typeInstitutionInputField(String institution){
        institutionInputField.clear();
        institutionInputField.sendKeys(institution);
    }


}
