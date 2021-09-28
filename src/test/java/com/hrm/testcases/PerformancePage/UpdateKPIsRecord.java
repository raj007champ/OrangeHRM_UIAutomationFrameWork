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

public class UpdateKPIsRecord extends TestBase {
	
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
	
	@Test(description="HRMS-91:Edit record from Key Performance Indicators for Job Title table")
	public void UpdateRecordFromKPIs(){
		try{
			Log.startTestCase("-------Verify Performance Tab Test Case Stated-----------");			
			dashboardPage=loginPage.loginToApp(Config.getProperty("username"), Config.getProperty("password"));
			takeScreenShot("Login Successfully");
			Assert.assertTrue(performancePage.checkPresenceofPerformanceTab());
			Log.info("Performance Tab is Present");
			performancePage.hoverOnPerformanceTab();
			Log.info("Hover on Performance Tab");
			takeScreenShot("Test Case Pass");				
			performancePage.hoverOnConfigureTab();
			Log.info("Hover on Configure Tab");
			performancePage.clickKPIsText();
			Log.info("Click on KPIs Subtab");
			Assert.assertTrue(performancePage.checkPresenceofKeyPerIndiHeading());
			Log.info("Check persence of Key Performance Indicators for Job Title");			
			performancePage.clickAddBtn();
			performancePage.selectJobTitle("Automation tester");
			performancePage.enterKeyPerformanceIndicatorTextBox("Automation;");
			performancePage.minRatingTextBox("1");
			performancePage.maxRatingTextBox("5");
			performancePage.clickSaveBtn();
			performancePage.editKPIsRecord();
			performancePage.selectJobTitle("Quality Analyst");
			performancePage.enterKeyPerformanceIndicatorTextBox("Automation;");
			performancePage.minRatingTextBox("2");
			performancePage.maxRatingTextBox("7");
			performancePage.clickSaveBtn();
			Assert.assertEquals("Quality Analyst", performancePage.getJobTitle());
			Assert.assertEquals("2", performancePage.getMinRate());
			Assert.assertEquals("7", performancePage.getMaxRate());
			
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
