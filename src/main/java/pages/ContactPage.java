package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage extends BasePage{

    @FindBy(xpath = "//h1")
    private WebElement contactUsHeader;

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    public String getTextFromHeader(){
        return contactUsHeader.getText();
    }

    public Header openHeader(){
        return new Header(driver);
    }


}
