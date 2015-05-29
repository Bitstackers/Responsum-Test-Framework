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
import test.java.views.MessagesView;
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
		HomeView.selectingContact(Constants.DEFAULT_EMPLOYEE_1, driver);

		System.out.println("Receptionist checks, if Kim is available.");
		HomeView.checkCalendar(Constants.CALENDAR_ENTRIES_BS, driver);
		HomeView.checkContactEvents(Constants.EVENTS_ENTRIES_KIM, driver);

		MessagesView.sendMessage(driver);

		Common.hangOutCustomer();
	}

	@Test
	public void should_not_answer() {
		driver = new FirefoxDriver();
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
		HomeView.selectingContact(Constants.DEFAULT_EMPLOYEE_1, driver);

		System.out.println("Receptionist checks, if Kim is available.");
		HomeView.checkCalendar(Constants.CALENDAR_ENTRIES_BS, driver);
		HomeView.checkContactEvents(Constants.EVENTS_ENTRIES_KIM, driver);

		System.out.println("Receptionist calls:  "
				+ Constants.DEFAULT_EMPLOYEE_1);
		HomeView.callPerson(Constants.DEFAULT_EMPLOYEE_1, driver);

		System.out.println(Constants.DEFAULT_EMPLOYEE_1 + "doesnt't answer.");
		// TODO stop calling

		Common.hangOutCustomer();
	}

	@Test
	public void should_refuse_contact() {
		driver = new FirefoxDriver();
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
		HomeView.selectingContact(Constants.DEFAULT_EMPLOYEE_1, driver);

		System.out.println("Receptionist checks, if Kim is available.");
		HomeView.checkCalendar(Constants.CALENDAR_ENTRIES_BS, driver);
		HomeView.checkContactEvents(Constants.EVENTS_ENTRIES_KIM, driver);

		System.out.println("Receptionist calls:  "
				+ Constants.DEFAULT_EMPLOYEE_1);
		HomeView.callPerson(Constants.DEFAULT_EMPLOYEE_1, driver);

		System.out.println(Constants.DEFAULT_EMPLOYEE_1 + "doesnt't answer.");

		Helpers.waiting(5000);
		System.out.println(Constants.DEFAULT_EMPLOYEE_1
				+ " doesn't want to talk");

		Common.hangOutEmployee();

		MessagesView.sendMessage(driver);
		Common.hangOutCustomer();
	}

}
