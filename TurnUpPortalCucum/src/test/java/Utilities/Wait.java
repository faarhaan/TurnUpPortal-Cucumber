package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Wait {
    // Generic Function for wait for Element to be Clickable
    public static void WaitToBeClickable(WebDriver driver, String locatorType, String locatorValue, int Seconds)
    {
        //c #
        //var  wait = new WebDriverWait(driver, new TimeSpan(0,0, Seconds));
        var  wait = new WebDriverWait(driver, Duration.ofSeconds(Seconds));
        if (locatorType == "xpath")
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locatorValue)));
        if (locatorType == "id")
            wait.until(ExpectedConditions.elementToBeClickable(By.id(locatorValue)));
    }
    public static void WaitToBeVisible(WebDriver driver, String locatorType, String locatorValue, int Seconds)
    {
        var waitFor = new WebDriverWait(driver, Duration.ofSeconds(Seconds));
        if (locatorType == "xpath")
            waitFor.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
        if (locatorType == "Id")
            waitFor.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
    }
}
