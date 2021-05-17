package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract class BasePage {
    WebDriver driver;
    WebDriverWait wait;

    BasePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Wait for element located.
     *
     * @param element the element
     * @param timeout the timeout
     */
    public void waitForElementLocated(By element, int timeout) {
        wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    /**
     * Wait alert is presents.
     *
     * @param timeout the timeout
     */
    public void waitAlertIsPresents(int timeout) {
        wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.alertIsPresent());
    }

    /**
     * Wait text to be.
     *
     * @param element the element
     * @param timeout the timeout
     * @param string  the string
     */
    public void waitTextToBe(By element, int timeout, String string) {
        wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.textToBe(element, string));
    }
}