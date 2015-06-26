package test.java.views;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

import main.java.pom.Helpers;
import main.java.pom.Login;
import main.java.utils.ExternalCall;
import main.java.utils.TestService;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;

import test.java.helpers.Constants;

public class Common {
	private static String callFormat = new String("command.htm?number=%s");
	private static String keyFormat = new String("command.htm?key=%s");

	public static void login(WebDriver driver, String login, String password,
			Boolean firstTime) {
		Helpers.waiting(500);
		Login.txt_fd_login(driver).sendKeys(login);
		Login.btn_next(driver).click();
		Helpers.waiting(500);
		Login.txt_fd_password(driver).sendKeys(password);
		Login.btn_signIn(driver).click();
		if (firstTime) {
			Login.btn_accept(driver).click();
		}
		Reporter.log("Logging in.", Constants.LOG_TO_STD_OUT);
	}

	public static void callCompany(String company) {
		String query = String
				.format(callFormat, Constants.NUMBERS.get(company));
		String address = Constants.DEFAULT_ADDRESS_CUSTOMER + query;
		makeHTTPRequest(address);

	}

	public static void answerCall(String employee1Nr) {
		String query = String.format(keyFormat, "OFFHOOK");
		String address = Constants.DEFAULT_ADDRESS_EMPLOYEE + query;
		makeHTTPRequest(address);
	}

	private static void makeHTTPRequest(String address) {
		try {
			URLConnection connection = new URL(address).openConnection();
			connection.setRequestProperty("Accept-Charset",
					StandardCharsets.UTF_8.name());
			connection.getInputStream();
		} catch (MalformedURLException e) {
			Reporter.log("This URL is fucked-up, man.",
					Constants.LOG_TO_STD_OUT);
			e.printStackTrace();
		} catch (IOException e) {
			Reporter.log("This URL is fucked-up, man.",
					Constants.LOG_TO_STD_OUT);
			e.printStackTrace();
		}

	}

	public static void hangOutCustomer() {
		String query = String.format(keyFormat, "ONHOOK");
		String address = Constants.DEFAULT_ADDRESS_CUSTOMER + query;
		makeHTTPRequest(address);

	}

	public static void hangOutEmployee() {
		String query = String.format(keyFormat, "ONHOOK");
		String address = Constants.DEFAULT_ADDRESS_EMPLOYEE + query;
		makeHTTPRequest(address);
	}

	public static void checkIfEverythingPresentForBS(WebDriver driver) {
		HomeView.selectingCompany("BitStackers", driver);
		HomeView.selectingContact("Thomas Løcke", driver);
		HomeView.checkCalendar(2, driver);
		HomeView.checkHandling(7, driver);
		HomeView.checkContactEvents(4, driver);
		HomeView.checkHours(7, driver);
		HomeView.checkSales(5, driver);
		HomeView.checkContactInfo(driver);
		HomeView.sendMessage(driver);
	}

	public static void sendToLastActiveElement(String message, WebDriver driver) {
		Actions act = new Actions(driver);
		act.sendKeys(message).build().perform();
	}

	public static void checkExternalIsCalling(ExternalCall caller) {
		boolean value = TestService.isCustomerInCall(caller);
		Assert.assertEquals(value, true);
		Reporter.log("This person is in call.", Constants.LOG_TO_STD_OUT);
	}

}
