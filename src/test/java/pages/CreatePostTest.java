package pages;

import baseTest.BaseTest;
import org.junit.jupiter.api.Test;

public class CreatePostTest extends BaseTest {

    @Test
    public void createPostWithAllFieldsByUser() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .inputEmail("QWERTY@QERY.COM")
                .inputPassword("qwerty123")
                .clickLoginForUser()
                .clickOnCreatePostButton()
                .inputTitle("Title")
                .inputDescription("Description")
                .inputContent("Content")
                .clickOnUploadImageField()
                .imageIsUploaded()
                .clickOnSubmitButton();
    }

    @Test
    public void createDelayedPostByUser() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .inputEmail("QWERTY@QERY.COM")
                .inputPassword("qwerty123")
                .clickLoginForUser()
                .clickOnCreatePostButton()
                .inputTitle("Title")
                .inputDescription("Description")
                .inputContent("Content")
                .clickOnUploadImageField()
                .clickOnDelayDatePicker()
                .clickOnSubmitButton();
    }

    @Test
    public void createDraftByUser() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .inputEmail("QWERTY@QERY.COM")
                .inputPassword("qwerty123")
                .clickLoginForUser()
                .clickOnCreatePostButton()
                .inputTitle("Title")
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
