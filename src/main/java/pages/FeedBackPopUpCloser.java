package pages;

import core.PageObject;
import core.Wait;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FeedBackPopUpCloser extends PageObject {

    @FindBy(xpath = "//a[@id = 'declineSurvey']")
    private WebElement feedBackPopUpCloser;

    public FeedBackPopUpCloser(WebDriver driver){
        super(driver);
    }

    public void closeFeedBackPopUp(){
        try {
            Wait.waitUntilElementIsDisplayed(feedBackPopUpCloser, 2);
            feedBackPopUpCloser.click();
        } catch(TimeoutException ignored){}
    }
}
