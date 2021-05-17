package tests2;

import constants.ITestConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IFrameTest extends BaseTest implements ITestConstants {

    public static final String TEXT_IN_FRAME_TEXT_FIELD = "Your content goes here.";

    /**
     * Check text in frame test.
     * This method checks the text in the input field in the frame
     */
    @Test
    public void checkTextInFrameTest() {
        iFramePage.openPage(HEROKU_APP_IFRAME_PAGE_URL);
        iFramePage.waitForPageLoaded();
        Assert.assertEquals(iFramePage.getTextInFrameField(), TEXT_IN_FRAME_TEXT_FIELD);
        iFramePage.exitFromFrame();
    }
}