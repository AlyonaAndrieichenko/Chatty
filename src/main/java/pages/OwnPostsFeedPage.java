package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OwnPostsFeedPage extends BasePage{

    public OwnPostsFeedPage(WebDriver driver) {
        super(driver);
    }

    public Header openHeader(){
        return new Header(driver);
    }

}
