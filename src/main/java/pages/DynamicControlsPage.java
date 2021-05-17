package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DynamicControlsPage extends BasePage {

    public DynamicControlsPage(WebDriver driver) {
        super(driver);
    }

    public static final By CHECKBOX_FIELD = By.xpath("//*[@type='checkbox']");
    public static final By REMOVE_BUTTON = By.xpath("//*[text()='Remove']");
    public static final By MESSAGE = By.xpath("//*[@id='message']");
    public static final By INPUT_FIELD = By.xpath("//*[@type='text']");
    public static final By ENABLE_BUTTON = By.xpath("//*[text()='Enable']");

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
        waitForElementLocated(ENABLE_BUTTON, 10);
    }

    /**
     * Is checkbox displayed boolean.
     *
     * @return the boolean
     */
    public boolean isCheckboxDisplayed() {
        List<WebElement> checkboxesList = driver.findElements(CHECKBOX_FIELD);
        return !checkboxesList.isEmpty();
    }

    /**
     * Click checkbox field.
     */
    public void clickCheckboxField() {
        driver.findElement(CHECKBOX_FIELD).click();
    }

    /**
     * Is checkbox selected boolean.
     *
     * @return the boolean
     */
    public boolean isCheckboxSelected() {
        return driver.findElement(CHECKBOX_FIELD).isSelected();
    }

    /**
     * Click remove button.
     */
    public void clickRemoveButton() {
        driver.findElement(REMOVE_BUTTON).click();
    }

    /**
     * Wait text message.
     *
     * @param message the message
     */
    public void waitTextMessage(String message) {
        waitTextToBe(MESSAGE, 20, message);
    }

    /**
     * Is input field enabled boolean.
     *
     * @return the boolean
     */
    public boolean isInputFieldEnabled() {
        return driver.findElement(INPUT_FIELD).isEnabled();
    }

    /**
     * Click enable button.
     */
    public void clickEnableButton() {
        driver.findElement(ENABLE_BUTTON).click();
    }
}