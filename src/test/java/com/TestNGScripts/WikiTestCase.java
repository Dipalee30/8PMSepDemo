package com.TestNGScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WikiTestCase {

	
	//In TestNG your Test steps for test cases will be written as methods
	//all methods will be void in TestNG except for data driven
	//TestNG annotations to execute a test case
	//create a method as test case for create account in wikipage
	
	//A method used to perform Test Case is called a Test Method
	// if we have to execute a  test method,we will use a TestNG annotation called as @Test
	//Annotations will be written over the method name
	//Will execute this method in the bigining
   //for test cases to be executed in correct format or sequence, please give priority to test case 
	
	static WebDriver driver;
	
	//BeforeClass Annotation
	//A method which has before class annotation will get executed as the first method of the class...Only once
	
	@BeforeClass
	public void setup()
	{
System.setProperty("webdriver.chrome.driver","C:\\Users\\deeps\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		 driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		
		driver.get("https://en.wikipedia.org/w/index.php?title=Special:CreateAccount&returnto=Main+Page");
		
		
	}
	//@BeforeTest and  @Beforesuite---xml
	
	
	//A method with an annotation @BeforeMethod will get executed before every test method in the class
	@BeforeMethod
	public void login()
	{
		System.out.println("login into the application, enter user name and password");
	}
	
	
	//start Execution
     @Test(priority='1')
	public void createAccount() throws InterruptedException
	{
		//test steps to perform testcase goes here
		
    	 driver.findElement(By.name("wpName")).sendKeys("Username1");
    	 
    	 Thread.sleep(3000);

		driver.findElement(By.name("wpPassword")).sendKeys("Password1");
		
		driver.findElement(By.xpath("//*[@id=\"wpCreateaccount\"]")).click();
	}
	
	
	
	@Test(priority='2')
	public void MainPage()
	
	{
		driver.findElement(By.linkText("Main page")).click();	
		
		//To check if we have landed on the correct page or not
		
		System.out.println(driver.getTitle());
		
	}
	
	//this method will get executed after every test method
	@AfterMethod
	public void logout()
	{
		System.out.println("logout of the application.");
	}
	
	
	//close  my browser, close the server,close tabs
	//@AfterClass annotation is given that method which will be executed after all the test methods will get executed
	@AfterClass
	public void closebrowser()
	{
		driver.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
