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

public class FunctionalityofOKButtononOrangeHRMConfirmationRequiredwindow extends TestBase {

	/*1:Login  to HRMS with proper Credentials 
	2.Click On PIM tab 
	3.Click On Employee List
	4.Select any Employee you want to Delete by clicking on Checkbox
	5.Click On Delete Button
	6.Click on OK Button*/

	LoginPage loginPage;
	DashboardPage dashboardPage=null;
	PIMPage pimpageobjects=null;
	TopNevigationMenuPage topnevigationmenupage;
	EmployeeListPage employeelistpage;

	@BeforeMethod
	public void setUp() {
		initialization();
		topnevigationmenupage=new TopNevigationMenuPage();
		Log.startTestCase("-------Functionality of OK Button on Orange HRM Confirmation Required window Stated-----------");
		LoginPage loginPage =new LoginPage();
		dashboardPage=loginPage.loginToApp(Config.getProperty("username"), Config.getProperty("password"));
		Log.info("Login Successfully");
	}

	@Test(description="HRMS-16:Functionality of OK Button on OrangeHRM - Confirmation Required window")
	public void FunctionalityofOKButtononOrangeHRMConfirmationRequiredwindow(){
		try{
			pimpageobjects=dashboardPage.clickOnPIMTab();
			Log.info("PIM tab Clicked");
			Thread.sleep(1000);
			pimpageobjects.clickOnAddEmployee();
			Log.info("Add Employee tab Clicked");
			AddEmployeePage addemployeepage=new AddEmployeePage();
			addemployeepage.clickOnSaveButton();
			Log.info("Employee is Added");
			employeelistpage=new EmployeeListPage();
			pimpageobjects.clickOnEmployeeList();
			Thread.sleep(1000);
			if(employeelistpage.isAddedEmployeeDisplayed(TestConfig.Frist_Name)){
				Thread.sleep(1000);
				employeelistpage.DeleteEmployee(TestConfig.Frist_Name);
				Assert.assertEquals(true, employeelistpage.isDeletedEmployeeDisplayed(TestConfig.Frist_Name));
				Log.info("Test Case Pass");
				takeScreenShot("Test Case Pass");
			}
			else{
				Log.info("Employee is not Displayed");
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
		driver.quit();
		Log.endTestCase();
	}
}
