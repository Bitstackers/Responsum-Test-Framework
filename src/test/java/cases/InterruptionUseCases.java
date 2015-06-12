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
	public void should_call_and_stop() {

		System.out.println("***Should call and stop before being pick up.***");

		// TestService.dial(customer);

		System.out.println("Customer calls company: "
				+ Constants.DEFAULT_COMPANY);
		// Common.callCompany(Constants.DEFAULT_COMPANY);
		HomeView.selectingCompany("BitStackers", driver);
		HomeView.selectingContact("Trine Løcke", driver);
		// Common.hangOutCustomer();

	}

	@Test
	public void should_call_pick_up_and_stop() {
		System.out.println("***Should call, be picked up and stop call.***");

		System.out.println("Customer calls company: "
				+ Constants.DEFAULT_COMPANY);
		Common.callCompany(Constants.DEFAULT_COMPANY);

		Helpers.waiting(2000);

		System.out.println("Receptionist pick up the cal");
		ShortcutsView.pickup(driver);
		Helpers.waiting(2000);

		Common.hangOutCustomer();
	}
}
