package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Anna on 2015-04-13.
 */
public class Home {

    private static WebElement element = null;

    public static WebElement btn_Confirm(WebDriver driver) {
        element = driver.findElement(By.id("confirm"));
        return element;
    }
}
