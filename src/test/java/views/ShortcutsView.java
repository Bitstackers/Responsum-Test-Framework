package test.java.views;

import main.java.pom.home.Home;

import org.openqa.selenium.WebDriver;

import test.java.helpers.Shortcuts;

public class ShortcutsView {

	public static void getReady(WebDriver driver) {
		Home.Root(driver).sendKeys(Shortcuts.GET_READY);
	}

	public static void switchToHomePlusContext(WebDriver driver) {
		Home.Root(driver).sendKeys(Shortcuts.HOME_PLUS);
	}

	public static void switchToHomeContext(WebDriver driver) {
		Home.Root(driver).sendKeys(Shortcuts.HOME);
	}

	public static void pickup(WebDriver driver) {
		Home.Root(driver).sendKeys(Shortcuts.PICKUP);
	}

	public static void dial(WebDriver driver) {
		Home.Root(driver).sendKeys(Shortcuts.DIAL);
	}

	public static void transfer(WebDriver driver) {
		Home.Root(driver).sendKeys(Shortcuts.TRANSFER);
	}

	public static void park(WebDriver driver) {
		Home.Root(driver).sendKeys(Shortcuts.PARK);
	}

	public static void hangup(WebDriver driver) {
		Home.Root(driver).sendKeys(Shortcuts.HANGUP);
	}

	public static void switchToCompanyCalendar(WebDriver driver) {
		Home.Root(driver).sendKeys(Shortcuts.EVENTS_BOX);
	}

	public static void switchToContactCalendar(WebDriver driver) {
		Home.Root(driver).sendKeys(Shortcuts.CALENDAR_BOX);
	}

	public static void pickDirectNumber(WebDriver driver) {
		Home.Root(driver).sendKeys(Shortcuts.DIRECT_NO);
	}

	public static void pickMobileNumber(WebDriver driver) {
		Home.Root(driver).sendKeys(Shortcuts.MOBILE_NO);
	}

	public static void switchToCompany(WebDriver driver) {
		Home.Root(driver).sendKeys(Shortcuts.COMPANY_BOX);
	}

	public static void switchToSearch(WebDriver driver) {
		Home.Root(driver).sendKeys(Shortcuts.SEARCH_CONTACT);
	}

	public static void cancel(WebDriver driver) {
		Home.Root(driver).sendKeys(Shortcuts.CANCEL);
	}

	public static void send(WebDriver driver) {
		Home.Root(driver).sendKeys(Shortcuts.CONFIRM);
	}

}
