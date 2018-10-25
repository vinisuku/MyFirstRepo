package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
public LoginPageTest()
{
	super();
}

@BeforeMethod
public void setup()
{
	initialization();
	loginpage = new LoginPage();
}


@Test (priority=1)
public void LoginPageTitleTest()
{
	String title = loginpage.validateLoginPageTitle();
	Assert.assertEquals(title,"#1 Free CRM software in the cloud for sales and service");
}

@Test (priority=0,dependsOnMethods="LoginPageTitleTest")
public void loginTest() throws InterruptedException
{
	homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	
}
	
@AfterMethod
public void teardown()
{
	driver.quit();
}




}
