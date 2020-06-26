package TrelloTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BoardsPageHelper;
import pages.LoginPageHelper;

public class TrelloLogin extends TestBase {
    LoginPageHelper loginPage;
    BoardsPageHelper boardsPage;

    @BeforeMethod
    public void initTests(){
        loginPage = new LoginPageHelper(driver);
        boardsPage = new BoardsPageHelper(driver);
    }

    @Test
    public void trelloPositiveLgnPwd() {
        loginPage.openLoginPage();
        loginPage.enteringCredentialsAndClickingLogin(LOGIN,PASSWORD);
        boardsPage.waitUntilPageIsLoaded();
        Assert.assertEquals(boardsPage.getButtonBoardsText(), "Boards", "Text on the boardIcon is not 'Boards'");
    }

    @Test
    public void trelloNegativeLgn() {
        loginPage.openLoginPage();
        loginPage.enteringCredentialsAndClickingLogin("user@gmail.com",PASSWORD);
        loginPage.waitUntilErrorMessageIsVisible();
        Assert.assertEquals(loginPage.getErrorText(), "There isn't an account for this email", "Error message is not correct");
    }

    @Test
    public void trelloNegativePsswd() {
        loginPage.openLoginPage();
        loginPage.enteringCredentialsAndClickingLogin(LOGIN,"Password123");
        loginPage.waitUntilErrorMessageIsVisible();
        Assert.assertTrue(loginPage.getErrorText().contains("Incorrect email address"),
                "There is no error message or the text of the message is not correct");
    }

    @Test
    public void loginNegativeNoLoginNoPassword() {
        loginPage.openLoginPage();
        loginPage.enteringCredentialsAndClickingLogin("","");
        loginPage.waitUntilErrorMessageIsVisible();
        WebElement errorMessage = driver.findElement(By.xpath("//div[@id='error']//p[@class='error-message']"));

        Assert.assertEquals(errorMessage.getText(), "Missing email");
    }

}