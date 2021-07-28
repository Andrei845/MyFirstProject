package pages;

import Fragments.QualificationsGroupFragment;
import core.GetBy;
import core.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class QualificationsPage extends PageObject {

    public QualificationsPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//div[@class = 'content c-qualificationlevel']/span[contains(@class, 'c-qualificationlevel__letter')]")
    private WebElement qualificationLetter;

    @FindBy(xpath ="//div[@class = 'qualification-group']")
    private List<WebElement>qualificationsGroupList;


    public void clickEditForQualificationGroupNamed(String name){

        By titleOfTheGroup = GetBy.getBy("titleOfTheGroup", QualificationsGroupFragment.class);
        By editLinkForQualificationsGroup = GetBy.getBy("editLinkForQualificationsGroup", QualificationsGroupFragment.class);

        qualificationsGroupList
                .stream()
                .filter(i -> i.findElement(titleOfTheGroup).getText().trim().contains(name))
                .findFirst()
                .orElseThrow(()-> new IllegalStateException("The qualification group "+name+" was not found")).findElement(editLinkForQualificationsGroup).click();
    }


}
