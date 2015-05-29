package test.java.cases;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import main.java.pom.Helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import test.java.helpers.Constants;
import test.java.views.Common;
import test.java.views.HomeView;
import test.java.views.ShortcutsView;

public class EmployeeHatesYouUseCases {
	WebDriver driver;
	String password;
	private static String LOGIN = "walach.anna.or";

	@BeforeTest
	public void prepare() throws IOException {
		for (String line : Files.readAllLines(
				Paths.get("src/main/resources/.secret"),
				Charset.defaultCharset())) {
			password = line;
		}
	}

	@Test
	public void should_leave_message() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://client.openreception.org");
		System.out
				.println("Should leave message, because employee is unavailable. ");

		Common.login(driver, LOGIN, password, false);
		ShortcutsView.getReady(driver);

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
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://client.openreception.org");
		System.out
				.println("Should leave message, because employee is unavailable. ");

		Common.login(driver, LOGIN, password, false);
		ShortcutsView.getReady(driver);

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
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://client.openreception.org");
		System.out
				.println("Should leave message, because employee is unavailable. ");

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
