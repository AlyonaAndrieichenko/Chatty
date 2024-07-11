import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeRegistry {
    private static final String FILE_SEPARATOR = System.getProperty("file.separator");
    private static final String PATH = "." +  FILE_SEPARATOR +  "src" +  FILE_SEPARATOR + "main" +  FILE_SEPARATOR
            + "resources" +  FILE_SEPARATOR + "chromedriver-win64" +  FILE_SEPARATOR +  "chromedriver.exe";

//    public ChromeDriver registerDriver(){
//        System.setProperty("webdriver.chrome.driver", PATH);
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--disable-notifications");
//        return new ChromeDriver(options);
//    }

    public ChromeDriver registerDriver(){
        System.setProperty("webdriver.chrome.driver", PATH);
        return new ChromeDriver();
    }
}
