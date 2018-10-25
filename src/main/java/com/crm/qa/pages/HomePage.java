package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath=".//td[contains(text(),'User: vineela SUKHAVASI')]")
	WebElement loggedinName;
	
	@FindBy(xpath=".//a[contains(text(),'Contacts')]")
	WebElement contacts;
	
	@FindBy(xpath=".//a[contains(text(),'Deals')]")
	WebElement deals;
	
	@FindBy(xpath=".//a[contains(text(),'Tasks')]")
	WebElement tasks;
	
	@FindBy(xpath=".//a[contains(text(),'New Contact')]")
	WebElement newContact;
	
	public HomePage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public ContactsPage clickOnContactslink()
	{
		contacts.click();
		return new ContactsPage();
	}
	
	public DealsPage clickonDealslink()
	{
		deals.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTaskslink()
	{
		tasks.click();
		return new TasksPage();
	}

	public boolean verifyUserName()
	{
		return loggedinName.isDisplayed();
	}
	
	public void clickOnNewContactLink() throws InterruptedException
	{
		Actions action = new Actions(driver);
		Thread.sleep(3000);
		action.moveToElement(contacts).build().perform();
		newContact.click();
	}
	
	
	
}



