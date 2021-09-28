package com.hrm.testcases.AdminTab;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrm.base.TestBase;
import com.hrm.pages.AdminPage;
import com.hrm.pages.DashboardPage;
import com.hrm.pages.LoginPage;
import com.hrm.pages.TopNevigationMenuPage;
import com.hrm.util.Config;
import com.hrm.util.Log;

public class AssigningWorkShiftToEmp extends TestBase{
	AdminPage usermgmtpage=null;
	LoginPage loginPage=null;
	DashboardPage dashboardPage;
	TopNevigationMenuPage topnevigationmenupage;
	    
	    @BeforeMethod
	    public void setUp() {
		    initialization();
		    topnevigationmenupage=new TopNevigationMenuPage();
		    
	    }
		
		@Test(description="HRMS-26:Assigning Work Shifts to available Employees")
		public void AssignWorkShift() {
			try {
			    Log.startTestCase("-------Functionality of Assigning WorkShift to Employee-----------");
			    LoginPage loginPage =new LoginPage();
			    dashboardPage=loginPage.loginToApp(Config.getProperty("username"), Config.getProperty("password"));
			    takeScreenShot("Login Successfully");
			    usermgmtpage=dashboardPage.clickOnAdminTab();
			    Log.info("Admin tab Clicked");
			    takeScreenShot("Admin tab Clicked");
			    usermgmtpage.assignWorkShift("Afternoon Shift","Raj Pande");
			    Log.info("Work Shift assigned to Employee Successfully");
			    Assert.assertEquals(true, usermgmtpage.AssigningWorkShiftSuccess());
			    Log.info("Test Case Pass");
			    takeScreenShot("Test Case Pass");
			}
			catch(Exception e){
				e.printStackTrace();
			}	
			finally{
				topnevigationmenupage.ClickOnUserName();
			}
		}
		
		
		@AfterMethod
		public void tearDown(){
			driver.quit();
		}
	


}
