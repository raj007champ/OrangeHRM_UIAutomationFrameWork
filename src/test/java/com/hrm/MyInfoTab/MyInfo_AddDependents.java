package com.hrm.MyInfoTab;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hrm.base.TestBase;
import com.hrm.pages.DashboardPage;
import com.hrm.pages.LoginPage;
import com.hrm.pages.MyInfoPage;
import com.hrm.util.Config;
import com.hrm.util.ExcelReaderUtill;
import com.hrm.util.Log;

public class MyInfo_AddDependents extends TestBase{

	LoginPage loginPage;
	DashboardPage dashboardPage=null;
	MyInfoPage myinfo;
	String sheetName = "DependentDetails";
	
	@BeforeMethod
	public void setUp() {
		
		Log.startTestCase("AddDependentTest-Checking the functionality of adding a new dependent of user");
		initialization();
		loginPage=new LoginPage();
		dashboardPage=new DashboardPage();
		Log.info("Starting the Login Process");
		loginPage.loginToApp(Config.getProperty("username"),Config.getProperty("password"));
		myinfo=dashboardPage.ClickOnMyInfoHeader();	
		
	}
	
	
	@Test(description="HRMS-54:Validate that user is able to add a new Dependents from My info tab", dataProvider="DependentDataProvider")
	public void AddDependentTest(String name, String relationship, String DOB) throws InterruptedException {	
		Log.info("Navigating to Dependents Link");
		myinfo.NavigateToDependentsLinks();
		Log.info("Trying to Add new Dependent");
		myinfo.addDependent(name,relationship,DOB);
		Log.info("Checking for Success message");
		Assert.assertTrue(myinfo.AddDependentSuccess());
	}
	
	@DataProvider()
	public Object[][] DependentDataProvider()
	{	 
		Object[][] testData = ExcelReaderUtill.getTestData(sheetName);
		return testData;
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
