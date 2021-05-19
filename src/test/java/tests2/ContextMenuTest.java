package tests2;

import constants.ITestConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContextMenuTest extends BaseTest implements ITestConstants {

    public static final String ACTUAL_ALERT_TEXT = "You selected a context menu";

    /**
     * Context menu text test.
     * This method checks message on the context menu after right click to the element
     */
    @Test
    public void contextMenuTextTest() {
        contextMenuPage.openPage(HEROKU_APP_CONTEXT_MENU_PAGE_URL);
        contextMenuPage.rightClickToElement();
        Assert.assertEquals(contextMenuPage.getAlertText(), ACTUAL_ALERT_TEXT);
        contextMenuPage.closeAlert();
    }
}