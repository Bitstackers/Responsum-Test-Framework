package test.java;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import main.java.pom.Helpers;
import main.java.pom.Login;

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
	String password;

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
	public void firstTest() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("http://client.openreception.org");
		System.out.println("Page Title is " + driver.getTitle());

		// logging
		Helpers.wait(driver);
		Login.txt_fd_login(driver).sendKeys("walach.anna.or");
		Login.txt_fd_password(driver).sendKeys(password);
		Login.btn_signIn(driver).click();

		Assert.assertEquals(true, true);
		driver.quit();
	}

	// @Test
	public void secondTest() {
		driver = new ChromeDriver();
		driver.get("http://client.openreception.org");
		System.out.println("Page Title is " + driver.getCurrentUrl());
		Assert.assertEquals("Google", driver.getTitle());
		driver.quit();
	}

	@AfterTest
	public void closing() {
	}
}
