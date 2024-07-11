package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

import static java.lang.Thread.sleep;

public class HomePage extends BasePage{

    @FindBy(xpath = "//label[@for=\"myPostsId\"]")
    private WebElement myPostsToggle;

    @FindBy(xpath = "//span[@data-test=\"post-header__plus\"]")
    private WebElement createPostButton;

    @FindBy(xpath = "//input[@name=\"title\"]")
    private WebElement titleInput;

    @FindBy(xpath = "//input[@name=\"description\"]")
    private WebElement descriptionInput;

    @FindBy(xpath = "//textarea[@name=\"content\"]")
    private WebElement contentInput;

    @FindBy(xpath = "//div[@class=\"post_uploaded_image__7qSWV\"]")
    private WebElement uploadImageField;

    @FindBy(id = "publishDate")
    private WebElement delayPostField;

    @FindBy(xpath = "//label[@for=\"draftCheckbox\"]")
    private WebElement draftToggle;

    @FindBy(tagName = "button")
    private WebElement submitButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage clickOnMyPostsToggle(){
        myPostsToggle.click();
        return this;
    }

    public HomePage clickOnCreatePostButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(createPostButton));
        createPostButton.click();
        return this;
    }

    public HomePage inputTitle(String title){
        titleInput.sendKeys(title);
        return this;
    }

    public HomePage inputDescription(String description){
        descriptionInput.sendKeys(description);
        return this;
    }

    public HomePage inputContent(String content){
        contentInput.sendKeys(content);
        return this;
    }

    public HomePage clickOnUploadImageField() throws IOException, InterruptedException {
        uploadImageField.click();
       // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        sleep(3000);
        Runtime.getRuntime().exec("C:\\Users\\Admin\\Desktop\\uploadImage.exe");
        return this;
    }

    public HomePage clickOnDraftToggle(){
        draftToggle.click();
        return this;
    }

    public HomePage clickOnSubmitButton(){
        submitButton.click();
        return this;
    }
}
