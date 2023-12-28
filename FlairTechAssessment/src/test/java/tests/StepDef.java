package tests;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.AdminPage;
import pages.LoginPage;

import java.time.Duration;

public class StepDef{
    private WebDriver driver ;
    protected LoginPage loginPage;
    protected AdminPage adminPage;
    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }
    @Given("Website is opened")
    public void websiteIsOpened()
    {
        driver.get("https://opensource-demo.orangehrmlive.com/");
        loginPage=new LoginPage(driver);
    }
    @When("User Entered valid username and password")
    public void userEnteredValidUsernameAndPassword()
    {
        loginPage.setUserName();
        loginPage.setPassword();
        adminPage = loginPage.clickLoginButton();
    }
    @And("User Clicked on AdminTab")
    public void userClickedOnAdminTab()
    {
        adminPage.clickAdminTab();
    }
    @And("Get number of records")
    public void getRecordsNumber()
    {
    adminPage.getRecordsNumber();
    }
    @And("Click on Add button")
    public void clickOnAddButton()
    {
    adminPage.clickOnAddButton();
    }
    @And("Choose Desired UserRole")
    public void chooseDesiredUserRole() throws InterruptedException {
        adminPage.selectUserRole();
        Thread.sleep(5000);
        adminPage.setStatus();
    }
    @And("Choose Employee Name")
    public void chooseEmployeeName() throws InterruptedException {
        adminPage.setEmployeeName();
    }
    @And("Choose Status")
    public void chooseStatus() throws InterruptedException {
        adminPage.setStatus();
    }
    @And("Set UserName")
    public void setUserName() throws InterruptedException {
        adminPage.setUserName();
    }
    @And("Set password")
    public void setPassword()
    {
        adminPage.setPassword();
        adminPage.setConfirmPassword();
    }
    @And("Click on save Button")
    public void clickOnSaveButton()
    {
        adminPage.clickOnSaveButton();
    }
    @Then("Verify that number of records increased by 1")
    public void verifyThatNumberOfRecordsIncreasedByOne() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertTrue(adminPage.getRecordsNumberAfterAddingUser());
    }
    @And("Click on Search")
    public void clickOnSearch()
    {
        adminPage.clickOnSearch();
    }
    @And("Click on Delete")
    public void deleteUser()
    {
        adminPage.deleteUser();
    }
    @And("Verify that number of records decreased by 1")
    public void verifyThatNumberOfRecordsDecresedByOne()
    {
        Assert.assertTrue(adminPage.getRecordsNumberAfterDeletingUser());
    }
    @After
    public void closeBrowser()
    {
        driver.close();
    }
}
