package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	@CacheLookup
	WebElement contacts;
	
	@FindBy(id="first_name")
	@CacheLookup
	WebElement firstName;
	
	@FindBy(id="surname")
	@CacheLookup
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	@CacheLookup
	WebElement company;
	
	@FindBy(xpath=".//input[@type='submit' and @value='Save']")
	@CacheLookup
	WebElement save;
	
	
	public ContactsPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public boolean verifyContactsLabel()
	{
		return contacts.isDisplayed();
	}
	
	public void createNewContact(String title,String ftName, String ltName, String comp) throws InterruptedException
	{
	Thread.sleep(3000);
	Select s= new Select(driver.findElement(By.name("title")));
	s.selectByVisibleText(title);
	firstName.sendKeys(ftName);
	lastName.sendKeys(ltName);
	company.sendKeys(comp);
	save.click();
	}

}
