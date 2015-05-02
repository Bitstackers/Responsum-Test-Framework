package main.java.pom.messages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Message {
	private static WebElement element = null;

	public static WebElement spn_RecipientTo(WebDriver driver) {
		element = driver.findElement(By.className("email-recipient-role-to"));
		return element;
	}

	public static WebElement spn_RecipientCC(WebDriver driver) {
		element = driver.findElement(By.className("email-recipient-role-cc"));
		return element;
	}

	public static WebElement txt_fd_Name(WebDriver driver) {
		element = driver.findElement(By.id("message-edit-name"));
		return element;
	}

	public static WebElement txt_fd_Company(WebDriver driver) {
		element = driver.findElement(By.id("message-edit-company"));
		return element;
	}

	public static WebElement txt_fd_Phone(WebDriver driver) {
		element = driver.findElement(By.id("message-edit-phone"));
		return element;
	}

	public static WebElement txt_fd_Cellphone(WebDriver driver) {
		element = driver.findElement(By.id("message-edit-cellphone"));
		return element;
	}

	public static WebElement txt_fd_Local(WebDriver driver) {
		element = driver.findElement(By.id("message-edit-local-extension"));
		return element;
	}

	public static WebElement txt_fd_Body(WebDriver driver) {
		element = driver.findElement(By.id("message-edit-body"));
		return element;
	}

	public static WebElement check_PleaseCall(WebDriver driver) {
		element = driver.findElement(By.id("message-edit-tag-pleasecall"));
		return element;
	}

	public static WebElement check_CallsBack(WebDriver driver) {
		element = driver.findElement(By.id("message-edit-tag-callsback"));
		return element;
	}

	public static WebElement check_HasCalled(WebDriver driver) {
		element = driver.findElement(By.id("message-edit-tag-hascalled"));
		return element;
	}

	public static WebElement check_Urgent(WebDriver driver) {
		element = driver.findElement(By.id("message-edit-tag-urgent"));
		return element;
	}

	public static WebElement check_Draft(WebDriver driver) {
		element = driver.findElement(By.id("message-edit-tag-draft"));
		return element;
	}

	public static WebElement btn_Save(WebDriver driver) {
		element = driver.findElement(By
				.xpath("//*[@id=\"message-edit\"]/div[3]/button[1]"));
		return element;
	}

	public static WebElement btn_Resend(WebDriver driver) {
		element = driver.findElement(By
				.xpath("//*[@id=\"message-edit\"]/div[3]/button[2]"));
		return element;
	}
}
