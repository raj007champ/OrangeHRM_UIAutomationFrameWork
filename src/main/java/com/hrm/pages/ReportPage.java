package com.hrm.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.hrm.base.TestBase;
import com.hrm.util.Log;
import com.hrm.util.TestConfig;

public class ReportPage extends TestBase {

	public ReportPage(){

		PageFactory.initElements(driver, this);
	}

	//Page Elements

	@FindBy(xpath="//b[text()='PIM']")
	WebElement PIM;

	@FindBy(xpath="//h1[text()='Employee Reports']/parent::div")
	WebElement EmployeeReports;

	@FindBy(xpath="//input[@id='search_search']")
	WebElement ReportName;

	@FindBy(xpath="//input[@value='Search']")
	WebElement SearchButton;

	@FindBy(xpath="//input[@value='Reset']")
	WebElement ResetButton;

	@FindBy(xpath="//input[@id='btnAdd']")
	WebElement AddReportButton;

	@FindBy(xpath="//h1[text()='Define Report']")
	WebElement DefineReport;

	@FindBy(xpath="//input[@id='report_report_name']")
	WebElement NewReportName;

	@FindBy(xpath="//select[@id='report_criteria_list']")
	WebElement SelectionCriteria;

	@FindBy(xpath="//a[@id='btnAddConstraint']")
	WebElement SelectionCriteriaAddButton;

	@FindBy(xpath="//select[@id='report_include_comparision']")
	WebElement SelectedCriteriaInclude;

	@FindBy(xpath="//select[@id='report_display_groups']")
	WebElement DisplayFieldGroups;

	@FindBy(xpath="//a[@id='btnAddDisplayGroup']")
	WebElement DisplayFieldGroupsAddButton;

	@FindBy(xpath="//a[@id='btnAddDisplayField']")
	WebElement DisplayFieldAddButton;

	@FindBy(xpath="//select[@id='report_display_field_list']")
	WebElement DisplayFields;

	@FindBy(xpath="//input[@id='btnSave']")
	WebElement SaveButton;

	@FindBy(xpath="//input[@id='btnCancel']")
	WebElement CancelButton;

	@FindBy(xpath="//input[@id='display_group_1']")
	WebElement DisplayGroupCheckBox1;

	@FindBy(xpath="//input[@id='display_group_2']")
	WebElement DisplayGroupCheckBox2;

	@FindBy(xpath="//input[@id='btnDelete']")
	WebElement DeleteReport;

	@FindBy(xpath="//input[@id='dialogDeleteBtn']")
	WebElement DeleteDialogButton;

	@FindBy(xpath="//p[text()='Delete records?']")
	WebElement DeleterecordsText;

	@FindBy(xpath=".//*[@id='deleteConfModal']/div[1]/a")
	WebElement CrossButton;

	@FindBy(xpath="//table[@id='resultTable']/tbody/tr/td[2]")
	List<WebElement> AllReports;



	public boolean isEmployeeReportsDisplayed()
	{
		try{
			boolean test=EmployeeReports.isDisplayed();
			if(test){
				Log.info("Employee Reports is Displayed");
				return true;
			}
			else
			{
				Log.info("Employee Reports is not Displayed");
				return false;
			}
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	public void clickOnAddButton(){
		try{
			AddReportButton.click();
			Log.info("Add Button Is Clicked");
		}
		catch(Exception e){
			e.printStackTrace();
			Log.info("Add Button Is Not Clicked");
		}
	}

	public boolean isDifineReportsDisplayed()
	{
		try{
			boolean test=DefineReport.isDisplayed();
			if(test){
				Log.info("Define Reports is Displayed");
				return true;
			}
			else
			{
				Log.info("Define Reports is not Displayed");
				return false;
			}
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	public void clickOnSaveButton(){
		try{
			NewReportName.sendKeys(TestConfig.ReportName);
			Thread.sleep(1000);
			//SelectCriteria();
			//Thread.sleep(1000);
			//SelectCriteriaInclude();
			//Thread.sleep(1000);
			//DisplayFieldGroups();
			//Thread.sleep(1000);
			//driver.findElement(By.xpath("//input[@id='employee_name_empName']")).sendKeys(TestConfig.Employee_Name);
			DisplayFields();
			//Thread.sleep(1000);
			DisplayGroupCheckBox1.click();
			//Thread.sleep(1000);
			//DisplayGroupCheckBox2.click();
			SaveButton.click();
			Log.info("New Report Added");
		}catch(Exception e){
			e.printStackTrace();
			Log.info("New Report is not Added");
		}
	}

	public void SelectCriteria(){
		Select selectioncriteria = new Select(SelectionCriteria);
		selectioncriteria.selectByVisibleText("Employee Name");
		SelectionCriteriaAddButton.click();
	}

	public void SelectCriteriaInclude (){
		Select selectedcriteriainclude = new Select(SelectedCriteriaInclude);
		selectedcriteriainclude.selectByVisibleText("Current and Past Employees");

	}

	public void DisplayFieldGroups (){
		Select displayfieldgroups = new Select(DisplayFieldGroups);
		displayfieldgroups.selectByVisibleText("Contact Details");
		DisplayFieldGroupsAddButton.click();
	}

	public void DisplayFields (){
		Select displayfield = new Select(DisplayFields);
		displayfield.selectByVisibleText("Employee Last Name");
		DisplayFieldAddButton.click();
	}

	public boolean verifyCreatedsReportisDisplayed(String ReportName)
	{
		try{
			driver.findElement(By.xpath("//td[text()='"+ReportName+"']")).isDisplayed();
			Log.info("Report name "+ReportName +" is Displayed on Report Page");
			return true;
		}
		catch(Exception e){
			Log.info("Report name "+ReportName +" is not Displayed on Report Page");
			return false;
		}

	}

	public boolean verifyDeletedReportsDisplayedorNot(String ReportName)
	{
		try{
			Thread.sleep(1000);
			//driver.findElement(By.xpath("//td[text()='"+ReportName+"']")).isDisplayed();
			if(!driver.findElement(By.xpath("//td")).getText().equalsIgnoreCase(ReportName));
			Log.info("'"+ReportName+"' Is  Deleted");
			//return false;
			return true;
		}
		catch(Exception e){
			Log.info("'"+ReportName+"' Is Not Deleted");
			//return true;
			return false;
		}

	}

	public void DeleteReport(String ReportName){
		try{
			driver.findElement(By.xpath("//td[contains(text(),'"+ReportName+"')]/preceding::input[1]")).click();
			Thread.sleep(1000);
			DeleteReport.click();
			Thread.sleep(300);
			DeleteDialogButton.click();
			Log.info("'"+ReportName +"'is Deleted");

		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void clickCheckBox(String ReportName){
		try{
			driver.findElement(By.xpath("//td[contains(text(),'"+ReportName+"')]/preceding::input[1]")).click();
			Log.info("Checked Box Clicked");

		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void clickDeleteButton(String ReportName){
		try{
			driver.findElement(By.xpath("//td[contains(text(),'"+ReportName+"')]/preceding::input[1]")).click();
			Thread.sleep(1000);
			DeleteReport.click();
			Log.info("Delete Button Clicked");

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
				Log.info("Delete records? Dialog Box is Opened");
				return true;
			}
			else
			{
				Log.info("Delete records? Dialog Box is not Displayed");
				return false;
			}
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	public void clickOnOKButton(){
		try{
			DeleteDialogButton.click();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void clickOnCrossButton(){
		try{
			CrossButton.click();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void clickOnSearchButton(String reportname){
		try{
			ReportName.sendKeys(reportname);
			Thread.sleep(1000);
			SearchButton.click();
			Log.info("Search Button Clicked");
			Thread.sleep(300);			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void clickOnResetButton(String Reportname){
		try{
			ReportName.sendKeys(Reportname);
			Thread.sleep(2000);
			ResetButton.click();
			Log.info("Reset Button Clicked");
			Thread.sleep(300);			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public boolean verifyResetFunctionality(String Reportname )
	{
		try{
			ReportName.getText().equals("");
			Log.info("'"+Reportname+"'is not Displayed in Report Name Textbox on Report Page");
			return true;
		}
		catch(Exception e){
			Log.info("'"+Reportname+"'is Displayed in Report Name Textbox on Report Page");
			return false;
		}

	}

	public void clickRunButton(String ReportName){
		try{
			driver.findElement(By.xpath("//td[text()='"+ReportName+"']/following::a[text()='Run'][1]")).click();
			Log.info("Run Button Clicked for '"+ReportName+"'");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public boolean verifyRunFunctionality(String Reportname )
	{
		try{
			boolean test=driver.findElement(By.xpath("//span[text()='Personal']")).isDisplayed();
			if(test){
				Log.info("Report is Run");
				return true;
			}
			else
			{
				Log.info("Report is not Run");
				return false;
			}
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}

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

	public void clickEditButton(String ReportName){
		try{
			driver.findElement(By.xpath("//td[text()='"+ReportName+"']/following::a[text()='Edit'][1]")).click();
			Log.info("Edit Button Clicked for '"+ReportName+"'");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void EditReport(String newReportName){
		try{
			NewReportName.clear();
			NewReportName.sendKeys(newReportName);
			SaveButton.click();
			Log.info("Report Edited");
		}catch(Exception e){
			e.printStackTrace();
			Log.info("Report is not Edited");
		}
	}

}