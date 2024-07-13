package pages;

import baseTest.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationTest extends BaseTest {

    @Test
    public void registerUserTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .clickSignIn()
                .inputEmail("example1@email.com")
                .inputPassword("example123")
                .inputConfirmPassword("example123")
                .clickSelectionDropDown()
                .chooseUserOption()
                .clickRegistrationButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("http://chatty.telran-edu.de:8089/homeblog"));
        defineTestResultEquals("http://chatty.telran-edu.de:8089/homeblog", driver.getCurrentUrl());
    }

    @Test
    public void registerAdminTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .clickSignIn()
                .inputEmail("admin@email.com")
                .inputPassword("qwerty123")
                .inputConfirmPassword("qwerty123")
                .clickSelectionDropDown()
                .chooseAdminOption()
                .clickRegistrationButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("http://chatty.telran-edu.de:8089/homeblog"));
        defineTestResultEquals("http://chatty.telran-edu.de:8089/homeblog", driver.getCurrentUrl());
    }

    @Test
    public void registerAdminWithExistingDataTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .clickSignIn()
                .inputEmail("example@email.com")
                .inputPassword("example123")
                .inputConfirmPassword("example123")
                .clickSelectionDropDown()
                .chooseAdminOption()
                .clickRegistrationButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(new RegistrationPage(driver).getErrorText()));
        defineTestResultEquals("Email already exists!", new RegistrationPage(driver).getErrorText().getText());
    }

}
