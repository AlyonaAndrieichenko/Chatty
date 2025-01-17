package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;

import static java.lang.Thread.sleep;

public class HomePage extends BasePage{
    private final WebDriverWait wait;

    @FindBy(xpath = "//div[@class=\"post-header__left\"]")
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
    private WebElement delayPostPicker;

    @FindBy(xpath = "//label[@for=\"draftCheckbox\"]")
    private WebElement draftToggle;

    @FindBy(tagName = "button")
    private WebElement submitButton;

    @FindBy(xpath = "//a[@class=\"menu-item \"]")
    private WebElement myDraftsButton;

    @FindBy(xpath = "//img[@class=\"post_uploaded_image__7qSWV\"]")
    private WebElement imageUploaded;


    public HomePage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public OwnPostsFeedPage clickOnMyPostsToggle(){
        wait.until(ExpectedConditions.visibilityOf(myPostsToggle));
        myPostsToggle.click();
        return new OwnPostsFeedPage(driver);
    }

    public MyDraftsPage clickOnMyDraftsButton(){
        myDraftsButton.click();
        return new MyDraftsPage(driver);
    }

    public HomePage clickOnCreatePostButton(){
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

    public HomePage clickOnUploadImageField(){
        uploadImageField.click();
        String scriptPath = "C:\\Users\\Admin\\Desktop\\uploadImageScript.ps1";
        String command = "powershell.exe -ExecutionPolicy Bypass -File \"" + scriptPath + "\"";
        try {
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public HomePage clickOnDraftToggle(){
        draftToggle.click();
        return this;
    }

    public HomePage chooseDelayDate(LocalDate delayDate){
        String delayDateString = delayDate.toString();
        delayPostPicker.clear();
        String[] fullDate = delayDateString.split("-");
        String day = fullDate[2];
        String month = fullDate[1];
        String year = fullDate[0];
        delayPostPicker.sendKeys(day, month,year);
        return this;
    }

    public HomePage clickOnSubmitButton(){
        submitButton.click();
        return this;
    }

    public HomePage imageIsUploaded(){
        wait.until(ExpectedConditions.visibilityOf(imageUploaded));
        if (imageUploaded.isDisplayed()) return this;
        else throw new RuntimeException("Image ISN'T uploaded");
    }

}
