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

public class FunctionalityofEditButtononEmployeeReportsPage extends TestBase {

	/*1:Login  to HRMS with proper Credentials 
	2.Click On PIM tab 
	3.Click On Reports
	4.Select any Reports by click checkbox
	5.Click on Edit Button
	6.Verify Define Report Page Should be Opened
	7.Edit Report name from Report Name text box
	8.Click On Save Button
	9.Verify Modified report name should be displayed in r=Employee Report page*/

	LoginPage loginPage;
	DashboardPage dashboardPage=null;
	PIMPage pimpageobjects=null;
	TopNevigationMenuPage topnevigationmenupage;

	@BeforeMethod
	public void setUp() {
		initialization();
		topnevigationmenupage=new TopNevigationMenuPage();
		Log.startTestCase("-------Functionality of Edit Button on Employee Reports Page Stated-----------");
		LoginPage loginPage =new LoginPage();
		dashboardPage=loginPage.loginToApp(Config.getProperty("username"), Config.getProperty("password"));
		Log.info("Login Successfully");
	}

	@Test(description="HRMS-45:Functionality of Edit Button on Employee Reports Page")
	public void FunctionalityofEditButtononEmployeeReportsPage()  {
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
			reportpage.clickEditButton(TestConfig.ReportName);
			if(reportpage.isDifineReportsDisplayed()){
				reportpage.EditReport(TestConfig.EditReportName);
				Assert.assertEquals(true, reportpage.verifyCreatedsReportisDisplayed(TestConfig.EditReportName));
				Log.info("Test Case Pass");
				takeScreenShot("Test Case Pass");
				reportpage.DeleteReport(TestConfig.EditReportName);
			}
			else{
				Assert.assertFalse(true, "Define Report is Not Displayed.");
			}


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

	}
}
