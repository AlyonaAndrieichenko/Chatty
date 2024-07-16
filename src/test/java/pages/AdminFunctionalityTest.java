package pages;

import baseTest.BaseTest;
import org.junit.jupiter.api.Test;

public class AdminFunctionalityTest extends BaseTest {

    private final String adminEmail = "admin@email.com";
    private final String adminPass = "qwerty123";
    private final String userEmail = "forupdating@email.com";
    private final String userPass = "example123";

    @Test
    public void searchUserTest() {
        String actualSearchResult = new LoginPage(driver)
                .open()
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
                .inputEmailInSearchEditbox(userEmail)
                .clickOnSearchButton()
                .getUserEmail();
        defineTestResultEquals(userEmail, actualSearchResult);
    }

    @Test
    public void updateUserTest() {
        boolean isProfilePage = new LoginPage(driver)
                .open()
                .inputEmail(adminEmail)
                .inputPassword(adminPass)
                .clickLoginForAdmin()
                .inputEmailInSearchEditbox(userEmail)
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
                .inputEmailInSearchEditbox(userEmail)
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
