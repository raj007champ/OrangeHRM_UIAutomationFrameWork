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

public class MyInfo_AddLanguage extends TestBase {
	LoginPage loginPage;
	DashboardPage dashboardPage=null;
	MyInfoPage myinfo;
	String sheetName = "AddLanguage";
	
	@BeforeMethod
	public void setUp() {
		Log.startTestCase("AddLanguageTest:Checking the functionality of adding a new Language");
		initialization();
		loginPage=new LoginPage();
		dashboardPage=new DashboardPage();
		Log.info("Starting the login process");
		loginPage.loginToApp(Config.getProperty("username"),Config.getProperty("password"));
		myinfo=dashboardPage.ClickOnMyInfoHeader();	
		
	}
	
	
	@Test(description="HRMS-68:Validate that user is able to delete Qualification Record details from My info -Language & Licence",dataProvider="AddLanguageDataProvider")
	public void AddLanguageTest(String Language, String Fluency, String Competency)  {	
        Log.info("Navigating to Qualification Section");
		myinfo.NavigateToQualificationsSection();
		Log.info("Trying to add a new Language");
		myinfo.addLanguage(Language,Fluency,Competency);
		Assert.assertTrue(myinfo.AddLanguageDetailsSuccess());
	}
	
	@DataProvider()
	public Object[][] AddLanguageDataProvider()
	{	 
		Object[][] testData = ExcelReaderUtill.getTestData(sheetName);
		return testData;
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
