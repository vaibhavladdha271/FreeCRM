package com.crm.qa.tests;
import org.testng.Assert;
import org.testng.annotations.*;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
public class HomePageTest extends TestBase {

	HomePage homepage;
	LoginPage loginpage;
	ContactsPage contactspage;
	public HomePageTest()
	{
		super();
	}
	@BeforeMethod
	public void setup()
	{
		initialize();
		loginpage=new LoginPage();
		homepage=loginpage.login(pro.getProperty("username"), pro.getProperty("password"));
	}
	@Test(priority=1)
	public void verifyhomepagetitle()
	{
		String actualtitle="CRMPRO";
		Assert.assertEquals(actualtitle,homepage.verifyLoginTitle());
	}
	@Test(priority=2,enabled=false)
	public void verifyusername()
	{
		String actualtitle="User: Naveen K";
		Assert.assertEquals(actualtitle,homepage.verifyUsername());
	}
	@Test(priority=3,enabled=false)
	public void clickonContactsLink()
	{
		contactspage=homepage.clickonContacts();
	}
	@Test(priority=4,enabled=false)
	public void clickonNewContactslink()
	{
		homepage.clickonNewContact();
	}
	@Test(priority=5)
	public void clickonLogout()
	{
		String actualtitle=homepage.clickonLogoutlink();
		String expectedtitle="Free CRM software in the cloud powers sales and customer service";
		Assert.assertEquals(actualtitle,expectedtitle);
		
	}
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
