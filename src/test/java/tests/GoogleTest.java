package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import tests.googleTest.pages.GoogleMainPage;
import tests.googleTest.pages.GoogleSearchPage;

import java.util.ArrayList;
import java.util.List;

public class GoogleTest {

    private WebDriver driver;

    private WebElement search;
    private WebElement googleSearchButton;
    private List<WebElement> webElements;
    private List<String> urls = new ArrayList<String>();

    @BeforeTest
    public WebDriver setUp(){
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

    @Test
    public void googleSearch(){
        GoogleMainPage page = PageFactory.initElements(driver, GoogleMainPage.class);
        driver.get("https://www.google.com/");
        Assert.assertEquals("Google", driver.getTitle());

        page.typeToSearch(driver, "java");
        page.clickButtonSearch(driver);
    }

    @Test
    public void resultSearchTest(){
        GoogleSearchPage searchPage = PageFactory.initElements(driver, GoogleSearchPage.class);

        //Assert.assertEquals("java - Поиск в Google", driver.getTitle());

        webElements = searchPage.googleSearchTitlesTest(driver);
        for (int i = 0; i < webElements.size(); i++){
            System.out.println(webElements.get(i).getText());
            urls.add(webElements.get(i).getText());
        }
        for (int i = 0; i < urls.size(); i++){
            driver.get(urls.get(i));
            checkTitle(driver.getTitle());
        }
    }

    @AfterTest
    public void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }

    private void checkTitle(String title){
        String [] titleMass = title.split(" ");
        for (int i = 0; i < titleMass.length; i++){
            if (titleMass[i].equals("Java") || titleMass[i].equals("java")){
                org.junit.Assert.assertEquals("Java", titleMass[i]);
            }else {
                org.junit.Assert.assertNotEquals("Java", titleMass[i]);
            }
        }
    }
}
