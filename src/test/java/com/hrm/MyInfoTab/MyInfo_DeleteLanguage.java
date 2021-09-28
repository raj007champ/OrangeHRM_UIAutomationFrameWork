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

public class MyInfo_DeleteLanguage extends TestBase{

	LoginPage loginPage;
	DashboardPage dashboardPage=null;
	MyInfoPage myinfo;

	
	@BeforeMethod
	public void setUp() {
		Log.startTestCase("DeleteLanguageTest: Checking the functionality of Deleting the language from the list");
		initialization();
		loginPage=new LoginPage();
		dashboardPage=new DashboardPage();
		Log.info("Starting the login Process");
		loginPage.loginToApp(Config.getProperty("username"),Config.getProperty("password"));
		myinfo=dashboardPage.ClickOnMyInfoHeader();		
	}
	
	@Test(description="HRMS-68:Validate that user is able to delete Qualification Record details from My info -Language & Licence")
	public void DeleteLanguageTest() {	
		Log.info("Navigating to Qualification Section");
		myinfo.NavigateToQualificationsSection();
		Log.info("Trying to delete a language from the list");
		myinfo.deleteLanguage("English");
		Assert.assertTrue(myinfo.LanguageDeleteSuccessMessage());

	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
