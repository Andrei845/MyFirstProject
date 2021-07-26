package pages;

import core.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsByAcronymPage extends PageObject {

//    @FindBy(xpath = "//li[@class = 'product__list--item']")
//    private List<WebElement> storeProgramFragmentList;
//
//    @FindBy(xpath = "//div[@class= 'pagination-bar-results']/span")
//    private WebElement numberOfItemsFoundInStoreSpan;
//
//    @FindBy(xpath = "//div[@class= 'c-dropdown c-dropdown--inline c-dropdown--medium align-right']/label[@class = 'control-label']")
//    private WebElement sortByLabel;
//
//    @FindBy(xpath = "//span[@class = 'facet__text']/a[@href = '/store/usassessments/en/Store/" +
//            "c/store?q=%26%26relevance%26%26category%26%26cognition-neuro']")
//    private WebElement cognitionAndNeuroCategoryLink;
//
//    @FindBy(xpath = "//a[@href='/store/usassessments/en/Store/c/store?q=%26%26relevance%26%26category%26%26academic-learning']" +
//            "/following-sibling::span")
//    private WebElement SpanNumberOfProductsInAcademicLearningCategory;
//
//
//    private WebElement getProgramFragmentByTitle(String name){
//        By title = GetBy.getBy("nameOfTheProgram", StoreProgramFragment.class);
//
//        return storeProgramFragmentList
//                .stream()
//                .filter(iterator -> iterator.findElement(title).getText().trim().contains(name))
//                .findFirst()
//                .orElseThrow (() -> new IllegalStateException("Program with the title "+name+" was not found")).findElement(title);
//    }
//
//    public void clickOnTheProgram(String title){
//        Wait.waitUntilElementIsDisplayed(getProgramFragmentByTitle(title));
//       getProgramFragmentByTitle(title).click();
//    }

    @FindBy(xpath = "//a[@href = '/store/en/usd/p/100001262']")
    private WebElement abasLink;

        public ProductsByAcronymPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAbasLink(){
            abasLink.click();
    }


}
