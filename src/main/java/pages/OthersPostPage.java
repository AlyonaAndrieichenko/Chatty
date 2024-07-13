package pages;

import org.openqa.selenium.WebDriver;

public class OthersPostPage extends BasePage{
    public OthersPostPage(WebDriver driver) {
        super(driver);
    }

    public Header openHeader(){
        return new Header(driver);
    }

}
