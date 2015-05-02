package test.java.views;

import main.java.pom.Helpers;
import main.java.pom.Login;

import org.openqa.selenium.WebDriver;

public class Common {
	public static void login(WebDriver driver, String login, String password,
			Boolean firstTime) {
		Helpers.wait(driver);
		Login.txt_fd_login(driver).sendKeys(login);
		Login.txt_fd_password(driver).sendKeys(password);
		Login.btn_signIn(driver).click();
		if (firstTime) {
			Login.btn_accept(driver).click();
		}
	}
}
