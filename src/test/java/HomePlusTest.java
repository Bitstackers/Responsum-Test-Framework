package test.java;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import main.java.pom.Helpers;
import main.java.pom.Login;
import main.java.pom.home.CompanyInfo;
import main.java.pom.home.Contacts;
import main.java.pom.home.Home;
import main.java.pom.home.Message;
import main.java.pom.homeplus.HomePlus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePlusTest {
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

		login();
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

	@Test
	public void checkHomePlusDisplaying() {

		driver = new ChromeDriver();
		driver.get("http://client.openreception.org");
		System.out.println("Company picked");
		System.out.println("Page Title is " + driver.getTitle());

		login();
		selectingCompany("BitStackers");
		selectingContact("Thomas Løcke");
		HomePlus.btn_HomePlus(driver).click();
		checkBanks(5);
		checkCVRs(5);
		checkEmails(6);
		checkNames(5);
		checkNumbers(2);
		checkWebsites(7);
		driver.quit();
	}

	private void selectingCompany(String companyName) {
		Helpers.wait(driver);
		CompanyInfo.label_Company(driver).click();
		List<WebElement> options = CompanyInfo.opts_Company(driver);
		System.out.println(options.size());
		for (WebElement opt : options) {
			System.out.println(opt.getText() + " : " + opt.getText().length());
			if (opt.getText().equals(companyName)) {
				opt.click();
				break;
			}
		}

		String company = CompanyInfo.label_Company(driver).getText();
		System.out.println("Company name is: " + company);
		Assert.assertEquals(company, companyName);
		Helpers.wait(driver);
		String welcome = Home.label_Welcome(driver).getText();
		System.out.println("Welcome text is: " + welcome);
		Assert.assertEquals(welcome,
				"Velkommen til BitStackers, hvad kan jeg hjælpe med?");
	}

	private void selectingContact(String contactName) {
		Assert.assertEquals(Contacts.opts_Contact(driver).size(), 7);
		Contacts.txt_fd_SearchContact(driver).sendKeys(contactName);
		// Home.txt_fd_SearchContact(driver).sendKeys(Keys.ARROW_DOWN);
		System.out.println("Recipient: "
				+ Message.spn_RecipientTo(driver).getText());
		Assert.assertEquals(Message.spn_RecipientTo(driver).getText(),
				contactName);

	}

	private void checkEmails(int entries) {
		System.out.println("Emails entries: "
				+ HomePlus.opts_Emails(driver).size());
		Assert.assertEquals(HomePlus.opts_Emails(driver).size(), entries);

	}

	private void checkNames(int entries) {
		System.out.println("Names entries: "
				+ HomePlus.opts_AltNames(driver).size());
		Assert.assertEquals(HomePlus.opts_AltNames(driver).size(), entries);

	}

	private void checkWebsites(int entries) {
		System.out.println("Websites entries: "
				+ HomePlus.opts_Websites(driver).size());
		Assert.assertEquals(HomePlus.opts_Websites(driver).size(), entries);

	}

	private void checkNumbers(int entries) {
		System.out.println("Numbers entries: "
				+ HomePlus.opts_TelNumbers(driver).size());
		Assert.assertEquals(HomePlus.opts_TelNumbers(driver).size(), entries);

	}

	private void checkBanks(int entries) {
		System.out.println("Banks entries: "
				+ HomePlus.opts_BankInfo(driver).size());
		Assert.assertEquals(HomePlus.opts_BankInfo(driver).size(), entries);

	}

	private void checkCVRs(int entries) {
		System.out.println("CVRs entries: "
				+ HomePlus.opts_CVRNumbers(driver).size());
		Assert.assertEquals(HomePlus.opts_CVRNumbers(driver).size(), entries);

	}
}
