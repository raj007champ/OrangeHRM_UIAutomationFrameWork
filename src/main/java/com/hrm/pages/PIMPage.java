package com.hrm.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.base.TestBase;
import com.hrm.util.Log;

public class PIMPage extends TestBase{

	public PIMPage(){
		PageFactory.initElements(driver, this);
	}

	//Page Elements
	@FindBy(xpath="//a[text()='Employee List']")
	WebElement EmployeeList;

	@FindBy(xpath="//a[text()='Add Employee']")
	WebElement AddEmployee;

	@FindBy(xpath="//a[text()='Reports']")
	WebElement Reports;

	@FindBy(xpath=".//*[@id='menu_pim_Configuration']")
	WebElement Configuration;

	public boolean isAllOtherTabDisplayed()
	{
		/*boolean test=EmployeeList.isDisplayed();
		boolean tes1t=AddEmployee.isDisplayed();
		boolean test1=Reports.isDisplayed();
		boolean test2=Configuration.isDisplayed();*/
		if((EmployeeList.isDisplayed())&&(AddEmployee.isDisplayed())&&(Reports.isDisplayed())&&(Configuration.isDisplayed())){
			return true;
		}
		else
		{
			return false;
		}
	}

	//Click On Employee List
	public void clickOnEmployeeList(){
		try{
			Actions action = new Actions(driver);
			action.moveToElement(EmployeeList).click().perform();
			Log.info("Employee List Tab is Clicked");

		}
		catch(Exception e){
			Log.info("Employee List Tab is not Clicked");
			e.printStackTrace();

		}
	}

	//Click On Add Employee 
	public void clickOnAddEmployee(){
		try{
			Actions action = new Actions(driver);
			action.moveToElement(AddEmployee).click().perform();
		}
		catch(Exception e){
			Log.info("Add Employee Tab is not Clicked");
			e.printStackTrace();

		}
	}
	
	//Click On Reports
		public void clickOnReports(){
			try{
				Actions action = new Actions(driver);
				action.moveToElement(Reports).click().perform();
			}
			catch(Exception e){
				Log.info("Reports Tab is not Clicked");
				e.printStackTrace();

			}
		}

}
