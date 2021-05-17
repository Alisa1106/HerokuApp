package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileDownloaderPage extends BasePage {

    public FileDownloaderPage(WebDriver driver) {
        super(driver);
    }

    public static final By PAGE_CONTENT = By.xpath("//*[@id='content']");
    public static final String DOWNLOAD_FILE_LINK = "//*[@id='content']//*[text()='%s']";

    /**
     * Open page.
     *
     * @param url the url
     */
    public void openPage(String url) {
        driver.get(url);
    }

    /**
     * Wait for page loaded.
     */
    public void waitForPageLoaded() {
        waitForElementLocated(PAGE_CONTENT, 10);
    }

    /**
     * Click download file link.
     *
     * @param fileName the file name
     */
    public void clickDownloadFileLink(String fileName) {
        driver.findElement(By.xpath(String.format(DOWNLOAD_FILE_LINK, fileName))).click();
    }

    /**
     * Sleep.
     *
     * @throws InterruptedException the interrupted exception
     */
    public void sleep() throws InterruptedException {
        Thread.sleep(5000);
    }
}