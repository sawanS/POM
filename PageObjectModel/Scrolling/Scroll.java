package Scrolling;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scroll {

	public static void main(String[] args) throws Exception {


		
		System.setProperty("webdriver.chrome.driver", "F:\\Drivers\\chromedriver_win32 (7)\\chromedriver.exe");
		
		WebDriver driver= new ChromeDriver();
		driver.get("https://jqueryui.com/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		Thread.sleep(5000);
		
		//Scroll on the webpage
		((JavascriptExecutor)driver).executeScript("scroll(0,600)");
		
		
		// find no. of links present on the webpage
		
		List<WebElement> element = driver.findElements(By.tagName("a"));
		
		int sizeoflinks = element.size();
		System.out.println("Total Links present on the webpage:::"+sizeoflinks);
		
		System.out.println("TotalLinks are::");
		for(int i=0;i<sizeoflinks;i++)
		{
				String LinkText = element.get(i).getText();
				
				System.out.println(LinkText);
			
		}
		
		
		driver.close();
		driver.quit();
		
	}

}
