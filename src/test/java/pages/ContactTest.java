package pages;

import baseTest.BaseTest;
import org.junit.jupiter.api.Test;

public class ContactTest extends BaseTest {

    @Test
    public void leaveFeedbackTestPositive() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .inputEmail("QWERTY@QERY.COM")
                .inputPassword("qwerty123")
                .clickLoginForUser()
                .openHeader()
                .clickOnContactLink()
                .inputName("John")
                .inputEmail("QWERTY@QERY.COM")
                .inputMessage("Test message!")
                .clickSendMessageButton();
        defineTestResultTrue(new ContactPage(driver).displayedSuccessMessage());
    }

}
