package pages;

import baseTest.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationTest extends BaseTest {
    private final String registrationUserEmail = "registration@email.com";
    private final String password = "example123";
    private final String registrationAdminEmail = "registrationAdmin@email.com";
    private final String homeBlogLink = "http://chatty.telran-edu.de:8089/homeblog";


    @Test
    public void registerUserTest() {
        new LoginPage(driver)
                .open()
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
        new LoginPage(driver)
                .open()
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
        new LoginPage(driver)
                .open()
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
