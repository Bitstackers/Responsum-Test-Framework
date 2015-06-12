package main.java.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Anna on 2015-04-20.
 */
public class Login {
	private static WebElement element = null;

	public static WebElement txt_fd_login(WebDriver driver) {
		element = driver.findElement(By.id("Email"));
		return element;
	}

	public static WebElement txt_fd_password(WebDriver driver) {
		element = driver.findElement(By.id("Passwd"));
		return element;
	}

	public static WebElement btn_next(WebDriver driver) {
		element = driver.findElement(By.id("next"));
		return element;
	}

	public static WebElement btn_signIn(WebDriver driver) {
		element = driver.findElement(By.id("signIn"));
		return element;
	}

	public static WebElement btn_accept(WebDriver driver) {
		element = driver.findElement(By.id("accept"));
		return element;
	}
}
