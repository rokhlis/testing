package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BoardsPageHelper extends PageBase{
    @FindBy(xpath = "//button[@data-test-id='header-boards-menu-button']/span[2]")
    WebElement boardIcon;

    @FindBy(className = "content-all-boards")
    WebElement boardPageVisible;

    public BoardsPageHelper(WebDriver driver) {
        super(driver);
    }

    public void waitUntilPageIsLoaded(){
        waitUntilElementIsVisible(boardPageVisible, 10);
    }

    public String getButtonBoardsText(){
        //WebElement boardIcon = driver.findElement(By.xpath("//button[@data-test-id='header-boards-menu-button']/span[2]"));
        return boardIcon.getText();
    }
}
