package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;

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
    public void clickDownloadFileLink(String fileName) throws InterruptedException {
        driver.findElement(By.xpath(String.format(DOWNLOAD_FILE_LINK, fileName))).click();
        Thread.sleep(5000);
    }

    /**
     * Is file downloaded boolean.
     *
     * @param downloadFileName the download file name
     * @return the boolean
     */
    public boolean isFileDownloaded(String downloadFileName) {
        File folder = new File(System.getProperty("user.dir"));
        File[] listOfFiles = folder.listFiles();
        boolean found = false;
        File f = null;
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                String fileName = listOfFile.getName();
                System.out.println("File " + listOfFile.getName());
                if (fileName.matches(downloadFileName)) {
                    f = new File(fileName);
                    found = true;
                }
            }
        }
        return found;
    }
}