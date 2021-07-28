package StepsDef;

import core.DriverInitiator;
import pages.FeedBackPopUpCloser;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import pages.EditDegreePage;

public class EditDegreeStepDef {
    WebDriver driver = DriverInitiator.instantiateDriver();
    EditDegreePage editDegreePage = new EditDegreePage(driver);

    @And("User closes the feedback pop-up")
    public void userClosesTheFeedbackPopUp(){
        new FeedBackPopUpCloser(driver).closeFeedBackPopUp();
    }

    @And("^User chooses \"(.*)\" from Degree dropdown$")
    public void userChoosesOptionFromDegreeDropdown(String option){
        editDegreePage.selectOptionFromDegreeDropdown(option);
    }

    @And("^User types \"(.*)\" in the Major/Field input field$")
    public void userTypesInTheMajorField(String toType){
        editDegreePage.typeInMajorFieldInput(toType);
    }

    @And("^User types \"(.*)\" in the Institution input field$")
    public void userTypesInTheInstitutionField(String toType){
        editDegreePage.typeInstitutionInputField(toType);
    }

}
