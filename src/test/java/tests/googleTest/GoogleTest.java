package tests.googleTest;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import tests.googleTest.pages.GoogleMainPage;
import tests.googleTest.pages.GoogleSearchPage;

public class GoogleTest {

    public void googleTest() {
        System.setProperty("webdriver.gecko.driver", "C:/Users/user/Desktop/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.google.com/");

        GoogleMainPage page = PageFactory.initElements(driver, GoogleMainPage.class);
        GoogleSearchPage searchPage = PageFactory.initElements(driver, GoogleSearchPage.class);
        page.checkStartPage("Google", driver);
        page.searchFor("Java", driver);
        searchPage.checkSearchPage(driver.getTitle(), driver);
        searchPage.googleSearchTitlesTest(driver);

        driver.quit();
    }
}
