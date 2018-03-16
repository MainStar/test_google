package tests.googleTest.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverUtils {

    private WebDriver driver;

    public WebDriver getDriver(){
        String browser = System.getProperty("browser.param");
        if (browser.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", "C:/Users/user/Desktop/Downloads/chromedriver.exe");
            driver = new ChromeDriver();
        }else if (browser.equals("firefox")){
            System.setProperty("webdriver.gecko.driver", "C:/Users/user/Desktop/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        //driver.manage().window().maximize();
        return driver;
    }
}