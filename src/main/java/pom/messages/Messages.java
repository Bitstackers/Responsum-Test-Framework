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

}
