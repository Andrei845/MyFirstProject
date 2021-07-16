package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverInitiator {
    private static WebDriver driver;

    public static WebDriver instantiateDriver(){
        if(driver == null){
            driver = new ChromeDriver();
        }
        return driver;
    }
}
