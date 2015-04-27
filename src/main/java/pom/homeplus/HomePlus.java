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

	public static WebElement btn_HomePlus(WebDriver driver) {
		element = driver.findElement(By
				.xpath("//*[@id=\"contexthomeplus_switcherbutton\"]"));
		return element;
	}

	public static WebElement label_CSType(WebDriver driver) {
		element = driver.findElement(By.id("company-customertype-body"));
		return element;
	}

	public static List<WebElement> opts_Emails(WebDriver driver) {
		elements = driver.findElements(By
				.xpath("//*[@id=\"company-email-addresses-list\"]/li"));
		return elements;
	}

	public static List<WebElement> opts_AltNames(WebDriver driver) {
		elements = driver.findElements(By
				.xpath("//*[@id=\"company-alternate-names-list\"]/li"));
		return elements;
	}

	public static List<WebElement> opts_Websites(WebDriver driver) {
		elements = driver.findElements(By
				.xpath("//*[@id=\"company-websites-list\"]/li"));
		return elements;
	}

	public static List<WebElement> opts_TelNumbers(WebDriver driver) {
		elements = driver.findElements(By
				.xpath("//*[@id=\"company-telephonenumbers-list\"]/li"));
		return elements;
	}

	public static List<WebElement> opts_BankInfo(WebDriver driver) {
		elements = driver.findElements(By
				.xpath("//*[@id=\"company-banking-info-list\"]/li"));
		return elements;
	}

	public static List<WebElement> opts_CVRNumbers(WebDriver driver) {
		elements = driver.findElements(By
				.xpath("//*[@id=\"company-registration-number-list\"]/li"));
		return elements;
	}

}
