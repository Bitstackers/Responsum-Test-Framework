package test.java.common;

import main.java.pom.homeplus.HomePlus;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePlusView {

	public static void checkEmails(int entries, WebDriver driver) {
		System.out.println("Emails entries: "
				+ HomePlus.opts_Emails(driver).size());
		Assert.assertEquals(HomePlus.opts_Emails(driver).size(), entries);

	}

	public static void checkNames(int entries, WebDriver driver) {
		System.out.println("Names entries: "
				+ HomePlus.opts_AltNames(driver).size());
		Assert.assertEquals(HomePlus.opts_AltNames(driver).size(), entries);

	}

	public static void checkWebsites(int entries, WebDriver driver) {
		System.out.println("Websites entries: "
				+ HomePlus.opts_Websites(driver).size());
		Assert.assertEquals(HomePlus.opts_Websites(driver).size(), entries);

	}

	public static void checkNumbers(int entries, WebDriver driver) {
		System.out.println("Numbers entries: "
				+ HomePlus.opts_TelNumbers(driver).size());
		Assert.assertEquals(HomePlus.opts_TelNumbers(driver).size(), entries);

	}

	public static void checkBanks(int entries, WebDriver driver) {
		System.out.println("Banks entries: "
				+ HomePlus.opts_BankInfo(driver).size());
		Assert.assertEquals(HomePlus.opts_BankInfo(driver).size(), entries);

	}

	public static void checkCVRs(int entries, WebDriver driver) {
		System.out.println("CVRs entries: "
				+ HomePlus.opts_CVRNumbers(driver).size());
		Assert.assertEquals(HomePlus.opts_CVRNumbers(driver).size(), entries);

	}
}
