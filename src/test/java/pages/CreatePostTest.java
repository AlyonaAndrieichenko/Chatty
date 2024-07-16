package pages;

import baseTest.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class CreatePostTest extends BaseTest {
    private final String title = "qwerty";
    private final String description = "qwertyuio";
    private final String content = "asdfgh";
    private final String email = "QWERTY@QERY.COM";
    private final String password = "qwerty123";
    private final LocalDate delayDate = LocalDate.of(2024, 10, 8);


    @BeforeEach
    public void openCreatePost() {
        new LoginPage(driver)
                .open()
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
                .chooseDelayDate(delayDate)
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
