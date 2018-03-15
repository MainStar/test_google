package tests;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;


public class FirstTest {

    private static WebDriver driver;
    private List<WebElement> webElements = new ArrayList<WebElement>();
    private List<String> urlsList = new ArrayList<String>();

    @BeforeClass
    public static void setUp(){
        System.setProperty("webdriver.gecko.driver", "C:/Users/user/Desktop/geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @AfterClass
    public static void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testGoogleSearch() {
        driver.get("https://www.google.com/");
        Assert.assertEquals("Google", driver.getTitle());
        WebElement searchField = driver.findElement(By.id("lst-ib"));
        searchField.sendKeys("java");
        WebElement buttonSearch = driver.findElement(By.name("btnK"));
        buttonSearch.click();
        Assert.assertEquals("java - Поиск в Google", driver.getTitle());

        /** Ввытаскиваем все ссылки с каждого поиска гугл */
        webElements = (driver.findElements(By.className("iUh30")));

        /** Вытаскиваем все урлы с каждого елемента */
        for (int i = 0; i < webElements.size(); i++){
            urlsList.add(webElements.get(i).getText());
        }

        for (int i = 0; i < urlsList.size(); i++){
            String url = urlsList.get(i);
            driver.get(url);
            System.out.println("\n"+url);
            String title = driver.getTitle();
            System.out.println(title);
            checkAllTitles(title);
        }
    }

    private static void checkAllTitles(String title){

        String [] massTitle;
        massTitle = title.split(" ");
        String checkJavaLetter = null;
        for (int i = 0; i < massTitle.length; i++){
            if (massTitle[i].equals("Java") || massTitle[i].equals("java")){
                Assert.assertEquals("Java", massTitle[i]);
                checkJavaLetter = "true";
            }else {
                Assert.assertNotEquals("Java", massTitle[i]);
            }
        }
        Assert.assertEquals("true", checkJavaLetter);
    }
}
