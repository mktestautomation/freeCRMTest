package com.crm.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{

//Page Factory = Object Repository
	
	@FindBy(name="username")
	WebElement username;
	@FindBy(name="password")
	WebElement password;
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginBtn;
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement singUp;
	@FindBy(xpath="//img[@class='img-responsive']")
	WebElement crmLogo;

	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String validateTitle(){
		return driver.getTitle();
	}
	
	public boolean validateCRMLogo(){
		return crmLogo.isDisplayed();
	}
	public HomePage login(String un, String pwd){
		username.sendKeys(un);
//		password.sendKeys(pwd);
//		loginBtn.click();
		password.sendKeys(pwd + Keys.ENTER);
		return new HomePage();
	}
}
