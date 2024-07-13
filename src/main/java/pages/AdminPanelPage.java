package pages;

import org.openqa.selenium.WebDriver;

public class AdminPanelPage extends BasePage{
    public AdminPanelPage(WebDriver driver) {
        super(driver);
    }

    public Header openHeader(){
        return new Header(driver);
    }

}
