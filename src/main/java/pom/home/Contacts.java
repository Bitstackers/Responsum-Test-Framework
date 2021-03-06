package main.java.pom.home;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Contacts {
	private static WebElement element = null;
	private static List<WebElement> elements = null;

	public static WebElement txt_fd_SearchContact(WebDriver driver) {
		element = driver.findElement(By
				.xpath("//*[@id=\"contact-selector\"]/div[3]/input"));
		return element;
	}

	public static List<WebElement> opts_Contact(WebDriver driver) {
		elements = driver.findElements(By
				.xpath("//*[@id=\"contact-selector\"]/div[3]/ol/li"));
		return elements;
	}

	public static WebElement opt_Contact(WebDriver driver, String text) {
		element = driver.findElement(By
				.xpath("//*[@id=\"contact-selector\"]/div[3]/ol/li[text()=\""
						+ text + "\"]"));
		return element;
	}

	public static List<WebElement> opts_ContactEvents(WebDriver driver) {
		elements = driver.findElements(By
				.xpath("//*[@id=\"contact-calendar\"]/ol/li"));
		return elements;
	}

}
