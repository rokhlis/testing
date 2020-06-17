package TrelloTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    public WebDriver driver;
    public static final String BOARD_TITLE = "QA Haifa56";
    public static final String LOGIN = "rokhlis@gmail.com";
    public static final String PASSWORD = "MozganeT1982";
    public static final String NAME_TITLE = "Юрий Рохлис (rokhlisyuri)";
    public static final String USERNAME_TITLE = "Юрий Рохлис";

    @BeforeMethod
    public void initAppl() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://trello.com/");
        Thread.sleep(2000);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
