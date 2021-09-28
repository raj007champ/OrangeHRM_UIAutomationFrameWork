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

public class MyInfo_DeleteImmigrationDetails extends TestBase{
	
	LoginPage loginPage;
	DashboardPage dashboardPage=null;
	MyInfoPage myinfo;

	
	@BeforeMethod
	public void setUp() {
		Log.info("DeleteImmigrationDetails: Checking the functionality  of Deleting the immigration Details");
		initialization();
		loginPage=new LoginPage();
		dashboardPage=new DashboardPage();
		Log.info("Starting the login Process");
		loginPage.loginToApp(Config.getProperty("username"),Config.getProperty("password"));
		myinfo=dashboardPage.ClickOnMyInfoHeader();		
	}
	
	@Test(description="HRMS-57:Validate that user is able to Delete the Immigration Records from My info tab")
	public void DeleteEmergencyContact() {	
		Log.info("Navigating to Immigration Link");
		myinfo.NavigateToImmigrationLink();
		Log.info("Trying to delete a immigration Details");
		myinfo.deleteImmigrationDetails("Passport");
		Assert.assertTrue(myinfo.DeleteImmigrationSuccessMessage());

	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
