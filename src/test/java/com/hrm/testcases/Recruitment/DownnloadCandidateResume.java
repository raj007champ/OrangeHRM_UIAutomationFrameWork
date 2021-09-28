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
import com.hrm.util.TestConfig;

public class DownnloadCandidateResume extends TestBase{
	
	LoginPage loginPage;
	DashboardPage dashboardPage;
	RecruitmentPage recruitmentPage;
	TopNevigationMenuPage topnevigationmenupage;
	
	@BeforeMethod
	public void setUp() {
		if(Config.getProperty("local.browser.type").equalsIgnoreCase("CHROME") || Config.getProperty("local.browser.type").equalsIgnoreCase("IE"))
			initialization();
		else
			setFirefoxProfile();
		loginPage=new LoginPage();
		topnevigationmenupage=new TopNevigationMenuPage();
	}
	
	@Test(description="HRMS-81:Verify that user is able to download the particular candidate Resume")
	public void downloadCandidatedResume(){
		try{
			Log.startTestCase("----Download Candidate Resume Test Case Started");
			String username= Config.getProperty("username");
			String password= Config.getProperty("password");
			dashboardPage=loginPage.loginToApp(username,password);
			Log.info("Login Successful: User is on Dashboard page");
			recruitmentPage=dashboardPage.clickOnRecruitmentTab();	
			Log.info("User Navigated to Recruitment Page");			
			recruitmentPage.downloadResume(TestConfig.CANDIDATE_FULL_NAME);
			Log.info("Candiate: "+TestConfig.CANDIDATE_FULL_NAME+" resume has been downloaded");
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