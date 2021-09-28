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


public class FunctionalityofCancelButtononOrangeHRMConfirmationRequiredwindow extends TestBase {

	/*1:Login  to HRMS with proper Credentials 
	2.Click On PIM tab 
	3.Click On Employee List
	4.Select any Employee you want to Delete by clicking on Checkbox
	5.Click On Delete Button
	6.Click on Cancel Button*/

	LoginPage loginPage;
	DashboardPage dashboardPage=null;
	PIMPage pimpageobjects=null;
	TopNevigationMenuPage topnevigationmenupage;
	EmployeeListPage employeelistpage;

	@BeforeMethod
	public void setUp() {
		initialization();
		topnevigationmenupage=new TopNevigationMenuPage();
		Log.startTestCase("-------Functionality of Cancel Button on Orange HRM Confirmation Required window Stated-----------");
		LoginPage loginPage =new LoginPage();
		dashboardPage=loginPage.loginToApp(Config.getProperty("username"), Config.getProperty("password"));
		Log.info("Login Successfully");
	}

	@Test(description="HRMS-18:Functionality of Cancel Button on OrangeHRM - Confirmation Required window")
	public void FunctionalityofCancelButtononOrangeHRMConfirmationRequiredwindow(){
		try{
			pimpageobjects=dashboardPage.clickOnPIMTab();
			pimpageobjects.clickOnEmployeeList();
			Thread.sleep(1000);
			EmployeeListPage employeelist=new EmployeeListPage();
			Thread.sleep(1000);
			employeelist.verifyDeleteEmployeeWindow(TestConfig.Employee_Frist_Name);
			if(employeelist.isDeleterecordsTextDisplayed()){
				employeelist.clickOnCancelButton();
			}
			Thread.sleep(1000);
			Assert.assertEquals(true, employeelist.isAddedEmployeeDisplayed(TestConfig.Employee_Frist_Name));
			Log.info("Test Case pass");

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
