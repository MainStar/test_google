package test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class FirstTest {

    private static WebDriver driver;

    @BeforeClass
    public static void test(){
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\user\\Desktop\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        driver.get("https://www.google.com/");
    }

    @Test
    public void search(){
        WebElement searchField = driver.findElement(By.id("lst-ib"));
        searchField.sendKeys("java");
        WebElement buttonSearch = driver.findElement(By.name("btnK"));
        buttonSearch.click();
    }

    @AfterClass
    public static void close(){
        String title = driver.getTitle();
        System.out.println(title);
        driver.quit();
    }
}
