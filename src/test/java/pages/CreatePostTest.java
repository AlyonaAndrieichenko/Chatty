package pages;

import baseTest.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CreatePostTest extends BaseTest {
    private String title = "qwerty";
    private String description = "qwertyuio";
    private String content = "asdfgh";
    private String email = "QWERTY@QERY.COM";
    private String password = "qwerty123";


    @BeforeEach
    public void openCreatePost() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .inputEmail(email)
                .inputPassword(password)
                .clickLoginForUser()
                .clickOnCreatePostButton();
    }

    @Test
    public void createPostWithAllFieldsByUser() {
        new HomePage(driver)
                .inputTitle(title)
                .inputDescription(description)
                .inputContent(content)
                .clickOnUploadImageField()
                .imageIsUploaded()
                .clickOnSubmitButton();
    }

    @Test
    public void createDelayedPostByUser() {
        new HomePage(driver)
                .inputTitle(title)
                .inputDescription(description)
                .inputContent(content)
                .clickOnUploadImageField()
                .chooseDelayDate("10", "08", "2024")
                .clickOnSubmitButton();
    }

    @Test
    public void createDraftByUser() {
        new HomePage(driver)
                .inputTitle(title)
                .inputDescription(description)
                .inputContent(content)
                .clickOnUploadImageField()
                .imageIsUploaded()
                .clickOnDraftToggle()
                .clickOnSubmitButton()
                .clickOnMyDraftsButton();
        defineTestResultTrue(new MyDraftsPage(driver).containsDescription(description));
    }

}
