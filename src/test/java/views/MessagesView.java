package test.java.views;

import main.java.pom.messages.Message;
import main.java.pom.messages.Messages;
import main.java.pom.messages.Search;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import test.java.helpers.Constants;

public class MessagesView {
	public static void checkAgent(String search, int entries, WebDriver driver) {
		Search.label_Agent(driver).click();
		Reporter.log("Agents entries: " + Search.opts_Agent(driver).size(),
				Constants.LOG_TO_STD_OUT);
		Assert.assertEquals(Search.opts_Agent(driver).size(), entries);
		Search.opt_Agent(driver, search);
		Search.txt_fd_Agent(driver).sendKeys(search);
		Search.txt_fd_Agent(driver).sendKeys(Keys.ENTER);
	}

	public static void checkType(String search, int entries, WebDriver driver) {
		Search.label_Type(driver).click();
		Reporter.log("Types entries: " + Search.opts_Type(driver).size(),
				Constants.LOG_TO_STD_OUT);
		Assert.assertEquals(Search.opts_Type(driver).size(), entries);
		Search.opt_Type(driver, search);
		Search.txt_fd_Type(driver).sendKeys(search);
		Search.txt_fd_Type(driver).sendKeys(Keys.ENTER);
	}

	public static void checkCompany(String search, int entries, WebDriver driver) {
		Search.label_Company(driver).click();
		Reporter.log(
				"Companies entries: " + Search.opts_Company(driver).size(),
				Constants.LOG_TO_STD_OUT);
		Assert.assertEquals(Search.opts_Company(driver).size(), entries);
		Search.opt_Company(driver, search);
		Search.txt_fd_Company(driver).sendKeys(search);
		Search.txt_fd_Company(driver).sendKeys(Keys.ENTER);

	}

	public static void checkContact(String search, int entries, WebDriver driver) {
		Search.label_Contact(driver).click();
		Reporter.log("Contacts entries: " + Search.opts_Contact(driver).size(),
				Constants.LOG_TO_STD_OUT);
		Assert.assertEquals(Search.opts_Contact(driver).size(), entries);
		Search.opt_Contact(driver, search);
		Search.txt_fd_Contact(driver).sendKeys(search);
		Search.txt_fd_Contact(driver).sendKeys(Keys.ENTER);

	}

	public static void checkDataGrid(String search, int entries,
			WebDriver driver) {
		Reporter.log("Row entries: " + Messages.opts_MessageRow(driver).size(),
				Constants.LOG_TO_STD_OUT);
		Assert.assertEquals(Messages.opts_MessageRow(driver).size(), entries);

		Messages.check_All(driver).click();
		Messages.opt_MessageRow(driver, search).sendKeys(Keys.SPACE);
		Assert.assertEquals(Messages.check_MessageRow(driver, search)
				.isSelected(), false);
	}

	public static void sendMessage(WebDriver driver) {
		Message.txt_fd_Body(driver).sendKeys("This is body");
		Message.txt_fd_Cellphone(driver).sendKeys("159 399");
		Message.txt_fd_Company(driver).sendKeys("Bit Stackers");
		Message.txt_fd_Local(driver).sendKeys("+45");
		Message.txt_fd_Name(driver).sendKeys("Just testing");
		Message.txt_fd_Phone(driver).sendKeys("910416");
		Message.check_CallsBack(driver).click();
		Reporter.log("Send message confirmed.", Constants.LOG_TO_STD_OUT);

	}
}
