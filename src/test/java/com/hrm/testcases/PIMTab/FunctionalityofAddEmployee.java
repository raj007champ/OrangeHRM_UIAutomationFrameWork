package com.hrm.testcases.PIMTab;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrm.base.TestBase;
import com.hrm.pages.AddEmployeePage;
import com.hrm.pages.DashboardPage;
import com.hrm.pages.EmployeeListPage;
import com.hrm.pages.LoginPage;
import com.hrm.pages.PIMPage;
import com.hrm.pages.TopNevigationMenuPage;
import com.hrm.util.Config;
import com.hrm.util.Log;
import com.hrm.util.TestConfig;

public class FunctionalityofAddEmployee extends TestBase {

	/*1:Login  to HRMS with proper Credentials 
	2.Click On PIM tab 
	3.Click On Add Employee Options
	4.Verify Add Employee form should be open
	5.Enter First name,middle name,last name
	6.Browse Photograph(Accepts jpg, .png, .gif up to 1MB. Recommended dimensions: 200px X 200px)
	7.Click on Create Login Details check box
	8.Verify Create Login Details form should be open
	9.Enter Username,Password,Confirm Password
	10.Select Enabled Status from Status drop-down
	11.Click on Save button*/

	LoginPage loginPage;
	DashboardPage dashboardPage=null;
	PIMPage pimpageobjects=null;
	TopNevigationMenuPage topnevigationmenupage;
	EmployeeListPage employeelistpage;

	@BeforeMethod
	public void setUp() {
		initialization();
		topnevigationmenupage=new TopNevigationMenuPage();
		Log.startTestCase("-------Functionality of Add Employee Stated-----------");
		LoginPage loginPage =new LoginPage();
		dashboardPage=loginPage.loginToApp(Config.getProperty("username"), Config.getProperty("password"));
		Log.info("Login Successfully");
	}

	@Test(description="HRMS-12:Functionality of Add Employee")
	public void AddEmployeeTC(){
		try{
			pimpageobjects=dashboardPage.clickOnPIMTab();
			Log.info("PIM tab Clicked");
			takeScreenShot("PIM tab Clicked");
			Thread.sleep(1000);
			pimpageobjects.clickOnAddEmployee();
			Log.info("Add Employee tab Clicked");
			takeScreenShot("Add Employee tab Clicked");
			AddEmployeePage addemployeepage=new AddEmployeePage();
			addemployeepage.clickOnSaveButton();
			takeScreenShot("Employee is Added");
			employeelistpage=new EmployeeListPage();
			pimpageobjects.clickOnEmployeeList();
			Thread.sleep(1000);
			Assert.assertEquals(true, employeelistpage.isAddedEmployeeDisplayed(TestConfig.Frist_Name));
			Log.info("Test Case Pass");
			takeScreenShot("Test Case Pass");
			Thread.sleep(1000);
			employeelistpage.DeleteEmployee(TestConfig.Frist_Name);
			Thread.sleep(1000);
		}
		catch(Exception e){
			e.printStackTrace();
			Assert.assertFalse(true, "Test Case Fail.");
		}	
	}

	@AfterMethod
	public void tearDown(){
		topnevigationmenupage.ClickOnUserName();
		driver.quit();
		Log.endTestCase();
	}
}
