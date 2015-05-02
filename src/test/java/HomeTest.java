package test.java;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import test.java.common.HomeView;

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

	@Test
	public void noOnesCalling() {
		driver = new ChromeDriver();
		driver.get("http://client.openreception.org");
		System.out.println("Noone's calling");

		HomeView.login(driver, LOGIN, password, false);
		HomeView.checkElementsBeforeCall(driver);
		driver.quit();
	}

	@Test
	public void companyPicked() {

		driver = new ChromeDriver();
		driver.get("http://client.openreception.org");
		System.out.println("Company picked");

		HomeView.login(driver, LOGIN, password, false);
		HomeView.selectingCompany("BitStackers", driver);
		driver.quit();
	}

	@Test
	public void checkPeople() {
		System.out.println("Check People");

		HomeView.login(driver, LOGIN, password, false);
		HomeView.selectingCompany("BitStackers", driver);
		HomeView.selectingContact("Trine Løcke", driver);
		driver.quit();
	}

	@Test
	public void checkIfEverythingsPresent() {
		driver = new ChromeDriver();
		driver.get("http://client.openreception.org");
		System.out.println("Check People");
		System.out.println("Page Title is " + driver.getTitle());

		HomeView.login(driver, LOGIN, password, false);
		HomeView.selectingCompany("BitStackers", driver);
		HomeView.selectingContact("Thomas Løcke", driver);
		HomeView.checkCalendar(2, driver);
		HomeView.checkHandling(7, driver);
		HomeView.checkEvents(4, driver);
		HomeView.checkHours(7, driver);
		HomeView.checkSales(5, driver);
		HomeView.checkAddress(4, driver);
		HomeView.checkContactInfo(driver);
		HomeView.sendMessage(driver);

		driver.quit();
	}

	@AfterTest
	public void closing() {
	}

}
