package com.TestNGScripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utility.Xls_dataProvider;

public class ParametrizationwithPOI {

	
	WebDriver driver;
	
	
	//pass the name of data provide method as parameter to this test
	
	@BeforeClass

	public void startbrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\deeps\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://en.wikipedia.org/w/index.php?title=Special:CreateAccount&returnto=Special%3ASearch&returntoquery=search%3D%26go%3DGo");
	}
		@Test(dataProvider ="testdataxlsx")
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
		
	
	@DataProvider(name="testdataxlsx")
	public Object[][] readexcel() throws EncryptedDocumentException, IOException 
	{
		//provide the location of file
		FileInputStream f=new FileInputStream("F:\\QA Training\\SELENIUM\\input data apache.xlsx");
		
		//fetch the workbook from the location above
		
		Workbook book=WorkbookFactory.create(f);
		
		//fetch the sheet which has data
		
		Sheet s=book.getSheet("Sheet1");
		//fetch the Rows and Cols
		
		int rows=s.getLastRowNum();
		//fetch the coloumns
		int col=s.getRow(0).getLastCellNum();
		
		String input[][]=new String [rows][col];
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<col;j++)
			{
				input[i][j]=s.getRow(i+1).getCell(j).toString();
			}
		}
		return input;
	
		
		// instead of above DataProvider method we can automate that process by creating different class 
		//in an utility package
		
		/*@DataProvider(name="testdataxlsx"
		
		public Object[][] readExel2()
		{
			Object input[][]=Xls_dataProvider.getTestData("Sheet1")
		}
		return input;*/
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
