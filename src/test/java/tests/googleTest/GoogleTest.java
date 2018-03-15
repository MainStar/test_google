package tests.googleTest;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import tests.googleTest.pages.GoogleMainPageImpl;
import tests.googleTest.pages.GoogleSearchPageImpl;

public class GoogleTest {

    public void googleTest() {
        System.setProperty("webdriver.gecko.driver", "C:/Users/user/Desktop/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.google.com/");

        GoogleMainPageImpl page = PageFactory.initElements(driver, GoogleMainPageImpl.class);
        GoogleSearchPageImpl searchPage = PageFactory.initElements(driver, GoogleSearchPageImpl.class);
        page.checkStartPage("Google", driver);
        page.searchFor("Java", driver);
        searchPage.checkSearchPage(driver.getTitle(), driver);
        searchPage.googleSearchTitlesTest(driver);

        driver.quit();
    }
}
