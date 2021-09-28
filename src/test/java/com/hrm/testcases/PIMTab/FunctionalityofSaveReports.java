package com.hrm.testcases.PIMTab;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.hrm.base.TestBase;
import com.hrm.pages.DashboardPage;
import com.hrm.pages.LoginPage;
import com.hrm.pages.PIMPage;
import com.hrm.pages.ReportPage;
import com.hrm.pages.TopNevigationMenuPage;
import com.hrm.util.Config;
import com.hrm.util.Log;
import com.hrm.util.TestConfig;

public class FunctionalityofSaveReports extends TestBase {

	/*1:Login  to HRMS with proper Credentials 
	2.Click On PIM tab 
	3.Click On Reports 
	4.Click on Add Button
	5.Enter Report name
	6.Select Employee id from Displayed Field  Drop-down
	7.Click On Add 
	8.Click on Displayed Field Check Box 
	9.Click On Save Button
	10.Verify New Reports Should be Created*/

	LoginPage loginPage;
	DashboardPage dashboardPage=null;
	PIMPage pimpageobjects=null;
	TopNevigationMenuPage topnevigationmenupage;
	//ExecutionStatus result;
	//String notes;

	@BeforeMethod
	public void setUp() {
		initialization();
		topnevigationmenupage=new TopNevigationMenuPage();
		Log.startTestCase("-------Functionality of Save Reports Stated-----------");
		LoginPage loginPage =new LoginPage();
		dashboardPage=loginPage.loginToApp(Config.getProperty("username"), Config.getProperty("password"));
		Log.info("Login Successfully");
	}

	@Test(description="HRMS-112:Functionality of Save Reports")
	public void FunctionalityofSaveReports()  {
		try{
			pimpageobjects=dashboardPage.clickOnPIMTab();
			Log.info("PIM tab Clicked");
			takeScreenShot("PIM tab Clicked");
			Thread.sleep(1000);
			pimpageobjects.clickOnReports();
			ReportPage reportpage=new ReportPage();
			reportpage.clickOnAddButton();
			Thread.sleep(1000);
			reportpage.clickOnSaveButton();
			Assert.assertEquals(true, reportpage.verifyCreatedsReportisDisplayed(TestConfig.ReportName));
			Log.info("Test Case Pass");
			takeScreenShot("Test Case Pass");
			reportpage.DeleteReport(TestConfig.ReportName);
		}
		catch(Exception e){
			e.printStackTrace();
			Assert.assertFalse(true, "Test Case Fail.");
		}	

	}
	@AfterMethod
	public void tearDown(){
		topnevigationmenupage.ClickOnUserName();
		Log.endTestCase();
		driver.quit();
		Log.endTestCase();
	}







}
