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

public class MyInfo_EditPersonalDetails extends TestBase{
	
	LoginPage loginPage;
	DashboardPage dashboardPage=null;
	MyInfoPage myinfo;
	String sheetName = "PersonalDetails";
	
	@BeforeMethod
	public void setUp() {
		Log.startTestCase("EditPersonalDetailsTest: Checking the functionality of Editing the personal Details");
		initialization();
		loginPage=new LoginPage();
		dashboardPage=new DashboardPage();
		Log.info("Starting the login Process");
		loginPage.loginToApp(Config.getProperty("username_shishu"),Config.getProperty("password_shishu"));
		
	}
	
	
	@Test(description="HRMS-48:Validate that user is able to edit the personal details information from My info tab",dataProvider="PeronalDetailsDataProvider")
	public void UserNameValidationTest(String fname,String mname,String lname,
			String empid,String oid,String licid,String gender,String martial,String nation) {	
		Log.info("Naviagting to Edit Personal Details Section");

		myinfo=dashboardPage.ClickOnMyInfoHeader();	
		Log.info("Trying toe edit the personal Details Section");
		myinfo.editPersonalDetails(fname, mname, lname, empid, oid, licid, gender, martial, nation);
		
		Assert.assertTrue(myinfo.personalDetailsChangeSuccessMessage());

	}
	
	@DataProvider
	public Object[][] PeronalDetailsDataProvider()
	{	 
		Object[][] testData = ExcelReaderUtill.getTestData(sheetName);
		return testData;
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
