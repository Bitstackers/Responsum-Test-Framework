package test.java.standard;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import main.java.pom.Helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import test.java.views.Common;
import test.java.views.HomeView;

/**
 * Created by Anna on 2015-04-13.
 */
public class HomeTest {

	WebDriver driver;
	String password;
	private static String LOGIN = "walach.anna.or";

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
	public void noOnesCalling() {

		System.out.println("***Noone's calling***");

		HomeView.checkElementsBeforeCall(driver);

	}

	@Test
	public void companyPicked() {

		System.out.println("***Company picked***");

		HomeView.selectingCompany("BitStackers", driver);
	}

	@Test
	public void checkPeople() {
		System.out.println("***Check People***");

		HomeView.selectingCompany("BitStackers", driver);
		HomeView.selectingContact("Trine Løcke", driver);
	}

	@Test
	public void checkIfEverythingsPresent() {
		System.out.println("***Presence checking***");

		HomeView.selectingCompany("BitStackers", driver);
		HomeView.selectingContact("Thomas Løcke", driver);
		HomeView.checkCalendar(1, driver);
		HomeView.checkHandling(7, driver);
		HomeView.checkContactEvents(4, driver);
		HomeView.checkHours(7, driver);
		HomeView.checkSales(5, driver);
		HomeView.checkContactInfo(driver);
		HomeView.sendMessage(driver);

	}

}
