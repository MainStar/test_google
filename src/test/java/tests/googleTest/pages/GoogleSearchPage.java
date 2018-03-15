package tests.googleTest.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class GoogleSearchPage {

    private List<WebElement> webElements = new ArrayList<WebElement>();
    private List<String> titleList = new ArrayList<String>();

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
        for (int i = 0; i < titleMass.length; i++){
            if (titleMass[i].equals("Java") || titleMass[i].equals("java")){
                Assert.assertEquals("Java", titleMass[i]);
            }else {
                Assert.assertNotEquals("Java", titleMass[i]);
            }
        }
    }
}
