package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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


    public void waitUntilErrorMessageIsVisible() {
        waitUntilElementIsVisible(By.xpath("//div[@id='error']//p[@class='error-message']"), 10);
    }

    public String getErrorText(){
        WebElement errorMessage = driver.findElement(By.xpath("//div[@id='error']//p[@class='error-message']"));
        return errorMessage.getText();
    }
}

