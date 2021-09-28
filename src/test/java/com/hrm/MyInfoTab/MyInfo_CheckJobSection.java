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

public class MyInfo_CheckJobSection extends TestBase {
	LoginPage loginPage;
	DashboardPage dashboardPage=null;
	MyInfoPage myinfo;
	String sheetName = "DependentDetails";
	
	@BeforeMethod
	public void setUp() {
		
		Log.startTestCase("MyInfo_CheckJobSectionTest: Checking the functionality to check the Job Section");
		initialization();
		loginPage=new LoginPage();
		dashboardPage=new DashboardPage();
		Log.info("Starting the Login Process");
		loginPage.loginToApp(Config.getProperty("username"),Config.getProperty("password"));
		myinfo=dashboardPage.ClickOnMyInfoHeader();	
		
	}
	
	
	@Test(description="HRMS-58:Validate that user is able to navigate to Job Section and can check all the details")
	public void CheckJobSectionTest(){	
Log.info("Navigating to Job Details section");
		myinfo.NavigateToJobSection();
		//myinfo.checkJobDetails();
		Log.info("Checking the job details functionality");
		Assert.assertTrue(myinfo.checkJobDetails());
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
