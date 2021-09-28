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

public class MyInfo_DeleteDependent extends TestBase{

	LoginPage loginPage;
	DashboardPage dashboardPage=null;
	MyInfoPage myinfo;

	
	@BeforeMethod
	public void setUp() {
		Log.info("DeleteDependentTest: Checking the functionality of deleting the dependent details");
		initialization();
		loginPage=new LoginPage();
		dashboardPage=new DashboardPage();
		Log.info("Starting the Login Process");
		loginPage.loginToApp(Config.getProperty("username"),Config.getProperty("password"));
		myinfo=dashboardPage.ClickOnMyInfoHeader();		
	}
	
	@Test(description="HRMS-55:Validate that user is able to Delete the Dependents from My info tab")
	public void DeleteDependentContact() {	
		Log.info("Navigating To Dependents Section");
		myinfo.NavigateToDependentsLinks();
		Log.info("Trying to delete a dependent detail");
		myinfo.deleteDependent("Vishal");
		Assert.assertTrue(myinfo.DependentDeleteSuccessMessage());

	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
