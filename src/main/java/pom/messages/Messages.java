package main.java.pom.messages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Anna on 2015-04-13.
 */
public class Messages {
	private static WebElement element = null;
	private static List<WebElement> elements = null;

	public static WebElement btn_Messages(WebDriver driver) {
		element = driver.findElement(By
				.xpath("//*[@id=\"contextmessages_switcherbutton\"]"));
		return element;
	}

	public static WebElement btn_Print(WebDriver driver) {
		element = driver.findElement(By
				.xpath("//*[@id=\"message-search-print\"]"));
		return element;
	}

	public static WebElement btn_Resend(WebDriver driver) {
		element = driver.findElement(By
				.xpath("//*[@id=\"message-search-resend\"]"));
		return element;
	}

	public static WebElement check_All(WebDriver driver) {
		element = driver.findElement(By.id("message-overview-header-checkbox"));
		return element;
	}

	public static WebElement opt_MessageRow(WebDriver driver, String rowText) {
		element = driver
				.findElement(By
						.xpath("//*[@id=\"message-overview-body\"]/tr[td//text()[contains(., "
								+ rowText + ")]]"));
		return element;
	}

	public static List<WebElement> opts_MessageRow(WebDriver driver) {
		elements = driver.findElements(By
				.xpath("//*[@id=\"message-overview-body\"]/tr"));
		return elements;
	}

}
