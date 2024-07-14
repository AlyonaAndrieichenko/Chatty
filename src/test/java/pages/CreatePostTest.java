package pages;

import baseTest.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CreatePostTest extends BaseTest {

    @BeforeEach
    public void openCreatePost() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .inputEmail("QWERTY@QERY.COM")
                .inputPassword("qwerty123")
                .clickLoginForUser()
                .clickOnCreatePostButton();
    }

    @Test
    public void createPostWithAllFieldsByUser() {
        HomePage homePage = new HomePage(driver);
        homePage.inputTitle("Title")
                .inputDescription("Description")
                .inputContent("Content")
                .clickOnUploadImageField()
                .imageIsUploaded()
                .clickOnSubmitButton();
    }

    @Test
    public void createDelayedPostByUser() {
        HomePage homePage = new HomePage(driver);
        homePage.inputTitle("Title")
                .inputDescription("Description")
                .inputContent("Content")
                .clickOnUploadImageField()
                .chooseDelayDate("10", "08", "2024")
                .clickOnSubmitButton();
    }

    @Test
    public void createDraftByUser() {
        HomePage homePage = new HomePage(driver);
        homePage.inputTitle("Title")
                .inputDescription("Description")
                .inputContent("Content")
                .clickOnUploadImageField()
                .imageIsUploaded()
                .clickOnDraftToggle()
                .clickOnSubmitButton()
                .clickOnMyDraftsButton();
        defineTestResultTrue(new MyDraftsPage(driver).containsDescription("Description"));
    }

}
