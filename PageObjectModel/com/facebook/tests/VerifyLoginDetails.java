package com.facebook.tests;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.facebook.pages.Login;



public class VerifyLoginDetails extends Login {
	
		  Login login;
			
			public VerifyLoginDetails() throws Exception
			{
				super();
			}
			
	
			@BeforeMethod
			public void setup()
			{	
				initialization();// calling initilization method from the Login class
				login = new Login();
			}
	
			
			@Test(enabled=false)

			public void loginDetails()
			{
				login.LoginDetails(prop.getProperty("username"),prop.getProperty("password")); //Calling loginDetails method from Login class
			}
			
			
			@Test(enabled=false)

			public void titleValidation()
			{
				String title= login.validateLoginPageTitle();
				Assert.assertEquals(title, "Facebook – log in or sign up");
			}
			
			@Test(enabled=false)
			public void linksPresent()
			{
				login.allLinks();
				
			}
			
			
			@Test
			public void checkDropDownValues() throws Exception
			{	
				login.dropdown();
			}
			
			
			
			
			
			@AfterMethod
			public void closebrowser()
			{
			driver.quit();
			}
		
		
		
	}
		
	

