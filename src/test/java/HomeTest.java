package test.java;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import main.java.pom.Helpers;
import main.java.pom.Login;
import main.java.pom.home.CompanyInfo;
import main.java.pom.home.ContactInfo;
import main.java.pom.home.Contacts;
import main.java.pom.home.Home;
import main.java.pom.home.Message;

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
public class HomeTest {

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
		checkElementsBeforeCall();
		driver.quit();
	}

	@Test
	public void companyPicked() {

		driver = new ChromeDriver();
		driver.get("http://client.openreception.org");
		System.out.println("Company picked");
		System.out.println("Page Title is " + driver.getTitle());

		login();
		selectingCompany("BitStackers");
		driver.quit();
	}

	@Test
	public void checkPeople() {
		driver = new ChromeDriver();
		driver.get("http://client.openreception.org");
		System.out.println("Check People");
		System.out.println("Page Title is " + driver.getTitle());

		login();
		selectingCompany("BitStackers");
		selectingContact("Trine Løcke");
		driver.quit();
	}

	@Test
	public void checkIfEverythingsPresent() {
		driver = new ChromeDriver();
		driver.get("http://client.openreception.org");
		System.out.println("Check People");
		System.out.println("Page Title is " + driver.getTitle());

		login();
		selectingCompany("BitStackers");
		selectingContact("Thomas Løcke");
		checkCalendar(2);
		checkHandling(7);
		checkEvents(4);
		checkHours(7);
		checkSales(5);
		checkAddress(4);
		checkContactInfo();
		sendMessage();

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
		String welcome = Home.label_Welcome(driver).getText();
		System.out.println("Welcome text is: " + welcome);
		Assert.assertEquals(welcome, "Ikke i kald");
		// java.lang.AssertionError: expected [] but found [Ikke i kald]
		Helpers.wait(driver);
		String company = CompanyInfo.label_Company(driver).getText();
		Assert.assertEquals(company, "Søg efter en virksomhed");
		Helpers.wait(driver);
		System.out.println("Company name is: " + company);
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

	private void checkCalendar(int entries) {
		System.out.println("Calendar entries: "
				+ CompanyInfo.opts_Calendar(driver).size());
		Assert.assertEquals(CompanyInfo.opts_Calendar(driver).size(), entries);

	}

	private void checkHandling(int entries) {
		System.out.println("Handling entries: "
				+ CompanyInfo.opts_Handling(driver).size());
		Assert.assertEquals(CompanyInfo.opts_Handling(driver).size(), entries);
	}

	private void checkEvents(int entries) {
		System.out.println("Event entries: "
				+ Contacts.opts_Events(driver).size());
		Assert.assertEquals(Contacts.opts_Events(driver).size(), entries);
	}

	private void checkHours(int i) {
		System.out.println("Hours entries: " + Home.opts_Hours(driver).size());
		Assert.assertEquals(Home.opts_Hours(driver).size(), i);
	}

	private void checkSales(int i) {
		System.out.println("Sales entries: " + Home.opts_Sales(driver).size());
		Assert.assertEquals(Home.opts_Sales(driver).size(), i);
	}

	private void checkAddress(int i) {
		System.out.println("Address entries: "
				+ Home.opts_Address(driver).size());
		Assert.assertEquals(Home.opts_Address(driver).size(), i);
	}

	private void checkContactInfo() {
		Assert.assertEquals(ContactInfo.label_Department(driver).getText(),
				"Development");
		Assert.assertEquals(ContactInfo.label_AdditionalInfo(driver).getText(),
				"Yolk forfatter");
		Assert.assertEquals(ContactInfo.label_Position(driver).getText(),
				"Softwareudvikler");
		Assert.assertEquals(ContactInfo.label_Relations(driver).getText(),
				"Gift med Trine Løcke");
		Assert.assertEquals(ContactInfo.label_Responsibility(driver).getText(),
				"Server og klient udvikling");
		Assert.assertEquals(ContactInfo.opts_Backup(driver).size(), 2);
		Assert.assertEquals(ContactInfo.opts_Emails(driver).size(), 1);
		Assert.assertEquals(ContactInfo.opts_Workhours(driver).size(), 2);
		Assert.assertEquals(ContactInfo.opts_Handling(driver).size(), 1);
		Assert.assertEquals(ContactInfo.btn_Phone(driver).getText(), "60431992");
		System.out.println("Contact info confirmed.");

	}

	private void sendMessage() {
		Message.txt_fd_Body(driver).sendKeys("This is body");
		Message.txt_fd_Cellphone(driver).sendKeys("159 399");
		Message.txt_fd_Company(driver).sendKeys("Bit Stackers");
		Message.txt_fd_Local(driver).sendKeys("+45");
		Message.txt_fd_Name(driver).sendKeys("Just testing");
		Message.txt_fd_Phone(driver).sendKeys("910416");
		Message.check_CallsBack(driver).click();
		System.out.println("Send message confirmed.");

	}
}
