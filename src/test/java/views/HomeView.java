package test.java.views;

import java.util.List;

import main.java.pom.Helpers;
import main.java.pom.home.CompanyInfo;
import main.java.pom.home.ContactInfo;
import main.java.pom.home.Contacts;
import main.java.pom.home.Home;
import main.java.pom.home.Message;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import test.java.helpers.Constants;
import test.java.helpers.Shortcuts;

public class HomeView {

	public static void getReady(WebDriver driver) {
		// Home.Root(driver).click();
		Actions action = new Actions(driver);
		action.sendKeys(Shortcuts.GET_READY).build();
	}

	public static void checkElementsBeforeCall(WebDriver driver) {
		Helpers.wait(5000);
		String welcome = Home.label_Welcome(driver).getText();
		System.out.println("Welcome text is: " + welcome);
		Assert.assertEquals(welcome, "Ikke i kald");
		// java.lang.AssertionError: expected [] but found [Ikke i kald]
		Helpers.wait(5000);
		String company = CompanyInfo.label_Company(driver).getText();
		Assert.assertEquals(company, "Søg efter en virksomhed");
		Helpers.wait(5000);
		System.out.println("Company name is: " + company);
	}

	public static void selectingCompany(String companyName, WebDriver driver) {
		Helpers.wait(5000);
		CompanyInfo.label_Company(driver).click();
		List<WebElement> options = CompanyInfo.opts_Company(driver);
		System.out.println(options.size());
		for (WebElement opt : options) {
			System.out.println(opt.getText() + " : " + opt.getText().length());
			if (opt.getText().equals(companyName)) {
				opt.click();
				break;
			}
		}

		String company = CompanyInfo.label_Company(driver).getText();
		System.out.println("Company name is: " + company);
		Assert.assertEquals(company, companyName);
		Helpers.wait(5000);
		String welcome = Home.label_Welcome(driver).getText();
		System.out.println("Welcome text is: " + welcome);
		Assert.assertEquals(welcome,
				"Velkommen til BitStackers, hvad kan jeg hjælpe med?");
	}

	public static void selectingContact(String contactName, WebDriver driver) {
		Assert.assertEquals(Contacts.opts_Contact(driver).size(), 7);
		Contacts.txt_fd_SearchContact(driver).sendKeys(contactName);
		// Home.txt_fd_SearchContact(driver).sendKeys(Keys.ARROW_DOWN);
		System.out.println("Recipient: "
				+ Message.spn_RecipientTo(driver).getText());
		Assert.assertEquals(Message.spn_RecipientTo(driver).getText(),
				contactName);

	}

	public static void checkCalendar(int entries, WebDriver driver) {
		System.out.println("Calendar entries: "
				+ CompanyInfo.opts_Calendar(driver).size());
		Assert.assertEquals(CompanyInfo.opts_Calendar(driver).size(), entries);

	}

	public static void checkHandling(int entries, WebDriver driver) {
		System.out.println("Handling entries: "
				+ CompanyInfo.opts_Handling(driver).size());
		Assert.assertEquals(CompanyInfo.opts_Handling(driver).size(), entries);
	}

	public static void checkContactEvents(int entries, WebDriver driver) {
		System.out.println("Event entries: "
				+ Contacts.opts_ContactEvents(driver).size());
		Assert.assertEquals(Contacts.opts_ContactEvents(driver).size(), entries);
	}

	public static void checkHours(int i, WebDriver driver) {
		System.out.println("Hours entries: " + Home.opts_Hours(driver).size());
		Assert.assertEquals(Home.opts_Hours(driver).size(), i);
	}

	public static void checkSales(int i, WebDriver driver) {
		System.out.println("Sales entries: " + Home.opts_Sales(driver).size());
		Assert.assertEquals(Home.opts_Sales(driver).size(), i);
	}

	public static void checkAddress(int i, WebDriver driver) {
		System.out.println("Address entries: "
				+ Home.opts_Address(driver).size());
		Assert.assertEquals(Home.opts_Address(driver).size(), i);
	}

	public static void checkContactInfo(WebDriver driver) {
		Assert.assertEquals(ContactInfo.label_Department(driver).getText(),
				"Development");
		Assert.assertEquals(ContactInfo.label_AdditionalInfo(driver).getText(),
				"Yolk forfatter");
		Assert.assertEquals(ContactInfo.label_Position(driver).getText(),
				"Softwareudvikler");
		Assert.assertEquals(ContactInfo.label_Relations(driver).getText(),
				"Gift med Trine Løcke");
		Assert.assertEquals(ContactInfo.label_Responsibility(driver).getText(),
				"Server og klient udvikling");
		Assert.assertEquals(ContactInfo.opts_Backup(driver).size(), 2);
		Assert.assertEquals(ContactInfo.opts_Emails(driver).size(), 1);
		Assert.assertEquals(ContactInfo.opts_Workhours(driver).size(), 2);
		Assert.assertEquals(ContactInfo.opts_Handling(driver).size(), 1);
		Assert.assertEquals(ContactInfo.btn_Phone(driver).getText(), "60431992");
		System.out.println("Contact info confirmed.");

	}

	public static void sendMessage(WebDriver driver) {
		Message.txt_fd_Body(driver).sendKeys("This is body");
		Message.txt_fd_Cellphone(driver).sendKeys("159 399");
		Message.txt_fd_Company(driver).sendKeys("Bit Stackers");
		Message.txt_fd_Local(driver).sendKeys("+45");
		Message.txt_fd_Name(driver).sendKeys("Just testing");
		Message.txt_fd_Phone(driver).sendKeys("910416");
		Message.check_CallsBack(driver).click();
		System.out.println("Send message confirmed.");

	}

	public static void callPerson(String employee, WebDriver driver) {
		// Contacts.txt_fd_SearchContact(driver).sendKeys(employee);
		// Contacts.txt_fd_SearchContact(driver).sendKeys(Shortcuts.SELECT_1_NR);

		Home.txt_fd_Call(driver).sendKeys(
				Constants.NUMBERS.get(Constants.DEFAULT_EMPLOYEE_1));

		Contacts.txt_fd_SearchContact(driver).sendKeys(Shortcuts.HOLD);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("Yep, the sleeping failed");
			e.printStackTrace();
		}
		Home.btn_Call(driver).click();
	}

	public static void transferCall(WebDriver driver) {
		Contacts.txt_fd_SearchContact(driver).sendKeys(Shortcuts.TRANSFER);

	}

	public static void pickUpCall(WebDriver driver) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("Yep, the sleeping failed");
			e.printStackTrace();
		}
		Home.btns_Pickup(driver).get(0).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("Yep, the sleeping failed");
			e.printStackTrace();
		}
	}
}
