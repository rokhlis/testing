package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Trello_1 {
    public WebDriver driver;

    @BeforeMethod
    public void initAppl() throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://trello.com/");
        Thread.sleep(2000);

    }

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
        Thread.sleep(7000);
        driver.findElement(By.xpath("//input[@id='user']")).sendKeys("user@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("MozganeT1982");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#login")).click();
        Thread.sleep(2000);
        System.out.println("Error text: " + driver.findElement(By.cssSelector("body.atlassian-brand:nth-child(2) section.inner-section div.section-wrapper.quick-switch div.layout-twothirds-center.account-form div.quick-switch:nth-child(5) > p.error-message")).getText());
        Thread.sleep(2000);
    }

    @Test
    public void trelloNegativePsswd() throws InterruptedException {
        driver.findElement(By.xpath("//a[@class='btn btn-sm btn-link text-white']")).click();
        Thread.sleep(7000);
        driver.findElement(By.xpath("//input[@id='user']")).sendKeys("rokhlis@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password123");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#login")).click();
        Thread.sleep(2000);
        System.out.println("Error text: " + driver.findElement(By.cssSelector("body.atlassian-brand:nth-child(2) section.inner-section div.section-wrapper.quick-switch div.layout-twothirds-center.account-form div.quick-switch:nth-child(5) > p.error-message")).getText());
        Thread.sleep(2000);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
