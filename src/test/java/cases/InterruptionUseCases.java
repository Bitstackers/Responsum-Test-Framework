package test.java.cases;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import main.java.pom.Helpers;
import main.java.pom.home.Home;
import main.java.utils.ExternalCall;
import main.java.utils.Receptionist;
import main.java.utils.TestService;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
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
		Reporter.log("----N-E-W--T-E-S-T----", Constants.LOG_TO_STD_OUT);
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
		Helpers.waiting(2000);
		driver.quit();
	}

	@Test
	public void should_call_and_stop() {
		Reporter.log("***Should call and stop before being pick up.***",
				Constants.LOG_TO_STD_OUT);
		Reporter.log("Customer calls company: " + Constants.DEFAULT_COMPANY,
				Constants.LOG_TO_STD_OUT);

		TestService.dial(customer);
		Helpers.waiting(6000);
		HomeView.checkCallQueue(1, driver);
		Reporter.log("Customer hangs up.", Constants.LOG_TO_STD_OUT);
		TestService.hangUp(customer);
		Helpers.waiting(2000);
		HomeView.checkCallQueue(0, driver);

	}

	@Test
	public void should_call_pick_up_and_stop() {
		Reporter.log("***Should call, be picked up and stop call.***",
				Constants.LOG_TO_STD_OUT);

		Reporter.log("Customer calls company: " + Constants.DEFAULT_COMPANY,
				Constants.LOG_TO_STD_OUT);

		System.out.println();
		TestService.dial(customer);
		Helpers.waiting(6000);
		HomeView.checkCallQueue(1, driver);

		Reporter.log("Receptionist pick up the call.", Constants.LOG_TO_STD_OUT);
		ShortcutsView.pickup(driver);
		Helpers.waiting(1000);
		for (int i = 0; i < 5; i++) {
			if (Home.opts_Calls(driver).size() == 1) {
				break;
			} else {
				Reporter.log("Receptionist failed to picked up, trying again.",
						Constants.LOG_TO_STD_OUT);
				Helpers.waiting(1000);
				ShortcutsView.pickup(driver);

			}
		}
		HomeView.checkMyCalls(1, driver);
		Reporter.log("Customer hangs up.", Constants.LOG_TO_STD_OUT);

		TestService.hangUp(customer);

		Helpers.waiting(2000);
		HomeView.checkCallQueue(0, driver);
		HomeView.checkMyCalls(0, driver);

	}
}
