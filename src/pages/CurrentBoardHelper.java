package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static TrelloTests.TestBase.BOARD_TITLE;

public class CurrentBoardHelper extends PageBase{
    public CurrentBoardHelper(WebDriver driver) {
        super(driver);
    }

    public void openCurrentBoard(String boardTitle){
        WebElement ourBoard = driver.findElement(By.xpath(boardLocator(boardTitle)));
        ourBoard.click();
        waitUntilElementIsVisible((By.id("board")), 20);
    }

    public void waitUntilPageIsLoaded() {
    }

    public void enterWorkspace(String workSpace){
        driver.get(workSpace);
        waitUntilElementIsVisible((By.xpath(boardLocator(BOARD_TITLE))), 20);
    }

    public void checkQuantityOfLists(){
        System.out.println("Quantity of Lists: " + driver.findElements(By.className("js-list")).size());
    }

    public String boardLocator(String boardTitle) {
        return "//div[@title = '" + boardTitle + "']/../..";
    }
}
