
package tests2;

import constants.ITestConstants;
import org.testng.annotations.Test;

public class FileDownloaderTest extends BaseTest implements ITestConstants {

    public static final String DOWNLOAD_FILE_NAME = "factorial.txt";

    /**
     * File download test.
     * This method download File in file system
     *
     * @throws InterruptedException the interrupted exception
     */
    @Test
    public void FileDownloadTest() throws InterruptedException {
        fileDownloaderPage.openPage(HEROKU_APP_fILE_DOWNLOADER_PAGE);
        fileDownloaderPage.waitForPageLoaded();
        fileDownloaderPage.clickDownloadFileLink(DOWNLOAD_FILE_NAME);
        fileDownloaderPage.sleep();
    }
}