package TrelloTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TrelloBoards extends TestBase {

    private String boardLocator(String boardTitle) {
        return "//div[@title = '" + boardTitle + "']/../..";
    }

    @BeforeMethod
    public void initTests() throws InterruptedException {
        driver.findElement(By.xpath("//a[@class='btn btn-sm btn-link text-white']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@id='user']")).sendKeys(LOGIN);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(PASSWORD);
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#login")).click();
        Thread.sleep(5000);
//        driver.findElement(By.xpath("//div[@class='board-tile-details-name']//div[contains(text(),'QA Haifa56')]")).click();
//        Thread.sleep(5000);
        WebElement ourBoard = driver.findElement(By.xpath(boardLocator(BOARD_TITLE)));
        ourBoard.click();
        Thread.sleep(5000);
    }

    @Test
    public void trelloAddNewList() throws InterruptedException {

        System.out.println("Quantity of Lists: " + driver.findElements(By.className("js-list")).size());
        driver.findElement(By.xpath("//div[@class='js-add-list list-wrapper mod-add is-idle']//span[@class='placeholder']")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("name")).sendKeys("AutoGeneratedList");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@class='primary mod-list-add-button js-save-edit']")).click();
        System.out.println("Quantity of Lists: " + driver.findElements(By.className("js-list")).size());
        Thread.sleep(5000);
    }

    @Test
    public void trelloAddNewCard() throws InterruptedException {
//        driver.findElement(By.xpath("//a[@class='btn btn-sm btn-link text-white']")).click();
//        Thread.sleep(5000);
//        driver.findElement(By.xpath("//input[@id='user']")).sendKeys("rokhlis@gmail.com");
//        Thread.sleep(1000);
//        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("MozganeT1982");
//        Thread.sleep(1000);
//        driver.findElement(By.cssSelector("#login")).click();
//        Thread.sleep(5000);
//        driver.findElement(By.xpath("//div[@class='board-tile-details-name']//div[contains(text(),'QA Haifa56')]")).click();
//        Thread.sleep(5000);
        if ((driver.findElements(By.className("js-list")).size()) == 0) {
            driver.findElement(By.xpath("//div[@class='js-add-list list-wrapper mod-add is-idle']//span[@class='placeholder']")).click();
            Thread.sleep(2000);
            driver.findElement(By.name("name")).sendKeys("AutoGeneratedList");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@class='primary mod-list-add-button js-save-edit']")).click();
            Thread.sleep(2000);
        }
        System.out.println("Quantity of Cards: " + driver.findElements(By.className("js-card-name")).size());
        driver.findElement(By.className("js-open-card-composer")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//textarea[@placeholder='Enter a title for this card…']")).sendKeys("AutoGeneratedCard");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@class='primary confirm mod-compact js-add-card']")).click();
        System.out.println("Quantity of Cards: " + driver.findElements(By.className("js-card-name")).size());
        Thread.sleep(5000);
    }

}
