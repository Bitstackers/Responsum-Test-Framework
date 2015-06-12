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
import test.java.views.HomeView;
import test.java.views.ShortcutsView;

import com.mashape.unirest.http.Unirest;

public class InterruptionUseCases {
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
		customer = TestService.aquireCustomer();
		Helpers.waiting(500);
		ShortcutsView.getReady(driver);
	}

	@AfterMethod
	public void tearDown() {

		TestService.releaseReceptionist(rep);
		TestService.releaseCustomer(customer);
		Helpers.waiting(500);
		driver.quit();
	}

	@Test
	public void should_call_and_stop() {

		System.out.println("***Should call and stop before being pick up.***");

		System.out.println("Customer calls company: "
				+ Constants.DEFAULT_COMPANY);
		TestService.dial(customer);
		Helpers.waiting(1000);
		HomeView.checkCallQueue(1, driver);

		System.out.println("Customer hangs up.");
		TestService.hangUp(customer);
		Helpers.waiting(500);
		HomeView.checkCallQueue(0, driver);

	}

	@Test
	public void should_call_pick_up_and_stop() {
		System.out.println("***Should call, be picked up and stop call.***");

		System.out.println("Customer calls company: "
				+ Constants.DEFAULT_COMPANY);
		TestService.dial(customer);
		Helpers.waiting(1000);
		HomeView.checkCallQueue(1, driver);

		System.out.println("Receptionist pick up the cal");
		ShortcutsView.pickup(driver);

		System.out.println("Customer hangs up.");
		Helpers.waiting(1000);
		HomeView.checkMyCalls(1, driver);
		TestService.hangUp(customer);

		Helpers.waiting(500);
		HomeView.checkCallQueue(0, driver);
		HomeView.checkMyCalls(0, driver);

	}
}
