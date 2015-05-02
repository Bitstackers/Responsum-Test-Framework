package test.java;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import main.java.pom.homeplus.HomePlus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import test.java.common.HomePlusView;
import test.java.common.HomeView;

public class HomePlusTest {
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
		System.out.println("Page Title is " + driver.getTitle());

		HomeView.login(driver, LOGIN, password, false);
		driver.quit();
	}

	@AfterTest
	public void closing() {
	}

	@Test
	public void checkHomePlusDisplaying() {

		driver = new ChromeDriver();
		driver.get("http://client.openreception.org");
		System.out.println("Company picked");
		System.out.println("Page Title is " + driver.getTitle());

		HomeView.login(driver, LOGIN, password, false);
		HomeView.selectingCompany("BitStackers", driver);
		HomeView.selectingContact("Thomas Løcke", driver);
		HomePlus.btn_HomePlus(driver).click();
		HomePlusView.checkBanks(5, driver);
		HomePlusView.checkCVRs(5, driver);
		HomePlusView.checkEmails(6, driver);
		HomePlusView.checkNames(5, driver);
		HomePlusView.checkNumbers(2, driver);
		HomePlusView.checkWebsites(7, driver);
		driver.quit();
	}

}
