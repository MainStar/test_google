package tests.googleTest.Impl;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import tests.googleTest.interfaces.GoogleSearchTest;

import java.util.ArrayList;
import java.util.List;

public class GoogleSearchTestImpl implements GoogleSearchTest {

    private List<WebElement> webElements = new ArrayList<WebElement>();
    private List<String> titleList = new ArrayList<String>();

    private WebElement search;
    private WebElement googleSearchButton;

    public void checkPage(String pageName, WebDriver driver){
        Assert.assertEquals(pageName, driver.getTitle());
    }

    public void searchFor(String text, WebDriver driver){
        search = driver.findElement(By.id("lst-ib"));
        googleSearchButton = driver.findElement(By.name("btnK"));
        search.sendKeys(text);
        googleSearchButton.click();
    }

    public void checkSearchPage(String title, WebDriver driver){
        Assert.assertEquals(title, driver.getTitle());
    }

    public void googleSearchTitlesTest(WebDriver driver){
        webElements = driver.findElements(By.className("iUh30"));
        for (int i = 0; i < webElements.size(); i++){
            titleList.add(webElements.get(i).getText());
        }
        for (int i = 0; i < titleList.size(); i++){
            driver.get(titleList.get(i));
            checkTitle(driver.getTitle());
        }
    }

    private void checkTitle(String title){
        String [] titleMass = title.split(" ");
        String checkJavaLetter = "false";
        for (int i = 0; i < titleMass.length; i++){
            if (titleMass[i].equals("Java") || titleMass[i].equals("java")){
                Assert.assertEquals("Java", titleMass[i]);
                checkJavaLetter = "true";
            }else {
                Assert.assertNotEquals("Java", titleMass[i]);
            }
        }
        Assert.assertEquals("true", checkJavaLetter);
    }
}
