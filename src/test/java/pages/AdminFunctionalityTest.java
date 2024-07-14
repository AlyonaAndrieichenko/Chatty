package pages;

import baseTest.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdminFunctionalityTest extends BaseTest {

    private final String adminEmail = "admin@email.com";
    private final String adminPass = "qwerty123";
    private final String userEmail = "forupdating@email.com";
    private final String userPass = "example123";

    @Test
    public void searchUserTest() {
        LoginPage loginPage = new LoginPage(driver);
        String actualSearchResult = loginPage.open()
                .clickSignIn()
                .inputEmail(userEmail)
                .inputPassword(userPass)
                .inputConfirmPassword(userPass)
                .clickSelectionDropDown()
                .chooseUserOption()
                .clickRegistrationButton()
                .openHeader()
                .hoverDropDown()
                .clickOnLogout()
                .inputEmail(adminEmail)
                .inputPassword(adminPass)
                .clickLoginForAdmin()
                .inputEmailInSearchInput(userEmail)
                .clickOnSearchButton()
                .getUserEmail();
        defineTestResultEquals(userEmail, actualSearchResult);
    }

    @Test
    public void updateUserTest() {
        LoginPage loginPage = new LoginPage(driver);
        boolean isProfilePage = loginPage.open()
                .inputEmail(adminEmail)
                .inputPassword(adminPass)
                .clickLoginForAdmin()
                .inputEmailInSearchInput(userEmail)
                .clickOnSearchButton()
                .clickOnUpdateUserButton()
                .isProfilePage();
        defineTestResultTrue(isProfilePage);
        defineTestResultEquals(userEmail, new ProfilePage(driver).getTextFromHeader());
    }

    @Test
    public void deleteUserTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .inputEmail(adminEmail)
                .inputPassword(adminPass)
                .clickLoginForAdmin()
                .inputEmailInSearchInput(userEmail)
                .clickOnSearchButton()
                .clickOnDeleteUserButton()
                .openHeader()
                .hoverDropDown()
                .clickOnLogout()
                .inputEmail(userEmail)
                .inputPassword(userPass)
                .clickLoginForUser();
        defineTestResultTrue(loginPage.displayedUserNotFoundText());
    }

}
