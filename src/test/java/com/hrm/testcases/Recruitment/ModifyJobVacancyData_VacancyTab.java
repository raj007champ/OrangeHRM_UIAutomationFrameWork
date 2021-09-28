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

public class ModifyJobVacancyData_VacancyTab extends TestBase{
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
	
	@Test(description="HRMS-74:Verify that user is able to edit the job vacancies and save the changes.")
	public void modifyNoOfPositionFromJobVacancy(){
		try{
			Log.startTestCase("----Modify Job Vacancy Data of Vacancy Tab Test Case Started");
			String username= Config.getProperty("username");
			String password= Config.getProperty("password");	
			dashboardPage=loginPage.loginToApp(username,password);
			Assert.assertTrue(dashboardPage.WelcomeMessgae().contains("Welcome"));
			Log.info("Login Successful: User is on Dashboard page");
			recruitmentPage=dashboardPage.clickOnRecruitmentTab();
			recruitmentPage.clickOnVacanciesTab();
			Log.info("User is navigated to Vacancies page");
			recruitmentPage.clickOnVacancyName(TestConfig.VACANCYSEARCH_JOBVACANCYNAME);
			Log.info("User navigated to Edit Job Vacancy Page");
			recruitmentPage.clickOnSaveButton();
			recruitmentPage.setNoOfPositions(TestConfig.UPDATED_NUMBER_OF_POSITIONS);
			recruitmentPage.clickOnSaveButton();
			recruitmentPage.clickOnBackButton();
			recruitmentPage.clickOnVacancyName(TestConfig.VACANCYSEARCH_JOBVACANCYNAME);
			Assert.assertEquals(TestConfig.UPDATED_NUMBER_OF_POSITIONS, recruitmentPage.getNoOfPositions());	
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