package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RandomTest_HW1 {

    @Test
    public void simpleActions() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Opening Google
        driver.get("https://google.com/");
        Thread.sleep(2000);
        System.out.println("Title: " + driver.getTitle());
        //Opening Yahoo
        driver.get("https://yahoo.com/");
        Thread.sleep(2000);
        System.out.println("Title: " + driver.getTitle());
        //Opening Yandex
        driver.get("https://yandex.ru/");
        Thread.sleep(2000);
        System.out.println("Title: " + driver.getTitle());
        //Going back to Yahoo
        driver.navigate().back();
        System.out.println("Title: " + driver.getTitle());
        Thread.sleep(1000);
        //Going back to Google
        driver.navigate().back();
        System.out.println("Title: " + driver.getTitle());
        Thread.sleep(1000);
        /*Changing browser window size*/
        //Sizes
        Dimension vga = new Dimension(640, 480);
        Dimension hd = new Dimension(1280, 720);
        Dimension fullhd = new Dimension(1920, 1080);
        //Fullscreen
        driver.manage().window().fullscreen();
        Thread.sleep(1000);
        //HD
        driver.manage().window().setSize(hd);
        Thread.sleep(1000);
        //FullHD
        driver.manage().window().setSize(fullhd);
        Thread.sleep(1000);
        //VGA
        driver.manage().window().setSize(vga);
        Thread.sleep(1000);
        driver.quit();
    }

    @Test
    public void registrationOnMishpahugAndExitByCrossButton() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Opening Mishaphug
        driver.get("https://mishpahug.co.il/");
        Thread.sleep(2000);
        System.out.println("Title: " + driver.getTitle());
        //Closing intro popup
        WebElement closedIntro = driver.findElement(By.id("closedIntro"));
        closedIntro.click();
        Thread.sleep(2000);
        //Clicking on Registration
        WebElement idadduser = driver.findElement(By.id("idadduser"));
        idadduser.click();
        Thread.sleep(2000);
        //Closing registration form
        WebElement closedadduser = driver.findElement(By.id("closedadduser"));
        closedadduser.click();
        Thread.sleep(2000);
        driver.quit();
    }
}
