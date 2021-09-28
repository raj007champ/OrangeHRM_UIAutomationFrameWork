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

public class MyInfo_AddMembership extends TestBase {
	LoginPage loginPage;
	DashboardPage dashboardPage=null;
	MyInfoPage myinfo;
	String sheetName = "Membership";
	
	@BeforeMethod
	public void setUp() {
		
		Log.startTestCase("AddMembbershipTest: Checking the functionality of adding a new Membership details.");
		initialization();
		loginPage=new LoginPage();
		dashboardPage=new DashboardPage();
		Log.info("Starting the login Process");
		loginPage.loginToApp(Config.getProperty("username"),Config.getProperty("password"));
		myinfo=dashboardPage.ClickOnMyInfoHeader();	
		
	}
	
	
	@Test(description="HRMS-61:Validate that user is able to add a new Assigned membership details from My info tab",dataProvider="MembershipDataProvider")
	public void AddMembershipTest(String membership, String paidBy, String amount,String currency) throws InterruptedException {	
Log.info("Navigating to Membership Secttion");
		myinfo.NavigateToMembershipLink();
		Log.info("Trying to add a new Membership details");
		myinfo.addMembership(membership, paidBy, amount,currency);
		Assert.assertTrue(myinfo.AddMembershipSuccess());
	}
	
	@DataProvider()
	public Object[][] MembershipDataProvider()
	{	 
		Object[][] testData = ExcelReaderUtill.getTestData(sheetName);
		return testData;
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
