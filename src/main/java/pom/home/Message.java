package main.java.pom.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Message {
	private static WebElement element = null;

	public static WebElement txt_fd_Name(WebDriver driver) {
		element = driver.findElement(By.id("message-compose-name"));
		return element;
	}

	public static WebElement txt_fd_Company(WebDriver driver) {
		element = driver.findElement(By.id("message-compose-company"));
		return element;
	}

	public static WebElement txt_fd_Phone(WebDriver driver) {
		element = driver.findElement(By.id("message-compose-phone"));
		return element;
	}

	public static WebElement txt_fd_Cellphone(WebDriver driver) {
		element = driver.findElement(By.id("message-compose-cellphone"));
		return element;
	}

	public static WebElement txt_fd_Local(WebDriver driver) {
		element = driver.findElement(By.id("message-compose-local-extension"));
		return element;
	}

	public static WebElement txt_fd_Body(WebDriver driver) {
		element = driver.findElement(By.id("message-compose-body"));
		return element;
	}

	public static WebElement check_PleaseCall(WebDriver driver) {
		element = driver.findElement(By.id("message-compose-tag-pleasecall"));
		return element;
	}

	public static WebElement check_CallsBack(WebDriver driver) {
		element = driver.findElement(By.id("message-compose-tag-callsback"));
		return element;
	}

	public static WebElement check_HasCalled(WebDriver driver) {
		element = driver.findElement(By.id("message-compose-tag-hascalled"));
		return element;
	}

	public static WebElement check_Urgent(WebDriver driver) {
		element = driver.findElement(By.id("message-compose-tag-urgent"));
		return element;
	}

	public static WebElement check_Draft(WebDriver driver) {
		element = driver.findElement(By.id("message-compose-tag-draft"));
		return element;
	}

	public static WebElement btn_Save(WebDriver driver) {
		element = driver.findElement(By.className("save pure-button"));
		return element;
	}

	public static WebElement btn_Send(WebDriver driver) {
		element = driver.findElement(By.className("send pure-button"));
		return element;
	}

	public static WebElement btn_Cancel(WebDriver driver) {
		element = driver.findElement(By.className("cancel pure-button"));
		return element;
	}

}
