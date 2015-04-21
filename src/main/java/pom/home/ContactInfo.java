package main.java.pom.home;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactInfo {

	private static WebElement element = null;
	private static List<WebElement> elements = null;

	public static List<WebElement> opts_Workhours(WebDriver driver) {
		elements = driver.findElements(By
				.xpath("//*[@id=\"contactWorkHoursList\"]/li"));
		return elements;
	}

	public static List<WebElement> opts_Handling(WebDriver driver) {
		elements = driver.findElements(By
				.xpath("//*[@id=\"contactHandlingList\"]/li"));
		return elements;
	}

	public static WebElement label_Position(WebDriver driver) {
		element = driver.findElement(By.id("contactPosition"));
		return element;
	}

	public static WebElement label_Responsibility(WebDriver driver) {
		element = driver.findElement(By.id("contactResponsibility"));
		return element;
	}

	public static WebElement label_Department(WebDriver driver) {
		element = driver.findElement(By.id("contactDepartment"));
		return element;
	}

	public static WebElement btn_Phone(WebDriver driver) {
		element = driver.findElement(By.className("pure-button phonenumber"));
		return element;
	}

	public static WebElement label_Relations(WebDriver driver) {
		element = driver.findElement(By.id("contactRelations"));
		return element;
	}

	public static List<WebElement> opts_Emails(WebDriver driver) {
		elements = driver.findElements(By
				.xpath("//*[@id=\"contactEmailAddressList\"]/li"));
		return elements;
	}

	public static WebElement label_AdditionalInfo(WebDriver driver) {
		element = driver.findElement(By.id("contactAdditionalInfo"));
		return element;
	}

	public static List<WebElement> opts_Backup(WebDriver driver) {
		elements = driver.findElements(By
				.xpath("//*[@id=\"contactBackupList\"]/li"));
		return elements;
	}

}
