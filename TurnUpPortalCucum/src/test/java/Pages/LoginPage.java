package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage {
    public void LoginActions(WebDriver driver) throws InterruptedException {
        // Launch TurnUp Portal
        driver.navigate().to("http://horse.industryconnect.io");
        Thread.sleep(4000);
        driver.manage().window().maximize();
        Thread.sleep(1000);

        try
        {
            // Step-3 Identify username text box and enter valid user name
            WebElement usernameTextbox = driver.findElement(By.id("UserName"));
            usernameTextbox.sendKeys("hari");
        }
        catch (Exception ex)
        {
            Assert.fail("User text box not identified");
        }
        Thread.sleep(5000);
        // Wait.waitToBeVisible(driver, "Id", "Password", 7);

        // Identify password textbox and enter valid password
        WebElement paswordTextbox = driver.findElement(By.id("Password"));
        paswordTextbox.sendKeys("123123");


        // Identify Login button and perform action click
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/form/div[3]/input[1]"));
        loginButton.click();
    }
}
