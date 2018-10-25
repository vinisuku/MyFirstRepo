package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	ContactsPageTest contactpagetest;
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	TestUtil testutil;
	
	public ContactsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException
	{
		initialization();
		testutil = new TestUtil();
		contactspage = new ContactsPage();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		testutil.swtichToFrame();
		contactspage = homepage.clickOnContactslink();
	}
	
	@Test
	public void verifyContactsPageLabel()
	{
		Assert.assertTrue(contactspage.verifyContactsLabel(),"Contacts label is missing on the page");
		
	}
	
	@Test(dataProvider="getData")
	public void verifyCreateContactTest(String title, String FirstName, String LastName, String Company) throws InterruptedException
	{
		homepage.clickOnNewContactLink();
		contactspage.createNewContact(title, FirstName, LastName,Company);
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object data[][] = TestUtil.getTestData("Sheet1");
		return data;
	}

	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
}
