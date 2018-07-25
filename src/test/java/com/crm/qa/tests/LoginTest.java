package com.crm.qa.tests;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.base.TestBase;

import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest extends TestBase {

	LoginPage page;
	HomePage homepage;
	public LoginTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialize();
		page=new LoginPage();
		
	}
	@Test(priority=1,enabled=false)
	public void LoginPageTitleTest()
	{
	    String title=page.validateLoginTitle();
	    Assert.assertEquals(title,"Free CRM software in the cloud powers sales and customer service");
	}
	@Test(priority=2,enabled=false)
	public void LoginPageLogoTest()
	{
		boolean logo=page.validatecrmlogo();
		Assert.assertEquals(logo, true);
	}
	@Test(priority=3,enabled=false)
	public void Testlogin()
	{
		page.login(pro.getProperty("username"),pro.getProperty("password"));
	}
	@Test(priority=4)
	public void clickonSignup()
	{
		page.clickonSignup();
	}
	@Test(priority=5)
	public void clickonSignuplink()
	{
		page.clickonSignuplink();
	}
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

	
	
}
