package tests2;

import constants.ITestConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadTest extends BaseTest implements ITestConstants {

    public static final String RELATIVE_FILE_PATH = System.getProperty("user.dir") + "/src/test/resources/file.txt";
    public static final String FILE_NAME = "file.txt";

    /**
     * Upload file test.
     * This method checks the name the uploaded file
     */
    @Test
    public void uploadFileTest() {
        uploadPage.openPage(HEROKU_APP_UPLOAD_PAGE_URL);
        uploadPage.uploadFile(RELATIVE_FILE_PATH);
        Assert.assertEquals(uploadPage.getFileUploadedFieldText(), FILE_NAME);
    }
}