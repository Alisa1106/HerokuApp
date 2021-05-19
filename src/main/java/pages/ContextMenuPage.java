package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage extends BasePage {

    public ContextMenuPage(WebDriver driver) {
        super(driver);
    }

    public static final By RECTANGLE_ELEMENT = By.xpath("//*[@id='hot-spot']");

    /**
     * Open page.
     *
     * @param url the url
     */
    public void openPage(String url) {
        driver.get(url);
    }

    /**
     * Right click to element after it appears on page.
     */
    public void rightClickToElement() {
        Actions action = new Actions(driver);
        waitForElementLocated(RECTANGLE_ELEMENT, 10);
        action.contextClick(driver.findElement(RECTANGLE_ELEMENT)).perform();
    }

    /**
     * Gets alert text after it appears on page.
     *
     * @return the alert text
     */
    public String getAlertText() {
        waitAlertIsPresents(10);
        return driver.switchTo().alert().getText();
    }

    /**
     * Close alert.
     */
    public void closeAlert() {
        driver.switchTo().alert().accept();
    }
}