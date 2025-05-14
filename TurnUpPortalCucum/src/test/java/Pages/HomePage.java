package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    public void VerifyUserInHomePage(WebDriver driver) {
        //  Verify if user login successfully or not
        WebElement HelloHari = driver.findElement(By.xpath("//*[@id=\"logoutForm\"]/ul/li/a"));
        // C-sharp code:: if (HelloHari.text == "Hello hari!")
        if (HelloHari.getText().equals("Hello hari!")) {
            // Console.WriteLine  for printing in c-sharp
            System.out.println("User is login successfully! Test is Passed");
        } else {
            System.out.println("User is not successfully login! Test is Failed");
        }

    }

    public void NavigateToTMPage(WebDriver driver) throws InterruptedException {
        // Identify administration drop down and perform action click
        WebElement administrationDropdown = driver.findElement(By.xpath("/html/body/div[3]/div/div/ul/li[5]/a/span"));
        administrationDropdown.click();
        Thread.sleep(5000);
        // Wait.WaitToBeClickable(driver, "XPath", "/html/body/div[3]/div/div/ul/li[5]/ul/li[3]/a", 10);

        // Click on option Time and Material
        WebElement TimeAndMaterialOption = driver.findElement(By.xpath("/html/body/div[3]/div/div/ul/li[5]/ul/li[3]/a"));
        TimeAndMaterialOption.click();

    }
}
