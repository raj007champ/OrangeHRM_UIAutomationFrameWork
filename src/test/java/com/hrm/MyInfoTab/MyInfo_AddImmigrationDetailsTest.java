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

public class MyInfo_AddImmigrationDetailsTest extends TestBase {
	LoginPage loginPage;
	DashboardPage dashboardPage=null;
	MyInfoPage myinfo;
	String sheetName = "ImmigrationDetails";
	
	@BeforeMethod
	public void setUp() {
		Log.startTestCase("AddImmigrationTest:Checking the functionality of adding Immigiration details");
		initialization();
		loginPage=new LoginPage();
		dashboardPage=new DashboardPage();
		Log.info("Starting the login Process");
		loginPage.loginToApp(Config.getProperty("username"),Config.getProperty("password"));
		myinfo=dashboardPage.ClickOnMyInfoHeader();	
		
	}
	
	
	@Test(description="HRMS-56:Validate that user is able to add a new Immigration Records from My info tab",dataProvider="ImmigrationDetailsDataProvider")
	public void AddImmigrationTest(String doctype, String docno, String Status, String country) throws InterruptedException {	
        Log.info("Navigating to Immigration Link");
		myinfo.NavigateToImmigrationLink();
		Log.info("Trying to add Immigiration Details");
		myinfo.addImmigration(doctype,docno,Status, country);
		Assert.assertTrue(myinfo.AddImmigrationSuccess());
	}
	
	@DataProvider()
	public Object[][] ImmigrationDetailsDataProvider()
	{	 
		Object[][] testData = ExcelReaderUtill.getTestData(sheetName);
		return testData;
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
