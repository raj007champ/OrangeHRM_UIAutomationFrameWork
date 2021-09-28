package com.hrm.testcases.Recruitment;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.hrm.base.TestBase;
import com.hrm.pages.DashboardPage;
import com.hrm.pages.LoginPage;
import com.hrm.pages.RecruitmentPage;
import com.hrm.pages.TopNevigationMenuPage;
import com.hrm.util.Config;
import com.hrm.util.Log;

public class VerifyCandidatesTab extends TestBase{
	LoginPage loginPage;
	DashboardPage dashboardPage;
	RecruitmentPage recruitmentPage;
	TopNevigationMenuPage topnevigationmenupage;
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage=new LoginPage();
		topnevigationmenupage=new TopNevigationMenuPage();
	}
	
	@Test(description="HRMS-66:Verify that Candidates tab should be by default selected on Recruitment page")
	public void verifyCandidateTab(){
		try{
			Log.startTestCase("----Verify Candidates Tab Test Case Started");
			String username= Config.getProperty("username");
			String password= Config.getProperty("password");	
			dashboardPage=loginPage.loginToApp(username,password);
			Log.info("Login Successful: User is on Dashboard page");
			recruitmentPage=dashboardPage.clickOnRecruitmentTab();
			Log.info("User Navigated to Recruitment Page");
			Log.info("Verifying candidates tab is by default selected");
			Assert.assertTrue(recruitmentPage.isCandidateTabSelected());
			Log.info("Test Case Passed");
		}
		catch(Exception e){
			e.printStackTrace();
			Assert.assertFalse(true, "Could not login.");
		}
	}

	@AfterMethod
	public void tearDown(){
		topnevigationmenupage.ClickOnUserName();
		Log.endTestCase();
		driver.quit();
	}
}