import core.Utils;
import org.junit.*;
import pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SignInAndAddProductToCart implements Utils {
    static WebDriver driver = new ChromeDriver();
    SignInPage signInPage = new SignInPage(driver);
    StorePage storePage = new StorePage(driver);
    CartPage cartPage = new CartPage(driver);
    CheckOutPage checkOutPage = new CheckOutPage(driver);
    AdaptiveBehaviorAssessmentSystemPage programPage = new AdaptiveBehaviorAssessmentSystemPage(driver);

    @BeforeClass
    public static void loadPage(){
        driver.get(SIGN_IN_URL);
        driver.manage().window().maximize();
    }

    @Test
    public void endToEndTest() throws InterruptedException{
        signInPage.clickClosePopUp();
        signInPage.clickClosePopUpOurStores();
        signInPage.enterUsername(USERNAME);
        signInPage.enterCurrentPassword(CURRENT_PASSWORD);
        signInPage.checkRememberMeCheckbox();
        signInPage.clickSignInButton();
        storePage.clickAbas3ProgramLink();
        programPage.clickAllProductsFormatCard();
        storePage.clickAddToCartFirstProduct();
        Thread.sleep(1000);
        storePage.clickPopUpAddToCartCloser();
        Utils.scroll(driver, storePage.getAddToCartpenultimateButton());
        storePage.clickAddToCartPenultimateProduct();
        Thread.sleep(1000);
        programPage.clickViewCartButton();
        Thread.sleep(2000);
        Utils.scroll(driver, cartPage.getCheckoutButton());
        cartPage.clickCheckoutButton();
        Thread.sleep(2000);
        Utils.scroll(driver, checkOutPage.getMyAccountRadioBox());
        checkOutPage.clickMyAccountRadioBox();
        Thread.sleep(1000);
        Utils.scroll(driver, checkOutPage.getChooseQualifiedUserLabel());
        Thread.sleep(5000);
        Assert.assertTrue("The message displayed is not appropriate for the account and the product(s) in the cart", checkOutPage.isAppropriateMessageDisplayedForQualifications());

    }

    @After
    public void deleteCookies(){
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public static void closePage(){
        driver.close();
    }

}
