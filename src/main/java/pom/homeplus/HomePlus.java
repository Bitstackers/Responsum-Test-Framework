package main.java.pom.homeplus;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Anna on 2015-04-13.
 */
public class HomePlus {

	private static WebElement element = null;
	private static List<WebElement> elements = null;

	public static List<WebElement> opts_AltNames(WebDriver driver) {
		elements = driver.findElements(By
				.xpath("//*[@id=\"reception-alt-names\"]/ol/li"));
		return elements;
	}

	public static List<WebElement> opts_Websites(WebDriver driver) {
		elements = driver.findElements(By
				.xpath("//*[@id=\"reception-websites\"]/ol/li"));
		return elements;
	}

	public static List<WebElement> opts_Addresses(WebDriver driver) {
		elements = driver.findElements(By
				.xpath("//*[@id=\"reception-addresses\"]/ol/li"));
		return elements;
	}

	public static List<WebElement> opts_VATNumbers(WebDriver driver) {
		elements = driver.findElements(By
				.xpath("//*[@id=\"reception-vat-numbers\"]/ol/li"));
		return elements;
	}

	public static List<WebElement> opts_Emails(WebDriver driver) {
		elements = driver.findElements(By
				.xpath("//*[@id=\"reception-email\"]/ol/li"));
		return elements;
	}

	public static WebElement label_ReceptionType(WebDriver driver) {
		element = driver.findElement(By
				.xpath("//*[@id=\"reception-type\"]/ol/li"));
		return element;
	}

	public static List<WebElement> opts_TelNumbers(WebDriver driver) {
		elements = driver
				.findElements(By
						.xpath("//*[@id=\"reception-telephone-numbers\"]/ol/li/span[1]"));
		return elements;
	}

	public static List<WebElement> opts_BankInfo(WebDriver driver) {
		elements = driver.findElements(By
				.xpath("//*[@id=\"reception-bank-info\"]/ol/li"));
		return elements;
	}

}
