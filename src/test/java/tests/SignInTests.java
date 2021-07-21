package tests;

import core.Utils;
import pages.SignInRegisterPage;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Before;

public class SignInTests implements Utils {
    private static final WebDriver driver = new ChromeDriver();
    SignInRegisterPage signInRegisterPage = new SignInRegisterPage(driver);

    @Before
    public void loadPageAndClosePopUps(){
        driver.get(SIGN_IN_REGISTER_PAGE_URL);
        driver.manage().window().maximize();
        signInRegisterPage.clickClosePopUp();
        signInRegisterPage.clickClosePopUpOurStores();
    }

    @Test
    public void checkIfElementsAreDisplayed(){
        Assert.assertTrue("Store link is not displayed", signInRegisterPage.isStoreLinkDisplayed());
        Assert.assertTrue("Breadcrumb link is not displayed", signInRegisterPage.isSignInBreadcrumbDisplayed());
        signInRegisterPage.clickOnPearsonLogo();
    }

    @Test
    public void signIn(){
        signInRegisterPage.enterUsername(USERNAME);
        signInRegisterPage.enterCurrentPassword(CURRENT_PASSWORD);
        signInRegisterPage.clickSignInButton();
    }


    @After
    public void deleteCookies(){
        driver.manage().deleteAllCookies();
    }

    @AfterClass
     public static void cleanUp(){
        driver.close();
    }

}
