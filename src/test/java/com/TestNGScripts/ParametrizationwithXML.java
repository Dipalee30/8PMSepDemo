package com.TestNGScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametrizationwithXML {

	
	public static WebDriver driver;
	
	@BeforeClass
	
	public static void setup()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\deeps\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		 driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		
		driver.get("https://en.wikipedia.org/w/index.php?title=Special:CreateAccount&returnto=Main+Page");
		
	}
	
	@Parameters({"Uname","Pword"})
	
	@Test
	public void createAccount(String Uname,String Pword) throws InterruptedException
	{
		//test steps to perform testcase goes here
		
   	 driver.findElement(By.name("wpName")).sendKeys(Uname);
   	 
   	 Thread.sleep(3000);

		driver.findElement(By.name("wpPassword")).sendKeys(Pword);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id=\"wpCreateaccount\"]")).click();
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
	}
	
	
	
	
		
	
}
