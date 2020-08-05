package com.facebook.pages;


import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.facebook.base.TestBase;

public class Login extends TestBase {

	/*By username = By.xpath("//*[@id='email']");
	By Password = By.cssSelector("#pass");
	By submitbutton = By.cssSelector("#u_0_b");*/
	
	
	//Using PageFactory method
	@FindBy(xpath="//*[@id='email']") WebElement user;
	@FindBy(css="#pass") WebElement Password1;
	@FindBy(css="#u_0_b") WebElement submit;
	@FindBy(tagName ="a") List<WebElement> links;
	@FindBy(id="day") WebElement Dropdownvalue;
	
	
	
	
	public Login()  
	{
		
		PageFactory.initElements(driver, this); //this method is used to initilize the page factory elements.
	}


	// Method for Login in Facebook
	public void LoginDetails(String un, String Pass)
	{
		/*driver.findElement(username).sendKeys(User);
		driver.findElement(Password).sendKeys(Pass);
		driver.findElement(submitbutton).click();*/
		
		user.sendKeys(un);
		Password1.sendKeys(Pass);
		submit.click();

	}

	//getting the title of the webpage
	public String validateLoginPageTitle()
	{
		 return driver.getTitle();
	}

	//find all the links on the webpage
	public void allLinks()
	{
		int size = links.size();
		for(int i=0;i<size;i++)
		{
			String text = links.get(i).getText();
			System.out.println("Links are::"+text);
		}
	}
	
	
	public void dropdown() throws Exception
	{
		Dropdownvalue.click(); //click on the dropdown
		
		
		Select select = new Select(Dropdownvalue);
		select.selectByIndex(10);
		
		Thread.sleep(4000);
		
		select.selectByVisibleText("12");
		Thread.sleep(4000);
			
		System.out.println("The value of dropdown is::"+select);
		
	}
	
	
	
}
