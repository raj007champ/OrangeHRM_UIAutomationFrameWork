package com.hrm.MyInfoTab;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrm.base.TestBase;
import com.hrm.pages.DashboardPage;
import com.hrm.pages.LoginPage;
import com.hrm.pages.MyInfoPage;
import com.hrm.util.Config;
import com.hrm.util.Log;

public class MyInfo_CheckReportsToSection extends TestBase{
	LoginPage loginPage;
	DashboardPage dashboardPage=null;
	MyInfoPage myinfo;
	String sheetName = "DependentDetails";
	
	@BeforeMethod
	public void setUp() {
		Log.startTestCase("CheckReportsToSectionTest: Checking the functionality of Reports To Section");
		initialization();
		loginPage=new LoginPage();
		dashboardPage=new DashboardPage();
		Log.info("Starting  the login Process");
		loginPage.loginToApp(Config.getProperty("username"),Config.getProperty("password"));
		myinfo=dashboardPage.ClickOnMyInfoHeader();	
		
	}
	
	
	@Test(description="HRMS-60:Validate that user is able to navigate to Report-to Section and can check all the details")
	public void CheckReportsToSectionTest(){	
        Log.info("Navigating to Report Section");
		myinfo.NavigateToReportsToSection();
		//myinfo.checkJobDetails();
		Log.info("Checking the Reports to Details Section");
		Assert.assertTrue(myinfo.checkReportsToDetails());
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
