package main.java.pom.home;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Message {
	private static WebElement element = null;
	private static List<WebElement> elements = null;

	public static WebElement spn_showRecipients(WebDriver driver) {
		element = driver.findElement(By
				.xpath("//*[@id=\"message-compose\"]/h4/span[3]"));
		return element;
	}

	public static List<WebElement> opts_Recipients(WebDriver driver) {
		elements = driver.findElements(By
				.xpath("//*[@id=\"message-compose\"]/div[3]/div[1]/ol/li"));
		return elements;
	}

	public static WebElement txt_fd_Name(WebDriver driver) {
		element = driver.findElement(By
				.xpath("//*[@id=\"message-compose\"]/div[3]/div[3]/input[1]"));
		return element;
	}

	public static WebElement txt_fd_Company(WebDriver driver) {
		element = driver.findElement(By
				.xpath("//*[@id=\"message-compose\"]/div[3]/div[3]/input[2]"));
		return element;
	}

	public static WebElement txt_fd_Phone(WebDriver driver) {
		element = driver.findElement(By
				.xpath("//*[@id=\"message-compose\"]/div[3]/div[4]/input[1]"));
		return element;
	}

	public static WebElement txt_fd_Cellphone(WebDriver driver) {
		element = driver.findElement(By
				.xpath("//*[@id=\"message-compose\"]/div[3]/div[4]/input[2]"));
		return element;
	}

	public static WebElement txt_fd_Extension(WebDriver driver) {
		element = driver.findElement(By
				.xpath("//*[@id=\"message-compose\"]/div[3]/div[4]/input[3]"));
		return element;
	}

	public static WebElement txt_fd_Body(WebDriver driver) {
		element = driver.findElement(By
				.xpath("//*[@id=\"message-compose\"]/div[3]/div[5]/textarea"));
		return element;
	}

	public static WebElement check_PleaseCall(WebDriver driver) {
		element = driver.findElement(By
				.xpath("//*[@id=\"message-compose-please-call\"]"));
		return element;
	}

	public static WebElement check_CallsBack(WebDriver driver) {
		element = driver.findElement(By
				.xpath("//*[@id=\"message-compose-calls-back\"]"));
		return element;
	}

	public static WebElement check_Urgent(WebDriver driver) {
		element = driver.findElement(By
				.xpath("//*[@id=\"message-compose-urgent\"]"));

		return element;
	}

	public static WebElement check_Draft(WebDriver driver) {
		element = driver.findElement(By
				.xpath("//*[@id=\"message-compose-draft\"]"));
		return element;
	}

	public static WebElement btn_Save(WebDriver driver) {
		element = driver.findElement(By.className("save"));
		return element;
	}

	public static WebElement btn_Send(WebDriver driver) {
		element = driver.findElement(By.className("send"));
		return element;
	}

	public static WebElement btn_Cancel(WebDriver driver) {
		element = driver.findElement(By.className("cancel"));
		return element;
	}

}
