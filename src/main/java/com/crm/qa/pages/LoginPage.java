package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{

	
	//Page Factory - OR:
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath=".//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(linkText="Sign Up")
	WebElement signupBtn;
	//Initializing the Page objects
	public LoginPage()
	{
		PageFactory.initElements(driver,this);
	}
	//Actions
	public String validateLoginPageTitle()
	{
		return driver.getTitle();	
	}
	 
	public HomePage login(String un, String pswd) throws InterruptedException
	{
		username.sendKeys(un);
		password.sendKeys(pswd);
		Thread.sleep(5000);
		loginBtn.click();
		return new HomePage();
	}
	
	
	
	
	
	
	
	
}
