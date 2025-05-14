package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class TMpage {
    public void CreateTimeRecord(WebDriver driver) throws InterruptedException {
        try {
            //  Click on Create New button
            WebElement CreateNewButton = driver.findElement(By.xpath("//*[@id=\"container\"]/p/a"));
            CreateNewButton.click();
        } catch (Exception ex) {
            Assert.fail("Create New Button has not been found");
        }
        // Identify Dropdown  and select Time option
        WebElement timeDropdownOPtion = driver.findElement(By.xpath("//*[@id=\"TimeMaterialEditForm\"]/div/div[1]/div/span[1]/span/span[2]/span"));
        timeDropdownOPtion.click();
        Thread.sleep(1000);
        WebElement timeOption = driver.findElement(By.xpath("//*[@id=\"TypeCode_listbox\"]/li[2]"));
        timeOption.click();

        // Type code in code Textbox
        WebElement codeTextbox = driver.findElement(By.xpath("//*[@id=\"Code\"]"));
        codeTextbox.sendKeys("123A");

        // Type description in description text box
        WebElement descriptionTextBox = driver.findElement(By.xpath("//*[@id=\"Description\"]"));
        descriptionTextBox.sendKeys("This is my first Time Order");

        // **Type price in price Text box Note:Below code line extra due to overlapping code
        WebElement priceTagOverlap = driver.findElement(By.xpath("//*[@id=\"TimeMaterialEditForm\"]/div/div[4]/div/span[1]/span/input[1]"));
        priceTagOverlap.click();
        WebElement priceTextBox = driver.findElement(By.xpath("//*[@id=\"Price\"]"));
        priceTextBox.sendKeys("12");
        Thread.sleep(2000);
        //Wait.WaitToBeClickable(driver, "Id", "SaveButton", 2);

        // Click on Save Button
        WebElement saveButton = driver.findElement(By.id("SaveButton"));
        saveButton.click();
        Thread.sleep(9000);
        WebElement goToLastPageButton = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[4]/a[4]/span"));
        goToLastPageButton.click();
        Thread.sleep(9000);

    }
    public String GetCode(WebDriver driver)
    {
        WebElement newCode = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[1]"));
        return newCode.getText();
    }
    public String GetDescription(WebDriver driver)
    {
        WebElement newDescription = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[3]"));
        return newDescription.getText();
    }
    public String GetPrice(WebDriver driver)
    {
        WebElement newPrice = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[4]"));
        return newPrice.getText();

    }


    public void EditTimeRecord(WebDriver driver, String Code, String Description) throws InterruptedException {
        Thread.sleep(9000);
        WebElement goToLastPageButton = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[4]/a[4]/span"));
        goToLastPageButton.click();
        Thread.sleep(8000);

        //  Edit the Time Record
        WebElement editButton = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[5]/a[1]"));
        editButton.click();
        Thread.sleep(5000);

        // Identify Code Text box and change text to alpha, beta , gamma
        WebElement editCodeText = driver.findElement(By.xpath("//*[@id=\"Code\"]"));
        editCodeText.clear();
        editCodeText.sendKeys(Code);

        // Identify Description text box and enter description gold, silver, bronze
        WebElement descriptionTextBoxM = driver.findElement(By.xpath("//*[@id=\"Description\"]"));
        descriptionTextBoxM.clear();
        descriptionTextBoxM.sendKeys(Description);

       /*  **Identify Price Text box and enter price value
         As this text box is with overlapping code so create first code for highlight the price
        field and then create code to enter the text
        WebElement overLapedField = driver.findElement(By.xpath("//*[@id=\"TimeMaterialEditForm\"]/div/div[4]/div/span[1]/span/input[1]"));
        overLapedField.click();
        WebElement priceTextBoxM = driver.findElement(By.xpath("//*[@id=\"Price\"]"));
        priceTextBoxM.clear();
        priceTextBoxM.sendKeys("20");*/

        // Identify Save Button and click on it
        WebElement saveButtonclick = driver.findElement(By.id("SaveButton"));
        saveButtonclick.click();
        Thread.sleep(5000);
    }


       /* if (EditedCode.getText().equals("TA-FAR")) {
            System.out.println("Time Record is Successfully Edited! Test is Passed!");
        }
        else        {
            System.out.println("Time Record is not Edited! Test is Failed");
        }*/

    public String GeteditedCode(WebDriver driver) throws InterruptedException {
        // imp point goto last page before getting
        Thread.sleep(6000);
        WebElement goToLastPageButton = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[4]/a[4]/span"));
        goToLastPageButton.click();
        Thread.sleep(8000);
        WebElement EditedCode = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[1]"));
        return EditedCode.getText();
    }
    public String GeteditedDescription(WebDriver driver) throws InterruptedException {
       /* //  No need to goto last page
        Thread.sleep(5000);
        WebElement goToLastPageButton = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[4]/a[4]/span"));
        goToLastPageButton.click();
        Thread.sleep(5000);*/
        WebElement EditedDescription = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[3]"));
        return EditedDescription.getText();
    }

    public void DeleteTimeRecord(WebDriver driver) throws InterruptedException {
        Thread.sleep(9000);
        WebElement goToLastPageButton = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[4]/a[4]/span"));
        goToLastPageButton.click();
        Thread.sleep(9000);

        // Click on the Delete Button
        WebElement deleteButton = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[5]/a[2]"));
        deleteButton.click();
        Thread.sleep(2000);

        // Switch to Alert window to press Ok in Delete box
        driver.switchTo().alert().accept();
        Thread.sleep(5000);
        //driver.navigate().refresh();
    }
    public String getDeletedCode(WebDriver driver) {

            // Check if Record is deleted or not
            WebElement deletedCode = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[1]"));
            return deletedCode.getText();
           /* if (!deletedCode.getText().equals("TA-FAR")) {
                System.out.println("Record is deleted successfully! Test is Passed");
            } else {
                System.out.println("Record is not deleted successfully so Test Is Failed");
            }*/
    }

    }
