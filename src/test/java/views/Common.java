package test.java.views;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

import main.java.pom.Helpers;
import main.java.pom.Login;

import org.openqa.selenium.WebDriver;

import test.java.helpers.Constants;

public class Common {
	private static String callFormat = new String("command.htm?number=%s");
	private static String keyFormat = new String("command.htm?key=%s");

	public static void login(WebDriver driver, String login, String password,
			Boolean firstTime) {
		Helpers.waiting(5000);
		Login.txt_fd_login(driver).sendKeys(login);
		Login.txt_fd_password(driver).sendKeys(password);
		Login.btn_signIn(driver).click();
		if (firstTime) {
			Login.btn_accept(driver).click();
		}
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
			System.out.println("This URL is fucked-up, man.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("This URL is fucked-up, man.");
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
}
