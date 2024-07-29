package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Header extends BasePage{
    private final WebDriverWait wait;

    @FindBy(xpath = "//a[@href=\"/about\"]")
    private WebElement aboutLink;

    @FindBy(xpath = "//a[@href=\"/contact\"]")
    private WebElement contactUsLink;

    @FindBy(className = "header__user")
    private WebElement dropdownMenu;

    @FindBy(xpath = "//a[@href=\"/userprofile\"]")
    private WebElement yourProfileButton;

    @FindBy(xpath = "//a[@href=\"/users\"]")
    private WebElement adminPanelButton;

    @FindBy(xpath = "//a[@href=\"/draft\"]")
    private WebElement yourDraftsButton;

    @FindBy(xpath = "//a[@href=\"/login\"]")
    private WebElement logoutButton;

    public Header(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public Header hoverDropDown(){
        wait.until(ExpectedConditions.visibilityOf(dropdownMenu));
        new Actions(driver).moveToElement(dropdownMenu).perform();
        return this;
    }

    public ProfilePage clickOnYourProfile(){
        wait.until(ExpectedConditions.visibilityOf(yourProfileButton));
        yourProfileButton.click();
        return new ProfilePage(driver);
    }

    public MyDraftsPage clickOnYourDraftsLink(){
        wait.until(ExpectedConditions.visibilityOf(yourDraftsButton));
        yourDraftsButton.click();
        return new MyDraftsPage(driver);
    }

    public LoginPage clickOnLogout(){
        wait.until(ExpectedConditions.visibilityOf(logoutButton));
        logoutButton.click();
        return new LoginPage(driver);
    }

    public AdminPanelPage clickOnAdminPanel(){
        wait.until(ExpectedConditions.visibilityOf(adminPanelButton));
        adminPanelButton.click();
        return new AdminPanelPage(driver);
    }

    public AboutPage clickOnAboutLink(){
        wait.until(ExpectedConditions.visibilityOf(aboutLink));
        aboutLink.click();
        return new AboutPage(driver);
    }

    public ContactPage clickOnContactLink(){
        wait.until(ExpectedConditions.visibilityOf(contactUsLink));
        contactUsLink.click();
        return new ContactPage(driver);
    }
}
