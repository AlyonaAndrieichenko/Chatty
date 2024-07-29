package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangePasswordPopUpPage extends BasePage{

    @FindBy(xpath = "//input[@placeholder=\"Old password\"]")
    private WebElement oldPasswordInput;

    @FindBy(xpath = "//input[@placeholder=\"New password\"]")
    private WebElement newPasswordInput;

    @FindBy(xpath = "//input[@placeholder=\"Confirm new password\"]")
    private WebElement confirmNewPasswordInput;

    @FindBy(xpath = "//button[@class=\"PasswordModal_pass_btn__eGL9h\"]")
    private WebElement saveButton;

    public ChangePasswordPopUpPage(WebDriver driver) {
        super(driver);
    }

    public ChangePasswordPopUpPage inputOldPassword(String oldPassword){
        oldPasswordInput.sendKeys(oldPassword);
        return this;
    }

    public ChangePasswordPopUpPage inputNewPassword(String newPassword){
        newPasswordInput.sendKeys(newPassword);
        return this;
    }

    public ChangePasswordPopUpPage inputConfirmNewPassword(String confirmNewPassword){
        confirmNewPasswordInput.sendKeys(confirmNewPassword);
        return this;
    }

    public ProfilePage clickOnSaveButton(){
        saveButton.click();
        return new ProfilePage(driver);
    }

}
