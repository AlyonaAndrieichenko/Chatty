package pages;

import baseTest.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HeaderLinksTest extends BaseTest {
    @Test
    public void openAboutPageTest() {
        LoginPage loginPage = new LoginPage(driver);
        String actualHeader = loginPage.open()
                .inputEmail("QWERTY@QERY.COM")
                .inputPassword("qwerty123")
                .clickLoginForUser()
                .openHeader()
                .clickOnAboutLink()
                .getTextFromHeader();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("http://chatty.telran-edu.de:8089/about"));
        defineTestResultEquals("About Chatty", actualHeader);
    }

    @Test
    public void openContactPageTest() {
        LoginPage loginPage = new LoginPage(driver);
        String actualHeader = loginPage.open()
                .inputEmail("QWERTY@QERY.COM")
                .inputPassword("qwerty123")
                .clickLoginForUser()
                .openHeader()
                .clickOnContactLink()
                .getTextFromHeader();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("http://chatty.telran-edu.de:8089/contact"));
        defineTestResultEquals("Contact Us", actualHeader);
    }

    @Test
    public void openDraftsPageFromHeaderTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .inputEmail("QWERTY@QERY.COM")
                .inputPassword("qwerty123")
                .clickLoginForUser()
                .openHeader()
                .hoverDropDown()
                .clickOnYourDraftsLink();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("http://chatty.telran-edu.de:8089/draft"));
        defineTestResultEquals("http://chatty.telran-edu.de:8089/draft", driver.getCurrentUrl());
    }

    @Test
    public void openAdminPanelPageFromHeaderTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .inputEmail("admin@email.com")
                .inputPassword("qwerty123")
                .clickLoginForAdmin()
                .openHeader()
                .hoverDropDown()
                .clickOnAdminPanel();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("http://chatty.telran-edu.de:8089/users"));
        defineTestResultEquals("http://chatty.telran-edu.de:8089/users", driver.getCurrentUrl());
    }

    @Test
    public void logoutFromHeaderTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .inputEmail("QWERTY@QERY.COM")
                .inputPassword("qwerty123")
                .clickLoginForUser()
                .openHeader()
                .hoverDropDown()
                .clickOnLogout();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("http://chatty.telran-edu.de:8089/login"));
        defineTestResultEquals("http://chatty.telran-edu.de:8089/login", driver.getCurrentUrl());
    }

}
