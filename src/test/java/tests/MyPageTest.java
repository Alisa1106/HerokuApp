package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MyPageTest {

    @Test
    public void searchDataInTableTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("G:/TMS/ДЗ_ТЕСТ/HerokuApp/src/test/resources/hometask7.html");
        String actualText = driver.findElement(By.xpath("//*[@class='table']//tr[2]/td[1]")).getText();
        Assert.assertEquals(actualText, "One-time visit");
        actualText = driver.findElement(By.xpath("//*[@class='table']//tr[4]/td[2]")).getText();
        Assert.assertEquals(actualText, "30.00");
        driver.quit();
    }

    @Test
    public void allRegistrationFieldsFillTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("G:/TMS/ДЗ_ТЕСТ/HerokuApp/src/test/resources/hometask7.html");
        WebElement userName = driver.findElement(By.xpath("//*[@id='first_name']"));
        userName.sendKeys("User");
        String actualText = userName.getAttribute("value");
        Assert.assertEquals(actualText, "User");
        WebElement email = driver.findElement(By.xpath("//*[@id='email']"));
        email.sendKeys("user@mail.ru");
        actualText = email.getAttribute("value");
        Assert.assertEquals(actualText, "user@mail.ru");
        WebElement password = driver.findElement(By.xpath("//*[@id='password']"));
        password.sendKeys("111111");
        actualText = password.getAttribute("value");
        Assert.assertEquals(actualText, "111111");
        WebElement confirmPassword = driver.findElement(By.xpath("//*[@id='confirm']"));
        confirmPassword.sendKeys("111111");
        actualText = confirmPassword.getAttribute("value");
        Assert.assertEquals(actualText, "111111");
        driver.quit();
    }

    @Test
    public void genderChoiceButtonsTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("G:/TMS/ДЗ_ТЕСТ/HerokuApp/src/test/resources/hometask7.html");
        List<WebElement> choiceButtonsElements = driver.findElements(By.xpath("//*[@type='radio']"));
        Assert.assertFalse(choiceButtonsElements.get(0).isSelected());
        choiceButtonsElements.get(0).click();
        Assert.assertTrue(choiceButtonsElements.get(0).isSelected());
        Assert.assertFalse(choiceButtonsElements.get(1).isSelected());
        choiceButtonsElements.get(1).click();
        Assert.assertTrue(choiceButtonsElements.get(1).isSelected());
        Assert.assertFalse(choiceButtonsElements.get(0).isSelected());
        driver.quit();
    }

    @Test
    public void checkboxTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("G:/TMS/ДЗ_ТЕСТ/HerokuApp/src/test/resources/hometask7.html");
        WebElement checkbox = driver.findElement(By.xpath("//*[@id='agree']"));
        checkbox.click();
        Assert.assertTrue(checkbox.isSelected());
        checkbox.click();
        Assert.assertFalse(checkbox.isSelected());
        driver.quit();
    }

    @Test
    public void languageSelectTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("G:/TMS/ДЗ_ТЕСТ/HerokuApp/src/test/resources/hometask7.html");
        Select select = new Select(driver.findElement(By.xpath("//*[@id='languages']")));
        select.selectByVisibleText("English");
        String firstSelectText = select.getFirstSelectedOption().getText();
        Assert.assertEquals(firstSelectText, "English");
        select.selectByVisibleText("German");
        String secondSelectText = select.getFirstSelectedOption().getText();
        Assert.assertEquals(secondSelectText, "German");
        driver.quit();
    }

    @Test
    public void sendButtonEnabledTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("G:/TMS/ДЗ_ТЕСТ/HerokuApp/src/test/resources/hometask7.html");
        WebElement sendButton = driver.findElement(By.xpath("//*[@class='button1']"));
        Assert.assertTrue(sendButton.isEnabled());
        driver.quit();
    }

    @Test
    public void imageIsDisplayedTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("G:/TMS/ДЗ_ТЕСТ/HerokuApp/src/test/resources/hometask7.html");
        WebElement image = driver.findElement(By.xpath("//*[@alt='Gym']"));
        Assert.assertTrue(image.isDisplayed());
        driver.quit();
    }

    @Test
    public void checkParagraphsTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("G:/TMS/ДЗ_ТЕСТ/HerokuApp/src/test/resources/hometask7.html");
        List<WebElement> textFields = driver.findElements(By.xpath("//p"));
        String actualText = textFields.get(4).getText();
        Assert.assertEquals(actualText, "Everyday from 9 a.m. to 9 p.m.");
        driver.quit();
    }

    @Test
    public void checkLinkTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("G:/TMS/ДЗ_ТЕСТ/HerokuApp/src/test/resources/hometask7.html");
        driver.findElement(By.xpath("//*[@href='http://www.brest-hockey.by/fitnes.php']")).click();
        String newPage = driver.getCurrentUrl();
        Assert.assertEquals(newPage, "http://www.brest-hockey.by/fitnes.php");
        driver.quit();
    }
}
