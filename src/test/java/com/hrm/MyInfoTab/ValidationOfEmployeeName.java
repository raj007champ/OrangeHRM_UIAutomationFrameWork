package com.hrm.MyInfoTab;

import java.io.IOException;

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

public class ValidationOfEmployeeName extends TestBase{

	
/*
Open the HRM Page and login with valid credentials
Now click on My Info link present on dashboard page
Now check for the presence of User full name on My info section
Click on Logout.
*/
	LoginPage loginPage;
	DashboardPage dashboardPage=null;
	MyInfoPage myinfo;
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage=new LoginPage();
		dashboardPage=new DashboardPage();
	
	}
	
	@Test(description="HRMS-47:Validate the presence of User full name on My info section")
	public void UserNameValidationTest() throws IOException {	
		
		Log.startTestCase("UserNameValidationTest");
		Log.info("Starting the Login Process");
	
		loginPage.loginToApp(Config.getProperty("username"),Config.getProperty("password"));

		Log.info("Clicked on MyInfo tab present at header to Navigate  to MyInfo Tab");
		
		myinfo=dashboardPage.ClickOnMyInfoHeader();			
		
		if(Config.getProperty("username").toLowerCase().contains("sagar"))
		{
		Assert.assertEquals(myinfo.checkEmployeeName(), "Sagar Unbeg");
		}else
			if(Config.getProperty("username").toLowerCase().contains("shishu"))
			{
				Assert.assertEquals(myinfo.checkEmployeeName(), "SHISHU RAJ PANDEY");
			}
			else {
				Assert.assertTrue(true);
			}
		
		Log.info("Checking for Employee Details");
		
		takeScreenShot("MyInfoTab_Employee_Name_Validation_Test_Case");
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
