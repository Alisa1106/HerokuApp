package tests2;

import constants.ITestConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicControlsTest extends BaseTest implements ITestConstants {

    public static final String MESSAGE_WHEN_CHECKBOX_FIELD_REMOVE = "It's gone!";
    public static final String MESSAGE_WHEN_INPUT_FIELD_ENABLED = "It's enabled!";

    /**
     * Checkbox test.
     * This method checks that after click the remove button checkbox isn`t displayed
     */
    @Test
    public void checkboxIsGoneTest() {
        dynamicControlsPage.openPage(HEROKU_APP_DYNAMIC_CONTROLS_PAGE_URL);
        dynamicControlsPage.waitForPageLoaded();
        Assert.assertTrue(dynamicControlsPage.isCheckboxDisplayed());
        dynamicControlsPage.clickCheckboxField();
        Assert.assertTrue(dynamicControlsPage.isCheckboxSelected());
        dynamicControlsPage.clickRemoveButton();
        dynamicControlsPage.waitTextMessage(MESSAGE_WHEN_CHECKBOX_FIELD_REMOVE);
        Assert.assertFalse(dynamicControlsPage.isCheckboxDisplayed());
    }

    /**
     * Input test.
     * This method checks that after click the enable button the input field is enabled
     */
    @Test
    public void InputFieldIsEnabledTest() {
        dynamicControlsPage.openPage(HEROKU_APP_DYNAMIC_CONTROLS_PAGE_URL);
        dynamicControlsPage.waitForPageLoaded();
        Assert.assertFalse(dynamicControlsPage.isInputFieldEnabled());
        dynamicControlsPage.clickEnableButton();
        dynamicControlsPage.waitTextMessage(MESSAGE_WHEN_INPUT_FIELD_ENABLED);
        Assert.assertTrue(dynamicControlsPage.isInputFieldEnabled());
    }
}