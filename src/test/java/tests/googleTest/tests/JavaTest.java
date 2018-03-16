package tests.googleTest.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.googleTest.utils.WebDriverUtils;
import tests.googleTest.pages.GoogleMainPage;
import tests.googleTest.pages.GoogleSearchPage;

import java.util.ArrayList;
import java.util.List;

public class JavaTest extends WebDriverUtils {

    WebDriver driver;

    private WebElement search;
    private WebElement googleSearchButton;
    private List<WebElement> webElements;
    private List<String> urls = new ArrayList<String>();

    @BeforeClass
    public void setDriver(){
        driver = getDriver();
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
        Assert.assertEquals(driver.getTitle(), "java - Поиск в Google", "java - Поиск в Google");


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

    @AfterClass
    public void shutdown(){
        driver.quit();
    }
}
