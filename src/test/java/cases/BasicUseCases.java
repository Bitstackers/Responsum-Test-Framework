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

public class BasicUseCases {
	WebDriver driver;
	String password;
	Receptionist rep;
	ExternalCall customer;
	ExternalCall employee;
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
		customer = TestService.aquireCustomer();
		employee = TestService.aquireCustomer();
		ShortcutsView.getReady(driver);
	}

	@AfterMethod
	public void tearDown() {

		TestService.releaseReceptionist(rep);
		TestService.releaseCustomer(customer);
		TestService.releaseCustomer(employee);
		Helpers.waiting(200);
	}

	@Test
	public void should_call_specific_employee() {
		System.out.println("***Basic use case***");

		System.out.println("Customer calls company: "
				+ Constants.DEFAULT_COMPANY);

		TestService.dial(customer);
		Helpers.waiting(2000);
		HomeView.checkCallQueue(1, driver);

		System.out.println("Receptionist pick up the call.");
		ShortcutsView.pickup(driver);
		Helpers.waiting(2000);

		System.out
				.println("Customer asks for: " + Constants.DEFAULT_EMPLOYEE_1);
		ShortcutsView.switchToSearch(driver);
		Common.sendToLastActiveElement(Constants.DEFAULT_EMPLOYEE_1, driver);

		System.out.println("Receptionist checks, if employee is available.");

		ShortcutsView.switchToContactCalendar(driver);
		HomeView.checkContactEvents(Constants.EVENTS_ENTRIES_KIM, driver);

		ShortcutsView.switchToCompanyCalendar(driver);
		HomeView.checkCalendar(Constants.CALENDAR_ENTRIES_BS, driver);

		System.out.println("Receptionist informs, that employee is available.");
		ShortcutsView.park(driver);

		System.out.println("Receptionist calls: "
				+ Constants.DEFAULT_EMPLOYEE_1);

		Helpers.waiting(500);
		// HomeView.callSelectedPerson(driver);
		TestService.dial_ext(employee, rep);

		System.out.println(Constants.DEFAULT_EMPLOYEE_1 + " answers");
		Helpers.waiting(1000);
		TestService.pickup(employee);
		Helpers.waiting(1000);

		HomeView.checkMyCalls(2, driver);

		System.out.println(Constants.DEFAULT_EMPLOYEE_1 + " wants to talk");
		ShortcutsView.transfer(driver);
		Helpers.waiting(2000);

		System.out.println("Transfer completed, conversation's done");
		HomeView.checkMyCalls(0, driver);
		Common.checkExternalIsCalling(customer);
		Common.checkExternalIsCalling(employee);
		Helpers.waiting(500);

		ShortcutsView.hangup(driver);
		TestService.hangUp(customer);
		TestService.hangUp(employee);

	}

	@Test
	public void should_call_specific_employee_by_keywords() {
		System.out.println("***Basic use case by keywords***");

		System.out.println("Customer calls company: "
				+ Constants.DEFAULT_COMPANY);

		TestService.dial(customer);
		Helpers.waiting(2000);
		HomeView.checkCallQueue(1, driver);

		System.out.println("Receptionist pick up the call.");
		ShortcutsView.pickup(driver);
		Helpers.waiting(2000);

		System.out.println("Customer asks for someone with knowledge about: "
				+ Constants.DEFAULT_KEYWORD);

		ShortcutsView.switchToSearch(driver);
		Common.sendToLastActiveElement(Constants.DEFAULT_KEYWORD, driver);

		System.out.println("Receptionist checks, if employee is available.");

		ShortcutsView.switchToCompanyCalendar(driver);
		HomeView.checkCalendar(Constants.CALENDAR_ENTRIES_BS, driver);

		ShortcutsView.switchToContactCalendar(driver);
		HomeView.checkContactEvents(Constants.EVENTS_ENTRIES_THOMAS, driver);

		System.out.println("Receptionist informs, that employee is available.");

		System.out.println("Receptionist calls: "
				+ Constants.DEFAULT_EMPLOYEE_2);

		Helpers.waiting(500);
		// HomeView.callSelectedPerson(driver);
		TestService.dial_ext(employee, rep);

		System.out.println(Constants.DEFAULT_EMPLOYEE_2 + " answers");
		Helpers.waiting(1000);
		TestService.pickup(employee);
		Helpers.waiting(1000);

		HomeView.checkMyCalls(2, driver);

		System.out.println(Constants.DEFAULT_EMPLOYEE_2 + " wants to talk");
		ShortcutsView.transfer(driver);
		Helpers.waiting(2000);

		System.out.println("Transfer completed, conversation's done");
		HomeView.checkMyCalls(0, driver);
		Common.checkExternalIsCalling(customer);
		Common.checkExternalIsCalling(employee);
		Helpers.waiting(500);

		ShortcutsView.hangup(driver);
		TestService.hangUp(customer);
		TestService.hangUp(employee);

	}

	@Test
	public void should_find_another_employee() {
		System.out.println("***Should search for another employee,"
				+ " because first one is unavailable.***");

		System.out.println("Customer calls company: "
				+ Constants.DEFAULT_COMPANY);

		TestService.dial(customer);
		Helpers.waiting(2000);
		HomeView.checkCallQueue(1, driver);

		System.out.println("Receptionist pick up the cal");
		ShortcutsView.pickup(driver);
		Helpers.waiting(2000);

		System.out
				.println("Customer asks for: " + Constants.DEFAULT_EMPLOYEE_2);
		ShortcutsView.switchToSearch(driver);
		Common.sendToLastActiveElement(Constants.DEFAULT_EMPLOYEE_2, driver);

		System.out.println("Receptionist checks, if employee is available.");

		ShortcutsView.switchToCompanyCalendar(driver);
		HomeView.checkCalendar(Constants.CALENDAR_ENTRIES_BS, driver);

		ShortcutsView.switchToContactCalendar(driver);
		HomeView.checkContactEvents(Constants.EVENTS_ENTRIES_THOMAS, driver);

		System.out
				.println("Receptionist informs, that employee is unavailable.");

		System.out
				.println("Customer asks for: " + Constants.DEFAULT_EMPLOYEE_1);
		ShortcutsView.switchToSearch(driver);
		Common.sendToLastActiveElement(Constants.DEFAULT_EMPLOYEE_1, driver);

		System.out
				.println("Receptionist checks, if another employee is available.");

		ShortcutsView.switchToContactCalendar(driver);
		HomeView.checkContactEvents(Constants.EVENTS_ENTRIES_KIM, driver);

		ShortcutsView.switchToCompanyCalendar(driver);
		HomeView.checkCalendar(Constants.CALENDAR_ENTRIES_BS, driver);

		System.out
				.println("Receptionist informs, that another employee is available.");

		System.out.println("Receptionist calls: "
				+ Constants.DEFAULT_EMPLOYEE_1);

		Helpers.waiting(500);
		// HomeView.callSelectedPerson(driver);
		TestService.dial_ext(employee, rep);

		System.out.println(Constants.DEFAULT_EMPLOYEE_1 + " answers");
		Helpers.waiting(1000);
		TestService.pickup(employee);
		Helpers.waiting(1000);

		HomeView.checkMyCalls(2, driver);

		System.out.println(Constants.DEFAULT_EMPLOYEE_1 + " wants to talk");
		ShortcutsView.transfer(driver);
		Helpers.waiting(2000);

		System.out.println("Transfer completed, conversation's done");
		HomeView.checkMyCalls(0, driver);
		Common.checkExternalIsCalling(customer);
		Common.checkExternalIsCalling(employee);
		Helpers.waiting(500);

		ShortcutsView.hangup(driver);
		TestService.hangUp(customer);
		TestService.hangUp(employee);
	}

}
