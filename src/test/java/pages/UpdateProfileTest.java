package pages;

import baseTest.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class UpdateProfileTest extends BaseTest {

    private final String userEmail = "QWERTY@QERY.COM";
    private final String updatedName = "UpdatedName";
    private final String updatedSurname = "UpdatedSurname";
    private final String gender = "FEMALE";
    private final String updatedBirthday = "1987-05-12"; //split(-)
    private final String updatedPhone = "+49151147445";
    private final String oldPassword = "qwerty123";
    private final String newPassword = "qwerty12345";
    private final String homeBlogLink = "http://chatty.telran-edu.de:8089/homeblog";


    @BeforeEach
    public void login() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .inputEmail(userEmail)
                .inputPassword(oldPassword)
                .clickLoginForUser()
                .openHeader()
                .hoverDropDown()
                .clickOnYourProfile();
    }

    @Test
    public void updateAllProfileInputsTest() {
        ProfilePage profilePage = new ProfilePage(driver);
        List<String> updatedData = new ArrayList<>();
        updatedData.add(updatedName);
        updatedData.add(updatedSurname);
        updatedData.add(updatedBirthday);
        updatedData.add(updatedPhone);
        updatedData.add(gender);
        profilePage.clickOnEditButton()
                .inputName(updatedName)
                .inputSurname(updatedSurname)
                .inputBirthday("12", "05", "1987")
                .inputPhone(updatedPhone)
                .clickOnGenderDropDown()
                .chooseFemaleGender()
                .clickOnSaveButton();
        defineTestResultTrue(profilePage.containUserData(updatedData));
    }

    @Test
    public void updatePasswordTest() {
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickOnEditButton()
                .clickOnChangePasswordButton()
                .inputOldPassword(oldPassword)
                .inputNewPassword(newPassword)
                .inputConfirmNewPassword(newPassword)
                .clickOnSaveButton()
                .openHeader()
                .hoverDropDown()
                .clickOnLogout()
                .inputEmail(userEmail)
                .inputPassword(newPassword)
                .clickLoginForUser();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(homeBlogLink));
        defineTestResultEquals(homeBlogLink, driver.getCurrentUrl());

        HomePage homePage = new HomePage(driver);
        homePage.openHeader()
                .hoverDropDown()
                .clickOnYourProfile()
                .clickOnChangePasswordButton()
                .inputOldPassword(newPassword)
                .inputNewPassword(oldPassword)
                .inputConfirmNewPassword(oldPassword)
                .clickOnSaveButton();
    }
}
