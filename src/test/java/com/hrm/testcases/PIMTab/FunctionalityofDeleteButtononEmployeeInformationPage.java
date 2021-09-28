package com.hrm.testcases.PIMTab;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrm.base.TestBase;
import com.hrm.pages.DashboardPage;
import com.hrm.pages.EmployeeListPage;
import com.hrm.pages.LoginPage;
import com.hrm.pages.PIMPage;
import com.hrm.pages.TopNevigationMenuPage;
import com.hrm.util.Config;
import com.hrm.util.Log;
import com.hrm.util.TestConfig;


public class FunctionalityofDeleteButtononEmployeeInformationPage extends TestBase {

	/*1:Login  to HRMS with proper Credentials 
	2.Click On PIM tab 
	3.Click On Employee List
	4.Select any Employee you want to Delete by clicking on Checkbox
	5.Click On Delete Button*/

	LoginPage loginPage;
	DashboardPage dashboardPage=null;
	PIMPage pimpageobjects=null;
	TopNevigationMenuPage topnevigationmenupage;
	EmployeeListPage employeelistpage;

	@BeforeMethod
	public void setUp() {
		initialization();
		topnevigationmenupage=new TopNevigationMenuPage();
		Log.startTestCase("-------Functionality of Delete Button on Employee Information Page Stated-----------");
		LoginPage loginPage =new LoginPage();
		dashboardPage=loginPage.loginToApp(Config.getProperty("username"), Config.getProperty("password"));
		Log.info("Login Successfully");
	}

	@Test(description="HRMS-15:Functionality of Delete Button on Employee Information Page")
	public void FunctionalityofDeleteButtononEmployeeInformationPage(){
		try{
			pimpageobjects=dashboardPage.clickOnPIMTab();
			pimpageobjects.clickOnEmployeeList();
			Thread.sleep(1000);
			EmployeeListPage employeelist=new EmployeeListPage();
			employeelist.verifyDeleteEmployeeWindow(TestConfig.Employee_Frist_Name);
			Thread.sleep(1000);
			Assert.assertEquals(true, employeelist.isDeleterecordsTextDisplayed());
			Log.info("Test Case pass");
			employeelist.clickOnCancelButton();

		}
		catch(Exception e){
			e.printStackTrace();
			Assert.assertFalse(true, "Test Case Fail.");
		}	
	}

	@AfterMethod
	public void teardown()
	{
		try{
			Thread.sleep(1000);
			topnevigationmenupage.ClickOnUserName();
			driver.quit();
			Log.endTestCase();
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

}
