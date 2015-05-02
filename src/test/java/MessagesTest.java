package test.java;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import main.java.pom.messages.Messages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

	@Test
	public void checkMessagesWorking() {

		driver = new ChromeDriver();
		driver.get("http://client.openreception.org");
		System.out.println("Messages context");
		System.out.println("Page Title is " + driver.getTitle());

		Common.login(driver, LOGIN, password, false);
		HomeView.selectingCompany("BitStackers", driver);
		HomeView.selectingContact("Thomas Løcke", driver);
		Messages.btn_Messages(driver).click();
		MessagesView.checkAgent("Alle", 4, driver);
		MessagesView.checkType("Alle", 4, driver);
		MessagesView.checkCompany("BitStackers", 6, driver);
		MessagesView.checkContact("Alle", 8, driver);
		MessagesView.sendMessage(driver);
		MessagesView.checkDataGrid("Jens Olsen", 4, driver);

		driver.quit();
	}
}
