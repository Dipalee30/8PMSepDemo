package com.TestNGScripts;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class TestDataExcel {
	
	WebDriver driver;
	
@BeforeClass

public void startbrowser()
{
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\deeps\\Downloads\\chromedriver_win32\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://en.wikipedia.org/w/index.php?title=Special:CreateAccount&returnto=Special%3ASearch&returntoquery=search%3D%26go%3DGo");
}
	@Test(dataProvider ="Testdata")
	public void wikipagedata(String name,String password,String retype,String email)
	{
		driver.findElement(By.id("wpName2")).clear();
		driver.findElement(By.id("wpName2")).sendKeys(name);
		driver.findElement(By.id("wpPassword2")).clear();
		driver.findElement(By.id("wpPassword2")).sendKeys(password);
		driver.findElement(By.id("wpRetype")).clear();
		driver.findElement(By.id("wpRetype")).sendKeys(retype);
		driver.findElement(By.id("wpEmail")).clear();
		driver.findElement(By.id("wpEmail")).sendKeys(email);
	}
	
	
	
    //DataProvider method : fetch data from the excel sheet and pass it on test method
	@DataProvider(name="Testdata")
	public Object[][] readExcel() throws BiffException, IOException
	{
		//f is the object storing the location
		File f=new File("F:\\QA Training\\SELENIUM\\input data for parameterization.xls");
		//fetch the excelfrom above provided location and store it an object
		//added a jxl jar file to my project
		//these classes are part of jxl
	     Workbook w= Workbook.getWorkbook(f);
	    		 
	   Sheet s= w.getSheet("Sheet1");	 
	    //number of rows in the sheet having data		 
	   int rows= s.getRows();
	   //number of columns in the sheet having data
	   int col= s.getColumns();
	   // go to each row.its each column and fetch the datafrom cell
	   //Create an array which is going to store all the values of rows and columns
	   
	   String inputdata[][]=new String[rows][col];
	  
	   //read the data
	   for(int i=0;i<rows;i++)
	   {
		   for(int j=0;j<col;j++) 
		   {
			   //fetch the data from each cell of that row
			  Cell c= s.getCell(j,i);
			  //once you have the cell value fetch the contents
			  inputdata[i][j]=c.getContents();
			  
		   }
	   }
		   
		 return inputdata;  
		   
		   
		   
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
