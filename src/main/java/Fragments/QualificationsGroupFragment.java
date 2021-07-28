package Fragments;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QualificationsGroupFragment {

    @FindBy(xpath = ".//div[@class = 'qualification-group-header col-sm-8']/h2")
    public WebElement titleOfTheGroup;

    @FindBy(xpath = ".//div[@class = 'qualification-group-details']")
    public WebElement detailsForQualificationsGroup;

    @FindBy(xpath = ".//div[@class = 'qualification-group-edit']/a")
    public WebElement editLinkForQualificationsGroup;



}
