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

public class MyInfo_AddEmergencyContact extends TestBase {
	
	LoginPage loginPage;
	DashboardPage dashboardPage=null;
	MyInfoPage myinfo;
	String sheetName = "EmergencyContactDetails";
	
	@BeforeMethod
	public void setUp() {
		Log.startTestCase("Checking the Functionality of Adding a new Emergency Contact for a User");;
		initialization();
		loginPage=new LoginPage();
		dashboardPage=new DashboardPage();
		Log.info("Starting the login Process");
		loginPage.loginToApp(Config.getProperty("username"),Config.getProperty("password"));
		myinfo=dashboardPage.ClickOnMyInfoHeader();	
		
	}
	
	
	@Test(description="HRMS-52:Validate that user is able to add the Emergency contacts from My info tab",dataProvider="EmergencyContactDataProvider")
	public void AddEmergencyContactTest(String name, String relation, String mobno, String WorkTel) {	
		Log.info("Navigating to Emergency Contact Section");
		myinfo.NavigateToEmergencyContactDetails();
		Log.info("Trying to add a Emergency Contact");
		myinfo.addEmergencyContact(name,relation,mobno,WorkTel);
		
		Assert.assertTrue(myinfo.AddEmergencyContactSuccess(name));

	}
	
	@DataProvider()
	public Object[][] EmergencyContactDataProvider()
	{	 
		Object[][] testData = ExcelReaderUtill.getTestData(sheetName);
		return testData;
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
