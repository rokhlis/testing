package TrelloTests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TrelloLogin extends TestBase{


    @Test
    public void trelloPositiveLgnPwd() throws InterruptedException {
        driver.findElement(By.xpath("//a[@class='btn btn-sm btn-link text-white']")).click();
        Thread.sleep(7000);
        driver.findElement(By.xpath("//input[@id='user']")).sendKeys("rokhlis@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("MozganeT1982");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#login")).click();
        Thread.sleep(10000);
    }

    @Test
    public void trelloNegativeLgn() throws InterruptedException {
        driver.findElement(By.xpath("//a[@class='btn btn-sm btn-link text-white']")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//input[@id='user']")).sendKeys("user@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("MozganeT1982");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#login")).click();
        Thread.sleep(2000);
        System.out.println("Error text: " + driver.findElement(By.xpath("//div[@id='error']//p[@class='error-message']")).getText());
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
        System.out.println("Error text: " + driver.findElement(By.xpath("//div[@id='error']//p[@class='error-message']")).getText());
        Thread.sleep(2000);
    }

}
