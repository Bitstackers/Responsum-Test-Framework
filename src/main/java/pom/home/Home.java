package main.java.pom.home;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home {

	private static WebElement element = null;
	private static List<WebElement> elements = null;

	public static WebElement label_Welcome(WebDriver driver) {
		element = driver.findElement(By.id("welcome-message-text"));
		return element;
	}

	public static WebElement label_Company(WebDriver driver) {
		element = driver.findElement(By
				.xpath("//*[@id=\"companyselector\"]/div/a/span"));
		return element;
	}

	public static WebElement opt_Company(WebDriver driver, String text) {
		element = driver.findElement(By
				.xpath("//*[@id=\"companyselector\"]/div/div/ul/li[text()=\""
						+ text + "\"]"));
		return element;
	}

	public static List<WebElement> opts_Company(WebDriver driver) {
		elements = driver.findElements(By
				.xpath("//*[@id=\"companyselector\"]/div/div/ul/li"));
		return elements;
	}

	public static List<WebElement> opts_Calendar(WebDriver driver) {
		elements = driver.findElements(By
				.xpath("//*[@id=\"company_events_list\"]/li"));
		return elements;
	}

	public static List<WebElement> opts_Hours(WebDriver driver) {
		elements = driver.findElements(By
				.xpath("//*[@id=\"company-opening-hours-list\"]/li"));
		return elements;
	}

	public static List<WebElement> opts_Handling(WebDriver driver) {
		elements = driver.findElements(By
				.xpath("//*[@id=\"company_handling_list\"]/li"));
		return elements;
	}

	public static List<WebElement> opts_Sales(WebDriver driver) {
		elements = driver.findElements(By
				.xpath("//*[@id=\"company-sales-list\"]/li"));
		return elements;
	}

	public static WebElement label_Product(WebDriver driver) {
		element = driver.findElement(By
				.xpath("//*[@id=\"companyselector\"]/div/a/span"));
		return element;
	}

	public static List<WebElement> opts_Address(WebDriver driver) {
		elements = driver.findElements(By
				.xpath("//*[@id=\"company-addresses-list\"]/li"));
		return elements;
	}

	public static List<WebElement> opts_GQueue(WebDriver driver) {
		elements = driver.findElements(By
				.xpath("//*[@id=\"global-queue-list\"]/li"));
		return elements;
	}

	public static List<WebElement> opts_LQueue(WebDriver driver) {
		elements = driver.findElements(By
				.xpath("//*[@id=\"local-call-list\"]/li"));
		return elements;
	}

}
