package pages;

import core.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class StorePage extends PageObject {

    @FindBy(xpath = "//li[@class = 'product__list--item']")
    private List<StoreProgramFragment> storeProgramFragmentList;

    @FindBy(xpath = "//div[@class= 'pagination-bar-results']/span")
    private WebElement numberOfItemsFoundInStoreSpan;

    @FindBy(xpath = "//div[@class= 'c-dropdown c-dropdown--inline c-dropdown--medium align-right']/label[@class = 'control-label']")
    private WebElement sortByLabel;

    @FindBy(xpath = "//li[@class= 'product__list--item']/a[@href = '/store/usassessments/en/Store/" +
            "Professional-Assessments/Cognition-%26-Neuro/Activity-Measure-for-Post-Acute-Care/p/P100003000.html']")
    private WebElement activityMeasureForPostAcuteCareLink;

    @FindBy(xpath = "//span[@class = 'facet__text']/a[@href = '/store/usassessments/en/Store/" +
            "c/store?q=%26%26relevance%26%26category%26%26cognition-neuro']")
    private WebElement cognitionAndNeuroCategoryLink;

    @FindBy(xpath = "//li[@class = 'product__list--item']/a[contains(@href, 'Third-Edition/p/100001262.html')]")
    private WebElement abas3ProgramLink;

    @FindBy(xpath = "//a[@href='/store/usassessments/en/Store/c/store?q=%26%26relevance%26%26category%26%26academic-learning']" +
            "/following-sibling::span")
    private WebElement SpanNumberOfProductsInAcademicLearningCategory;

    public StorePage(WebDriver driver) {
        super(driver);
    }

    public void clickAbas3ProgramLink() {
        abas3ProgramLink.click();
    }

    private StoreProgramFragment getProgramFragmentByTitle(String title){
        System.out.println("driver = "+driver);
        System.out.println("storeProgramFragmentList = "+storeProgramFragmentList);
        return storeProgramFragmentList
                .stream()
                .filter(iterator -> iterator.getTitle().getText().trim().equals(title))
                .findFirst()
                .orElseThrow (() -> new IllegalStateException("Program with the title "+title+" was not found"));

    }

//    private WebElement getProgramFragmentByTitle(String title){
//        System.out.println("driver = "+driver);
//        System.out.println("storeProgramFragmentList = "+storeProgramFragmentList);
//        return storeProgramFragmentList
//                .stream()
//                .filter(iterator -> iterator.getText().trim().equals(title))
//                .findFirst()
//                .orElseThrow (() -> new IllegalStateException("Program with the title "+title+" was not found"));
//
//    }
    public void clickOnTheProgram(String title){
//        WaitUtils.waitUntilElementIsDisplayed(getProgramFragmentByTitle(title).getTitle());
       getProgramFragmentByTitle(title).click();
    }


}
