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

public class MyInfo_DeleteWorkExperience extends TestBase{

	LoginPage loginPage;
	DashboardPage dashboardPage=null;
	MyInfoPage myinfo;

	
	@BeforeMethod
	public void setUp() {
		Log.startTestCase("DeleteWorkExperienceTest: Checking  the functioanlity of deleting a WorkExperience Details");
		initialization();
		loginPage=new LoginPage();
		dashboardPage=new DashboardPage();
		Log.info("Starting the login Process");
		loginPage.loginToApp(Config.getProperty("username"),Config.getProperty("password"));
		myinfo=dashboardPage.ClickOnMyInfoHeader();		
	}
	
	@Test(description="HRMS-67:Validate that user is able to delete Qualification Record details from My info tab for follwing sec")
	public void DeleteWorkExperience() {	
		Log.info("Navigating to Qualification Section");
		myinfo.NavigateToQualificationsSection();
		Log.info("Trying to Delete the work Experience Details");
		myinfo.deleteWorkExperience("Msys");
		Assert.assertTrue(myinfo.WorkExperienceDeleteSuccessMessage());

	}
	
	
	@AfterMethod
	public void tearDown(){
	
		driver.quit();}
}


