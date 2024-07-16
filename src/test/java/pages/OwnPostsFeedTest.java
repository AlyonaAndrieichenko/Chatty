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
        new LoginPage(driver)
                .open()
                .inputEmail(userEmail)
                .inputPassword(password)
                .clickLoginForUser();
    }

    @Test
    public void ownPostsFeedContainsOnlyUserPosts() {
        boolean actual = new HomePage(driver)
                .clickOnMyPostsToggle()
                .containsOnlyUserName(updatedName);
        defineTestResultTrue(actual);
    }

}
