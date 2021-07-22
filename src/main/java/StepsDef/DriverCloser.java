package StepsDef;

import core.DriverInitiator;
import org.openqa.selenium.WebDriver;

public class DriverCloser {

//    @After
    public void closeDriver() {
        WebDriver driver = DriverInitiator.instantiateDriver();
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
