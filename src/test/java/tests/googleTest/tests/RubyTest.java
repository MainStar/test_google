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

public class RubyTest extends WebDriverUtils {

    WebDriver driver;
    List<WebElement> webElements = new ArrayList<WebElement>();
    List<String> urls = new ArrayList<String>();

    @BeforeClass
    public void setDriver(){
        driver = getDriver();
    }

    @Test
    public void googleSearch(){
        GoogleMainPage mainPage = PageFactory.initElements(driver, GoogleMainPage.class);
        driver.get("https://www.google.com/");
        Assert.assertEquals("Google", driver.getTitle());
        mainPage.typeToSearch(driver, "Ruby");
        mainPage.clickButtonSearch(driver);
    }

    @Test
    public void resultSearchTest(){
        GoogleSearchPage searchPage = PageFactory.initElements(driver, GoogleSearchPage.class);

        Assert.assertEquals("Ruby - Поиск в Google", driver.getTitle());
        String url = "http://www.";

        webElements = searchPage.googleSearchTitlesTest(driver);
        for (int i = 0; i < webElements.size(); i++){
            System.out.println(webElements.get(i).getText());
            if (webElements.get(i).getText().equals("rusrails.ru/")) {
                url += webElements.get(i).getText();
                urls.add(url);
            }else {
                urls.add(webElements.get(i).getText());
            }
        }
        for (int i = 0; i < urls.size(); i++){
            driver.get(urls.get(i));
            checkTitle(driver.getTitle());
        }
    }

    private void checkTitle(String title){
        String [] titleMass = title.split(" ");
        for (int i = 0; i < titleMass.length; i++){
            if (titleMass[i].equals("Ruby") || titleMass[i].equals("ruby")){
                org.junit.Assert.assertEquals("Ruby", titleMass[i]);
            }else {
                org.junit.Assert.assertNotEquals("Ruby", titleMass[i]);
            }
        }
    }

    @AfterClass
    public void shutDown(){
        driver.quit();
    }
}
