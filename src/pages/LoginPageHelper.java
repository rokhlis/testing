package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageHelper extends PageBase {
    @FindBy(xpath = "//a[@class='btn btn-sm btn-link text-white']")
    WebElement loginIcon;

    @FindBy(id = "login")
    WebElement loginButton;

    @FindBy(id = "user")
    WebElement userField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(xpath = "//div[@id='error']//p[@class='error-message']")
    WebElement loginError;

//    @FindBy(id = "login-submit")
//    WebElement loginSubmitButton;


    public LoginPageHelper(WebDriver driver) {
        super(driver);
    }

    public void openLoginPage() {
        loginIcon.click();
        waitUntilElementIsClickable(By.id("login"), 10);
    }

    public void enteringCredentialsAndClickingLogin(String login, String password) {
        userField.sendKeys(login);
        waitUntilAttributeValueIs(By.id("password"), "placeholder", "Enter password", 10);
        passwordField.sendKeys(password);
        loginButton.click();
    }


    public void waitUntilErrorMessageIsVisible() {
        waitUntilElementIsVisible(By.xpath("//div[@id='error']//p[@class='error-message']"), 10);
    }

    public String getErrorText() {
        WebElement errorMessage = driver.findElement(By.xpath("//div[@id='error']//p[@class='error-message']"));
        return errorMessage.getText();
        //return loginError.getText();
    }


//    public void enterLoginAtlassianAndClickLogin(String login) {
//        userField.sendKeys(login);
//        waitUntilAttributeValueIs(loginButton,"value","Log in with Atlassian",10);
//        loginButton.click();
//        waitUntilElementIsClickable(loginSubmitButton,15);
//    }
//
//    public void enterPasswordAtlassionAndClickLogin(String password) {
//
//        passwordField.sendKeys(password);
//        loginSubmitButton.click();
//
//    }
//
//    public void loginAsAtlassian(String login, String password){
//        this.enterLoginAtlassianAndClickLogin(login);
//        this.enterPasswordAtlassionAndClickLogin(password);
//    }

}

