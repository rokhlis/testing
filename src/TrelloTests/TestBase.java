package TrelloTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    public WebDriver driver;
    public static final String BOARD_TITLE = "QA Haifa56";
    public static final String LOGIN = "rokhlis@gmail.com";
    public static final String PASSWORD = "MozganeT1982";
    public static final String NAME_TITLE = "Rokhlis Yuri (rokhlisyuri)";
    public static final String USERNAME_TITLE = "Rokhlis Yuri";
    public static final String WORKSPACE_NAME = "https://trello.com/rokhlisyuri/boards";

    public void waitUntilElementIsClickable(By locator, int time) {
        try {
            new WebDriverWait(driver,time).until(ExpectedConditions.elementToBeClickable(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilElementIsVisible(By locator, int time) {
        try {
            new WebDriverWait(driver,time).until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilAttributeValueIs(By locator,String attribute, String value,int time){
        try {
            new WebDriverWait(driver,time).until(ExpectedConditions.attributeToBe(locator,attribute,value));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @BeforeMethod
    public void initAppl() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=" + "en");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://trello.com/");

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
