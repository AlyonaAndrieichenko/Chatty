package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AboutPage extends BasePage{
    @FindBy(xpath = "//h1")
    private WebElement aboutHeader;

    public AboutPage(WebDriver driver) {
        super(driver);
    }

    public String getTextFromHeader(){
        return aboutHeader.getText();
    }

}
