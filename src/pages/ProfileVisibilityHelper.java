package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static TrelloTests.TestBase.NAME_TITLE;
import static TrelloTests.TestBase.USERNAME_TITLE;

public class ProfileVisibilityHelper extends PageBase {
    public ProfileVisibilityHelper(WebDriver driver) {
        super(driver);
    }

    public void openProfileMenu() {
        driver.findElement(By.xpath("//button[@aria-label='Open Member Menu']")).click();
        waitUntilElementIsClickable(By.xpath("//span[contains(text(),'Profile and Visibility')]"), 20);
    }

    public String getMenuLabel() {
        WebElement menuLabel = driver.findElement(By.xpath("//button[@aria-label='Open Member Menu']"));
        return menuLabel.getText();
    }

    public String getLogoLabel() {
        WebElement nameLabel = driver.findElement(By.xpath(nameLocator(NAME_TITLE)));
        return nameLabel.getText();
    }

    public void enterProfileAndVisibility() {
        driver.findElement(By.xpath("//a[@data-test-id='header-member-menu-profile']")).click();
        waitUntilElementIsVisible(By.xpath("//a[@class='tabbed-pane-nav-item-button js-member-profile active']"), 20);
    }

    public String getProfileLabelText() {
        WebElement userNameProfile = driver.findElement(By.xpath(userNameTitleLocator(USERNAME_TITLE)));
        return userNameProfile.getText();
    }

    public String getUsernameText() {
        WebElement userName = driver.findElement(By.name("username"));
        return userName.getAttribute("value");
    }

    private String nameLocator(String nameTitle) {
        return "//div[@title = '" + nameTitle + "']";
    }

    private String userNameTitleLocator(String userNameProfile) {
        return "//span[contains(text(), '" + USERNAME_TITLE + "')]/../span[2]";
    }


}
