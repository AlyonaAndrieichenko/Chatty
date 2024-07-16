package pages;

import baseTest.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContactTest extends BaseTest {

    private final String userEmail = "QWERTY@QERY.COM";
    private final String userPassword = "qwerty123";
    private final String userName = "John";
    private final String message = "Test message!";

    @BeforeEach
    public void login() {
        new LoginPage(driver)
                .open()
                .inputEmail(userEmail)
                .inputPassword(userPassword)
                .clickLoginForUser();
    }

    @Test
    public void leaveFeedbackTestPositive() {
        new Header(driver)
                .clickOnContactLink()
                .inputName(userName)
                .inputEmail(userEmail)
                .inputMessage(message)
                .clickSendMessageButton();
        defineTestResultTrue(new ContactPage(driver).displayedSuccessMessage());
    }

}
