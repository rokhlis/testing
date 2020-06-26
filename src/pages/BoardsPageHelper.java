package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BoardsPageHelper extends PageBase{

    public BoardsPageHelper(WebDriver driver) {
        super(driver);
    }

    public void waitUntilPageIsLoaded(){
        waitUntilElementIsVisible(By.className("content-all-boards"), 10);
    }

    public String getButtonBoardsText(){
        WebElement boardIcon = driver.findElement(By.xpath("//button[@data-test-id='header-boards-menu-button']/span[2]"));
        return boardIcon.getText();
    }


}
