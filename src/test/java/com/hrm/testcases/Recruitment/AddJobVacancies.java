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

public class AddJobVacancies extends TestBase{
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

	@Test(groups= {"AddJobVacancy"},description="HRMS-69:Verify add job vacancies functionality of Recruitment")
	public void verifyJobVacancyAddFunctionality(){
		try{
			Log.startTestCase("----Add Job Vacanncy Test Case Started");
			String username= Config.getProperty("username");
			String password= Config.getProperty("password");
			dashboardPage=loginPage.loginToApp(username,password);
			Log.info("Login Successful: User is on Dashboard page");
			recruitmentPage=dashboardPage.clickOnRecruitmentTab();
			Log.info("User Navigated to Recruitment Page");
			recruitmentPage.clickOnVacanciesTab();
			recruitmentPage.clickOnAddButton();
			Log.info("User navigated to Add Job Vacancy Page");
			recruitmentPage.addJobVacancyDetails();
			Log.info("Added job vancancy details");
			recruitmentPage.clickOnSaveButton();
			Log.info("Job Vacancy details are saved");
			recruitmentPage.clickOnBackButton();
			Assert.assertTrue(recruitmentPage.verifyJobVacancyPresent(TestConfig.VACANCY_NAME));
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