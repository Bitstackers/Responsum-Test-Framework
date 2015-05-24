package test.java.cases;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import main.java.pom.Helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import test.java.helpers.Constants;
import test.java.views.Common;
import test.java.views.HomeView;

public class BasicUseCases {
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
	public void should_call_specific_employee() {
		driver = new ChromeDriver();
		driver.get("http://client.openreception.org");
		System.out.println("First use case");

		Common.login(driver, LOGIN, password, false);
		HomeView.getReady(driver);

		System.out.println("User calls company: " + Constants.DEFAULT_COMPANY);
		Common.callCompany(Constants.DEFAULT_COMPANY);

		System.out.println("Receptionist pick up the cal");
		HomeView.pickUpCall(driver);
		Helpers.wait(5000);
		System.out.println("User asks for: " + Constants.DEFAULT_EMPLOYEE_1);
		HomeView.selectingContact(Constants.DEFAULT_EMPLOYEE_1, driver);

		System.out.println("Receptionist checks, if Kim is available.");
		HomeView.checkCalendar(Constants.CALENDAR_ENTRIES_BS, driver);
		HomeView.checkContactEvents(Constants.EVENTS_ENTRIES_KIM, driver);

		System.out.println("Receptionist calls:  "
				+ Constants.DEFAULT_EMPLOYEE_1);
		HomeView.callPerson(Constants.DEFAULT_EMPLOYEE_1, driver);

		System.out.println(Constants.DEFAULT_EMPLOYEE_1 + " answers");
		// Common.answerCall(Constants.EMPLOYEE_1_NR);
		Helpers.wait(5000);
		System.out.println(Constants.DEFAULT_EMPLOYEE_1 + " wants to talk");
		HomeView.transferCall(driver);

		System.out.println("Trasnfer completed, conversation's done");
		Helpers.wait(5000);
		Common.hangOutCustomer();
		Common.hangOutEmployee();

	}

	@Test
	public void should_find_another_employee() {
		driver = new ChromeDriver();
		driver.get("http://client.openreception.org");
		System.out
				.println("Should search for another employee, because first one is unavailable.");

		Common.login(driver, LOGIN, password, false);
		HomeView.getReady(driver);

		System.out.println("User calls company: " + Constants.DEFAULT_COMPANY);
		Common.callCompany(Constants.DEFAULT_COMPANY);

		System.out.println("Receptionist pick up the cal");
		HomeView.pickUpCall(driver);
		Helpers.wait(5000);
		System.out.println("User asks for: " + Constants.DEFAULT_EMPLOYEE_2);
		HomeView.selectingContact(Constants.DEFAULT_EMPLOYEE_2, driver);

		System.out.println("Receptionist checks, if Thomas is available.");
		HomeView.checkCalendar(Constants.CALENDAR_ENTRIES_BS, driver);
		HomeView.checkContactEvents(Constants.EVENTS_ENTRIES_THOMAS, driver);

		System.out.println("User asks for: " + Constants.DEFAULT_EMPLOYEE_1);
		HomeView.selectingContact(Constants.DEFAULT_EMPLOYEE_1, driver);

		System.out.println("Receptionist checks, if Kim is available.");
		HomeView.checkCalendar(Constants.CALENDAR_ENTRIES_BS, driver);
		HomeView.checkContactEvents(Constants.EVENTS_ENTRIES_KIM, driver);

		System.out.println("Receptionist calls:  "
				+ Constants.DEFAULT_EMPLOYEE_1);
		HomeView.callPerson(Constants.DEFAULT_EMPLOYEE_1, driver);

		System.out.println(Constants.DEFAULT_EMPLOYEE_1 + " answers");
		// Common.answerCall(Constants.EMPLOYEE_1_NR);
		Helpers.wait(5000);
		System.out.println(Constants.DEFAULT_EMPLOYEE_1 + " wants to talk");
		HomeView.transferCall(driver);

		System.out.println("Trasnfer completed, conversation's done");
		Helpers.wait(5000);
		Common.hangOutCustomer();
		Common.hangOutEmployee();

	}

}
