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
		element = driver.findElement(By
				.xpath("//*[@id=\"welcome-message\"]/div/span"));
		return element;
	}

	public static List<WebElement> opts_Hours(WebDriver driver) {
		elements = driver.findElements(By
				.xpath("//*[@id=\"reception-opening-hours\"]/ol/li"));
		return elements;
	}

	public static List<WebElement> opts_Sales(WebDriver driver) {
		elements = driver.findElements(By
				.xpath("//*[@id=\"reception-salesmen\"]/ol/li"));
		return elements;
	}

	public static WebElement label_Product(WebDriver driver) {
		element = driver.findElement(By
				.xpath("//*[@id=\"reception-product\"]/div[3]"));
		return element;
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
}
