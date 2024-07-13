import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import util.ChromeRegistry;

public class Example {
    public static void main(String[] args) {
        ChromeDriver driver = new ChromeRegistry().registerDriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .inputEmail("QWERTY@QERY.COM")
                .inputPassword("qwerty123")
                .clickLoginForUser()
                .clickOnMyPostsToggle();
//                .openHeader()
//                .hoverDropDown()
//                .clickOnYourProfile();
//                .clickOnCreatePostButton()
//                .inputTitle("Title")
//                .inputDescription("Description")
//                .inputContent("Content")
//  //              .clickOnUploadImageField()
//                .clickOnDraftToggle();
             //   .clickOnSubmitButton();
    }
}
