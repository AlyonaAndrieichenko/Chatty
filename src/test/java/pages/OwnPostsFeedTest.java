package pages;

import baseTest.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OwnPostsFeedTest extends BaseTest {
    private final String userEmail = "QWERTY@QERY.COM";
    private final String password = "qwerty123";
    private final String updatedName = "qwerty123";

    @BeforeEach
    public void login() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .inputEmail(userEmail)
                .inputPassword(password)
                .clickLoginForUser();
    }

    @Test
    public void ownPostsFeedContainsOnlyUserPosts() {
        HomePage homePage = new HomePage(driver);
        boolean actual = homePage.clickOnMyPostsToggle()
                .containsOnlyUserName(updatedName);
        defineTestResultTrue(actual);
    }

}
