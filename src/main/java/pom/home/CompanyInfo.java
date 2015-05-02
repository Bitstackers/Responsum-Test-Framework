package main.java.pom.home;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CompanyInfo {

	private static WebElement element = null;
	private static List<WebElement> elements = null;

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

	public static List<WebElement> opts_Handling(WebDriver driver) {
		elements = driver.findElements(By
				.xpath("//*[@id=\"company_handling_list\"]/li"));
		return elements;
	}

}
