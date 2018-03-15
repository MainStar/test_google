package tests.googleTest;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import tests.googleTest.Impl.GoogleSearchTestImpl;

public class GoogleTest {

    public void googleTest() {
        System.setProperty("webdriver.gecko.driver", "C:/Users/user/Desktop/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.google.com/");

        GoogleSearchTestImpl page = PageFactory.initElements(driver, GoogleSearchTestImpl.class);
        page.checkStartPage("Google", driver);
        page.searchFor("Java", driver);
        page.checkSearchPage(driver.getTitle(), driver);
        page.googleSearchTitlesTest(driver);

        driver.quit();
    }
}
