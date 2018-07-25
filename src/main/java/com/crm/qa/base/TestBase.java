package com.crm.qa.base;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import java.io.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.crm.qa.util.TestUtil;

import org.openqa.selenium.edge.*;
public class TestBase {
	public static WebDriver driver;
	public static Properties pro;
	public TestBase()
	{
		try
		{
			FileInputStream input=new FileInputStream("C:\\Users\\Vaibhav\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			pro=new Properties();
			pro.load(input);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void initialize()
	{
		String browsername=pro.getProperty("browser");
	    if(browsername.equals("chrome"))
	    {
	    	System.setProperty("webdriver.chrome.driver","C:\\Geckodriver\\chromedriver.exe");
	    	driver=new ChromeDriver();
	    }
	    else if(browsername.equals("firefox"))
	    {
	    	System.setProperty("webdriver.gecko.driver", "C:\\Geckodriver\\geckodriver.exe");
	    	driver=new FirefoxDriver();
	    }
	    else
	    {
	    	System.setProperty("webdriver.edge.driver", "C:\\Geckodriver\\MicrosoftWebDriver.exe");
	    	driver=new InternetExplorerDriver();
	    }
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    //driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	    driver.get(pro.getProperty("url"));
	}

}
