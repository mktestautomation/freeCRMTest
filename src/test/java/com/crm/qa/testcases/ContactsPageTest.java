/**
 * TEST COMMENT
* */

package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	TestUtil testUtil;
	String sheetName = "contacts";
	
	
	public ContactsPageTest() {
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
		testUtil.switchToUtilMain();
		contactsPage = homePage.clickOnContactsLink();
	}
	
	
	@Test(priority=1)
	public void verifyContactsLabelTest() {
		Assert.assertTrue(contactsPage.verifyContactsLabel(),"Contacts Lable missing");
	}
	@Test(priority=2)
	public void selectContactsTest() {
		contactsPage.selectContacts("test wel");
//		contactsPage.selectContacts("big boss");
		
	}
	

	@DataProvider
	public Object[][] getCRMTestData() {
			Object data[][] = TestUtil.getTestData(sheetName);
			return data;
			
	}
	
	@Test(priority=3, dataProvider="getCRMTestData")
	public void clickOnNewContactsTest(String title, String fName, String mName, String sName, String ssuffix, String nName, String clientName) {
		homePage.clickOnNewContactsLink();
		contactsPage.createNewContact(title, fName, mName, sName, ssuffix, nName, clientName);
	}
	
	
	
	@AfterMethod
	public  void teamDown(){
		driver.quit();
	}
	
}
