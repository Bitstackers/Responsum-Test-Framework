package test.java.standard;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import main.java.pom.Helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import test.java.views.Common;
import test.java.views.HomePlusView;
import test.java.views.HomeView;
import test.java.views.ShortcutsView;

public class HomePlusTest {
	WebDriver driver;
	String password;
	private static String LOGIN = "walach.anna.or";

	// private static final Logger logger =
	// LogManager.getLogger(HomePlusTest.class);

	@BeforeTest
	public void prepare() throws IOException {
		for (String line : Files.readAllLines(
				Paths.get("src/main/resources/.secret"),
				Charset.defaultCharset())) {
			password = line;
		}
	}

	@AfterTest
	public void closing() {
	}

	@Test
	public void checkHomePlusDisplaying() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://client.openreception.org");
		System.out.println("***Home plus checking***");
		System.out.println("Page Title is " + driver.getTitle());

		Common.login(driver, LOGIN, password, false);
		HomeView.selectingCompany("BitStackers", driver);
		HomeView.selectingContact("Thomas Løcke", driver);
		ShortcutsView.switchToHomePlusContext(driver);
		HomePlusView.checkBanks(5, driver);
		HomePlusView.checkCVRs(5, driver);
		HomePlusView.checkEmails(6, driver);
		HomePlusView.checkNames(5, driver);
		HomePlusView.checkNumbers(2, driver);
		HomePlusView.checkWebsites(7, driver);
		ShortcutsView.switchToHomeContext(driver);
		Helpers.waiting(2000);
		driver.quit();
	}

}
