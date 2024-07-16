package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdminPanelPage extends BasePage {

    private WebDriverWait wait;

    @FindBy(xpath = "//input[@data-test=\"searchEmailInput\"]")
    private WebElement searchByEmailEditbox;

    @FindBy(xpath = "//button[@class=\"email-btn\"]")
    private WebElement searchButton;

    @FindBy(xpath = "//span[@data-test=\"editUserButton\"]")
    private WebElement updateUserIcon;

    @FindBy(xpath = "//span[@data-test=\"deleteUserButton\"]")
    private WebElement deleteUserIcon;

    @FindBy(xpath = "//td[@data-test=\"userEmail\"]")
    private WebElement userEmail;

    public AdminPanelPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public AdminPanelPage inputEmailInSearchEditbox(String email) {
        wait.until(ExpectedConditions.visibilityOf(searchByEmailEditbox));
        searchByEmailEditbox.sendKeys(email);
        return this;
    }

    public AdminPanelPage clickOnSearchButton() {
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();
        return this;
    }

    public ProfilePage clickOnUpdateUserButton() {
        wait.until(ExpectedConditions.visibilityOf(updateUserIcon));
        updateUserIcon.click();
        return new ProfilePage(driver);
    }

    public AdminPanelPage clickOnDeleteUserButton() {
        wait.until(ExpectedConditions.visibilityOf(deleteUserIcon));
        deleteUserIcon.click();
        return this;
    }

    public String getUserEmail() {
        wait.until(ExpectedConditions.visibilityOf(userEmail));
        return userEmail.getText();
    }

}
