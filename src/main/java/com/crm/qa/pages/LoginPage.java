package com.crm.qa.pages;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;

import com.crm.qa.base.*;

public class LoginPage extends TestBase {
	@FindBy(name="username")
	WebElement username;
    
	@FindBy(name="password")
    WebElement password;
    
	@FindBy(xpath="//input[@type='submit']")
    WebElement loginbtn;
    
	@FindBy(xpath="//button[@class='btn']")
    WebElement signup;
	
	@FindBy(xpath="//*[@id=\"navbar-collapse\"]/ul/li[2]/a")
	WebElement signuplink;
    
	@FindBy(xpath="//img[@class='img-responsive']")
    WebElement freecrmlogo;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	public String validateLoginTitle()
	{
		return driver.getTitle();
	}
	public boolean validatecrmlogo()
	{
		return freecrmlogo.isDisplayed();
	}
	public HomePage login(String un,String pwd)
	{
		
		username.sendKeys(un);
		password.sendKeys(pwd);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", loginbtn);
		return new HomePage();
	}
	public SignupPage clickonSignup()
	{
		String signuptext=signup.getText();
		if(signuptext.equals("Sign Up"))
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click()", signup);
		}
		return new SignupPage();
	}
	public SignupPage clickonSignuplink()
	{
		String signuptext=signuplink.getText();
		if(signuptext.equals("Sign Up") && signuplink.isDisplayed())
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click()", signuplink);
		}
		return new SignupPage();
	}
}
