package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IFramePage extends BasePage {
    public IFramePage(WebDriver driver) {
        super(driver);
    }

    public static final By FRAME_AREA = By.xpath("//*[@class='tox tox-tinymce']");
    public static final By FRAME = By.xpath("//*[@id='mce_0_ifr']");
    public static final By INPUT_TEXT_FIELD = By.xpath("//*[@id='tinymce']");

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
        waitForElementLocated(FRAME_AREA, 10);
    }

    /**
     * Gets text in frame field.
     *
     * @return the text in the frame field
     */
    public String getTextInFrameField() {
        driver.switchTo().frame(driver.findElement(FRAME));
        return driver.findElement(INPUT_TEXT_FIELD).getText();
    }

    /**
     * Exit from frame.
     */
    public void exitFromFrame() {
        driver.switchTo().defaultContent();
    }
}