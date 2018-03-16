package tests.googleTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class GoogleSearchPage {

    private List<WebElement> webElements = new ArrayList<WebElement>();

    public List<WebElement> googleSearchTitlesTest(WebDriver driver){
        return webElements = driver.findElements(By.className("iUh30"));
    }
}
