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

public class FunctionalityofmployeeList extends TestBase {

	/*1:Login  to HRMS with proper Credentials 
    2.Click On PIM tab 
    3.Click On Employee List
	 */
	LoginPage loginPage;
	DashboardPage dashboardPage=null;
	PIMPage pimpageobjects=null;
	TopNevigationMenuPage topnevigationmenupage;

	@BeforeMethod
	public void setUp() {
		initialization();
		topnevigationmenupage=new TopNevigationMenuPage();
		Log.startTestCase("-------Functionality of Employee List Stated-----------");
		LoginPage loginPage =new LoginPage();
		dashboardPage=loginPage.loginToApp(Config.getProperty("username"), Config.getProperty("password"));
		Log.info("Login Successfully");
	}

	@Test(description="HRMS-13:Functionality of Employee list")
	public void FunctionalityofmployeeList(){
		try{
			pimpageobjects=dashboardPage.clickOnPIMTab();
			Log.info("PIM tab Clicked");
			takeScreenShot("PIM tab Clicked");
			Thread.sleep(1000);
			pimpageobjects.clickOnEmployeeList();
			EmployeeListPage employeelistpage=new EmployeeListPage();
			Assert.assertEquals(true, employeelistpage.isEmployeeInformationDisplayed());
			Log.info("Test Case Pass");
			takeScreenShot("Test Case Pass");
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
