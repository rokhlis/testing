package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstTest {
    public WebDriver driver;

    @BeforeMethod
    public void initAppl() throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://mishpahug.co.il/");
        Thread.sleep(2000);

    }

    @Test
    public void enterToMishpahug() throws InterruptedException {
        System.out.println("Title: " + driver.getTitle());

    }
    @Test
    public void enterToMishpahugAndClickOnCrossButton() throws InterruptedException {
        WebElement crossButton = driver.findElement(By.id("closedIntro"));
        crossButton.click();
        Thread.sleep(2000);

    }
    @Test
    public void loginToMishpahugAndExitByCrossButton() throws InterruptedException {
        WebElement login = driver.findElement(By.id("closedIntro"));
        login.click();
        Thread.sleep(2000);
        WebElement crossButton = driver.findElement(By.id("idsignin"));
        crossButton.click();
        Thread.sleep(2000);
        WebElement crossButtonLogin = driver.findElement(By.id("closedsignin"));
        crossButtonLogin.click();
        Thread.sleep(2000);

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
