package test.java.views;

import java.util.List;

import main.java.pom.Helpers;
import main.java.pom.home.CompanyInfo;
import main.java.pom.home.ContactInfo;
import main.java.pom.home.Contacts;
import main.java.pom.home.Home;
import main.java.pom.home.Message;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import test.java.helpers.Constants;

public class HomeView {

	public static void checkElementsBeforeCall(WebDriver driver) {
		Helpers.waiting(2000);
		String welcome = Home.label_Welcome(driver).getText();
		Reporter.log("Welcome text is: " + welcome, Constants.LOG_TO_STD_OUT);
		Assert.assertEquals(welcome, "You've called....");

	}

	public static void selectingCompany(String companyName, WebDriver driver) {
		Helpers.waiting(500);
		List<WebElement> options = CompanyInfo.opts_Company(driver);
		Reporter.log(
				"Number of companies: " + Integer.toString(options.size()),
				Constants.LOG_TO_STD_OUT);
		for (WebElement opt : options) {
			Reporter.log(opt.getText() + " : " + opt.getText().length(),
					Constants.LOG_TO_STD_OUT);
			if (opt.getText().contains(companyName)) {
				opt.click();
				break;
			}
		}
		Helpers.waiting(500);
		String company = null;
		try {
			company = CompanyInfo.label_choosenCompany(driver).getText();
		} catch (NoSuchElementException e) {
			Reporter.log("You forgot to click, Anna. Again.",
					Constants.LOG_TO_STD_OUT);
			CompanyInfo.opt_Company(driver, companyName).click();
			company = CompanyInfo.label_choosenCompany(driver).getText();
		}
		Reporter.log("Company name is: " + company, Constants.LOG_TO_STD_OUT);
		Assert.assertEquals(company, companyName);
		String welcome = Home.label_Welcome(driver).getText();
		Reporter.log("Welcome text is: " + welcome, Constants.LOG_TO_STD_OUT);
		Assert.assertEquals(welcome, "Welcome to BitStackers, how may I help?");
	}

	public static void selectingContact(String contactName, WebDriver driver) {
		Assert.assertEquals(Contacts.opts_Contact(driver).size(), 7);
		Contacts.txt_fd_SearchContact(driver).sendKeys(contactName);
		Message.spn_showRecipients(driver).click();
		Boolean found = false;
		for (WebElement element : Message.opts_Recipients(driver)) {
			Reporter.log("Recipient: " + element.getText(),
					Constants.LOG_TO_STD_OUT);
			if (element.getText().contains(contactName))
				found = true;
		}
		Boolean shouldFound = true;
		Assert.assertEquals(found, shouldFound);

	}

	public static void checkCallQueue(int entries, WebDriver driver) {
		Reporter.log("Calls waiting: " + Home.opts_Queue(driver).size(),
				Constants.LOG_TO_STD_OUT);
		Assert.assertEquals(Home.opts_Queue(driver).size(), entries);

	}

	public static void checkMyCalls(int entries, WebDriver driver) {
		Reporter.log("My calls: " + Home.opts_Calls(driver).size(),
				Constants.LOG_TO_STD_OUT);
		Assert.assertEquals(Home.opts_Calls(driver).size(), entries);

	}

	public static void checkCalendar(int entries, WebDriver driver) {
		Reporter.log("Calendar entries: "
				+ CompanyInfo.opts_Calendar(driver).size(),
				Constants.LOG_TO_STD_OUT);
		Assert.assertEquals(CompanyInfo.opts_Calendar(driver).size(), entries);

	}

	public static void checkHandling(int entries, WebDriver driver) {
		Reporter.log("Handling entries: "
				+ CompanyInfo.opts_Commands(driver).size(),
				Constants.LOG_TO_STD_OUT);
		Assert.assertEquals(CompanyInfo.opts_Commands(driver).size(), entries);
	}

	public static void checkContactEvents(int entries, WebDriver driver) {
		Reporter.log("Event entries: "
				+ Contacts.opts_ContactEvents(driver).size(),
				Constants.LOG_TO_STD_OUT);
		Assert.assertEquals(Contacts.opts_ContactEvents(driver).size(), entries);
	}

	public static void checkHours(int i, WebDriver driver) {
		Reporter.log("Hours entries: " + Home.opts_Hours(driver).size(),
				Constants.LOG_TO_STD_OUT);
		Assert.assertEquals(Home.opts_Hours(driver).size(), i);
	}

	public static void checkSales(int i, WebDriver driver) {
		Reporter.log("Sales entries: " + Home.opts_Sales(driver).size(),
				Constants.LOG_TO_STD_OUT);
		Assert.assertEquals(Home.opts_Sales(driver).size(), i);
	}

	public static void checkContactInfo(WebDriver driver) {
		Assert.assertEquals(ContactInfo.opts_Department(driver).get(0)
				.getText(), "Development");
		Assert.assertEquals(ContactInfo.opts_Miscellaneous(driver).get(0)
				.getText(), "Yolk author");
		Assert.assertEquals(ContactInfo.opts_Title(driver).get(0).getText(),
				"Software Developer");
		Assert.assertEquals(
				ContactInfo.opts_Relations(driver).get(0).getText(),
				"Married to Trine Løcke");
		Assert.assertEquals(ContactInfo.opts_Responsibility(driver).get(0)
				.getText(), "Server og client development");
		Assert.assertEquals(ContactInfo.opts_Backup(driver).size(), 3);
		Assert.assertEquals(ContactInfo.opts_Emails(driver).size(), 2);
		Assert.assertEquals(ContactInfo.opts_Workhours(driver).size(), 2);
		Assert.assertEquals(ContactInfo.opts_Commands(driver).size(), 1);
		Assert.assertEquals(ContactInfo.opts_Phone(driver).get(0).getText(),
				"60431992");
		Reporter.log("Contact info confirmed.");

	}

	public static void sendMessage(WebDriver driver) {
		Message.txt_fd_Body(driver).sendKeys("This is body");
		Message.txt_fd_Cellphone(driver).sendKeys("159 399");
		Message.txt_fd_Company(driver).sendKeys("Bit Stackers");
		Message.txt_fd_Extension(driver).sendKeys("+45");
		Message.txt_fd_Name(driver).sendKeys("Just testing");
		Message.txt_fd_Phone(driver).sendKeys("910416");
		Message.check_CallsBack(driver).click();
		Reporter.log("Send message confirmed.");

	}

	public static void callSelectedPerson(WebDriver driver) {
		ShortcutsView.pickDirectNumber(driver);
		ShortcutsView.dial(driver);

	}

	public static void callNumber(WebDriver driver, String number) {
		ContactInfo.btn_Call(driver).click();
		ContactInfo.txt_fd_Call(driver).sendKeys(number);
		ShortcutsView.dial(driver);

	}

}
