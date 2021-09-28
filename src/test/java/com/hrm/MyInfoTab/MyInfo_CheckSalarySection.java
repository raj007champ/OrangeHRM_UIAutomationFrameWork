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

public class MyInfo_CheckSalarySection extends TestBase {
			LoginPage loginPage;
			DashboardPage dashboardPage=null;
			MyInfoPage myinfo;
			String sheetName = "DependentDetails";
			
			@BeforeMethod
			public void setUp() {
				Log.startTestCase("CheckSalarySectionTest: Checking the functionality of verifying  salary tab");
				initialization();
				loginPage=new LoginPage();
				dashboardPage=new DashboardPage();
				Log.info("Starting the Login Process");
				loginPage.loginToApp(Config.getProperty("username"),Config.getProperty("password"));
				myinfo=dashboardPage.ClickOnMyInfoHeader();	
				
			}
			
			
			@Test(description="HRMS-59:Validate that user is able to navigate to Salary Section and can check all the details")
			public void CheckSalarySectionTest(){	
Log.info("Navigating to Salary Section");
				myinfo.NavigateToSalarySection();
				//myinfo.checkJobDetails();
				Log.info("Verifying the Salary Section");
				Assert.assertTrue(myinfo.checkSalaryDetails());
			}
			
			
			@AfterMethod
			public void tearDown(){
				driver.quit();
			}
		}


