package pages;

import baseTest.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationTest extends BaseTest {
    String registrationUserEmail = "registration@email.com";
    String password = "example123";
    String registrationAdminEmail = "registrationAdmin@email.com";
    private final String homeBlogLink = "http://chatty.telran-edu.de:8089/homeblog";


    @Test
    public void registerUserTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .clickSignIn()
                .inputEmail(registrationUserEmail)
                .inputPassword(password)
                .inputConfirmPassword(password)
                .clickSelectionDropDown()
                .chooseUserOption()
                .clickRegistrationButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(homeBlogLink));
        defineTestResultEquals(homeBlogLink, driver.getCurrentUrl());
    }

    @Test
    public void registerAdminTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .clickSignIn()
                .inputEmail(registrationAdminEmail)
                .inputPassword(password)
                .inputConfirmPassword(password)
                .clickSelectionDropDown()
                .chooseAdminOption()
                .clickRegistrationButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(homeBlogLink));
        defineTestResultEquals(homeBlogLink, driver.getCurrentUrl());
    }

    @Test
    public void registerAdminWithExistingDataTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .clickSignIn()
                .inputEmail(registrationUserEmail)
                .inputPassword(password)
                .inputConfirmPassword(password)
                .clickSelectionDropDown()
                .chooseAdminOption()
                .clickRegistrationButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(new RegistrationPage(driver).getErrorText()));
        defineTestResultEquals("Email already exists!", new RegistrationPage(driver).getErrorText().getText());
    }

}
