
package com.hrm.testcases.PerformancePage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrm.base.TestBase;
import com.hrm.pages.DashboardPage;
import com.hrm.pages.LoginPage;
import com.hrm.pages.PerformancePage;
import com.hrm.pages.TopNevigationMenuPage;
import com.hrm.util.Config;
import com.hrm.util.Log;

@Test
public class VerifySubtabsPresentInConfigureTab extends TestBase {
	
	LoginPage loginPage;
	DashboardPage dashboardPage=null;
	PerformancePage performancePage=null;
	TopNevigationMenuPage topnevigationmenupage;
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage=new LoginPage();
		dashboardPage=new DashboardPage();
		performancePage=new PerformancePage();
		topnevigationmenupage=new TopNevigationMenuPage();
	}	
	@Test(description="HRMS-89:Verify Subtabs present in Configure")
	public void VerifySubTab(){
		try{
			Log.startTestCase("-------Verify Performance Tab Test Case Stated-----------");			
			dashboardPage=loginPage.loginToApp(Config.getProperty("username"), Config.getProperty("password"));
			takeScreenShot("Login Successfully");			
			Log.info("Performance Tab is Present");
			performancePage.hoverOnPerformanceTab();
			Log.info("Hover on Performance Tab");
			takeScreenShot("Test Case Pass");				
			Assert.assertEquals(true, performancePage.isAllTabsDisplayed());
			Log.info("All tabs are displayed");
		}
		catch(Exception e){
			e.printStackTrace();
			Assert.assertFalse(true, "Could not login.");
		}	
		finally{
			topnevigationmenupage.ClickOnUserName();
			Log.info("-------Verify Performance Tab Test Case Finished-----------");
		}
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}

