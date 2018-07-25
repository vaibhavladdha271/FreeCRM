package com.crm.qa.tests;
import org.testng.Assert;
import org.testng.annotations.*;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.SignupPage;

public class SignupPageTest extends TestBase {
	
	SignupPage signuppage;
	LoginPage loginpage;
	@BeforeMethod
	public void setup()
	{
		initialize();
		loginpage=new LoginPage();
		signuppage=loginpage.clickonSignup();
		signuppage=loginpage.clickonSignuplink();
	}
	
	@Test(priority=1)
	public void verifyPageTitle()
	{
		String actualtitle="CRMPRO - CRM Pro for customer relationship management, sales, and support";
		String expectedtitle=signuppage.verifypagetitle();
		Assert.assertEquals(expectedtitle, actualtitle);
	}
	@Test(priority=2)
	public void fillform()
	{
		signuppage.submitform();
	}
	@Test(priority=3)
	public void clickontermsandconditions()
	{
		String actualtitle=signuppage.clickontermsandconditionslink();
		String expectedtitle="FreeCRM terms";
		Assert.assertEquals(actualtitle,expectedtitle);
	}
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
