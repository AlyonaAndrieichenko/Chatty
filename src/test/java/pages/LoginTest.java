package pages;

import baseTest.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginTest extends BaseTest {

    @Test
    public void loginTestPositive() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .inputEmail("QWERTY@QERY.COM")
                .inputPassword("qwerty123")
                .clickLoginForUser();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("http://chatty.telran-edu.de:8089/homeblog"));
        defineTestResultEquals("http://chatty.telran-edu.de:8089/homeblog", driver.getCurrentUrl());
    }

    @Test
    public void loginWithoutAtInEmailTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .inputEmail("QWERTYQERY.COMM")
                .inputPassword("qwerty123")
                .clickLoginForUser();
        defineTestResultEquals("Incorrect email", loginPage.getIncorrectEmailText().getText());
    }

    @Test
    public void loginWithNotRegisteredEmailTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .inputEmail("QWERTY@QERY.COMM")
                .inputPassword("qwerty123")
                .clickLoginForUser();
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
         wait.until(ExpectedConditions.visibilityOf(loginPage.getUserNotFoundText()));
        defineTestResultEquals("User not found. Please register.", loginPage.getUserNotFoundText().getText());
    }

    @Test
    public void loginOnlyWithOnlyNumbersPasswordTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .inputEmail("QWERTY@QERY.COM")
                .inputPassword("12345678")
                .clickLoginForUser();
        defineTestResultEquals("Password must be 8-100 characters and include at least one letter and one digit",
                                loginPage.getIncorrectPasswordText().getText());
    }
}
