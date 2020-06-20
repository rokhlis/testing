package TrelloTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProfileVisibility extends TestBase {

    @BeforeMethod
    public void initTests() {
        //Clicking login button
        driver.findElement(By.xpath("//a[@class='btn btn-sm btn-link text-white']")).click();
        waitUntilElementIsClickable(By.id("login"), 10);
        //Entering credentials and logging in
        driver.findElement(By.xpath("//input[@id='user']")).sendKeys(LOGIN);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(PASSWORD);
        waitUntilElementIsClickable(By.id("login"), 10);
        driver.findElement(By.cssSelector("#login")).click();
        waitUntilElementIsVisible((By.className("home-sticky-container")), 20);
        //Entering the workspace
        driver.get(WORKSPACE_NAME);
        //Opening profile menu
        driver.findElement(By.xpath("//button[@aria-label='Open Member Menu']")).click();
        waitUntilElementIsClickable(By.xpath("//span[contains(text(),'Profile and Visibility')]"), 20);
        //Entering Profile and Visibility
        driver.findElement(By.xpath("//a[@data-test-id='header-member-menu-profile']")).click();
        waitUntilElementIsVisible(By.xpath("//a[@class='tabbed-pane-nav-item-button js-member-profile active']"), 20);
    }

    @Test
    public void labelTextVerificationTest() throws InterruptedException {
        //Getting menu label text
        WebElement menuLabel = driver.findElement(By.xpath("//button[@aria-label='Open Member Menu']"));
        System.out.println("Menu button text: " + menuLabel.getText());
        Thread.sleep(2000);
        //Getting logo label text
        WebElement nameLabel = driver.findElement(By.xpath(nameLocator(NAME_TITLE)));
        System.out.println("Name icon text: " + nameLabel.getText());
        Thread.sleep(2000);
        //Equivalence checking
        Assert.assertEquals(menuLabel.getText(), nameLabel.getText(), "'Open Menu Button' and 'Name Icon' have a different names");
    }

    @Test
    public void userNameVerificationTest() throws InterruptedException {
        WebElement userNameProfile = driver.findElement(By.xpath(userNameTitleLocator(USERNAME_TITLE)));
        System.out.println("User name Profile: " + userNameProfile.getText());
        Thread.sleep(2000);

        WebElement userName = driver.findElement(By.name("username"));
        System.out.println("User name text: @" + userName.getAttribute("value"));
        Thread.sleep(2000);

        Assert.assertEquals(userNameProfile.getText(), "@" + userName.getAttribute("value"), "'User name Profile' and 'User name' have a different names");
    }

    private String nameLocator(String nameTitle) {
        return "//div[@title = '" + nameTitle + "']";
    }

    private String userNameTitleLocator(String userNameProfile) {
        return "//span[contains(text(), '" + USERNAME_TITLE + "')]/../span[2]";
    }


}
