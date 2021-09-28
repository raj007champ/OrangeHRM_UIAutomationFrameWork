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

public class MyInfo_DeleteMembership extends TestBase{

	LoginPage loginPage;
	DashboardPage dashboardPage=null;
	MyInfoPage myinfo;

	
	@BeforeMethod
	public void setUp() {
		Log.startTestCase("DeleteMembershipTest: Checing the functionality of Deleting a membership details");
		initialization();
		loginPage=new LoginPage();
		dashboardPage=new DashboardPage();
		Log.info("Starting the login Process");
		loginPage.loginToApp(Config.getProperty("username"),Config.getProperty("password"));
		myinfo=dashboardPage.ClickOnMyInfoHeader();		
	}
	
	@Test(description="HRMS-62:Validate that user is able to Delete the Assigned membership details from My info tab")
	public void DeleteEmergencyContact() {	
Log.info("Navigating  to Membership Details Section");
		myinfo.NavigateToMembershipLink();
		Log.info("Trying to delete a membership details");
		myinfo.deleteMembership("PayClub");
		Assert.assertTrue(myinfo.MembershipDeleteSuccessMessage());

	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}


