package com.TestNGScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnnotationsTestNG {

	//Methods with @Test Annotations are reffered as Test methods
	//@Test : it is used when we want to execute a Test method
	//@Test(priority='1'): used to prioritize your test case 
	//@BeforeMethod : This Annotation repersents that the method will get executed before every test method in the class
	//@AfterMethod : this Annotation represents that the method will get executed after every test method in the class
	//@BeforeClass : this Annotation represents that the method will get executed before any test method in the class.
	//                And this method will get executed only once.
	//@AfterClass : this Annotation represents that the method will get executed after all the test method,beforemethod,aftermethods are executed  in the class.
	//                And this method will get executed only once.
	
	@BeforeSuite
	public void suiteTest()
	{
		System.out.println("This method will be executed before the suite begins");
	}
	@BeforeTest 
	//This method will be executed before every tests in your xml file
	public void exampletest()
	{
		System.out.println("This method will be executed before the test begins");
	}
	
	@BeforeClass
     public void login()
	{
		System.out.println("Script to login into the appliction");
	}
	
	
	@BeforeMethod
    public void Timeouts()
	{
		System.out.println("write steps to implicit wait");
	}
	
	@Test(priority='1')
    public void createCust()
	{
		System.out.println("Script to create a customer details");
	}
	
	@Test(priority='2')
    public void searchCust()
	{
		System.out.println("Script to Search Customer in the application");
	}
	
	@Test(priority='3')
    public void deleteCust()
	{
		System.out.println("Script to delete Customer in the application");
	
	}
	
	@AfterMethod
     public void cookiesdel()
	{
		//for eg. screenshot to be taken for each test method
		System.out.println("Script to delete the cookeiesfrom the browser");
	
	}
	
	
	@AfterClass
    public void logout()
	{
		System.out.println("Script to logout of the application and close the browser");
	
	}
	
	
	
}
