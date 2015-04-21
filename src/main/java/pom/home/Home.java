package main.java.pom.home;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home {

	private static WebElement element = null;
	private static List<WebElement> elements = null;
	public static Message Message = new Message();

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
		elements = driver.findElements(By
				.xpath("//*[@id=\"companyselector\"]/div/div/ul/li"));
		return elements;
	}

	public static WebElement opt_Company(WebDriver driver, String text) {
		element = driver.findElement(By
				.xpath("//*[@id=\"companyselector\"]/div/div/ul/li[text()=\""
						+ text + "\"]"));
		return element;
	}

	public static WebElement txt_fd_SearchContact(WebDriver driver) {
		element = driver.findElement(By.id("contact-info-searchbar"));
		return element;
	}

	public static List<WebElement> opts_Contact(WebDriver driver) {
		elements = driver.findElements(By.xpath("//*[@id=\"contactlist\"]/li"));
		return elements;
	}

	public static WebElement opt_Contact(WebDriver driver, String text) {
		element = driver.findElement(By
				.xpath("//*[@id=\"contactlist\"]/li[text()=\"" + text + "\"]"));
		return element;
	}

	public static WebElement spn_Recipient(WebDriver driver) {
		element = driver.findElement(By
				.xpath("//*[@id=\"message-compose\"]/div[2]/ul/li"));
		return element;
	}
}
