package TrelloTests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BoardsPageHelper;
import pages.LoginPageHelper;

public class Login extends TestBase {
    LoginPageHelper loginPage;
    BoardsPageHelper boardsPage;

    @BeforeMethod
    public void initTests(){
        loginPage = PageFactory.initElements(driver, LoginPageHelper.class);
        boardsPage = PageFactory.initElements(driver, BoardsPageHelper.class);
        loginPage.openLoginPage();
    }

    @Test
    public void trelloPositiveLgnPwd() {
        loginPage.enteringCredentialsAndClickingLogin(LOGIN,PASSWORD);
        boardsPage.waitUntilPageIsLoaded();
        Assert.assertEquals(boardsPage.getButtonBoardsText(), "Boards", "Text on the boardIcon is not 'Boards'");
    }

    @Test
    public void trelloNegativeLgn() {
        loginPage.enteringCredentialsAndClickingLogin("user@gmail.com",PASSWORD);
        loginPage.waitUntilErrorMessageIsVisible();
        Assert.assertEquals(loginPage.getErrorText(), "There isn't an account for this email", "Error message is not correct");
    }

    @Test
    public void trelloNegativePsswd() {
        loginPage.enteringCredentialsAndClickingLogin(LOGIN,"Password123");
        loginPage.waitUntilErrorMessageIsVisible();
        Assert.assertTrue(loginPage.getErrorText().contains("Incorrect email address"),
                "There is no error message or the text of the message is not correct");
    }

    @Test
    public void loginNegativeNoLoginNoPassword() {
        loginPage.enteringCredentialsAndClickingLogin("","");
        loginPage.waitUntilErrorMessageIsVisible();
        Assert.assertEquals(loginPage.getErrorText(), "Missing email");
    }

}