package TrelloTests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BoardsPageHelper;
import pages.CurrentBoardHelper;
import pages.LoginPageHelper;

public class CurrentBoard extends TestBase {
    LoginPageHelper loginPage;
    BoardsPageHelper boardsPage;
    CurrentBoardHelper currentBoard;

    @BeforeMethod
    public void initTests() {
        loginPage = PageFactory.initElements(driver,LoginPageHelper.class);
        boardsPage = PageFactory.initElements(driver, BoardsPageHelper.class);
        currentBoard = new CurrentBoardHelper(driver,BOARD_TITLE);
        loginPage.openLoginPage();
        loginPage.enteringCredentialsAndClickingLogin(LOGIN,PASSWORD);
        currentBoard.enterWorkspace(WORKSPACE_NAME);
        currentBoard.openCurrentBoard();
    }

    @Test
    public void trelloAddNewList() {
        currentBoard.checkQuantityOfLists();
        currentBoard.createNewListWithNameSpecified(LIST_NAME);
        currentBoard.checkQuantityOfLists();
    }

    @Test
    public void trelloAddNewCard() {
        if ((driver.findElements(By.className("js-list")).size()) == 0) {
            currentBoard.createNewListWithNameSpecified(LIST_NAME);
        }
        currentBoard.checkQuantityOfCards();
        currentBoard.createNewCardWithNameSpecified(CARD_NAME);
        currentBoard.checkQuantityOfCards();
    }

}
