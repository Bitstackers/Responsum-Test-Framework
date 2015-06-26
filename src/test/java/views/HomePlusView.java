package test.java.views;

import main.java.pom.homeplus.HomePlus;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import test.java.helpers.Constants;

public class HomePlusView {

	public static void checkEmails(int entries, WebDriver driver) {
		Reporter.log("Emails entries: " + HomePlus.opts_Emails(driver).size(),
				Constants.LOG_TO_STD_OUT);
		Assert.assertEquals(HomePlus.opts_Emails(driver).size(), entries);

	}

	public static void checkNames(int entries, WebDriver driver) {
		Reporter.log("Names entries: " + HomePlus.opts_AltNames(driver).size(),
				Constants.LOG_TO_STD_OUT);
		Assert.assertEquals(HomePlus.opts_AltNames(driver).size(), entries);

	}

	public static void checkWebsites(int entries, WebDriver driver) {
		Reporter.log("Websites entries: "
				+ HomePlus.opts_Websites(driver).size(),
				Constants.LOG_TO_STD_OUT);
		Assert.assertEquals(HomePlus.opts_Websites(driver).size(), entries);

	}

	public static void checkNumbers(int entries, WebDriver driver) {
		Reporter.log("Numbers entries: "
				+ HomePlus.opts_TelNumbers(driver).size(),
				Constants.LOG_TO_STD_OUT);
		Assert.assertEquals(HomePlus.opts_TelNumbers(driver).size(), entries);

	}

	public static void checkBanks(int entries, WebDriver driver) {
		Reporter.log("Banks entries: " + HomePlus.opts_BankInfo(driver).size(),
				Constants.LOG_TO_STD_OUT);
		Assert.assertEquals(HomePlus.opts_BankInfo(driver).size(), entries);

	}

	public static void checkCVRs(int entries, WebDriver driver) {
		Reporter.log(
				"CVRs entries: " + HomePlus.opts_VATNumbers(driver).size(),
				Constants.LOG_TO_STD_OUT);
		Assert.assertEquals(HomePlus.opts_VATNumbers(driver).size(), entries);

	}
}
