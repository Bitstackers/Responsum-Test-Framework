package test.java;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import main.java.pom.Helpers;
import main.java.pom.Home;
import main.java.pom.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	private static String LOGIN = "walach.anna.or";
	private static boolean FIRST_TIME = false;

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

		// logging
		login();
		checkElementsBeforeCall();
		driver.quit();
	}

	@Test
	public void companyPicked() {

		driver = new ChromeDriver();
		driver.get("http://client.openreception.org");
		System.out.println("Company picked");
		System.out.println("Page Title is " + driver.getTitle());

		// logging
		login();
		selectingCompany("BitStackers");
		driver.quit();
	}

	@AfterTest
	public void closing() {
	}

	private void login() {
		Helpers.wait(driver);
		Login.txt_fd_login(driver).sendKeys(LOGIN);
		Login.txt_fd_password(driver).sendKeys(password);
		Login.btn_signIn(driver).click();
		if (FIRST_TIME) {
			Login.btn_accept(driver).click();
		}
	}

	private void checkElementsBeforeCall() {
		Helpers.wait(driver);
		String welcome = Home.spn_fd_Welcome(driver).getText();
		System.out.println("Welcome text is: " + welcome);
		Assert.assertEquals(welcome, "Ikke i kald");
		// java.lang.AssertionError: expected [] but found [Ikke i kald]
		Helpers.wait(driver);
		String company = Home.spn_Company(driver).getText();
		Assert.assertEquals(company.length(),
				"S?g efter en virksomhed".length());
		Helpers.wait(driver);
		System.out.println("Company name is: " + company);
	}

	private void selectingCompany(String companyName) {
		Helpers.wait(driver);
		Home.spn_Company(driver).click();
		List<WebElement> options = Home.opts_Company(driver);
		System.out.println(options.size());
		for (WebElement opt : options) {
			System.out.println(opt.getText() + " : " + opt.getText().length());
			if (opt.getText().length() == companyName.length()) {
				opt.click();
				break;
			}
		}

		String company = Home.spn_Company(driver).getText();
		System.out.println("Company name is: " + company);
		Assert.assertEquals(company, companyName);
		Helpers.wait(driver);
		String welcome = Home.spn_fd_Welcome(driver).getText();
		System.out.println("Welcome text is: " + welcome);
		Assert.assertEquals(welcome,
				"Velkommen til BitStackers, hvad kan jeg hjælpe med?");
	}
}
