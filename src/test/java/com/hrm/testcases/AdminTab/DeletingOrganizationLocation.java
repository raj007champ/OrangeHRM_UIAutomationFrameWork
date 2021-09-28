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

public class DeletingOrganizationLocation extends TestBase{
	AdminPage usermgmtpage=null;
	LoginPage loginPage=null;
	DashboardPage dashboardPage;
	TopNevigationMenuPage topnevigationmenupage;
	    
	    @BeforeMethod
	    public void setUp() {
		    initialization();
		    topnevigationmenupage=new TopNevigationMenuPage();
		    
	    }
		
		@Test(description="HRMS-29:Deleting locations under organization section")
		public void DeleteOrganizationLocation() {
			try {
			    Log.startTestCase("-------Functionality of Deleting Location of Organization-----------");
			    LoginPage loginPage =new LoginPage();
			    dashboardPage=loginPage.loginToApp(Config.getProperty("username"), Config.getProperty("password"));
			    takeScreenShot("Login Successfully");
			    usermgmtpage=dashboardPage.clickOnAdminTab();
			    Log.info("Admin tab Clicked");
			    takeScreenShot("Admin tab Clicked");
			    usermgmtpage.deleting_OrganizationLocation("georgia");
			    Log.info("Organization Location Deleted Successfully");
			    Assert.assertEquals(true, usermgmtpage.DeletingOgranizationLocationSuccess());
			    Log.info("Test Case Pass");
			    takeScreenShot("Test Case Pass");
			}
			catch(Exception e){
				e.printStackTrace();
				Assert.assertFalse(true, "Could not login.");
			}	
			finally{
				topnevigationmenupage.ClickOnUserName();
				Log.endTestCase();
			}
		}
		
		
		@AfterMethod
		public void tearDown(){
			driver.quit();
		}
	

}
