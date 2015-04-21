package main.java.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Home {

	private static WebElement element = null;
	private static Select dropdown = null;

	public static WebElement btn_Save(WebDriver driver) {
		element = driver.findElement(By.className("save pure-button"));
		return element;
	}

	public static WebElement btn_Send(WebDriver driver) {
		element = driver.findElement(By.className("send pure-button"));
		return element;
	}

	public static WebElement btn_Cancel(WebDriver driver) {
		element = driver.findElement(By.className("cancel pure-button"));
		return element;
	}

	public static WebElement ui_contacts(WebDriver driver) {
		element = driver.findElement(By.id("contactlist"));
		return element;
	}

	public static WebElement spn_fd_Welcome(WebDriver driver) {
		element = driver.findElement(By.id("welcome-message-text"));
		return element;
	}

	public static WebElement spn_Company(WebDriver driver) {
		element = driver.findElement(By
				.xpath("//*[@id=\"companyselector\"]/div/a/span"));
		return element;
	}

	public static List<WebElement> opts_Company(WebDriver driver) {
		List<WebElement> list = driver.findElements(By
				.xpath("//*[@id=\"companyselector\"]/div/div/ul/li"));
		return list;
	}

	public static WebElement opt_Company(WebDriver driver, String text) {
		element = driver.findElement(By
				.xpath("//*[@id=\"companyselector\"]/div/div/ul/li[text()=\""
						+ text + "\"]"));
		return element;
	}

	public static WebElement txt_fd_Search(WebDriver driver) {
		element = driver.findElement(By.id("contact-info-searchbar"));
		return element;
	}

}
