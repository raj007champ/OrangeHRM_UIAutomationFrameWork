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

public class SearchJobVacancy_HiringManager extends TestBase{
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
	
	@Test(description="HRMS-77:Verify that user is able to filter job vacancy by selecting Hiring Manager")
	public void searchJobVacancy_HiringManager(){
		try{
			Log.startTestCase("----Search Job Vacancy by Hiring Manager Test Case Started");
			String username= Config.getProperty("username");
			String password= Config.getProperty("password");			
			dashboardPage=loginPage.loginToApp(username,password);
			Log.info("Login Successful: User is on Dashboard page");
			recruitmentPage=dashboardPage.clickOnRecruitmentTab();
			recruitmentPage.clickOnVacanciesTab();
			Log.info("User is navigated to Vacancies page");
			recruitmentPage.selectHiringManager_VacancySearch(TestConfig.VACANCYSEARCH_HIRINGMANAGER);
			recruitmentPage.clickOnSearchButton();
			Assert.assertTrue(recruitmentPage.JobvacanciesFilterByHiringManager(TestConfig.VACANCYSEARCH_HIRINGMANAGER));
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