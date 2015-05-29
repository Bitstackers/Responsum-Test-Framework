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

public class BasicUseCases {
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
	public void should_call_specific_employee() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://client.openreception.org");
		System.out.println("***Basic use case***");

		Common.login(driver, LOGIN, password, false);
		ShortcutsView.getReady(driver);

		System.out.println("Customer calls company: "
				+ Constants.DEFAULT_COMPANY);
		Common.callCompany(Constants.DEFAULT_COMPANY);

		System.out.println("Receptionist pick up the call.");
		ShortcutsView.pickup(driver);

		Helpers.waiting(2000);

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

		System.out.println("Receptionist calls: "
				+ Constants.DEFAULT_EMPLOYEE_1);
		HomeView.callSelectedPerson(driver);

		System.out.println(Constants.DEFAULT_EMPLOYEE_1 + " answers");

		Helpers.waiting(2000);

		System.out.println(Constants.DEFAULT_EMPLOYEE_1 + " wants to talk");
		ShortcutsView.transfer(driver);

		System.out.println("Transfer completed, conversation's done");
		Helpers.waiting(2000);

		ShortcutsView.hangup(driver);
		Common.hangOutEmployee();

	}

	@Test
	public void should_call_specific_employee_by_keywords() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://client.openreception.org");
		System.out.println("***Basic use case by keywords***");

		Common.login(driver, LOGIN, password, false);
		ShortcutsView.getReady(driver);

		System.out.println("Customer calls company: "
				+ Constants.DEFAULT_COMPANY);
		Common.callCompany(Constants.DEFAULT_COMPANY);

		System.out.println("Receptionist pick up the call.");
		ShortcutsView.pickup(driver);

		Helpers.waiting(2000);

		System.out.println("Customer asks for someone with knowledge about: "
				+ Constants.DEFAULT_KEYWORD);

		ShortcutsView.switchToSearch(driver);
		Common.sendToLastActiveElement(Constants.DEFAULT_KEYWORD, driver);

		System.out.println("Receptionist checks, if employee is available.");

		ShortcutsView.switchToContactCalendar(driver);
		HomeView.checkCalendar(Constants.CALENDAR_ENTRIES_BS, driver);

		ShortcutsView.switchToCompanyCalendar(driver);
		HomeView.checkContactEvents(Constants.EVENTS_ENTRIES_THOMAS, driver);

		System.out.println("Receptionist informs, that employee is available.");

		System.out.println("Receptionist calls: "
				+ Constants.DEFAULT_EMPLOYEE_2);
		HomeView.callSelectedPerson(driver);

		System.out.println(Constants.DEFAULT_EMPLOYEE_2 + " answers");

		Helpers.waiting(2000);

		System.out.println(Constants.DEFAULT_EMPLOYEE_2 + " wants to talk");
		ShortcutsView.transfer(driver);

		System.out.println("Transfer completed, conversation's done");
		Helpers.waiting(2000);

		ShortcutsView.hangup(driver);
		Common.hangOutEmployee();

	}

	@Test
	public void should_find_another_employee() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://client.openreception.org");
		System.out.println("***Should search for another employee,"
				+ " because first one is unavailable.***");

		Common.login(driver, LOGIN, password, false);
		ShortcutsView.getReady(driver);

		System.out.println("Customer calls company: "
				+ Constants.DEFAULT_COMPANY);
		Common.callCompany(Constants.DEFAULT_COMPANY);

		System.out.println("Receptionist pick up the cal");
		ShortcutsView.pickup(driver);
		Helpers.waiting(2000);

		System.out
				.println("Customer asks for: " + Constants.DEFAULT_EMPLOYEE_2);
		ShortcutsView.switchToSearch(driver);
		Common.sendToLastActiveElement(Constants.DEFAULT_EMPLOYEE_2, driver);

		System.out.println("Receptionist checks, if employee is available.");

		ShortcutsView.switchToContactCalendar(driver);
		HomeView.checkCalendar(Constants.CALENDAR_ENTRIES_BS, driver);
		ShortcutsView.switchToCompanyCalendar(driver);
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
		HomeView.checkCalendar(Constants.CALENDAR_ENTRIES_BS, driver);
		ShortcutsView.switchToCompanyCalendar(driver);
		HomeView.checkContactEvents(Constants.EVENTS_ENTRIES_KIM, driver);

		System.out
				.println("Receptionist informs, that another employee is available.");

		System.out.println("Receptionist calls: "
				+ Constants.DEFAULT_EMPLOYEE_1);
		HomeView.callSelectedPerson(driver);

		System.out.println(Constants.DEFAULT_EMPLOYEE_1 + " answers");

		Helpers.waiting(2000);
		System.out.println(Constants.DEFAULT_EMPLOYEE_1 + " wants to talk");
		ShortcutsView.transfer(driver);

		System.out.println("Transfer completed, conversation's done");
		Helpers.waiting(2000);

		ShortcutsView.hangup(driver);
		Common.hangOutEmployee();

	}

}
