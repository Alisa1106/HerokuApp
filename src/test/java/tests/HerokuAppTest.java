package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HerokuAppTest {

    @Test
    public void addAndRemoveElementsTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        WebElement addElementButton = driver.findElement(By.xpath("//*[@onclick='addElement()']"));
        addElementButton.click();
        addElementButton.click();
        driver.findElement(By.xpath("//*[@onclick='deleteElement()']")).click();
        List<WebElement> deleteElementsButton = driver.findElements(By.xpath("//*[@onclick='deleteElement()']"));
        Assert.assertEquals(deleteElementsButton.size(), 1);
        driver.quit();
    }

    @Test
    public void CheckboxesElementsTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        List<WebElement> checkboxesElements = driver.findElements(By.cssSelector("[type=checkbox]"));
        Assert.assertFalse(checkboxesElements.get(0).isSelected());
        checkboxesElements.get(0).click();
        Assert.assertTrue(checkboxesElements.get(0).isSelected());
        Assert.assertTrue(checkboxesElements.get(1).isSelected());
        checkboxesElements.get(1).click();
        Assert.assertFalse(checkboxesElements.get(1).isSelected());
        driver.quit();
    }

    @Test
    public void dropdownTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/dropdown");
        Select select = new Select(driver.findElement(By.id("dropdown")));
        select.selectByVisibleText("Option 1");
        String firstSelectText = select.getFirstSelectedOption().getText();
        Assert.assertEquals(firstSelectText, "Option 1");
        select.selectByVisibleText("Option 2");
        String secondSelectText = select.getFirstSelectedOption().getText();
        Assert.assertEquals(secondSelectText, "Option 2");
        driver.quit();
    }

    @Test
    public void inputsFieldByNumbersTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/inputs");
        WebElement inputField = driver.findElement(By.tagName("input"));
        inputField.sendKeys("100");
        String actualText = inputField.getAttribute("value");
        Assert.assertEquals(actualText, "100");
        inputField.sendKeys(Keys.ARROW_UP);
        actualText = inputField.getAttribute("value");
        Assert.assertEquals(actualText, "101");
        inputField.sendKeys(Keys.ARROW_DOWN);
        actualText = inputField.getAttribute("value");
        Assert.assertEquals(actualText, "100");
        driver.quit();
    }

    @Test
    public void inputsFieldByTextTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/inputs");
        WebElement inputField = driver.findElement(By.tagName("input"));
        inputField.sendKeys("Hello");
        String actualText = inputField.getAttribute("value");
        Assert.assertEquals(actualText, "");
        inputField.sendKeys(Keys.ARROW_UP);
        actualText = inputField.getAttribute("value");
        Assert.assertEquals(actualText, "1");
        inputField.sendKeys(Keys.ARROW_DOWN);
        actualText = inputField.getAttribute("value");
        Assert.assertEquals(actualText, "0");
        driver.quit();
    }

    @Test
    public void sortableDataTableTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/tables");
        String actualText = driver.findElement(By.xpath("//*[@id='table1']//tr[1]//td[1]")).getText();
        Assert.assertEquals(actualText, "Smith");
        actualText = driver.findElement(By.xpath("//*[@id='table1']//tr[1]//td[4]")).getText();
        Assert.assertEquals(actualText, "$50.00");
        actualText = driver.findElement(By.xpath("//*[@id='table1']//tr[4]//td[6]")).getText();
        Assert.assertEquals(actualText, "edit delete");
        actualText = driver.findElement(By.xpath("//*[@id='table2']//tr[2]//td[1]")).getText();
        Assert.assertEquals(actualText, "Bach");
        actualText = driver.findElement(By.xpath("//*[@id='table2']//tr[2]//td[3]")).getText();
        Assert.assertEquals(actualText, "fbach@yahoo.com");
        actualText = driver.findElement(By.xpath("//*[@id='table2']//tr[4]//td[5]")).getText();
        Assert.assertEquals(actualText, "http://www.timconway.com");
        driver.quit();
    }

    @Test
    public void typosTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/typos");
        List<WebElement> strings = driver.findElements(By.tagName("p"));
        String actualText = strings.get(0).getText();
        Assert.assertEquals(actualText, "This example demonstrates a typo being introduced. " +
                "It does it randomly on each page load.");
        actualText = strings.get(1).getText();
        Assert.assertEquals(actualText, "Sometimes you'll see a typo, other times you won't.");
        driver.quit();
    }

    @Test
    public void hoversFirstUserTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/hovers");
        Actions action = new Actions(driver);
        List<WebElement> avatarsPhotos = driver.findElements(By.xpath("//img[@src='/img/avatar-blank.jpg']"));
        WebElement firstUserName = driver.findElement(By.cssSelector(":nth-child(3) h5"));
        action.moveToElement(avatarsPhotos.get(0)).moveToElement(firstUserName).build().perform();
        String actualText = firstUserName.getText();
        Assert.assertEquals(actualText, "name: user1");
        driver.findElement(By.xpath("//*[@href='/users/1']")).click();
        actualText = driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(actualText, "Not Found");
        driver.quit();
    }

    @Test
    public void hoversSecondUserTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/hovers");
        Actions action = new Actions(driver);
        List<WebElement> avatarsPhotos = driver.findElements(By.xpath("//img[@src='/img/avatar-blank.jpg']"));
        WebElement secondUserName = driver.findElement(By.cssSelector(":nth-child(4) h5"));
        action.moveToElement(avatarsPhotos.get(1)).moveToElement(secondUserName).build().perform();
        String actualText = secondUserName.getText();
        Assert.assertEquals(actualText, "name: user2");
        driver.findElement(By.xpath("//*[@href='/users/2']")).click();
        actualText = driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(actualText, "Not Found");
        driver.quit();
    }

    @Test
    public void hoversThirdUserTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/hovers");
        Actions action = new Actions(driver);
        List<WebElement> avatarsPhotos = driver.findElements(By.xpath("//img[@src='/img/avatar-blank.jpg']"));
        WebElement thirdUserName = driver.findElement(By.cssSelector(":nth-child(5) h5"));
        action.moveToElement(avatarsPhotos.get(2)).moveToElement(thirdUserName).build().perform();
        String actualText = thirdUserName.getText();
        Assert.assertEquals(actualText, "name: user3");
        driver.findElement(By.xpath("//*[@href='/users/3']")).click();
        actualText = driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(actualText, "Not Found");
        driver.quit();
    }
}
