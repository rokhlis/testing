package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LocatorsMishTests {
    public WebDriver driver;

    @BeforeMethod
    public void initAppl() throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://mishpahug.co.il/");
        Thread.sleep(2000);

    }

    @Test
    public void locatorsVerification() throws InterruptedException {
        driver.findElement(By.id("closedIntro")).click();
        Thread.sleep(2000);
        System.out.println("Quantity of elements with tag select: " + driver.findElements(By.tagName("select")).size());
        System.out.println(driver.findElement(By.name("selectlangues")).getTagName());
        driver.findElement(By.linkText("more...")).click();
        Thread.sleep(2000);
        System.out.println("Text Login button: " + driver.findElement(By.xpath("//*[@id='idsignin']//span")).getText());
        driver.findElement(By.id("idsignin")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[placeholder='your login']")).sendKeys("loginTest");
        Thread.sleep(2000);
    }

    @Test


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
