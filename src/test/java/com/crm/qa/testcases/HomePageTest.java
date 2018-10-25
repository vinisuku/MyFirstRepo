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
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	DealsPage dealspage;
	TestUtil testUtil;

		public HomePageTest()
		{
			super();
		}

@BeforeMethod
public void setup() throws InterruptedException
{
	initialization();
	testUtil = new TestUtil();
	loginpage = new LoginPage();
	homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));	
}
@Test(priority=0)
public void verifyhomePageTitleTest()
{
	
	String title = homepage.verifyHomePageTitle();
	Assert.assertEquals(title,"CRMPRO","Home Page title NOT Match");
}

@Test(priority=1)
public void verifyUserName()
{
	testUtil.swtichToFrame();
	Assert.assertTrue(homepage.verifyUserName());
}

@Test(priority=2)
public void verifyClickOnContactsLink()
{
	testUtil.swtichToFrame();
	contactspage = homepage.clickOnContactslink();
}

@Test(priority=3)
public void verifyClickonDealsLink()
{
	testUtil.swtichToFrame();
	dealspage = homepage.clickonDealslink();
}
@AfterMethod
public void teardown()
{
	driver.quit();
}

}



