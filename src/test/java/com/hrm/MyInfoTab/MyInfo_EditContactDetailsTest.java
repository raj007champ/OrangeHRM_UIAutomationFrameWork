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

public class MyInfo_EditContactDetailsTest extends TestBase{
	
	LoginPage loginPage;
	DashboardPage dashboardPage=null;
	MyInfoPage myinfo;
	String sheetName = "ContactDetails";
	
	@BeforeMethod
	public void setUp() {
		Log.startTestCase("EditContactDetailsTest: Checking the functionality of Editing Contact Details");
		initialization();
		loginPage=new LoginPage();
		dashboardPage=new DashboardPage();
		Log.info("Starting the login Process");
		loginPage.loginToApp(Config.getProperty("username"),Config.getProperty("password"));
		myinfo=dashboardPage.ClickOnMyInfoHeader();	
		
	}
	
	
	@Test(description="HRMS-51:Validate that user is able to edit the Contact details information from My info tab",dataProvider="ContactDetailsDataProvider")
	public void UserNameValidationTest(String address, String city, String state, String zip, String country, String mobile) {	
Log.info("Naviagting to Contact Details Section");
		myinfo.NavigateToContactDetails();
		Log.info("Trying to Edit the contact Details");
		myinfo.editContactDetails(address, city, state, zip, country, mobile);
		
		Assert.assertEquals(myinfo.ContactDetailsChangeSuccessCheck(),"Edit");

	}
	
	@DataProvider()
	public Object[][] ContactDetailsDataProvider()
	{	 
		Object[][] testData = ExcelReaderUtill.getTestData(sheetName);
		return testData;
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
