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

public class ModifyCandidateData_CandidateTab extends TestBase{
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
	
	@Test(description="HRMS-80:Verify that user is able to edit and change the fields of the candidates from Recruitment tab")
	public void modifyCandidateData(){
		try{
			Log.startTestCase("----Modify Candidate Data Test Case Started");
			String username= Config.getProperty("username");
			String password= Config.getProperty("password");
			dashboardPage=loginPage.loginToApp(username,password);
			Log.info("Login Successful: User is on Dashboard page");
			recruitmentPage=dashboardPage.clickOnRecruitmentTab();	
			Log.info("User Navigated to Recruitment Page");
			recruitmentPage.clickOnCandidateName(TestConfig.CANDIDATE_FULL_NAME);
			Log.info("User navigated to Edit Candidate Information Page");
			recruitmentPage.clickOnSaveButton();
			recruitmentPage.setContactNo(TestConfig.UPDATED_CANDIDATE_CONTACT_NUMNBER);
			recruitmentPage.clickOnSaveButton();
			Log.info("Candidate contact number has been updated");
			recruitmentPage.clickOnBackButton();
			recruitmentPage.clickOnCandidateName(TestConfig.CANDIDATE_FULL_NAME);
			Assert.assertEquals(TestConfig.UPDATED_CANDIDATE_CONTACT_NUMNBER, recruitmentPage.getContactNo());
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