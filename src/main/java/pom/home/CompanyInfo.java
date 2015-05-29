package main.java.pom.home;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CompanyInfo {

	private static WebElement element = null;
	private static List<WebElement> elements = null;

	public static WebElement label_choosenCompany(WebDriver driver) {
		element = driver.findElement(By.className("selected"));
		return element;
	}

	public static WebElement txt_fd_Company(WebDriver driver) {
		element = driver.findElement(By
				.xpath("//*[@id=\"reception-selector\"]/div[3]/div/input"));
		return element;
	}

	public static WebElement opt_Company(WebDriver driver, String text) {
		element = driver.findElement(By
				.xpath("//*[@id=\"reception-selector\"]/div[3]/ol/li[text()=\""
						+ text + "\"]"));
		return element;
	}

	// *[@id="reception-selector"]/div[3]/ol/li[2]
	public static List<WebElement> opts_Company(WebDriver driver) {
		elements = driver.findElements(By
				.xpath("//*[@id=\"reception-selector\"]/div[3]/ol/li"));
		return elements;
	}

	public static List<WebElement> opts_Calendar(WebDriver driver) {
		elements = driver.findElements(By
				.xpath("//*[@id=\"reception-calendar\"]/ol/li"));
		return elements;
	}

	public static List<WebElement> opts_Commands(WebDriver driver) {
		elements = driver.findElements(By
				.xpath("//*[@id=\"reception-commands\"]/ol/li"));
		return elements;
	}

}
