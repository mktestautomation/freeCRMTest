package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	//Page Factory
	
	@FindBy(xpath="//td[contains(text(),'User: Mahesh K')]")
	WebElement usernameValue;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;

	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'New Deal')]")
	WebElement newDealLink;

	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	public boolean verifyUserName() {
		return usernameValue.isDisplayed();
	}
	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}

	public ContactsPage clickOnNewContactsLink() {
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
		return new ContactsPage();
	}
	
	
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	public TasksPage clickOnTasksLink() {
		tasksLink.click();
		return new TasksPage();
		
	}
	
	
	
	
}
