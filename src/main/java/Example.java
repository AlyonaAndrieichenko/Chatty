import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import java.io.IOException;

public class Example {
    public static void main(String[] args) throws IOException, InterruptedException {
        ChromeDriver driver = new ChromeRegistry().registerDriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .inputEmail("QWERTY@QERY.COM")
                .inputPassword("qwerty123")
                .clickLogin()
                .clickOnCreatePostButton()
                .inputTitle("Title")
                .inputDescription("Description")
                .inputContent("Content")
                .clickOnUploadImageField();
                //.clickOnSubmitButton();
    }
}
