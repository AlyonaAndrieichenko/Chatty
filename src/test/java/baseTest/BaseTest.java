package baseTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.LoginPage;
import util.ChromeRegistry;
import util.ScreenshotUtil;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.*;

public class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    public void setUp(){
        driver = new ChromeRegistry().registerDriver();
        driver.manage().window().maximize();
        driver.get("http://chatty.telran-edu.de:8089/login");
    }

//    @AfterEach
//    public void tearDown(){
//        driver.quit();
//    }

    public void defineTestResultEquals(Object expected, Object actual) {
        String name = this.getClass().getName();
        try {
            assertEquals(expected, actual);
        } catch (AssertionError e) {
            ScreenshotUtil.captureScreen(driver, name);
            Assert.fail("TEST FAILED");
        }
    }

    public void defineTestResultTrue(boolean condition) {
        String name = this.getClass().getName();
        try {
            assertTrue(condition);
        } catch (AssertionError e) {
            ScreenshotUtil.captureScreen(driver, name);
            Assert.fail("TEST FAILED");
        }
    }

    public void defineTestResultFalse(boolean condition) {
        String name = this.getClass().getName();
        try {
            assertFalse(condition);
        } catch (AssertionError e) {
            ScreenshotUtil.captureScreen(driver, name);
            Assert.fail("TEST FAILED");
        }
    }
}

