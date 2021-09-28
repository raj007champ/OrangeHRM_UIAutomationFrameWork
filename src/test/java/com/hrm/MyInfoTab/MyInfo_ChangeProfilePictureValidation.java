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

public class MyInfo_ChangeProfilePictureValidation extends TestBase{

	
	LoginPage loginPage;
	DashboardPage dashboardPage=null;
	MyInfoPage myinfo;
	
	@BeforeMethod
	public void setUp() {
		
		Log.startTestCase("ChangeProfilePictureTest: Checking the functionality to add a new Profile Picture");
		initialization();
		loginPage=new LoginPage();
		dashboardPage=new DashboardPage();
	
	}
	
	@Test(description="HRMS-49:Validate that user is able to change his/her profile picture")
	public void UserNameValidationTest() throws IOException {	
		
		Log.startTestCase("UserNameValidationTest");
		Log.info("Starting the Login Process");
	
		loginPage.loginToApp(Config.getProperty("username"),Config.getProperty("password"));

		Log.info("Clicked on MyInfo tab present at header to Navigate  to MyInfo Tab");
		
		myinfo=dashboardPage.ClickOnMyInfoHeader();	
		
		myinfo.ChangeProfilePicClick();
		
		String PhotoWidth=myinfo.ChangeProfilePic();
	
		System.out.println(PhotoWidth);
		
		Assert.assertEquals(PhotoWidth,"131");

	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
