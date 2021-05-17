package tests2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.io.File;
import java.util.HashMap;

public class BaseTest {
    WebDriver driver;
    ContextMenuPage contextMenuPage;
    DynamicControlsPage dynamicControlsPage;
    IFramePage iFramePage;
    UploadPage uploadPage;
    FileDownloaderPage fileDownloaderPage;

    /**
     * Init test.
     * This method performed before the test method
     */
    @BeforeMethod
    public void InitTest() {
        WebDriverManager.chromedriver().setup();
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", new File("src/test/resources/Download").getAbsolutePath());
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        contextMenuPage = new ContextMenuPage(driver);
        dynamicControlsPage = new DynamicControlsPage(driver);
        iFramePage = new IFramePage(driver);
        uploadPage = new UploadPage(driver);
        fileDownloaderPage = new FileDownloaderPage(driver);
    }

    /**
     * End test.
     * This method performed after test method
     */
    @AfterMethod
    public void endTest() {
        driver.quit();
    }
}