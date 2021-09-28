package com.hrm.MyInfoTab;

import org.openqa.selenium.By;
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
import com.hrm.util.Log;


public class MyInfo_DeleteEmergencyContact extends TestBase{
	
	LoginPage loginPage;
	DashboardPage dashboardPage=null;
	MyInfoPage myinfo;

	
	@BeforeMethod
	public void setUp() {
		Log.startTestCase("DeleteEmergencyContact: Checking  the functionality of Deleting the Emergency contact details");
		initialization();
		loginPage=new LoginPage();
		dashboardPage=new DashboardPage();
		Log.info("Starting the Login Process");
		loginPage.loginToApp(Config.getProperty("username"),Config.getProperty("password"));
		myinfo=dashboardPage.ClickOnMyInfoHeader();		
	}
	
	@Test(description="HRMS-53:Validate that user is able to Delete the Emergency contacts from My info tab")
	public void DeleteEmergencyContact() {	
		Log.info("Navigating  to Emergency Contact Section");
		myinfo.NavigateToEmergencyContactDetails();
		Log.info("Trying  to delete a Emergency contact");
		myinfo.deletEmergencyContact("Sagar Unbeg");
		Assert.assertTrue(myinfo.EmergencyContactDeleteSuccessMessage());

	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

	
}
