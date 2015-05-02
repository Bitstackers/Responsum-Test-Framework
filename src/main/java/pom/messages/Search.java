package main.java.pom.messages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Search {
	private static WebElement element = null;
	private static List<WebElement> elements = null;

	public static WebElement label_Agent(WebDriver driver) {
		element = driver.findElement(By
				.xpath("//*[@id=\"message-search-agent\"]/div/a/span"));
		return element;
	}

	public static WebElement txt_fd_Agent(WebDriver driver) {
		element = driver.findElement(By.id("message-search-agent-searchbar"));
		return element;
	}

	public static WebElement opt_Agent(WebDriver driver, String text) {
		element = driver
				.findElement(By
						.xpath("//*[@id=\"message-search-agent\"]/div/div/ul/li[text()=\""
								+ text + "\"]"));
		return element;
	}

	public static List<WebElement> opts_Agent(WebDriver driver) {
		elements = driver.findElements(By
				.xpath("//*[@id=\"message-search-agent\"]/div/div/ul/li"));
		return elements;
	}

	public static WebElement label_Type(WebDriver driver) {
		element = driver.findElement(By
				.xpath("//*[@id=\"message-search-type\"]/div/a/span"));
		return element;
	}

	public static WebElement txt_fd_Type(WebDriver driver) {
		element = driver.findElement(By.id("message-search-type-searchbar"));
		return element;
	}

	public static WebElement opt_Type(WebDriver driver, String text) {
		element = driver
				.findElement(By
						.xpath("//*[@id=\"message-search-type\"]/div/div/ul/li[text()=\""
								+ text + "\"]"));
		return element;
	}

	public static List<WebElement> opts_Type(WebDriver driver) {
		elements = driver.findElements(By
				.xpath("//*[@id=\"message-search-type\"]/div/div/ul/li"));
		return elements;
	}

	public static WebElement label_Company(WebDriver driver) {
		element = driver.findElement(By
				.xpath("//*[@id=\"message-search-company\"]/div/a/span"));
		return element;
	}

	public static WebElement txt_fd_Company(WebDriver driver) {
		element = driver.findElement(By.id("message-search-company-searchbar"));
		return element;
	}

	public static WebElement opt_Company(WebDriver driver, String text) {
		element = driver
				.findElement(By
						.xpath("//*[@id=\"message-search-company\"]/div/div/ul/li[text()=\""
								+ text + "\"]"));
		return element;
	}

	public static List<WebElement> opts_Company(WebDriver driver) {
		elements = driver.findElements(By
				.xpath("//*[@id=\"message-search-company\"]/div/div/ul/li"));
		return elements;
	}

	public static WebElement label_Contact(WebDriver driver) {
		element = driver.findElement(By
				.xpath("//*[@id=\"message-search-contact\"]/div/a/span"));
		return element;
	}

	public static WebElement txt_fd_Contact(WebDriver driver) {
		element = driver.findElement(By.id("message-search-contact-searchbar"));
		return element;
	}

	public static WebElement opt_Contact(WebDriver driver, String text) {
		element = driver
				.findElement(By
						.xpath("//*[@id=\"message-search-contact\"]/div/div/ul/li[text()=\""
								+ text + "\"]"));
		return element;
	}

	public static List<WebElement> opts_Contact(WebDriver driver) {
		elements = driver.findElements(By
				.xpath("//*[@id=\"message-search-contact\"]/div/div/ul/li"));
		return elements;
	}
}
