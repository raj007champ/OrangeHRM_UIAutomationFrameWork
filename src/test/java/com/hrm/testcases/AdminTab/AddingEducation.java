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

public class AddingEducation extends TestBase{
	AdminPage usermgmtpage=null;
	LoginPage loginPage=null;
	DashboardPage dashboardPage;
	TopNevigationMenuPage topnevigationmenupage;
	    
	    @BeforeMethod
	    public void setUp() {
		    initialization();
		    topnevigationmenupage=new TopNevigationMenuPage();
		    
	    }
		
		@Test(description="HRMS-120:Adding education to Qualification Section")
		public void Adding_Education() {
			try {
			    Log.startTestCase("-------Functionality of Adding Eduction to Qualification Section-----------");
			    LoginPage loginPage =new LoginPage();
			    dashboardPage=loginPage.loginToApp(Config.getProperty("username"), Config.getProperty("password"));
			    takeScreenShot("Login Successfully");
			    usermgmtpage=dashboardPage.clickOnAdminTab();
			    Log.info("Admin tab Clicked");
			    takeScreenShot("Admin tab Clicked");
			    usermgmtpage.addingEducation("B.Tech-Computer Science");
			    Log.info("Work Education Added Successfully");
			    Assert.assertEquals(true, usermgmtpage.AddingEducationSuccess());
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
