package pages;

import baseTest.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginTest extends BaseTest {

    private final String userEmail = "QWERTY@QERY.COM";
    private final String emailWithoutAT = "QWERTYQERY.COMM";
    private final String notRegisteredEmail = "QWERTY@QERY.COMM";
    private final String password = "qwerty123";
    private final String wrongPassword = "12345678";
    private final String homeBlogLink = "http://chatty.telran-edu.de:8089/homeblog";

    @Test
    public void loginTestPositive() {
        new LoginPage(driver)
                .open()
                .inputEmail(userEmail)
                .inputPassword(password)
                .clickLoginForUser();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(homeBlogLink));
        defineTestResultEquals(homeBlogLink, driver.getCurrentUrl());
    }

    @Test
    public void loginWithoutAtInEmailTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .inputEmail(emailWithoutAT)
                .inputPassword(password)
                .clickLoginForUser();
        defineTestResultEquals("Incorrect email", loginPage.getIncorrectEmailText().getText());
    }

    @Test
    public void loginWithNotRegisteredEmailTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .inputEmail(notRegisteredEmail)
                .inputPassword(password)
                .clickLoginForUser();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(loginPage.getUserNotFoundText()));
        defineTestResultEquals("User not found. Please register.", loginPage.getUserNotFoundText().getText());
    }

    @Test
    public void loginOnlyWithOnlyNumbersPasswordTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .inputEmail(userEmail)
                .inputPassword(wrongPassword)
                .clickLoginForUser();
        defineTestResultEquals("Password must be 8-100 characters and include at least one letter and one digit",
                loginPage.getIncorrectPasswordText().getText());
    }
}
