package pages;

import org.openqa.selenium.WebDriver;

public class OwnPostPage extends BasePage{
    public OwnPostPage(WebDriver driver) {
        super(driver);
    }

    public Header openHeader(){
        return new Header(driver);
    }

}
