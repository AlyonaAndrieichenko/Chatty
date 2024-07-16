package pages;

import baseTest.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OwnPostsFeedTest extends BaseTest {

    @BeforeEach
    public void login() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .inputEmail("QWERTY@QERY.COM")
                .inputPassword("qwerty123")
                .clickLoginForUser();
    }

    @Test
    public void ownPostsFeedContainsOnlyUserPosts() {
        HomePage homePage = new HomePage(driver);
        boolean actual = homePage.clickOnMyPostsToggle()
                .containsOnlyUserName("UpdatedName");
        defineTestResultTrue(actual);
    }

}
