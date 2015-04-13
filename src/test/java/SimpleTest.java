import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by Anna on 2015-04-13.
 */
public class SimpleTest {

    WebDriver driver;

    @BeforeTest
    public void prepare() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

    }
    @Test
    public void firstTest() {
        driver = new ChromeDriver();
        driver.get("http://www.google.com");
        System.out.println("Page Title is " + driver.getTitle());
        Assert.assertEquals("Google", driver.getTitle());
        driver.quit();
    }

    @Test
    public void secondTest() {
        driver = new ChromeDriver();
        driver.get("http://www.google.com");
        System.out.println("Page Title is " + driver.getCurrentUrl());
        Assert.assertEquals("Google", driver.getTitle());
        driver.quit();
    }

    @AfterTest
    public void closing() {
    }
}
