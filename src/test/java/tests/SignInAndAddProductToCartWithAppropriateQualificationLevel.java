//package tests;
//
//import core.Utils;
//import org.junit.*;
//import pages.*;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class SignInAndAddProductToCartWithAppropriateQualificationLevel implements Utils {
//
//    static WebDriver driver = new ChromeDriver();
//    SignInPage signInPage = new SignInPage(driver);
//    StorePage storePage = new StorePage(driver);
//    CartPage cartPage = new CartPage(driver);
//    AccountsForCheckoutPage accountsForCheckoutPage = new AccountsForCheckoutPage(driver);
//    AdaptiveBehaviorAssessmentSystemPage programPage = new AdaptiveBehaviorAssessmentSystemPage(driver);
//    SecureCheckout secureCheckout = new SecureCheckout(driver);
//
//    @BeforeClass
//    public static void loadPage(){
//        driver.get(SIGN_IN_URL);
//        driver.manage().window().maximize();
//    }
//
//    @Test
//    public void endToEndTest() throws InterruptedException{
//        signInPage.clickClosePopUp();
//        signInPage.clickClosePopUpOurStores();
//        signInPage.enterUsername(USERNAME);
//        signInPage.enterCurrentPassword(CURRENT_PASSWORD);
//        signInPage.checkRememberMeCheckbox();
//        signInPage.clickSignInButton();
//        storePage.clickAbas3ProgramLink();
//        programPage.clickAllProductsFormatCard();
//        programPage.clickAddToCartFirstProduct();
//        Thread.sleep(1000);
//        programPage.clickPopUpAddToCartCloser();
//        Utils.scroll(driver, programPage.getAddToCartpenultimateButton());
//        programPage.clickAddToCartPenultimateProduct();
//        Thread.sleep(1000);
//        programPage.clickViewCartButton();
//        Thread.sleep(2000);
//        Utils.scroll(driver, cartPage.getCheckoutButton());
//        cartPage.clickCheckoutButton();
//        Thread.sleep(2000);
//        Utils.scroll(driver, accountsForCheckoutPage.getMyAccountRadioBox());
//        accountsForCheckoutPage.clickMyAccountRadioBox();
//        Thread.sleep(1000);
//        Utils.scroll(driver, accountsForCheckoutPage.getChooseQualifiedUserLabel());
//        Thread.sleep(2000);
//        Assert.assertEquals("This account is allowed to buy products at this level", accountsForCheckoutPage.getAccountAllowedToBuyParagraph());
//        Assert.assertTrue("The account is not qualified to buy products", accountsForCheckoutPage.isAccountQualifiedForProducts());
//        accountsForCheckoutPage.clickContinueButton();
//        Thread.sleep(3000);
//        secureCheckout.clickAddNewAddress();
//        secureCheckout.clickOnCountryDropdown();
//        Thread.sleep(2200);
//        secureCheckout.clickOptionFromCountryDropdown();
//        Thread.sleep(10000);
//        secureCheckout.clickTitleDropdown();
//        secureCheckout.clickOptionFromTitleDropdown();
//        secureCheckout.clickFirstNameInputField();
//        secureCheckout.typeFirstName("Andrei");
//        secureCheckout.clickLastNameInputField();
//        secureCheckout.typeLastName("Ungureanu");
//        secureCheckout.clickStreetAddressInputField();
//        secureCheckout.typeStreetAddress("Street 21");
//        secureCheckout.clickApartmentInputField();
//        secureCheckout.typeApartment();
//        secureCheckout.clickCityInputField();
//        secureCheckout.typeCityName();
//        secureCheckout.clickZipCodeInputField();
//        secureCheckout.typeZipCode("B1675");
//        secureCheckout.clickEmailAddressInputField();
//        secureCheckout.typeEmailAddress("andreiungureanu854@gmail.com");
//        secureCheckout.clickPhoneNumberInputField();
//        secureCheckout.typePhoneNumberInputField();
//        secureCheckout.clickSaveShippingAddressCheckbox();
//        secureCheckout.clickNextButtonFromShippingAddress();
//        Thread.sleep(2000);
//        secureCheckout.clickShippingMethodDropdown();
//        secureCheckout.clickOptionFromShippingMethodDropdown();
//        secureCheckout.clickNextButtonFromShippingMethod();
//
//
//
//    }
//
//    @After
//    public void deleteCookies(){
//        driver.manage().deleteAllCookies();
//    }
//
//    @AfterClass
//    public static void closePage(){
//        driver.close();
//    }
//
//}
