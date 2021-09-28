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

public class MyInfo_AddQualification_WorkExperience extends TestBase{

	LoginPage loginPage;
	DashboardPage dashboardPage=null;
	MyInfoPage myinfo;
	String sheetName = "WorkExperience";
	
	@BeforeMethod
	public void setUp() {
		Log.startTestCase("AddQualification_WorkExperienceTest: Checking the Functionality of adding a Work Experience Details");
		initialization();
		loginPage=new LoginPage();
		dashboardPage=new DashboardPage();
		Log.info("Starting the Login Process");
		loginPage.loginToApp(Config.getProperty("username"),Config.getProperty("password"));
		myinfo=dashboardPage.ClickOnMyInfoHeader();	
		
	}
	
	
	@Test(description="HRMS-63:Validate that user is able to add a new Qualification Record details from My info tab for follwing s",dataProvider="WorkExperienceProvider")
	public void AddWorkExperienceTest(String company, String jobtitle) throws InterruptedException {	
        Log.info("Navigating to Work Experience Section");
		myinfo.NavigateToQualificationsSection();
		Log.info("Trying to add a new WorkExperience");
		myinfo.addWorkExperience(company,jobtitle);
		Assert.assertTrue(myinfo.AddWorkExperienceSuccess());
	}
	
	@DataProvider()
	public Object[][] WorkExperienceProvider()
	{	 
		Object[][] testData = ExcelReaderUtill.getTestData(sheetName);
		return testData;
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
