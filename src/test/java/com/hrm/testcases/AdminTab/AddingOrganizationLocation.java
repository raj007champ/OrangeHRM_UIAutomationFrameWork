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

public class AddingOrganizationLocation extends TestBase{
	AdminPage usermgmtpage=null;
	LoginPage loginPage=null;
	DashboardPage dashboardPage;
	TopNevigationMenuPage topnevigationmenupage;
	String sheetName = "AddLanguage";
	    
	    @BeforeMethod
	    public void setUp() {
		    initialization();
		    topnevigationmenupage=new TopNevigationMenuPage();
		    
	    }
		
		@Test(description="HRMS-28:Adding locations of organization in different countries")
		public void AddingOrganizationInformation() {
			try {
			    Log.startTestCase("-------Functionality of Adding Location to Organization-----------");
			    LoginPage loginPage =new LoginPage();
			    dashboardPage=loginPage.loginToApp(Config.getProperty("username"), Config.getProperty("password"));
			    takeScreenShot("Login Successfully");
			    usermgmtpage=dashboardPage.clickOnAdminTab();
			    Log.info("Admin tab Clicked");
			    takeScreenShot("Admin tab Clicked");
			    usermgmtpage.adding_OrganizationLocation("georgia","United States");
			    Log.info("Organization Location Added Successfully");
			    Assert.assertEquals(true, usermgmtpage.AddOgranizationLocationSuccess());
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
