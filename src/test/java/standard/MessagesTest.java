package test.java.standard;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import main.java.pom.Helpers;
import main.java.pom.messages.Messages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import test.java.views.Common;
import test.java.views.HomeView;
import test.java.views.MessagesView;

public class MessagesTest {
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
	public void checkMessagesWorking() {

		System.out.println("***Messages context***");

		HomeView.selectingCompany("BitStackers", driver);
		HomeView.selectingContact("Thomas Løcke", driver);
		Messages.btn_Messages(driver).click();
		MessagesView.checkAgent("Alle", 4, driver);
		MessagesView.checkType("Alle", 4, driver);
		MessagesView.checkCompany("BitStackers", 6, driver);
		MessagesView.checkContact("Alle", 8, driver);
		MessagesView.sendMessage(driver);
		MessagesView.checkDataGrid("Jens Olsen", 4, driver);

	}
}
