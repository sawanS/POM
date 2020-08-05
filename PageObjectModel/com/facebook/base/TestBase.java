package com.facebook.base;

import java.io.FileInputStream;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class TestBase 
{

	public static WebDriver driver;
	public static Properties prop;
	

		//How to read properties file
		public TestBase()
		{
			try{
				
				prop = new Properties();
				FileInputStream ip = new FileInputStream("F:\\New folder\\PageObjectModelWithPageFactory\\PageObjectModel\\qa\\facebook\\config\\config.properties");
				prop.load(ip);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		
		}

		
		public void initialization()
		{
			
		String browserName = prop.getProperty("browser"); // getting the browsername from config.properties file
		
		// Intializing the chrome browser
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "F:\\Drivers\\chromedriver_win32 (Updated)\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else
		{
			System.out.println("No browser found");
		}
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
		}
}
	







