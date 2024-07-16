package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class OwnPostsFeedPage extends BasePage{

    @FindBy(tagName = "span")
    private List<WebElement> authorNames;

    public OwnPostsFeedPage(WebDriver driver) {
        super(driver);
    }

    public boolean containsOnlyUserName(String userName){
        boolean contain = false;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfAllElements(authorNames));
        for (WebElement authorName : authorNames) {
            if (authorName.getText().contains(userName)) contain = true;
            else return false;
        }
        return contain;
    }
}
