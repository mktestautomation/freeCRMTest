package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(xpath="//input[name='cs_submit')]")
	WebElement searchButton;

	@FindBy(name="title") 	//select[@name="title"]
	WebElement selectTitle;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="middle_initial")
	WebElement middleName;

	@FindBy(id="surname")
	WebElement surName;
	
	@FindBy(name="suffix")
	WebElement selectSuffix;
	
	@FindBy(name="nickname")
	WebElement nickName;
	
	@FindBy(name="client_lookup")
	WebElement clientLookup;
	
 	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement btnSave;
	
	
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}

	public boolean verifySearchButton() {
		return searchButton.isDisplayed();
	}

	public void selectContacts(String name) {
		driver.findElement(By.xpath("//a[text()='" + name + "']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	
	public void createNewContact(String title, String fName, String mName, String sName, String ssuffix, String nName, String clientName) {
		Select select1 = new Select(selectTitle);
		select1.selectByVisibleText(title);
		firstName.sendKeys(fName);
		middleName.sendKeys(mName);
		surName.sendKeys(sName);

		Select select2 = new Select(selectSuffix);
		select2.selectByVisibleText(ssuffix);
		nickName.sendKeys(nName);
		clientLookup.sendKeys(clientName);

		btnSave.click();
	}
	
}
