package test;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class FirstTest {

    private static WebDriver driver;

    @BeforeClass
    public static void connectToBrowser(){
        System.setProperty("webdriver.gecko.driver", "C:/Users/user/Desktop/geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @Test
    public void testGoogleSearch(){
        driver.get("https://www.google.com/");
        Assert.assertEquals("Google", driver.getTitle());
        WebElement searchField = driver.findElement(By.id("lst-ib"));
        searchField.sendKeys("java");
        WebElement buttonSearch = driver.findElement(By.name("btnK"));
        buttonSearch.click();
        Assert.assertEquals("java - Поиск в Google", driver.getTitle());
    }

    @AfterClass
    public static void closeBrowser(){
        if (driver != null) {
            driver.quit();
        }
    }
}
