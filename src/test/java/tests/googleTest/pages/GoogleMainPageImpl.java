package tests.googleTest.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleMainPageImpl {

    private WebElement search;
    private WebElement googleSearchButton;

    public void checkStartPage(String pageName, WebDriver driver){
        Assert.assertEquals(pageName, driver.getTitle());
    }

    public void searchFor(String text, WebDriver driver){
        search = driver.findElement(By.id("lst-ib"));
        googleSearchButton = driver.findElement(By.name("btnK"));
        search.sendKeys(text);
        googleSearchButton.click();
    }
}
