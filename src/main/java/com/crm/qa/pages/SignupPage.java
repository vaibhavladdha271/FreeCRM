package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.util.*;

import com.crm.qa.base.TestBase;

public class SignupPage extends TestBase {

     @FindBy(name="first_name")
     WebElement firstname;
     
     @FindBy(id="payment_plan_id")
     WebElement edition;
     
     @FindBy(id="editionText")
     WebElement editiontext;
     
     @FindBy(name="surname")
     WebElement lastname;
     
     @FindBy(name="email")
     WebElement email;
     
     @FindBy(name="email_confirm")
     WebElement confirmemail;
     
     @FindBy(name="username")
     WebElement username;
     
     @FindBy(name="password")
     WebElement password;
     
     @FindBy(name="passwordconfirm")
     WebElement confirmpassword;
     
     @FindBy(name="agreeTerms")
     WebElement checkbox;
     
     @FindBy(linkText="terms and conditions")
     WebElement conditionslink;

     @FindBy(id="submitButton")
     WebElement submitbtn;
     
     public SignupPage()
     {
    	 PageFactory.initElements(driver, this);
     }
     public String verifypagetitle()
     {
    	 return driver.getTitle();
     }
     public void submitform()
     {
    	Select select=new Select(edition);
    	List<WebElement> editionoptions=select.getOptions();
    	for(int i=0;i<editionoptions.size();i++)
    	{
    		String s=editionoptions.get(i).getText();
    		if(s.equals("Free Edition"))
    		select.selectByIndex(i);
    	}
    	firstname.sendKeys("Vaibhav");
    	lastname.sendKeys("Laddha");
    	email.sendKeys("vaibhavladdha271@gmail.com");
    	password.sendKeys("becomp4367");
    	confirmpassword.sendKeys("becomp4367");
    	username.sendKeys("vladdha");
    	selectcheckbox();
     }
     public void selectcheckbox()
     {
    	 if(checkbox.isEnabled()&& !(checkbox.isSelected()))
    		 checkbox.click();
     }
     public String clickontermsandconditionslink()
     {
    	 conditionslink.click();
    	 return driver.getTitle();
     }
     
     

}
