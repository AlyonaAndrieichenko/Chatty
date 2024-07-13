package pages;

import org.openqa.selenium.WebDriver;

public class ProfilePage extends BasePage{
    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public Header openHeader(){
        return new Header(driver);
    }

}
