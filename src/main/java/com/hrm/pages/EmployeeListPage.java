package com.hrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.base.TestBase;
import com.hrm.util.Log;
import com.hrm.util.TestConfig;

public class EmployeeListPage extends TestBase {

	//WebDriver driver;

	public EmployeeListPage(){

		PageFactory.initElements(driver, this);
	}

	//Page Elements

	@FindBy(xpath=".//*[@id='employee-information']/a")
	WebElement EmployeeInformation;
	
	@FindBy(xpath="//input[@id='btnAdd']")
	WebElement AddEmployeeButton;

	@FindBy(xpath="//a[text()='q q']")
	WebElement NewEmployee;

	@FindBy(xpath="//input[@id='btnDelete']")
	WebElement DeleteEmployee;
	
	@FindBy(xpath="//input[@id='searchBtn']")
	WebElement SearchButton;

	@FindBy(xpath="//input[@id='dialogDeleteBtn']")
	WebElement DeleteDialogButton;
	
	@FindBy(xpath="//h1[text()='Add Employee']")
	WebElement AddEmployeeHeading;
	
	@FindBy(xpath="//p[text()='Delete records?']")
	WebElement DeleterecordsText;
	
	@FindBy(xpath="//input[@id='dialogDeleteBtn']/following::input[1]")
	WebElement CancelButton;
	
	@FindBy(xpath="//input[@id='empsearch_employee_name_empName']")
	WebElement EmployeeNameSearch;
	
	@FindBy(xpath="//input[@id='resetBtn']")
	WebElement ResetButton;
	
	@FindBy(xpath="//input[@id='empsearch_id']")
	WebElement EmployeeIdSearch;
	
	@FindBy(xpath="//input[@id='empsearch_supervisor_name']")
	WebElement SupervisorNameSearch;
	
	

	public boolean isEmployeeInformationDisplayed()
	{
		try{
			boolean test=EmployeeInformation.isDisplayed();
			if(test){
				Log.info("Employee Information is Displayed");
				return true;
			}
			else
			{
				Log.info("Employee Information is not Displayed");
				return false;
			}
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}

	}

	public boolean isAddedEmployeeDisplayed(String EmpName)
	{
		try{
			driver.findElement(By.xpath("//a[contains(text(),'"+EmpName+"')]")).isDisplayed();
			Log.info("Employee is Displayed on Employee List");
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}

	}
	
	public boolean isAddedEmployeeWithSupervisiorDisplayed(String SupervisiorName)
	{
		try{
			driver.findElement(By.xpath("//td[contains(text(),'"+SupervisiorName+"')]")).isDisplayed();
			Log.info("Supervisire name is Displayed on Employee List");
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}

	}
	
	public boolean verifyResetFunctionality(String EmpName )
	{
		try{
			EmployeeNameSearch.getText().equals("");
			Log.info("Employee'"+EmpName+"'is not Displayed in Employee Name Textbox on Employee Information");
			return true;
		}
		catch(Exception e){
			Log.info("Employee'"+EmpName+"'is Displayed in Employee Name Textbox on Employee Information");
			return false;
		}

	}
	
	public boolean isDeletedEmployeeDisplayed(String EmpName)
	{
		try{
			driver.findElement(By.xpath("//a[contains(text(),'"+EmpName+"')]")).isDisplayed();
			Log.info("Employee is Displayed on Employee List");
			return false;
		}
		catch(Exception e){
			//e.printStackTrace();
			return true;
		}

	}

	public void DeleteEmployee(String EmpName){
		try{
			driver.findElement(By.xpath("//a[contains(text(),'"+EmpName+"')]/preceding::input[1]")).click();
			Thread.sleep(1000);
			DeleteEmployee.click();
			Thread.sleep(300);
			DeleteDialogButton.click();
			Log.info("Employee is Deleted");

		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void clickOnAddButton(){
		try{
			AddEmployeeButton.click();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public boolean isAddEmployeeDisplayed()
	{
		try{
			boolean test=AddEmployeeHeading.isDisplayed();
			if(test){
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}

	}
	
	public void verifyDeleteEmployeeWindow(String EmpName){
		try{
			driver.findElement(By.xpath("//a[contains(text(),'"+EmpName+"')]/preceding::input[1]")).click();
			Thread.sleep(1000);
			DeleteEmployee.click();
			Thread.sleep(300);			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void clickOnSearchButton(String EmpName){
		try{
			EmployeeNameSearch.sendKeys(EmpName);
			Thread.sleep(1000);
			SearchButton.click();
			Log.info("Search Button Clicked");
			Thread.sleep(300);			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void clickOnResetButton(String EmpName){
		try{
			EmployeeNameSearch.sendKeys(EmpName);
			Thread.sleep(2000);
			ResetButton.click();
			Log.info("Reset Button Clicked");
			Thread.sleep(300);			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void verifyByEmployeeId(String EmpID){
		try{
			EmployeeIdSearch.sendKeys(EmpID);
			Thread.sleep(1000);
			SearchButton.click();
			Log.info("Search Button Clicked");
			Thread.sleep(300);			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void verifyBySupervisorName(String SupervisorName){
		try{
			SupervisorNameSearch.sendKeys(SupervisorName);
			Thread.sleep(1000);
			SearchButton.click();
			Log.info("Search Button Clicked");
			Thread.sleep(300);			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public boolean isDeleterecordsTextDisplayed()
	{
		try{
			boolean test=DeleterecordsText.isDisplayed();
			if(test){
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public void clickOnCancelButton(){
		try{
			CancelButton.click();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
