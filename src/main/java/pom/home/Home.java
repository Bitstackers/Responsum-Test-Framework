package main.java.pom.home;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home {

	private static WebElement element = null;
	private static List<WebElement> elements = null;

	public static WebElement btn_Home(WebDriver driver) {
		element = driver.findElement(By
				.xpath("//*[@id=\"contexthome_switcherbutton\"]"));
		return element;
	}

	public static WebElement label_Welcome(WebDriver driver) {
		element = driver.findElement(By.id("welcome-message-text"));
		return element;
	}

	public static WebElement txt_fd_Call(WebDriver driver) {
		element = driver.findElement(By.id("call-originate-number-field"));
		return element;
	}

	public static WebElement btn_Call(WebDriver driver) {
		element = driver.findElement(By
				.xpath("//*[@id=\"call-originate\"]/button"));
		return element;
	}

	public static List<WebElement> opts_Hours(WebDriver driver) {
		elements = driver.findElements(By
				.xpath("//*[@id=\"company-opening-hours-list\"]/li"));
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

	public static WebElement Root(WebDriver driver) {
		element = driver.findElement(By.tagName("html"));
		return element;
	}

	public static List<WebElement> btns_Pickup(WebDriver driver) {
		elements = driver.findElements(By
				.xpath("//*[@id=\"global-queue-list\"]/li/button"));
		return elements;
	}

}
