package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactPage extends BasePage{

    @FindBy(xpath = "//h1")
    private WebElement contactUsHeader;

    @FindBy(id = "name")
    private WebElement nameInput;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "content")
    private WebElement contentTextarea;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement sendMessageButton;

    @FindBy(xpath = "//div[@class=\"success-message\"]")
    private WebElement successMessage;

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    public String getTextFromHeader(){
        return contactUsHeader.getText();
    }

    public ContactPage inputName(String name){
        nameInput.sendKeys(name);
        return this;
    }

    public ContactPage inputEmail(String email){
        emailInput.sendKeys(email);
        return this;
    }

    public ContactPage inputMessage(String message){
        contentTextarea.sendKeys(message);
        return this;
    }

    public ContactPage clickSendMessageButton(){
        sendMessageButton.click();
        return this;
    }

    public boolean displayedSuccessMessage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(successMessage));
        return successMessage.isDisplayed();
    }
}
