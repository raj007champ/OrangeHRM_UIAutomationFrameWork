package com.hrm.MyInfoTab;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrm.base.TestBase;
import com.hrm.pages.DashboardPage;
import com.hrm.pages.LoginPage;
import com.hrm.pages.MyInfoPage;
import com.hrm.util.Config;
import com.hrm.util.Log;

public class MyInfoNavigationTest extends TestBase {

	/**
	 * 
	 * Open the Ornage HRM login page->	Validate that user is able to navigate to Orange Hrm login page
       Now login with the valid credentials	-> Validate that user is able to login with valid credentials and navigated to dashboard page
       Check for the presence of My Info link on dashboard page	-> Validate that My Info link is present on dashboard page
       Click on My Info link from the dasboard page-> 	Validate that user is able to click on MyInfo section and navigated to MyInfo page
       Click on Logout->Validate that user is able to logout from the application.
	 * 
	 * 
	 */
	
	LoginPage loginPage;
	DashboardPage dashboardPage=null;
	MyInfoPage myinfo;
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage=new LoginPage();
		dashboardPage=new DashboardPage();
		//myinfo=new MyInfoPage(driver);
	}
	
	@Test(description="HRMS-48:Validate that user is able to edit the personal details information from My info tab")
	public void NavigationToMyInfoTest() throws IOException {	
		
		Log.startTestCase("MyInfoNavigationTest");
		Log.info("Starting the Login Process");
	
		loginPage.loginToApp(Config.getProperty("username"),Config.getProperty("password"));
		
		//Assert.assertTrue(dashboardPage.WelcomeMessgae().contains("Welcome"));
		Log.info("Checking for the presence of MyInfoHeader");
		Assert.assertTrue(dashboardPage.PresenceofMyinfoTabHeader());
		Log.info("Clicked on MyInfo tab present at header to Navigate  to MyInfo Tab");
		myinfo=dashboardPage.ClickOnMyInfoHeader();	
		takeScreenShot("MyInfo Page");
		
		Assert.assertTrue(myinfo.CheckPresenceofEmplyeeInfoBox());
			
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	
}
