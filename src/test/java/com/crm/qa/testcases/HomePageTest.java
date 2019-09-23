package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	TestUtil testUtil;
	
	
	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		dealsPage = new DealsPage();
		homePage = new HomePage();
		testUtil = new TestUtil();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String homepagetitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homepagetitle, "CRMPRO - CRM software for customer relationship management, sales, and support.","HomePage title Not Matched");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest() {
		testUtil.switchToUtilMain();
		boolean verifyusername = homePage.verifyUserName();
		Assert.assertTrue(verifyusername);
	}

	@Test(priority=3)
	public void clickOnContactsLinkTest() {
		testUtil.switchToUtilMain();
		contactsPage = homePage.clickOnContactsLink();	
	}

	@Test(priority=4)
	public void clickOnDealsLinkTest() {
		testUtil.switchToUtilMain();
		dealsPage = homePage.clickOnDealsLink();
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	
	
}
