package Fragments;

import core.GetBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AssessmentSolutionsFragment {

    @FindBy(xpath =".//a")
    public WebElement assessmentSolutionsLink;
    public By byAssessmentSolutionsLink = GetBy.getBy("assessmentSolutionsLink", this.getClass());
}
