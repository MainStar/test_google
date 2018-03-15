package tests.googleTest.interfaces;

import org.openqa.selenium.WebDriver;

public interface GoogleSearchTest {
    void checkStartPage(String pageName, WebDriver driver);
    void searchFor(String text, WebDriver driver);
    void checkSearchPage(String title, WebDriver driver);
    void googleSearchTitlesTest(WebDriver driver);
}
