package utility;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.File;
import java.net.MalformedURLException;
import java.util.HashMap;

public class BasePage {
    static String chromeDriverPath = System.getProperty("user.dir")+File.separator+"src"+File.separator+"driver"+File.separator+ClassHelp.getEnv("googleChrome");
    public static WebDriver driver;
    TestData testData = new TestData();
    public WebDriver openBrowser(String browser){

        if ("chrome".equals(browser)) {
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
            System.out.println(chromeDriverPath);
            String downloadFilepath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "DownloadFile" + File.separator;
            HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
            chromePrefs.put("profile.default_content_settings.popups", 0);
            chromePrefs.put("download.default_directory", downloadFilepath);
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setExperimentalOption("prefs", chromePrefs);
            if (testData.getIsHeadless().equalsIgnoreCase("yes")) {
                chromeOptions.addArguments("--headless");
            }
            chromeOptions.addArguments("--disable-notifications");
            chromeOptions.addArguments("--window-size=1366, 768");//1920,1080
            driver = new ChromeDriver(chromeOptions);
        }
        System.out.println("Opening Browser: " + browser);
        return driver;
    }
}