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

    public void createNewListWithNameSpecified(String listName){
        driver.findElement(By.xpath("//div[@class='js-add-list list-wrapper mod-add is-idle']//span[@class='placeholder']")).click();
        waitUntilElementIsVisible((By.xpath("//input[@class='primary mod-list-add-button js-save-edit']")), 20);
        //Entering new List name
        driver.findElement(By.name("name")).sendKeys(listName);
        waitUntilElementIsClickable(By.xpath("//input[@class='primary mod-list-add-button js-save-edit']"), 20);
        //Adding new List with entered name
        driver.findElement(By.xpath("//input[@class='primary mod-list-add-button js-save-edit']")).click();
        //Canceling other List adding
        waitUntilElementIsVisible((By.xpath("//a[@class='icon-lg icon-close dark-hover js-cancel-edit']")), 20);
        driver.findElement(By.xpath("//a[@class='icon-lg icon-close dark-hover js-cancel-edit']")).click();
    }

    public void createNewCardWithNameSpecified(String cardName){
        //Opening card composer
        driver.findElement(By.className("js-open-card-composer")).click();
        waitUntilElementIsVisible((By.className("js-add-card")), 20);
        //Entering card name
        driver.findElement(By.xpath("//textarea[@placeholder='Enter a title for this card…']")).sendKeys(cardName);
        waitUntilElementIsClickable((By.className("primary confirm mod-compact js-add-card")), 0);
        //Adding card to the list
        driver.findElement(By.xpath("//input[@class='primary confirm mod-compact js-add-card']")).click();
    }

    public void checkQuantityOfLists(){
        System.out.println("Quantity of Lists: " + driver.findElements(By.className("js-list")).size());
    }

    public void checkQuantityOfCards(){
        System.out.println("Quantity of Cards: " + driver.findElements(By.className("js-card-name")).size());
    }

    public String boardLocator(String boardTitle) {
        return "//div[@title = '" + boardTitle + "']/../..";
    }
}
