package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageHelper extends PageBase{

    public LoginPageHelper(WebDriver driver){
        super(driver);
    }

    public void openLoginPage(){
        driver.findElement(By.xpath("//a[@class='btn btn-sm btn-link text-white']")).click();
        waitUntilElementIsClickable(By.id("login"), 10);
    }

    public void enteringCredentialsAndClickingLogin(String login, String password){
        driver.findElement(By.xpath("//input[@id='user']")).sendKeys(login);
        waitUntilAttributeValueIs(By.id("password"), "placeholder", "Enter password", 10);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        driver.findElement(By.cssSelector("#login")).click();
    }


}

