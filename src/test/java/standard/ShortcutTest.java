package test.java.standard;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import main.java.pom.Helpers;
import main.java.pom.home.Home;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import test.java.views.Common;

public class ShortcutTest {
	WebDriver driver;
	String password;
	private static String LOGIN = "walach.anna.or";

	// private static final Logger logger =
	// LogManager.getLogger(HomePlusTest.class);

	@BeforeTest
	public void prepare() throws IOException {
		System.setProperty("webdriver.chrome.driver",
				"src/main/resources/chromedriver.exe");
		for (String line : Files.readAllLines(
				Paths.get("src/main/resources/.secret"),
				Charset.defaultCharset())) {
			password = line;
		}
	}

	@BeforeMethod
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://client.openreception.org");
		Common.login(driver, LOGIN, password, false);

	}

	@AfterMethod
	public void tearDown() {

		Helpers.waiting(2000);
		driver.quit();
	}

	@Test
	public void izShortcutWorking() {
		System.out.println("***Shortcut testing***");
		Helpers.waiting(1000);

		System.out.println("Testing key" + Keys.ADD);
		Home.Root(driver).sendKeys(Keys.ADD);
		Helpers.waiting(500);

		System.out.println("Testing key" + Keys.MULTIPLY);
		Home.Root(driver).sendKeys(Keys.MULTIPLY);
		Helpers.waiting(500);

		System.out.println("Testing key" + Keys.SUBTRACT);
		Home.Root(driver).sendKeys(Keys.SUBTRACT);
		Helpers.waiting(500);

		System.out.println("Testing key" + Keys.DIVIDE);
		Home.Root(driver).sendKeys(Keys.DIVIDE);
	}

}
