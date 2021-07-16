package tests;

import core.Utils;
import pages.SignInPage;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Before;

public class SignInTests implements Utils {
    private static final WebDriver driver = new ChromeDriver();
    SignInPage signInPage = new SignInPage(driver);

    @Before
    public void loadPageAndClosePopUps(){
        driver.get(SIGN_IN_URL);
        driver.manage().window().maximize();
        signInPage.clickClosePopUp();
        signInPage.clickClosePopUpOurStores();
    }

    @Test
    public void checkIfElementsAreDisplayed(){
        Assert.assertTrue("Store link is not displayed", signInPage.isStoreLinkDisplayed());
        Assert.assertTrue("Breadcrumb link is not displayed", signInPage.isSignInBreadcrumbDisplayed());
        signInPage.clickOnPearsonLogo();
    }

    @Test
    public void signIn(){
        signInPage.enterUsername(USERNAME);
        signInPage.enterCurrentPassword(CURRENT_PASSWORD);
        signInPage.clickSignInButton();
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
