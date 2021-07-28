package Fragments;

import core.GetBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderFragment {

    @FindBy(xpath = ".//div[@class = 'col-md-6 col-12']//a[@href = '/store/usassessments/en/order-status']")
    public WebElement orderStatusLink;
    public By byOrderStatusLink = GetBy.getBy("orderStatusLink", this.getClass());

    @FindBy(xpath = ".//div[@class = 'col-md-6 col-12']//a[@href = '/store/invoices']")
    public WebElement invoicesLink;
    public By byInvoicesLink = GetBy.getBy("invoicesLink", this.getClass());

    @FindBy(xpath = ".//div[@class = 'col-md-6 col-12']//a[@href = 'https://www.pearsonassessments.com/contact-us.html']")
    public WebElement contactUsLink;
    public By byContactUsLink = GetBy.getBy("contactUsLink", this.getClass());

    @FindBy(xpath = ".//div[@class = 'logo-v2 section']//img[@alt = 'Pearson logo']")
    public WebElement pearsonLogo;
    public By byPearsonLogo = GetBy.getBy("pearsonLogo", this.getClass());

    @FindBy(xpath = ".//form[@id = 'headerSearch']/input[@class = 'search-box-input ui-autocomplete-input']")
    public WebElement inputSearch;
    public By byInputSearch = GetBy.getBy("inputSearch", this.getClass());

    @FindBy(xpath = ".//ul[@id = 'mn-root--1228158151']//a[@href = '/store/usassessments/en/quickOrder']")
    public WebElement quickOrderLink;
    public By byQuickOrderLink = GetBy.getBy("quickOrderLink", this.getClass());

    @FindBy(xpath = ".//nav[@id = 'commerceHeader']//img[contains(@src, 'icons/ic_cart.svg')]")
    public WebElement cartImage;
    public By byCartImage = GetBy.getBy("cartImage", this.getClass());

    @FindBy(xpath = ".//a[@href = '/store/usassessments/en/login']")
    public WebElement signInLink;
    public By bySignInLink = GetBy.getBy("signInLink", this.getClass());




}
