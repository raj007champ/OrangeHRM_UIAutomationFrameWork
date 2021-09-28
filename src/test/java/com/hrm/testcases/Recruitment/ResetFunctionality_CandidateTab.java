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

public class ResetFunctionality_CandidateTab extends TestBase{
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
	
	@Test(description="HRMS-83:Verify that reset functionality is working on Candidates page of Recruitment tab")
	public void verifyResetFunctionality(){
		try{
			Log.startTestCase("----Reset Functionality on Candidate Test Case Started");
			String username= Config.getProperty("username");
			String password= Config.getProperty("password");
			dashboardPage=loginPage.loginToApp(username,password);
			Log.info("Login Successful: User is on Dashboard page");
			recruitmentPage=dashboardPage.clickOnRecruitmentTab();	
			Log.info("User Navigated to Recruitment Page");
			recruitmentPage.selectJobTitle_CandidateSearch(TestConfig.CANDIDATE_JOBTITLE);
			recruitmentPage.selectJobVacancy_CandidateSearch(TestConfig.CANDIDATE_JOBVACANCYNAME);
			recruitmentPage.selectHiringManager_CandidateSearch(TestConfig.CANDIDATE_HIRINGMANAGER);
			recruitmentPage.selectStatus_CandidateSearch(TestConfig.CANDIDATE_STATUS);
			recruitmentPage.clickOnResetButton();	
			Assert.assertTrue(recruitmentPage.verifyCandidatesFieldsDefaultValue());
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