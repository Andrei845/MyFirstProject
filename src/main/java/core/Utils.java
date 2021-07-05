package core;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public interface Utils {
        String SIGN_IN_URL = "https://www.pearsonassessments.com/store/usassessments/en/login";
        String USERNAME = "andreiungureanu854";
        String CURRENT_PASSWORD = "Pearson854";

        static void scroll(WebDriver driver, WebElement element){
                ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
        }

        static void instantiatePages(Object obj){
                WebDriver driver = new ChromeDriver();
        }
}
