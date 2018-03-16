package tests.googleTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleMainPage {

    public void typeToSearch(WebDriver driver, String textSearch){
        driver.findElement(By.id("lst-ib")).sendKeys(textSearch);
    }

    public void clickButtonSearch(WebDriver driver){
        driver.findElement(By.name("btnK")).click();
    }
}
