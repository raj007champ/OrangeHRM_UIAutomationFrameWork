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

public class VerifyRecruitmentTab extends TestBase{
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

	@Test(description="HRMS-65:Verify Recruitment tab")
	public void verifyRecruitmentTab(){
		try{
			Log.startTestCase("----Verify Recruitment Tab Test Case Started");
			String username= Config.getProperty("username");
			String password= Config.getProperty("password");	
			dashboardPage=loginPage.loginToApp(username,password);
			Assert.assertTrue(dashboardPage.WelcomeMessgae().contains("Welcome"));
			Log.info("User Navigated to Recruitment Page");
			recruitmentPage=dashboardPage.clickOnRecruitmentTab();
			Log.info("Verifying sub menu of recruitment tab");
			Assert.assertTrue(recruitmentPage.isSubMenuDisplayed());
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