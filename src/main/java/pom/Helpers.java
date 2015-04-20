package main.java.pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

/**
 * Created by Anna on 2015-04-20.
 */
public class Helpers {

	public static void wait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

	}
}
