package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By userName = By.name("username");
    private By password = By.name("password");
    private By loginButton = By.xpath("//button[@type='submit']");
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    public void setUserName(){
        driver.findElement(userName).sendKeys("Admin");
    }
    public void setPassword(){
        driver.findElement(password).sendKeys("admin123");
    }

    public AdminPage clickLoginButton() {
        driver.findElement(loginButton).click();
        return new AdminPage(driver);
    }
}
