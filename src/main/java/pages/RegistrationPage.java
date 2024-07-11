package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{

    @FindBy(css = "[name=\"email\"]")
    private WebElement emailInput;

    @FindBy(css = "[name=\"password\"]")
    private WebElement passwordInput;

    @FindBy(css = "[name=\"confirmPassword\"]")
    private WebElement confirmPasswordInput;

    @FindBy(className = "registration-btn")
    private WebElement registrationButton;

    @FindBy(tagName = "select")
    private WebElement selectMenu;

    @FindBy(xpath = "//option[1]")
    private WebElement userOption;

    @FindBy(xpath = "//option[2]")
    private WebElement adminOption;

    @FindBy(xpath = "//a[@href=\"/contact\"]")
    private WebElement contactUsLink;

    @FindBy(xpath = "//a[@href=\"/about\"]")
    private WebElement aboutUsLink;

    @FindBy(xpath = "//a[@href=\"/login\"]")
    private WebElement loginLink;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public RegistrationPage inputEmail(String email){
        emailInput.sendKeys(email);
        return this;
    }

    public RegistrationPage clickRegistration(){
        registrationButton.click();
        return this;
    }

    public RegistrationPage inputPassword(String password){
        passwordInput.sendKeys(password);
        return this;
    }

    public RegistrationPage inputConfirmPassword(String password){
        confirmPasswordInput.sendKeys(password);
        return this;
    }

    public LoginPage clickLoginLink(){
        loginLink.click();
        return new LoginPage(driver);
    }

    public ContactPage clickContactUsLink(){
        contactUsLink.click();
        return new ContactPage(driver);
    }

    public AboutPage clickAboutUsLink(){
        aboutUsLink.click();
        return new AboutPage(driver);
    }

    public RegistrationPage clickSelectionDropDown(){
        selectMenu.click();
        return this;
    }

    public RegistrationPage chooseUserOption(){
        userOption.click();
        return this;
    }

    public RegistrationPage chooseAdminOption(){
        adminOption.click();
        return this;
    }
}
