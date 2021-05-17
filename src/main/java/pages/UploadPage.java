package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UploadPage extends BasePage {
    public UploadPage(WebDriver driver) {
        super(driver);
    }

    public static final By CHOSE_FILE_BUTTON = By.xpath("//*[@id='file-upload']");
    public static final By UPLOAD_BUTTON = By.xpath("//*[@id='file-submit']");
    public static final By UPLOADED_FILE_NAME_FIELD = By.xpath("//*[@id='uploaded-files']");

    /**
     * Open page.
     *
     * @param url the url
     */
    public void openPage(String url) {
        driver.get(url);
    }

    /**
     * Upload file.
     *
     * @param filePath the file path
     */
    public void uploadFile(String filePath) {
        waitForElementLocated(CHOSE_FILE_BUTTON, 10);
        driver.findElement(CHOSE_FILE_BUTTON).sendKeys(filePath);
        driver.findElement(UPLOAD_BUTTON).click();
    }

    /**
     * Gets file uploaded field text.
     *
     * @return the text in the file uploaded field
     */
    public String getFileUploadedFieldText() {
        return driver.findElement(UPLOADED_FILE_NAME_FIELD).getText();
    }
}