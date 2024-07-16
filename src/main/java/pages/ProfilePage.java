package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProfilePage extends BasePage {

    private final WebDriverWait wait;

    @FindBy(xpath = "//p[@data-test=\"profileEmail\"]")
    private WebElement profileEmail;

    @FindBy(xpath = "//img[@class=\"user_uploaded_image__JubbD\"]")
    private WebElement uploadProfileImage;

    @FindBy(xpath = "//input[@data-test=\"profileName\"]")
    private WebElement nameInput;

    @FindBy(xpath = "//input[@data-test=\"profileSurname\"]")
    private WebElement surnameInput;

    @FindBy(id = "birthDate")
    private WebElement birthdayInput;

    @FindBy(xpath = "//input[@name=\"phone\"]")
    private WebElement phoneInput;

    @FindBy(id = "gender")
    private WebElement genderDropDown;

    @FindBy(xpath = "//option[@value=\"MALE\"]")
    private WebElement genderMaleOption;

    @FindBy(xpath = "//option[@value=\"FEMALE\"]")
    private WebElement genderFemaleOption;

    @FindBy(xpath = "//button[@class=\"data-input pass__btn\"]")
    private WebElement changePasswordButton;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement saveButton;

    @FindBy(xpath = "//span[@data-test=\"post-header__plus\"]")
    private WebElement editButton;

    @FindBy(xpath = "//span[@data-test=\"post-header__plus\"]")
    private List<WebElement> userData;


    public ProfilePage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public boolean isProfilePage() {
        return driver.getCurrentUrl().startsWith("http://chatty.telran-edu.de:8089/userprofile/");
    }

    public String getTextFromHeader() {
        wait.until(ExpectedConditions.visibilityOf(profileEmail));
        return profileEmail.getText();
    }

    public ProfilePage clickOnEditButton() {
        wait.until(ExpectedConditions.visibilityOf(editButton));
        editButton.click();
        return this;
    }

    public ProfilePage clickOnSaveButton() {
        wait.until(ExpectedConditions.visibilityOf(saveButton));
        saveButton.click();
        return this;
    }

    public ChangePasswordPopUp clickOnChangePasswordButton() {
        wait.until(ExpectedConditions.visibilityOf(changePasswordButton));
        changePasswordButton.click();
        return new ChangePasswordPopUp(driver);
    }

    public ProfilePage clickOnGenderDropDown() {
        wait.until(ExpectedConditions.visibilityOf(genderDropDown));
        genderDropDown.click();
        return this;
    }

    public ProfilePage chooseMaleGender() {
        wait.until(ExpectedConditions.visibilityOf(genderMaleOption));
        genderMaleOption.click();
        return this;
    }

    public ProfilePage chooseFemaleGender() {
        wait.until(ExpectedConditions.visibilityOf(genderFemaleOption));
        genderFemaleOption.click();
        return this;
    }

    public ProfilePage inputName(String name) {
        nameInput.clear();
        nameInput.sendKeys(name);
        return this;
    }

    public ProfilePage inputSurname(String surname) {
        surnameInput.clear();
        surnameInput.sendKeys(surname);
        return this;
    }

    public ProfilePage inputBirthday(LocalDate birthDay) {
        String birthDayString = birthDay.toString();
        birthdayInput.clear();
        String[] fullDate = birthDayString.split("-");
        String day = fullDate[2];
        String month = fullDate[1];
        String year = fullDate[0];
        birthdayInput.sendKeys(day, month, year);
        return this;
    }

    public ProfilePage inputPhone(String phone) {
        phoneInput.clear();
        phoneInput.sendKeys(phone);
        return this;
    }

    public boolean containUserData(List<String> updatedData) {
        System.out.println(updatedData);
        if (!nameInput.getAttribute("value").equals(updatedData.get(0))) {
            System.out.println("name false");
            return false;
        }
        if (!surnameInput.getAttribute("value").equals(updatedData.get(1))) {
            System.out.println("surname false");
            return false;
        }
        if (!birthdayInput.getAttribute("value").equals(updatedData.get(2))) {
            System.out.println(birthdayInput.getAttribute("value"));
            return false;
        }
        if (!phoneInput.getAttribute("value").equals(updatedData.get(3))) {
            System.out.println("phone false");
            return false;
        }
        if (!genderFemaleOption.getAttribute("value").equals(updatedData.get(4))) {
            System.out.println("gender false");
            return false;
        }
        return true;
    }
}
