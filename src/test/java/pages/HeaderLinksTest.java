package pages;

import baseTest.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HeaderLinksTest extends BaseTest {
    private final String contactLink = "http://chatty.telran-edu.de:8089/contact";
    private final String aboutLink = "http://chatty.telran-edu.de:8089/about";
    private final String draftLink = "http://chatty.telran-edu.de:8089/draft";
    private final String loginLink = "http://chatty.telran-edu.de:8089/login";
    private final String adminPanelLink = "http://chatty.telran-edu.de:8089/users";
    private final String userEmail = "QWERTY@QERY.COM";
    private final String adminEmail = "admin@email.com";
    private final String password = "qwerty123";


    @Test
    public void openAboutPageTest() {
        String actualHeader = new LoginPage(driver)
                .open()
                .inputEmail(userEmail)
                .inputPassword(password)
                .clickLoginForUser()
                .openHeader()
                .clickOnAboutLink()
                .getTextFromHeader();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(aboutLink));
        defineTestResultEquals("About Chatty", actualHeader);
    }

    @Test
    public void openContactPageTest() {
        String actualHeader = new LoginPage(driver)
                .open()
                .inputEmail(userEmail)
                .inputPassword(password)
                .clickLoginForUser()
                .openHeader()
                .clickOnContactLink()
                .getTextFromHeader();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(contactLink));
        defineTestResultEquals("Contact Us", actualHeader);
    }

    @Test
    public void openDraftsPageFromHeaderTest() {
        new LoginPage(driver)
                .open()
                .inputEmail(userEmail)
                .inputPassword(password)
                .clickLoginForUser()
                .openHeader()
                .hoverDropDown()
                .clickOnYourDraftsLink();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(draftLink));
        defineTestResultEquals(draftLink, driver.getCurrentUrl());
    }

    @Test
    public void openAdminPanelPageFromHeaderTest() {
        new LoginPage(driver)
                .open()
                .inputEmail(adminEmail)
                .inputPassword(password)
                .clickLoginForAdmin()
                .openHeader()
                .hoverDropDown()
                .clickOnAdminPanel();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(adminPanelLink));
        defineTestResultEquals(adminPanelLink, driver.getCurrentUrl());
    }

    @Test
    public void logoutFromHeaderTest() {
        new LoginPage(driver)
                .open()
                .inputEmail(userEmail)
                .inputPassword(password)
                .clickLoginForUser()
                .openHeader()
                .hoverDropDown()
                .clickOnLogout();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(loginLink));
        defineTestResultEquals(loginLink, driver.getCurrentUrl());
    }

}
