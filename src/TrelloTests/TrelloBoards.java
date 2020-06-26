package TrelloTests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BoardsPageHelper;
import pages.CurrentBoardHelper;
import pages.LoginPageHelper;

public class TrelloBoards extends TestBase {
    LoginPageHelper loginPage;
    BoardsPageHelper boardsPage;
    CurrentBoardHelper currentBoard;

    @BeforeMethod
    public void initTests() {
        loginPage = new LoginPageHelper(driver);
        boardsPage = new BoardsPageHelper(driver);
        currentBoard = new CurrentBoardHelper(driver);

        loginPage.openLoginPage();
        loginPage.enteringCredentialsAndClickingLogin(LOGIN,PASSWORD);
        currentBoard.enterWorkspace(WORKSPACE_NAME);
        currentBoard.openCurrentBoard(BOARD_TITLE);
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
