package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MyDraftsPage extends BasePage{

    @FindBy(xpath = "//p[@class=\"post__description\"]")
    private List<WebElement> postsDescriptions;

    public MyDraftsPage(WebDriver driver) {
        super(driver);
    }

    public boolean containsDescription(String description){
        boolean contains = false;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfAllElements(postsDescriptions));
        for (WebElement postDescription : postsDescriptions) {
             if (postDescription.getText().contains(description)) contains = true;
             else return false;
        }
        return contains;
    }


}
