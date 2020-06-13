import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class qwe {
    public static void main (String[] args) throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        //System.out.println("Open Chrome browser");
        WebDriver driver = new ChromeDriver();
        driver.get("https://mishpahug.co.il/");
        System.out.println("Title: " + driver.getTitle());
        Thread.sleep(2000);
        //driver.findElement(By.id("closedIntro")).click();
        /*WebElement crossButton = driver.findElement(By.id("closedIntro"));
        crossButton.click();
        Thread.sleep(2000);
        List<WebElement> listButton = driver.findElements(By.xpath("//span[@class='navi-item']"));
        for (WebElement element: listButton){
            System.out.println(element.getText());
        }
        //driver.findElement(By.id("idHome"));
        Thread.sleep(2000);*/
//        driver.manage().window().fullscreen();
//        System.out.println("Title: " + driver.getTitle());
//        Thread.sleep(1000);
//        Dimension d = new Dimension(1920,1080);
//        driver.manage().window().setSize(d);
//        Thread.sleep(5000);
//        driver.get("https://yandex.ru/");
//        System.out.println("Title: " + driver.getTitle());
//        Thread.sleep(1000);
//        driver.get("https://yahoo.com/");
//        System.out.println("Title: " + driver.getTitle());
//        driver.navigate().back();
//        System.out.println("Title: " + driver.getTitle());
//        Thread.sleep(1000);
//        driver.navigate().forward();
//        System.out.println("Title: " + driver.getTitle());
//        Thread.sleep(1000);
        //driver.quit();
    }
}
