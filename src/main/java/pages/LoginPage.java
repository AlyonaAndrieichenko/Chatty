package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage{

    @FindBy(css = "[name=\"email\"]")
    private WebElement emailInput;

    @FindBy(css = "[name=\"password\"]")
    private WebElement passwordInput;

    @FindBy(className = "registration-btn")
    private WebElement loginButton;

    @FindBy(className = "password-eye")
    private WebElement passwordEyeButton;

    @FindBy(xpath = "(//a[@href=\"/registration\"])[1]")
    private WebElement signUpLink;

    @FindBy(xpath = "(//a[@href=\"/registration\"])[2]")
    private WebElement signInLink;

    @FindBy(xpath = "//div[@class=\"text-error\" and text()=\"Incorrect email\"]")
    private WebElement incorrectEmailText;

    @FindBy(xpath = "//div[@class=\"text-error\" and text()=\"Password must be 8-100 characters and include at least one letter and one digit\"]")
    private WebElement incorrectPasswordText;

    @FindBy(xpath = "//div[@class=\"text-error\" and text()=\"User not found. Please register.\"]")
    private WebElement userNotFoundText;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage open(){
        driver.get("http://chatty.telran-edu.de:8089/login");
        return this;
    }

    public LoginPage inputEmail(String email){
        emailInput.sendKeys(email);
        return this;
    }

    public HomePage clickLoginForUser(){
        loginButton.click();
        return new HomePage(driver);
    }

    public AdminPanelPage clickLoginForAdmin(){
        loginButton.click();
        return new AdminPanelPage(driver);
    }

    public LoginPage inputPassword(String password){
        passwordInput.sendKeys(password);
        return this;
    }

    public RegistrationPage clickSignUp(){
        signUpLink.click();
        return new RegistrationPage(driver);
    }

    public RegistrationPage clickSignIn(){
        signInLink.click();
        return new RegistrationPage(driver);
    }

    public WebElement getIncorrectEmailText(){
        return this.incorrectEmailText;
    }

    public WebElement getIncorrectPasswordText(){
        return this.incorrectPasswordText;
    }

    public WebElement getUserNotFoundText(){
        return this.userNotFoundText;
    }

    public boolean displayedUserNotFoundText(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(userNotFoundText));
        return userNotFoundText.isDisplayed();
    }
}
