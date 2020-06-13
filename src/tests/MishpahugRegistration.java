package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MishpahugRegistration {
    public WebDriver driver;

    @BeforeMethod
    public void initAppl() throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mishpahug.co.il/");
        Thread.sleep(2000);

    }

    @Test
    public void mishpahugRegistration() throws InterruptedException {
        driver.findElement(By.cssSelector("body:nth-child(2) div.formIntro:nth-child(1) div:nth-child(1) div.but-closed > i.fa.fa-times-circle-o")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[contains(text(),'Registration')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#namelogin")).sendKeys("Yuri Rokhlis");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#newlogininput[placeholder='login']")).sendKeys("rokhlis");
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html[1]/body[1]/header[1]/div[3]/div[1]/div[6]/div[1]/div[6]/div[1]/input[1]")).sendKeys("rokhlis@gmail.com");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#phonenumberinput[placeholder='phone number']")).sendKeys("0537127366");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#newpasswordinput[placeholder='password']")).sendKeys("Password_123");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#confirmnewpasswordinput[placeholder='confirm password']")).sendKeys("Password_123");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[contains(text(),'create account')]")).click();
        Thread.sleep(2000);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
