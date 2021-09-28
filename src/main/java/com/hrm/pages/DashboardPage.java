package com.hrm.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.base.TestBase;

import io.qameta.allure.Step;

public class DashboardPage extends TestBase{
	
		
		public DashboardPage()
		{
			PageFactory.initElements(driver, this);
		}
		

		@FindBy(id="welcome")
		WebElement welcomeMessage;
		
		@FindBy(xpath="//b[text()='PIM']")
		WebElement PIM;
		
		@FindBy(id="menu_recruitment_viewRecruitmentModule")
		WebElement Recruitment;
		
		public String WelcomeMessgae() {
			return welcomeMessage.getText();
		}
		
		public PIMPage clickOnPIMTab(){
			try{
				PIM.click();
				return new PIMPage();
			}
			catch(Exception e){
				e.printStackTrace();
				return null;
			}
			
		}
		
		@FindBy(xpath=".//*[@id='menu_admin_viewAdminModule']/b")
		public static WebElement Admin;
		public AdminPage clickOnAdminTab(){
			try{
				Admin.click();
				return new AdminPage();
			}
			catch(Exception e){
				e.printStackTrace();
				return null;
			}
			
		}
		
		@Step("User Navigated to Recruitment Tab")
		public RecruitmentPage clickOnRecruitmentTab() {
			try {
				Recruitment.click();
				return new RecruitmentPage();
			}
			catch(Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		
		@FindBy(id="menu_pim_viewMyDetails")
		WebElement my_info_menu;

		public MyInfoPage ClickOnMyInfoHeader() {
			my_info_menu.click();
			return new MyInfoPage();
		}

		public boolean PresenceofMyinfoTabHeader() {
			return my_info_menu.isDisplayed();
		}
}
