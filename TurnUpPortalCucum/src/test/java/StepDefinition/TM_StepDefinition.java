package StepDefinition;

import Pages.*;
import Utilities.CommonDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import java.util.HashMap;

public class TM_StepDefinition extends CommonDriver {
    @Before
    public void SetupSteps() {

        HashMap<Object, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("profile.password_manager_leak_detection", false);

        final ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("prefs", chromePrefs);
        //  Open Chrome Browser
        driver = new ChromeDriver(chromeOptions);

    }
    @Given("I Login to the Portal Successfully")
    public void iLoginToThePortalSuccessfully() throws InterruptedException {
        // LoginPage Object initiallization and definition

        LoginPage loginpageObj = new LoginPage();
        loginpageObj.LoginActions(driver);

    }
    @When("I navigate to Time and Material Page")
    public void iNavigateToTimeAndMaterialPage() throws InterruptedException {
        // HomePage Object initilization and definition
        HomePage homePageObj = new HomePage();
        homePageObj.VerifyUserInHomePage(driver);
        homePageObj.NavigateToTMPage(driver);
    }
    @When("I create the time record successfully")
    public void iCreateTheTimeRecordSuccessfully() throws InterruptedException {
        // TMpage Object initialization and definition
        TMpage tMpageObj = new TMpage();
        tMpageObj.CreateTimeRecord(driver);
    }

    @Then("Record should be created successfully")
    public void recordShouldBeCreatedSuccessfully() throws InterruptedException {
        TMpage tMpageObj = new TMpage();
        String newCode = tMpageObj.GetCode(driver);
        String newDescription = tMpageObj.GetDescription(driver);
        String newPrice =  tMpageObj.GetPrice(driver);

       // String expectedCode = "123A";
        String expectedDescription = "This is my first Time Order";

        Assert.assertEquals(newCode, "123A", "Time Record is not created! Test is Failed");
        Assert.assertEquals(newDescription,expectedDescription, "Expected and Actual description don't match");
        Assert.assertEquals(newPrice, "$12.00", "Actual Price and Expected Price do not match");
    }

    @When("I update the {string} and {string} on an existing Time Record")
        public void iUpdateTheCodeAndDescriptionOnAnExistingTimeRecord(String Code, String Description) throws InterruptedException {
            TMpage tMpageObj = new TMpage();
            tMpageObj.EditTimeRecord(driver, Code, Description);
    }

    @Then("the record should have the updated {string} and {string}")
    public void theRecordShouldHaveTheUpdatedCodeAndDescription(String Code, String Description) throws InterruptedException {
        TMpage tMpageObj = new TMpage();
        String editedCode = tMpageObj.GeteditedCode(driver);
        String editedDescription = tMpageObj.GeteditedDescription(driver);
        Assert.assertEquals(editedCode, Code, "Expected Edited code donot match with Actual Edited code");
        Assert.assertEquals(editedDescription, Description, "Expected Edited description donot match with Actual Description");
    }

    @When("I delete the time record successfully")
    public void iDeleteTheTimeRecordSuccessfully() throws InterruptedException {
        TMpage tMpageObj = new TMpage();
        tMpageObj.DeleteTimeRecord(driver);
    }

    @Then("Record should be deleted successfully")
    public void recordShouldBeDeletedSuccessfully() {
        TMpage tMpageObj = new TMpage();
        String newDeletedCode = tMpageObj.getDeletedCode(driver);
        Assert.assertNotEquals("gamma",newDeletedCode,"record is not deleted");
    }
    @After
    public void CloseRun() throws InterruptedException {
        driver.close();

    }
}
