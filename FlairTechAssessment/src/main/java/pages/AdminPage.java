package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class AdminPage {
    private WebDriver driver;
    private int recordsNumberBeforeAddingUser;
    private int recordsNumberAfterAddingUser;
    private int recordsNumberAfterDeletingUser;
    public AdminPage(WebDriver driver) {
        this.driver =driver;
    }
    private By adminTab = By.xpath("(//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'])[1]");
    private By recordsText = By.xpath("(//span[@class='oxd-text oxd-text--span'])[1]");
    private By addButton = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']");
    private By userRole = By.xpath("(//div[@class='oxd-select-text-input'])[1]");
    private By userName = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    private By employeeName = By.xpath("//input[@placeholder='Type for hints...']");
    private By status = By.xpath("(//div[@class='oxd-select-text-input'])[2]");
   private By password = By.xpath("(//input[@type='password'])[1]");
    private By confirmPassword = By.xpath("(//input[@type='password'])[2]");
    private By save = By.xpath("//button[@type='submit']");
    private By search = By.xpath("//button[@type='submit']");
    private By delete = By.xpath("//i[@class='oxd-icon bi-trash']");
    public void clickAdminTab() {
        driver.findElement(adminTab).click();
    }
    public int getRecordsNumber()
    {
       String textRecord = driver.findElement(recordsText).getText();
        String numberOnly= textRecord.replaceAll("[^0-9]", "");
        System.out.println(numberOnly);
        return recordsNumberBeforeAddingUser = Integer.parseInt(numberOnly);
    }
    public void selectUserRole()
    {
        driver.findElement(userRole).click();
        driver.findElements(By.xpath("//div[@role='listbox']")).get(0).click();
    }
    public void clickOnAddButton(){
        driver.findElement(addButton).click();
    }
    public void setUserName() throws InterruptedException {
        driver.findElement(userName).sendKeys("Test1");
        Thread.sleep(5000);
    }
    public void setEmployeeName() throws InterruptedException {
        driver.findElement(employeeName).sendKeys("test");
        Thread.sleep(5000);
        driver.findElements(By.xpath("//div[@role='listbox']")).get(0).click();

    }
    public void setStatus()
    {
        driver.findElement(status).click();
        driver.findElements(By.xpath("//div[@role='listbox']")).get(0).click();
    }
    public void setPassword()
    {
        driver.findElement(password).sendKeys("Test@1234");
    }
    public void setConfirmPassword()
    {
        driver.findElement(confirmPassword).sendKeys("Test@1234");
    }
    public void clickOnSaveButton()
    {
        driver.findElement(save).click();
    }
    public boolean getRecordsNumberAfterAddingUser()
    {
        boolean flag;
        String textRecord = driver.findElement(recordsText).getText();
        String numberOnly= textRecord.replaceAll("[^0-9]", "");
        System.out.println(numberOnly);
        recordsNumberAfterAddingUser = Integer.parseInt(numberOnly);
        if (recordsNumberAfterAddingUser==recordsNumberBeforeAddingUser+1)
        {
            flag = true;
        }
        else {
            flag = false;
        }
        return flag;
    }
    public void clickOnSearch()
    {
        driver.findElement(search).click();
    }
    public void deleteUser()
    {
        driver.findElement(delete).click();
        driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']")).click();
    }
    public boolean getRecordsNumberAfterDeletingUser()
    {
        boolean flag;
        driver.findElement(adminTab).click();
        String textRecord = driver.findElement(recordsText).getText();
        String numberOnly= textRecord.replaceAll("[^0-9]", "");
        System.out.println(numberOnly);
        recordsNumberAfterDeletingUser = Integer.parseInt(numberOnly);
        if (recordsNumberAfterDeletingUser==recordsNumberBeforeAddingUser)
        {
            flag = true;
        }
        else {
            flag = false;
        }
        return flag;
    }

}
