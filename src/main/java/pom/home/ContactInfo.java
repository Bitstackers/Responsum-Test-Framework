package main.java.pom.home;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactInfo {

	private static WebElement element = null;
	private static List<WebElement> elements = null;

	public static WebElement btn_Call(WebDriver driver) {
		element = driver.findElement(By
				.xpath("//*[@id=\"contact-data\"]/h4/div/span[2]"));
		return element;
	}

	public static WebElement txt_fd_Call(WebDriver driver) {
		element = driver.findElement(By
				.xpath("//*[@id=\"contact-data\"]/div[3]/div[1]/input"));
		return element;
	}

	public static List<WebElement> opts_Workhours(WebDriver driver) {
		elements = driver.findElements(By
				.xpath("//*[@id=\"contact-data\"]/div[3]/div[2]/div[1]/ol/li"));
		return elements;
	}

	public static List<WebElement> opts_Commands(WebDriver driver) {
		elements = driver.findElements(By
				.xpath("//*[@id=\"contact-data\"]/div[3]/div[3]/div[1]/ol/li"));
		return elements;
	}

	public static List<WebElement> opts_Title(WebDriver driver) {
		elements = driver.findElements(By
				.xpath("//*[@id=\"contact-data\"]/div[3]/div[2]/div[2]/ol/li"));
		return elements;
	}

	public static List<WebElement> opts_Responsibility(WebDriver driver) {
		elements = driver.findElements(By
				.xpath("//*[@id=\"contact-data\"]/div[3]/div[3]/div[2]/ol/li"));
		return elements;
	}

	public static List<WebElement> opts_Department(WebDriver driver) {
		elements = driver.findElements(By
				.xpath("//*[@id=\"contact-data\"]/div[3]/div[2]/div[3]/ol/li"));
		return elements;
	}

	public static List<WebElement> opts_Phone(WebDriver driver) {
		elements = driver
				.findElements(By
						.xpath("//*[@id=\"contact-data\"]/div[3]/div[3]/div[3]/ol/li/span[1]"));
		return elements;
	}

	public static List<WebElement> opts_Relations(WebDriver driver) {
		elements = driver.findElements(By
				.xpath("//*[@id=\"contact-data\"]/div[3]/div[2]/div[4]/ol/li"));
		return elements;
	}

	public static List<WebElement> opts_Emails(WebDriver driver) {
		elements = driver.findElements(By
				.xpath("//*[@id=\"contact-data\"]/div[3]/div[3]/div[4]/ol/li"));
		return elements;
	}

	public static List<WebElement> opts_Miscellaneous(WebDriver driver) {
		elements = driver.findElements(By
				.xpath("//*[@id=\"contact-data\"]/div[3]/div[2]/div[5]/ol/li"));
		return elements;
	}

	public static List<WebElement> opts_Backup(WebDriver driver) {
		elements = driver.findElements(By
				.xpath("//*[@id=\"contact-data\"]/div[3]/div[3]/div[5]/ol/li"));
		return elements;
	}
}
