package com.hrm.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.hrm.base.TestBase;

public class PerformancePage extends TestBase {
	
	public PerformancePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//b[text()='Performance']")
	WebElement PerformanceTab;
	
	@FindBy(id="menu_performance_Configure")
	WebElement ConfigureTab;
	
	@FindBy(xpath="//a[text()='KPIs']")
	WebElement KPIsTab;
	
	@FindBy(xpath="//a[text()='Trackers']")
	WebElement TrackersTab;
	
	@FindBy(id="menu_performance_ManageReviews")
	WebElement ManageReviewesTab;
	
	@FindBy(id="menu_performance_viewMyPerformanceTrackerList")
	WebElement MyTrackersTab;
	
	@FindBy(id="menu_performance_viewEmployeePerformanceTrackerList")
	WebElement EmployeeTrakersTab;
	
	@FindBy(xpath="//h1[text()='Key Performance Indicators for Job Title']")
	WebElement KeyPerIndiHeading;
	
	@FindBy(id="btnAdd")
	WebElement AddBtn;
	
	@FindBy(xpath="//select[@class='formSelect']")
	WebElement JobTitle;
	
	@FindBy(id="defineKpi360_keyPerformanceIndicators")
	WebElement KeyPerformanceIndicator;
	
	@FindBy(id="defineKpi360_minRating")
	WebElement MinRating;
	
	@FindBy(id="defineKpi360_maxRating")
	WebElement MaxRating;
	
	@FindBy(id="saveBtn")
	WebElement SaveBtn;
	
	@FindBy(id="ohrmList_chkSelectAll")
	WebElement ChkSelectAll;
	
	@FindBy(xpath="//input[@value='Cancel']")
	WebElement CancleBtn;
	
	@FindBy(id="btnDelete")
	WebElement DeleteBtn;
	
	@FindBy(xpath="//*[@id=\"resultTable\"]/tbody/tr[1]/td[2]/a")
	WebElement KPIsRecord;
	
	@FindBy(xpath="//*[@id=\"resultTable\"]/tbody/tr[1]/td[3]")
	WebElement UpdatedJobTitle;
	
	@FindBy(xpath="//*[@id=\"resultTable\"]/tbody/tr[1]/td[4]")
	WebElement UpdatedMinRate;
	
	@FindBy(xpath="//*[@id=\"resultTable\"]/tbody/tr[1]/td[5]")
	WebElement UpdatedMaxRate;
	
	@FindBy(xpath="//*[@id=\"searchKpi\"]//li//select[@class=\"formSelect\"]")
	WebElement JobtitleDrpdwn;
	
	@FindBy(id="searchBtn")
	WebElement SearchBtn;
	
	@FindBy(xpath="//*[@id=\"resultTable\"]/tbody/tr[1]/td[3]")
	WebElement JobtitleAfterSearch;
	
	@FindBy(id="dialogDeleteBtn")
	WebElement OkBtn;		
	
	public boolean checkPresenceofPerformanceTab() {
		return PerformanceTab.isDisplayed();
	}
	
	public void hoverOnPerformanceTab() {
		Actions builder = new Actions(driver);
		builder.moveToElement(PerformanceTab).build().perform();
	}
	
	public void hoverOnConfigureTab() {
		Actions builder = new Actions(driver);
		builder.moveToElement(ConfigureTab).build().perform();
	}
	
	public void hoverOnManageReviewesTab() {
		Actions builder = new Actions(driver);
		builder.moveToElement(ManageReviewesTab).build().perform();
	}
	
	public boolean getKPIsText() {
		return KPIsTab.isDisplayed();
	}
	
	public String getTrackersText() {
		return TrackersTab.getText();
	}
		
	public boolean isAllTabsDisplayed()
	{		
		if((ConfigureTab.isDisplayed())&&(ManageReviewesTab.isDisplayed())&&(MyTrackersTab.isDisplayed())&&(EmployeeTrakersTab.isDisplayed())){
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean getKeyPerIndiHeading() {
		return KeyPerIndiHeading.isDisplayed();
	}
	
	public void clickKPIsText() {
		KPIsTab.click();
	}
	
	public void clickAddBtn() {
		AddBtn.click();
	}
	
	public void selectJobTitle(String option) {
		Select jobtitle= new Select(JobTitle);
		jobtitle.selectByVisibleText(option);		
	}
	
	public void enterKeyPerformanceIndicatorTextBox(String KPI) {
		KeyPerformanceIndicator.clear();
		KeyPerformanceIndicator.sendKeys(KPI);
	}
	
	public void minRatingTextBox(String minRating) {
		MinRating.clear();
		MinRating.sendKeys(minRating);
	}
	
	public void maxRatingTextBox(String maxRating) {
		MaxRating.clear();
		MaxRating.sendKeys(maxRating);
	}
	
	public boolean checkPresenceofKeyPerIndiHeading() {
		return PerformanceTab.isDisplayed();
	}
	
	public void clickSaveBtn() {
		try {
			waitForElementToBeClickable(SaveBtn);
			SaveBtn.click();
			}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickChkSelectAll() {	
		try {
			waitForElementToBeClickable(ChkSelectAll);
			ChkSelectAll.click();
			}
		catch(Exception e) {
			e.printStackTrace();
			}
	}
	
	public void clickCancleBtn() {		
		CancleBtn.click();
	}
	
	public void clickDeleteBtn() {	
		try {
			waitForElementToBeClickable(DeleteBtn);
			DeleteBtn.click();
			}
		catch(Exception e) {
			e.printStackTrace();
			}		
	}
	
	public void editKPIsRecord() {	
		try {
			waitForElementToBeClickable(KPIsRecord);
			KPIsRecord.click();
			}
		catch(Exception e) {
			e.printStackTrace();
			}
	}
	
	public String getJobTitle() {
		return UpdatedJobTitle.getText();
	}
	
	public String getMinRate() {
		return UpdatedMinRate.getText();
	}
	
	public String getMaxRate() {
		return UpdatedMaxRate.getText();
	}
	
	public void selectJobTitlefromDrpDwn(String option) {
		Select JobtitleDrpdwn= new Select(JobTitle);
		JobtitleDrpdwn.selectByVisibleText(option);		
	}
	
	public void clickSearchBtn() {	
		try {
			waitForElementToBeClickable(SearchBtn);
			SearchBtn.click();
			}
		catch(Exception e) {
			e.printStackTrace();
			}
	}	
	
	public String getJobTitleAfterSearch() {
		return JobtitleAfterSearch.getText();
	}
	
	public void clickOkBtn() {	
		try {
			waitForElementToBeClickable(OkBtn);
			OkBtn.click();
			}
		catch(Exception e) {
			e.printStackTrace();
			}
	}
	
	public boolean SaveSuccessMessage(){		
		return driver.findElement(By.xpath(".//div[@class='message success fadable']")).isDisplayed();
	}
	
	@FindBy(id="menu_performance_addPerformanceTracker")
	WebElement TrackerTab;
	
	@FindBy(xpath="//*[@id=\"addPerformanceTracker_availableEmp\"]/option[1]")
	WebElement FristOptionAvailableReviewvers;
	
	@FindBy(xpath="//*[@id=\"addPerformanceTracker_assignedEmp\"]/option")
	WebElement AssignedReviewvers;
	
	@FindBy(id="btnAssignEmployee")
	WebElement AssignedEmployeeAddBtn;
	
	@FindBy(id="btnRemoveEmployee")
	WebElement RemoveBtn;
	
	@FindBy(id="addPerformanceTracker_tracker_name")
	WebElement TrackerName;
	
	@FindBy(id="addPerformanceTracker_employeeName_empName")
	WebElement EmployeeName;
	
	@FindBy(id="btnSave")
	WebElement TrackerSaveBtn;
	
	@FindBy(id="btnCancel")
	WebElement TrackerCancelBtn;
	
	@FindBy(xpath="//*[@id=\"search-results\"]/div[1]/h1")
	WebElement PerformanceTracker;
	
	@FindBy(xpath="//*[@id=\"resultTable\"]/tbody/tr[1]/td[3]/a")
	WebElement PerformanceTrackerRecord;
	
	@FindBy(id="ohrmList_chkSelectAll")
	WebElement TrackerchkSelectAll;
	
	@FindBy(id="btnDelete")
	WebElement TrackersDeleteBtn;
	
	@FindBy(id="dialogDeleteBtn")
	WebElement TrackersDialogDeleteBtn;
	
	public void clickTrackersTab() {	
		try {
			waitForElementToBeClickable(TrackersTab);
			TrackersTab.click();
			}
		catch(Exception e) {
			e.printStackTrace();
			}
	}	
	
	public String getFristOptionAvailableReviewvers() {
		return FristOptionAvailableReviewvers.getText();
	}
		
	public void AddAvailableReviewertoAssignedReviewver() {	
		try {
			waitForElementToBeClickable(FristOptionAvailableReviewvers);
			//FristOptionAvailableReviewvers.click();
			List<WebElement> options = driver.findElements(By.xpath("//*[@id=\"addPerformanceTracker_availableEmp\"]/option"));

			for (WebElement option : options) {
			    if (option.getText().contains("Yogiraj Ghumade")) {
			        option.click();
			        break;
			    }
			}
			AssignedEmployeeAddBtn.click();
			}
		catch(Exception e) {
			e.printStackTrace();
			}
	}
	
	public String getAssignedReviewvers() {
		return AssignedReviewvers.getText();
	}
	
	public boolean RemoveAssignedReviewer() {	
		try {
			waitForElementToBeClickable(FristOptionAvailableReviewvers);
			List<WebElement> options = driver.findElements(By.xpath("//*[@id=\"addPerformanceTracker_availableEmp\"]/option"));
			for (WebElement option : options) {
			    if (option.getText().contains("Yogiraj Ghumade")) {
			        option.click();			        
			    }
			}			
			AssignedEmployeeAddBtn.click();	
			waitForElementToBeClickable(AssignedReviewvers);
			RemoveBtn.click();
			Thread.sleep(2000);
			List<WebElement> assignedReviewvers= driver.findElements(By.xpath("//*[@id=\"addPerformanceTracker_assignedEmp\"]/option"));
			for (WebElement option : assignedReviewvers) {
			    if (option.getText().contains("Yogiraj Ghumade")) {
			        return true;		        
			    }			  
			}
			RemoveBtn.click();
			Thread.sleep(2000);
			List<WebElement> AvailableEmp= driver.findElements(By.xpath("//*[@id=\"addPerformanceTracker_availableEmp\"]/option"));
			for (WebElement option : AvailableEmp) {
			    if (option.getText().contains("Yogiraj Ghumade")) {
			        return true;		        
			    }			  
			}
			}
		catch(Exception e) {
			e.printStackTrace();
			}
		return false;
	}
	
	public void clickTrackerCancelBtn() {	
		try {
			waitForElementToBeClickable(TrackerCancelBtn);
			TrackerCancelBtn.click();
			}
		catch(Exception e) {
			e.printStackTrace();
			}
	}	
	
	public String getPerformanceTracker() {
		return PerformanceTracker.getText();
	}
	
	public void enterTrackerNameTextBox(String TrackName) {
		TrackerName.clear();		
		TrackerName.sendKeys(TrackName);
	}
	
	public void enterEmployeeNameTextBox(String EmpName) {
		EmployeeName.clear();
		EmployeeName.clear();
		EmployeeName.sendKeys(EmpName);
	}
	
	public void clickTrackersSaveBtn() {	
		try {
			waitForElementToBeClickable(TrackerSaveBtn);
			TrackerSaveBtn.click();
			}
		catch(Exception e) {
			e.printStackTrace();
			}
	}	
	
	public void UpdateEmpPerformanceRecord(String TrackName, String AvailableReviewer) {	
		try {
			waitForElementToBeClickable(PerformanceTrackerRecord);
			PerformanceTrackerRecord.click();
			TrackerName.clear();			
			TrackerName.sendKeys(TrackName);
			EmployeeName.clear();
			List<WebElement> options = driver.findElements(By.xpath("//*[@id=\"addPerformanceTracker_availableEmp\"]/option"));
			for (WebElement option : options) {
			    if (option.getText().contains(AvailableReviewer)) {
			        option.click();
			        break;
			    }
			}
			AssignedEmployeeAddBtn.click();
			TrackerSaveBtn.click();
			}
		catch(Exception e) {
			e.printStackTrace();
			}
	}
	
	public String getPerformanceTrackerRecord() {
		return PerformanceTrackerRecord.getText();
	}
	
	public void clickTrackerchkSelectAll() {	
		try {
			waitForElementToBeClickable(TrackerchkSelectAll);
			TrackerchkSelectAll.click();
			}
		catch(Exception e) {
			e.printStackTrace();
			}
	}	
	
	public void clickTrackersDeleteBtn() {	
		try {
			waitForElementToBeClickable(TrackersDeleteBtn);
			TrackersDeleteBtn.click();
			}
		catch(Exception e) {
			e.printStackTrace();
			}
	}
	
	public void clickTrackersDialogDeleteBtn() {	
		try {
			waitForElementToBeClickable(TrackersDialogDeleteBtn);
			TrackersDialogDeleteBtn.click();
			}
		catch(Exception e) {
			e.printStackTrace();
			}
	}
	
	public boolean DeleteSuccessMessage(){		
		return driver.findElement(By.xpath(".//div[@class='message success fadable']")).isDisplayed();
	}
	
	@FindBy(xpath="//a[text()='Manage Reviews']")
	WebElement ManageReviewsTab;
	
	@FindBy(xpath="//a[text()='My Reviews']")
	WebElement MyReviewsTab;
	
	@FindBy(xpath="//a[text()='Review List']")
	WebElement ReviewListTab;
	
	@FindBy(xpath="//*[@id=\"resultTable\"]/tbody/tr/td[1]/a")
	WebElement EmpLink;
	
	@FindBy(id="addperformanceTrackerLog_log")
	WebElement LogTextBox;
	
	@FindBy(id="addperformanceTrackerLog_comment")
	WebElement CommentBox;
	
	public boolean ManageReviewAllSutTabsDisplayed()
	{		
		if((ManageReviewsTab.isDisplayed())&&(MyReviewsTab.isDisplayed())&&(ReviewListTab.isDisplayed())&&(EmployeeTrakersTab.isDisplayed())){
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void CancleUpdateEmployeeTrakersTab() {	
		try {
			waitForElementToBeClickable(EmployeeTrakersTab);
			EmployeeTrakersTab.click();			
			EmpLink.click();
			AddBtn.click();
			CancleBtn.click();				
			}
		catch(Exception e) {
			e.printStackTrace();
			}
	}
	
	public void AddEmployeeTrakersLog() {	
		try {
			waitForElementToBeClickable(EmployeeTrakersTab);
			EmployeeTrakersTab.click();			
			EmpLink.click();
			AddBtn.click();
			LogTextBox.clear();
			LogTextBox.sendKeys("Execellent");
			List<WebElement> options = driver.findElements(By.xpath("//*[@id=\"addperformanceTrackerLog_achievement\"]/option"));
			for (WebElement option : options) {
			    if (option.getText().contains("Positive")) {
			        option.click();			        
			    }
			}
			CommentBox.clear();
			CommentBox.sendKeys("Working Hard");	
			SaveBtn.click();
			}
		catch(Exception e) {
			e.printStackTrace();
			}
	}
	
	public boolean UpdateEmployeeTrakersLog() {	
		try {
			waitForElementToBeClickable(EmpLink);					
			EmpLink.click();			
			LogTextBox.clear();
			LogTextBox.sendKeys("Better");
			List<WebElement> options = driver.findElements(By.xpath("//*[@id=\"addperformanceTrackerLog_achievement\"]/option"));
			for (WebElement option : options) {
			    if (option.getText().contains("Positive")) {
			        option.click();			        
			    }
			}
			CommentBox.clear();
			CommentBox.sendKeys("Work Hard");	
			SaveBtn.click();
			Thread.sleep(1000);
			List<WebElement> updatedLog = driver.findElements(By.xpath("//*[@id=\"resultTable\"]/tbody/tr/td[2]"));
			for (WebElement option : updatedLog) {
			    if (option.getText().contains("Better")) {
			        return true;	        
			    }
			}
			}
		catch(Exception e) {
			e.printStackTrace();
			}
		return false;
	}
	
	@FindBy(xpath="//*[@alt=\"Edit\"]")
	WebElement ReadComment;	
	
	@FindBy(xpath="//div[@id=\"commentDialog\"]/div/a[@class=\"close\"]")
	WebElement CloseCommentBox;
	
	@FindBy(xpath="//*[@id=\"commentDialog\"]/div[1]/h3")
	WebElement PerformanceTrackersLogComment;
	
	public boolean ReadEmployeeComment() {	
		try {
			waitForElementToBeClickable(ReadComment);
			ReadComment.click();
			System.out.println(PerformanceTrackersLogComment.getText());
			String text=PerformanceTrackersLogComment.getText();
			if(text=="Performance Tracker Log Comment") {
				return true;
			}	
			CloseCommentBox.click();
			}
		catch(Exception e) {
			e.printStackTrace();
			}
		return false;
	}
	
	@FindBy(xpath="//*[@id=\"performanceReview360SearchForm_employeeName\"]")
	WebElement EmpName;
	
	@FindBy(xpath="//*[@id=\"performanceReview360SearchForm_reviwerName\"]")
	WebElement ReviewerName;
	
	@FindBy(id="btnReset")
	WebElement ResetBtn;
	
	@FindBy(xpath="//*[@id=\"menu_performance_searchPerformancReview\"]")
	WebElement ManageReviewSubTab;
	
	public boolean ResetSearchPerformanceReview() {	
		try {		
			ManageReviewSubTab.click();
			EmpName.clear();
			EmpName.sendKeys("Pallavi Yadav");			
			ReviewerName.clear();
			ReviewerName.sendKeys("Yogiraj Ghumade");
			ResetBtn.click();
			String classAtr=EmpName.getAttribute("class");
			if(classAtr=="ac_input inputFormatHint") {
				return true;
			}
			String ReviewerClassAtr=ReviewerName.getAttribute("class");
			if(ReviewerClassAtr=="ac_input inputFormatHint") {
				return true;
			}			
			}
		catch(Exception e) {
			e.printStackTrace();
			}
		return false;
	}



}
