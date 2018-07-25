package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(),'User: Naveen K')]")
	WebElement username;
	
	@FindBy(xpath="//a[@title='Contacts']")
	WebElement contacts;
	
	@FindBy(linkText="New Contact")
	WebElement newcontacts;
	
	@FindBy(xpath="//tr/td[4]/a")
	WebElement logout;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyLoginTitle()
	{
		return driver.getTitle();
	}
	public boolean verifyUsername()
	{
		return username.isDisplayed();
	}
    public ContactsPage clickonContacts()
    {
    	driver.switchTo().frame("mainpanel");
    	contacts.click();
    	return new ContactsPage();
    }
    public void clickonNewContact()
    {
    	driver.switchTo().frame("mainpanel");
    	Actions action=new Actions(driver);
    	action.moveToElement(contacts).build().perform();
    	newcontacts.click();
    }
    public String clickonLogoutlink()
    {
    	driver.switchTo().frame("mainpanel");
    	logout.click();
    	return driver.getTitle();
    }
     
}
