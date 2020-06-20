package TrelloTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TrelloLogin extends TestBase {

    @Test
    public void trelloPositiveLgnPwd() {
        //Clicking Login button
        driver.findElement(By.xpath("//a[@class='btn btn-sm btn-link text-white']")).click();
        waitUntilElementIsClickable(By.id("login"), 10);
        //Entering credentials
        driver.findElement(By.xpath("//input[@id='user']")).sendKeys(LOGIN);
        waitUntilAttributeValueIs(By.id("password"), "placeholder", "Enter password", 10);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(PASSWORD);
        //Clicking Login button
        driver.findElement(By.cssSelector("#login")).click();
        waitUntilElementIsVisible(By.className("content-all-boards"), 10);
        WebElement boardIcon = driver.findElement(By.xpath("//button[@data-test-id='header-boards-menu-button']/span[2]"));

        Assert.assertEquals(boardIcon.getText(), "Boards", "Text on the boardIcon is not 'Boards'");
    }

    @Test
    public void trelloNegativeLgn() {
        //Clicking Login button
        driver.findElement(By.xpath("//a[@class='btn btn-sm btn-link text-white']")).click();
        waitUntilElementIsClickable(By.id("login"), 10);
        //Entering credentials
        driver.findElement(By.xpath("//input[@id='user']")).sendKeys("user@mail.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("MozganeT1982");
        //Clicking Login button
        driver.findElement(By.cssSelector("#login")).click();
        waitUntilElementIsVisible(By.xpath("//div[@id='error']//p[@class='error-message']"), 10);
        WebElement errorMessage = driver.findElement(By.xpath("//div[@id='error']//p[@class='error-message']"));

        Assert.assertEquals(errorMessage.getText(), "There isn't an account for this email", "Error message is not correct");
    }

    @Test
    public void trelloNegativePsswd() {
        driver.findElement(By.xpath("//a[@class='btn btn-sm btn-link text-white']")).click();
        waitUntilElementIsClickable(By.id("login"), 10);
        driver.findElement(By.xpath("//input[@id='user']")).sendKeys("rokhlis@gmail.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password123");
        waitUntilElementIsClickable(By.id("login"), 20);
        driver.findElement(By.cssSelector("#login")).click();
        waitUntilElementIsVisible(By.xpath("//p[contains(text(),'Incorrect email address and')]"), 10);
        WebElement errorMessage = driver.findElement(By.xpath("//p[contains(text(),'Incorrect email address and')]"));

        Assert.assertTrue(errorMessage.getText().contains("Incorrect email address"),
                "There is no error message or the text of the message is not correct");
    }

    @Test
    public void loginNegativeNoLoginNoPassword() {
        driver.findElement(By.xpath("//a[@class='btn btn-sm btn-link text-white']")).click();
        waitUntilElementIsClickable(By.id("login"), 30);
        driver.findElement(By.id("login")).click();
        waitUntilElementIsVisible(By.xpath("//div[@id='error']//p[@class='error-message']"), 10);
        WebElement errorMessage = driver.findElement(By.xpath("//div[@id='error']//p[@class='error-message']"));

        Assert.assertEquals(errorMessage.getText(), "Missing email");
    }

}