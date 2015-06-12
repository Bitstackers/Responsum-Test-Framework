package test.java.cases;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import main.java.pom.Helpers;
import main.java.utils.ExternalCall;
import main.java.utils.Receptionist;
import main.java.utils.TestService;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import test.java.helpers.Constants;
import test.java.views.Common;
import test.java.views.HomeView;
import test.java.views.ShortcutsView;

import com.mashape.unirest.http.Unirest;

public class EmployeeHatesYouUseCases {
	WebDriver driver;
	String password;
	Receptionist rep;
	ExternalCall customer;
	private static String LOGIN = "walach.anna.or";

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
		try {
			Unirest.shutdown();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@BeforeMethod
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		rep = TestService.aquireReceptionist();
		driver.get("http://ci.bitstack.dk:8000?settoken=" + rep.auth_token);
		ShortcutsView.getReady(driver);
		customer = TestService.aquireCustomer();
	}

	@AfterMethod
	public void tearDown() {

		TestService.releaseReceptionist(rep);
		TestService.releaseCustomer(customer);
		Helpers.waiting(2000);
		driver.quit();
	}

	@Test
	public void should_leave_message() {
		System.out
				.println("***Should leave message, because employee is unavailable.***");

		System.out.println("Customer calls company: "
				+ Constants.DEFAULT_COMPANY);
		Common.callCompany(Constants.DEFAULT_COMPANY);

		System.out.println("Receptionist pick up the cal");
		ShortcutsView.switchToSearch(driver);
		Common.sendToLastActiveElement(Constants.DEFAULT_EMPLOYEE_1, driver);

		System.out.println("Receptionist checks, if Kim is available.");

		ShortcutsView.switchToContactCalendar(driver);
		HomeView.checkCalendar(Constants.CALENDAR_ENTRIES_BS, driver);
		ShortcutsView.switchToCompanyCalendar(driver);
		HomeView.checkContactEvents(Constants.EVENTS_ENTRIES_KIM, driver);

		System.out.println("Receptionist informs, that Kim is unavailable.");

		System.out.println("Customer wants to send a message.");

		HomeView.sendMessage(driver);

		Common.hangOutCustomer();
	}

	@Test
	public void should_not_answer() {
		System.out
				.println("***Should leave message, because employee is unavailable***");

		System.out.println("Customer calls company: "
				+ Constants.DEFAULT_COMPANY);
		Common.callCompany(Constants.DEFAULT_COMPANY);

		System.out.println("Receptionist pick up the cal");
		ShortcutsView.pickup(driver);
		Helpers.waiting(5000);

		System.out
				.println("Customer asks for: " + Constants.DEFAULT_EMPLOYEE_1);
		ShortcutsView.switchToSearch(driver);
		Common.sendToLastActiveElement(Constants.DEFAULT_EMPLOYEE_1, driver);

		System.out.println("Receptionist checks, if employee is available.");

		ShortcutsView.switchToContactCalendar(driver);
		HomeView.checkCalendar(Constants.CALENDAR_ENTRIES_BS, driver);
		ShortcutsView.switchToCompanyCalendar(driver);
		HomeView.checkContactEvents(Constants.EVENTS_ENTRIES_KIM, driver);

		System.out.println("Receptionist informs, that employee is available.");

		System.out.println("Receptionist calls:  "
				+ Constants.DEFAULT_EMPLOYEE_1);
		HomeView.callSelectedPerson(driver);
		// TODO should not answer

		System.out.println(Constants.DEFAULT_EMPLOYEE_1 + "doesnt't answer.");
		// TODO stop calling

		System.out.println("Customer is done.");

		ShortcutsView.hangup(driver);
	}

	@Test
	public void should_refuse_contact() {
		System.out
				.println("***Should leave message, because employee is unavailable.***");

		Common.login(driver, LOGIN, password, false);
		ShortcutsView.getReady(driver);

		System.out.println("User calls company: " + Constants.DEFAULT_COMPANY);
		Common.callCompany(Constants.DEFAULT_COMPANY);

		System.out.println("Receptionist pick up the cal");
		ShortcutsView.pickup(driver);
		Helpers.waiting(5000);

		System.out.println("User asks for: " + Constants.DEFAULT_EMPLOYEE_1);
		ShortcutsView.switchToSearch(driver);
		Common.sendToLastActiveElement(Constants.DEFAULT_EMPLOYEE_1, driver);

		System.out.println("Receptionist checks, if employee is available.");

		ShortcutsView.switchToContactCalendar(driver);
		HomeView.checkCalendar(Constants.CALENDAR_ENTRIES_BS, driver);
		ShortcutsView.switchToCompanyCalendar(driver);
		HomeView.checkContactEvents(Constants.EVENTS_ENTRIES_KIM, driver);

		System.out.println("Receptionist informs, that employee is available.");

		System.out.println("Receptionist calls:  "
				+ Constants.DEFAULT_EMPLOYEE_1);
		HomeView.callSelectedPerson(driver);

		System.out.println(Constants.DEFAULT_EMPLOYEE_1 + " answer.");

		Helpers.waiting(2000);
		System.out.println(Constants.DEFAULT_EMPLOYEE_1
				+ " doesn't want to talk");

		Common.hangOutEmployee();

		System.out.println("Receptionist informs, that employee is busy.");
		System.out.println("Customer wants to leave a message.");
		HomeView.sendMessage(driver);

		Common.hangOutCustomer();
	}

}
