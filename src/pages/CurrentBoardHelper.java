package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CurrentBoardHelper extends PageBase{
    @FindBy(xpath = "//div[@class='js-add-list list-wrapper mod-add is-idle']//span[@class='placeholder']")
    WebElement addList;

    @FindBy(xpath = "//input[@class='primary mod-list-add-button js-save-edit']")
    WebElement addListButton;

    @FindBy(name = "name")
    WebElement inputName;

    @FindBy(xpath = "//a[@class='icon-lg icon-close dark-hover js-cancel-edit']")
    WebElement cancelEditList;

    @FindBy(className = "js-open-card-composer")
    WebElement openCard;

    @FindBy(className = "js-add-card")
    WebElement addCardButton;

    @FindBy(xpath = "//textarea[@placeholder='Enter a title for this card…']")
    WebElement enterCardName;

    private String boardName;

    public CurrentBoardHelper(WebDriver driver, String boardName) {
       super(driver);
       this.boardName = boardName;
       PageFactory.initElements(driver,this);
    }

    public void openCurrentBoard(){
        WebElement ourBoard = driver.findElement(By.xpath(boardLocator()));
        ourBoard.click();
        waitUntilElementIsVisible((By.id("board")), 20);
    }

    public void enterWorkspace(String workSpace){
        driver.get(workSpace);
        waitUntilElementIsVisible((By.xpath(boardLocator())), 20);
    }

    public void createNewListWithNameSpecified(String listName){
        addList.click();
        waitUntilElementIsVisible(addListButton, 20);
        inputName.sendKeys(listName);
        waitUntilElementIsClickable(addListButton, 20);
        addListButton.click();
        waitUntilElementIsVisible(cancelEditList, 20);
        cancelEditList.click();
    }

    public void createNewCardWithNameSpecified(String cardName){
        openCard.click();
        enterCardName.sendKeys(cardName);
        waitUntilElementIsClickable(addCardButton, 0);
        addCardButton.click();
    }

    public void checkQuantityOfLists(){
        System.out.println("Quantity of Lists: " + driver.findElements(By.className("js-list")).size());
    }

    public void checkQuantityOfCards(){
        System.out.println("Quantity of Cards: " + driver.findElements(By.className("js-card-name")).size());
    }

    public String boardLocator() {
        return "//div[@title = '" + boardName + "']/../..";
    }
}
