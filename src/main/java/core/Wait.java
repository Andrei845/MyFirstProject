package core;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static core.Utils.DEFAULT_TIME_TO_WAIT;

public abstract class Wait {

    private static final WebDriver driver = DriverInitiator.instantiateDriver();

    public static void implicitWait(long time) {
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    public static void waitUntilElementIsClickable(WebElement element) {
        new WebDriverWait(driver, DEFAULT_TIME_TO_WAIT).until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitUntilElementIsSelected(long time, WebElement element) {
        new WebDriverWait(driver, time).until(ExpectedConditions.elementToBeSelected(element));
    }

    public static void waitUntilElementIsDisplayed(WebElement element) {
        new WebDriverWait(driver, DEFAULT_TIME_TO_WAIT).until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitUntilElementIsDisplayed(WebElement element, int timeToWait) {
            new WebDriverWait(driver, timeToWait).until(ExpectedConditions.visibilityOf(element));
    }


    public static void waitUntilElementIsNotDisplayed(WebElement element) {
        new WebDriverWait(driver, DEFAULT_TIME_TO_WAIT).until(ExpectedConditions.invisibilityOf(element));
    }

    public static void fluentWait(long totalTime, long pollingTime) {

        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(totalTime))
                .pollingEvery(Duration.ofSeconds(pollingTime))
                .ignoring(NoSuchElementException.class);
    }

    public static void waitUntilRefreshed(WebElement element){
        new WebDriverWait(driver, DEFAULT_TIME_TO_WAIT).until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
    }



    public static void waitUntilPageIsLoaded(WebDriver webDriver) {
        if (waitForJs(webDriver)) {
            waitForJQuery(webDriver);
        }
    }

    private static boolean waitForJs(WebDriver webDriver) {
        WebDriverWait wait = new WebDriverWait(webDriver, Utils.DEFAULT_TIME_TO_WAIT);
        return wait.until((ExpectedCondition<Boolean>) driver -> ((JavascriptExecutor) driver).executeScript(
                "return document.readyState"
        ).equals("complete"));
    }

    private static void waitForJQuery(WebDriver webDriver) {
        WebDriverWait wait = new WebDriverWait(webDriver, Utils.DEFAULT_TIME_TO_WAIT);
        wait.until((ExpectedCondition<Boolean>) driver -> (Long) ((JavascriptExecutor) driver).executeScript(
                "return jQuery.active"
        ) == 0);
    }

}
