package com.hrm.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrm.base.TestBase;
import com.hrm.pages.DashboardPage;
import com.hrm.pages.LoginPage;
import com.hrm.pages.TopNevigationMenuPage;
import com.hrm.util.Config;
import com.hrm.util.Log;

public class LoginTest extends TestBase{
	LoginPage loginPage;
	DashboardPage dashboardPage;
	TopNevigationMenuPage topnevigationmenupage;
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage=new LoginPage();
		dashboardPage=new DashboardPage();
		topnevigationmenupage=new TopNevigationMenuPage();
	}
	
	@Test
	public void SucessfullLoginTest() throws IOException {	
		try{
			Log.startTestCase("LoginTest");
			String username= Config.getProperty("username");
			Log.info("Username entered in the Username text box");
			String password= Config.getProperty("password");
			Log.info("Password entered in the Username text box");
			loginPage.loginToApp(username,password);
			Log.info("Click action performed on Login button");
			Assert.assertTrue(dashboardPage.WelcomeMessgae().contains("Welcome"));
			takeScreenShot("Dashboard Page");
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
