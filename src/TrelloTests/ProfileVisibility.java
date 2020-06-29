package TrelloTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CurrentBoardHelper;
import pages.LoginPageHelper;
import pages.ProfileVisibilityHelper;

public class ProfileVisibility extends TestBase {
    LoginPageHelper loginPage;
    CurrentBoardHelper currentBoard;
    ProfileVisibilityHelper profile;

    @BeforeMethod
    public void initTests() {
        loginPage = new LoginPageHelper(driver);
        currentBoard = new CurrentBoardHelper(driver,BOARD_TITLE);
        profile = new ProfileVisibilityHelper(driver);

        loginPage.openLoginPage();
        loginPage.enteringCredentialsAndClickingLogin(LOGIN, PASSWORD);
        currentBoard.enterWorkspace(WORKSPACE_NAME);
        profile.openProfileMenu();
        profile.enterProfileAndVisibility();
    }

    @Test
    public void labelTextVerificationTest() {
        profile.getMenuLabel();
        profile.getLogoLabel();
        Assert.assertEquals(profile.getMenuLabel(), profile.getLogoLabel(), "'Open Menu Button' and 'Name Icon' have a different names");
    }

    @Test
    public void userNameVerificationTest() {
        profile.getProfileLabelText();
        profile.getUsernameText();
        Assert.assertEquals(profile.getProfileLabelText(), "@" + profile.getUsernameText(), "'User name Profile' and 'User name' have a different names");
    }

}
