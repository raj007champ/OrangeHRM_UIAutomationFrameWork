package com.hrm.testcases.Recruitment;

import java.net.MalformedURLException;
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

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class AddCandidate extends TestBase{
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
	
	
	@Description("Test Description: Add Candidate in Recruitment")
	@Severity(SeverityLevel.CRITICAL)
	@Test(groups= {"AddCandidate"},description="HRMS-78:Verify that user is able to add the candidates in Recruitment")
	public void verifyAddCandidatedFunctionality()throws MalformedURLException{
		try{
			Log.startTestCase("----Add Candidate Test Case Started");
			String username= Config.getProperty("username");
			String password= Config.getProperty("password");
			takeScreenShot("Home Page");
			dashboardPage=loginPage.loginToApp(username,password);
			Log.info("Login Successful: User is on Dashboard page");
			recruitmentPage=dashboardPage.clickOnRecruitmentTab();	
			Log.info("User Navigated to Recruitment Page");
			recruitmentPage.clickOnAddButton();
			Log.info("User navigated to Add Candidate Information Page");
			recruitmentPage.addCandidateDetails();
			Log.info("Added candidates details");
			recruitmentPage.clickOnSaveButton();
			Log.info("Candidate details are saved");
			recruitmentPage.clickOnBackButton();
			Assert.assertTrue(recruitmentPage.verifyCandidatePresent(TestConfig.CANDIDATE_FULL_NAME));
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