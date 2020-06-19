package TrelloTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TrelloLogin extends TestBase{

    @Test
    public void trelloPositiveLgnPwd() throws InterruptedException {
        driver.findElement(By.xpath("//a[@class='btn btn-sm btn-link text-white']")).click();
        Thread.sleep(7000);
        driver.findElement(By.xpath("//input[@id='user']")).sendKeys(LOGIN);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(PASSWORD);
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#login")).click();
        Thread.sleep(10000);
    }

    @Test
    public void trelloNegativeLgn() throws InterruptedException {
        driver.findElement(By.xpath("//a[@class='btn btn-sm btn-link text-white']")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//input[@id='user']")).sendKeys(LOGIN);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(PASSWORD);
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#login")).click();
        Thread.sleep(2000);
        System.out.println("Error message: " + driver.findElement(By.xpath("//div[@id='error']//p[@class='error-message']")).getText());
        Thread.sleep(2000);
    }

    @Test
    public void trelloNegativePsswd() throws InterruptedException {
        driver.findElement(By.xpath("//a[@class='btn btn-sm btn-link text-white']")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//input[@id='user']")).sendKeys("rokhlis@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password123");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#login")).click();
        Thread.sleep(2000);
        System.out.println("Error message: " + driver.findElement(By.xpath("//div[@id='error']//p[@class='error-message']")).getText());
        Thread.sleep(2000);
    }

    @Test
    public void loginNegativeNoLoginNoPassword() throws InterruptedException {
        driver.findElement(By.xpath("//a[@class='btn btn-sm btn-link text-white']")).click();
        Thread.sleep(5000);

        driver.findElement(By.id("login")).click();
        Thread.sleep(5000);

        WebElement errorMessage = driver.findElement(By.xpath("//div[@id='error']//p[@class='error-message']"));
        System.out.println("Error message: " + errorMessage.getText());
        Thread.sleep(5000);

        Assert.assertEquals("Missing email",errorMessage.getText(),"Error text is not 'Missing email'");
    }

}