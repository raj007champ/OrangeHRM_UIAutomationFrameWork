package com.hrm.pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.hrm.base.TestBase;
import com.hrm.util.Log;
import com.hrm.util.TestConfig;

import io.qameta.allure.Step;

public class RecruitmentPage extends TestBase{
	
	public RecruitmentPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@id='menu_recruitment_viewCandidates']//parent::li")
	WebElement candidatesTab;
	
	@FindBy(id="menu_recruitment_viewJobVacancy")
	WebElement vacanciesTab;
	
	@FindBy(id="btnSrch")
	WebElement searchBtn;
	
	@FindBy(id="btnRst")
	WebElement resetBtn;
	
	@FindBy(id="btnAdd")
	WebElement addBtn;
	
	@FindBy(id="btnDelete")
	WebElement deleteBtn;
	
	@FindBy(id="btnSave")
	WebElement saveBtn;
	
	@FindBy(id="btnBack")
	WebElement backBtn;
	
	@FindBy(id="dialogDeleteBtn")
	WebElement confirmation_OKbutton;
	
	@FindBy(className="btn reset")
	WebElement confirmation_Cancelbutton;
	
	// Add Job vacancies page webelements
	
	@FindBy(id="addJobVacancy_jobTitle")
	WebElement selectJobTitle;
	
	@FindBy(id="addJobVacancy_name")
	WebElement jobVacancyName;
	
	@FindBy(id="addJobVacancy_hiringManager")
	WebElement hiringManager;
	
	@FindBy(id="addJobVacancy_noOfPositions")
	WebElement noOfPositions;
	
	@FindBy(id="addJobVacancy_description")
	WebElement jobDescription;
	
	@FindBy(id="addJobVacancy_publishedInFeed")
	WebElement publishedInFeed;
	
	
	// Recruitment page- Vacancies search WebElements
	
	@FindBy(id="vacancySearch_jobTitle")
	WebElement vacancySearchJobTitle;
	
	@FindBy(id="vacancySearch_jobVacancy")
	WebElement vacancySearchJobVacancy;
	
	@FindBy(id="vacancySearch_hiringManager")
	WebElement vacancySearchHiringManager;
	
	@FindBy(id="vacancySearch_status")
	WebElement vacancySearchStatus;
	
	@FindBy(xpath="//table[@id='resultTable']/tbody/tr/td[3]")
	List<WebElement> JobVacancyRecords_JobTitle;
	
	@FindBy(xpath="//table[@id='resultTable']/tbody/tr/td[2]")
	List<WebElement> JobVacancyRecords_JobVacancyName;
	
	@FindBy(xpath="//table[@id='resultTable']/tbody/tr/td[5]")
	List<WebElement> JobVacancyRecords_Status;
	
	@FindBy(xpath="//table[@id='resultTable']/tbody/tr/td[4]")
	List<WebElement> JobVacancyRecords_HiringManager;
	
	@FindBy(xpath="//table[@id='resultTable']/tbody/tr/td[2]")
	List<WebElement> candidateRecords_JobVacancyName;
	
	@FindBy(xpath="//table[@id='resultTable']/tbody/tr/td[6]")
	List<WebElement> candidateRecords_Status;
	
	@FindBy(xpath="//table[@id='resultTable']/tbody/tr/td[4]")
	List<WebElement> candidateRecords_HiringManager;
	
	@FindBy(xpath="//table[@id='resultTable']/tbody/tr/td[5]")
	List<WebElement> candidateRecords_DateofApplication;
	
	// Candidate page webelements
	
	@FindBy(id="addCandidate_firstName")
	WebElement firstName;
	
	@FindBy(id="addCandidate_middleName")
	WebElement middletName;
	
	@FindBy(id="addCandidate_lastName")
	WebElement lastName;
	
	@FindBy(id="addCandidate_email")
	WebElement email;
	
	@FindBy(id="addCandidate_contactNo")
	WebElement contactNo;
	
	@FindBy(id="addCandidate_vacancy")
	WebElement jobVacancy_AddCandidate;
	
	@FindBy(id="addCandidate_resume")
	WebElement resume;
	
	@FindBy(id="addCandidate_keyWords")
	WebElement keywords;
	
	@FindBy(id="addCandidate_comment")
	WebElement comment;
	
	@FindBy(xpath="//img[@class='ui-datepicker-trigger']")
	WebElement datePickerImg;
	
	@FindBy(xpath="//input[@id='candidateSearch_fromDate']/following-sibling::img")
	WebElement datePickerImgFrom;
	
	@FindBy(xpath="//input[@id='candidateSearch_toDate']/following-sibling::img")
	WebElement datePickerImgTo;
	
	@FindBy(xpath="//select[@class='ui-datepicker-month']")
	WebElement datePickerMonth;
	
	@FindBy(xpath="//select[@class='ui-datepicker-year']")
	WebElement datePickerYear;
	

	// Recruitment page- Candidate search
	
	@FindBy(id="candidateSearch_jobTitle")
	WebElement candidateSearchJobTitle;
	
	@FindBy(id="candidateSearch_jobVacancy")
	WebElement candidateSearchJobVacancy;
	
	@FindBy(id="candidateSearch_hiringManager")
	WebElement candidateSearchHiringManager;
	
	@FindBy(id="candidateSearch_status")
	WebElement candidateSearchStatus;
	
	
	public void selectJobVacancy_AddCandidate(String vacancyName) {
		Select select=new Select(jobVacancy_AddCandidate);
		select.selectByVisibleText(vacancyName);
	}
	
	public void setFirstName(String fName) {
		firstName.clear();
		firstName.sendKeys(fName);
	}
	
	public void setMiddleName(String mName) {
		middletName.clear();
		middletName.sendKeys(mName);
	}
	
	public void setLastName(String lName) {
		lastName.clear();
		lastName.sendKeys(lName);
	}
	
	public void setContactNo(String contactNumber) {
		contactNo.clear();
		contactNo.sendKeys(contactNumber);
	}
	
	public String getContactNo() {
		return contactNo.getAttribute("value");
	}
	
	public void setEmail(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}
	
	public void setKeyword(String keyword) {
		this.keywords.clear();
		this.keywords.sendKeys(keyword);
	}
	
	public void setComment(String comment) {
		this.comment.clear();
		this.comment.sendKeys(comment);
	}
	
	public void sendResume() {
		resume.sendKeys(System.getProperty("user.dir")+"\\src\\main\\java\\com\\hrm\\testdata\\Resume.doc");
	}
	
	public void clickOnDatePickerImg() {
		try {
			waitForElementToBeClickable(datePickerImg);
			datePickerImg.click();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickOnDatePickerImgFrom() {
		try {
			waitForElementToBeClickable(datePickerImgFrom);
			datePickerImgFrom.click();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickOnDatePickerImgTo() {
		try {
			waitForElementToBeClickable(datePickerImgTo);
			datePickerImgTo.click();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setYearInDatePicker(String year) {
		try{
			Thread.sleep(1000);
		}catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Select select= new Select(datePickerYear);
		select.selectByVisibleText(year);
	}
	
	public void setMonthInDatePicker(String month) {
		try {
			Thread.sleep(1000);
		}catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Select select= new Select(datePickerMonth);
		select.selectByVisibleText(monthName(month));
	}
	
	public String monthName(String month) {
		switch(month){
			case "01": return "Jan";
			case "02": return "Feb";
			case "03": return "Mar";
			case "04": return "Apr";
			case "05": return "May";
			case "06": return "Jun";
			case "07": return "Jul";
			case "08": return "Aug";
			case "09": return "Sep";
			case "10": return "Oct";
			case "11": return "Nov";
			case "12": return "Dec";
		}
		return "Jan";
	}
	
	public void setDayInDatePicker(String day) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int currentDay= Integer.parseInt(day);
		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a[contains(text(),'"+currentDay+"')]")).click();
	}
	
	public void setDateOfApplication(String dateOfApplication) {	
		clickOnDatePickerImg();
		String date_YYYY_MM_DD[]=dateOfApplication.split("/");
		setYearInDatePicker(date_YYYY_MM_DD[0]);
		setMonthInDatePicker(date_YYYY_MM_DD[1]);
		setDayInDatePicker(date_YYYY_MM_DD[2]);
	}
	
	public void selectJobTitle_VacancySearch(String jobTitle) {
		Select select= new Select(vacancySearchJobTitle);
		select.selectByVisibleText(jobTitle);
	}
	
	public String getJobTitle_VacancySearch() {
		Select select= new Select(vacancySearchJobTitle);
		return select.getFirstSelectedOption().getText();
	}
	
	public void selectJobVacancy_VacancySearch(String jobVacancy) {
		Select select= new Select(vacancySearchJobVacancy);
		select.selectByVisibleText(jobVacancy);
	}
	
	public String getJobVacancy_VacancySearch() {
		Select select= new Select(vacancySearchJobVacancy);
		return select.getFirstSelectedOption().getText();
	}
	
	public void selectHiringManager_VacancySearch(String hiringManager) {
		Select select= new Select(vacancySearchHiringManager);
		select.selectByVisibleText(hiringManager);
	}
	
	public String getHiringManager_VacancySearch() {
		Select select= new Select(vacancySearchHiringManager);
		return select.getFirstSelectedOption().getText();
	}
	
	public void selectStatus_VacancySearch(String status) {
		Select select= new Select(vacancySearchStatus);
		select.selectByVisibleText(status);
	}
	
	public String getStatus_VacancySearch() {
		Select select= new Select(vacancySearchStatus);
		return select.getFirstSelectedOption().getText();
	}
	
	public void selectJobTitle(String jobTitle) {
		Select select= new Select(selectJobTitle);
		select.selectByVisibleText(jobTitle);
	}

	public void setJobVacancyName(String vacancyName) {
		jobVacancyName.clear();
		jobVacancyName.sendKeys(vacancyName);
	}

	public void setHiringManager(String hiringManagerName) {
		hiringManager.clear();
		hiringManager.sendKeys(hiringManagerName);
	}

	public void setNoOfPositions(int noOfPosition) {
		noOfPositions.clear();
		noOfPositions.sendKeys(Integer.toString(noOfPosition));
	}

	public int getNoOfPositions() {
		return Integer.parseInt(noOfPositions.getAttribute("value"));
	}
	
	public void setJobDescription(String jobDescription) {
		this.jobDescription.clear();
		this.jobDescription.sendKeys(jobDescription);
	}

	public void clickOnPublishedInFeed() {
		if(publishedInFeed.isSelected()){
			try{
				waitForElementToBeClickable(publishedInFeed);
				publishedInFeed.click();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void clickOnCandidatesTab() {
		try{
			waitForElementToBeClickable(candidatesTab);
			candidatesTab.click();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickOnVacanciesTab() {
		try {
			waitForElementToBeClickable(vacanciesTab);
			vacanciesTab.click();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnSearchButton() {
		try {
			waitForElementToBeClickable(searchBtn);
			searchBtn.click();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickOnResetButton() {
		try {
			waitForElementToBeClickable(resetBtn);
			resetBtn.click();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Step("User is on Add Candidate Information Page")
	public void clickOnAddButton() {
		try {
			waitForElementToBeClickable(addBtn);
			addBtn.click();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void clickOnDeleteButton() {
		try {
			waitForElementToBeClickable(deleteBtn);
			deleteBtn.click();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Step("Candidated details are saved")
	public void clickOnSaveButton() {
		try {
			waitForElementToBeClickable(saveBtn);
			saveBtn.click();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickOnBackButton() {
		try {
			waitForElementToBeClickable(backBtn);
			backBtn.click();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickOnOKbutton_ConfirmaitonPopup() {
		try {
			waitForElementToBeClickable(confirmation_OKbutton);
			confirmation_OKbutton.click();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickOnCancelbutton_ConfirmaitonPopup() {
		try {
			waitForElementToBeClickable(confirmation_Cancelbutton);
			confirmation_Cancelbutton.click();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean isSubMenuDisplayed() {
		if(candidatesTab.isDisplayed() && vacanciesTab.isDisplayed())
			return true;
		return false;
	}
	
	public boolean isCandidateTabSelected() {
		if(candidatesTab.getAttribute("class").equalsIgnoreCase("selected"))
			return true;
		return false;
	}
	
	public void addJobVacancyDetails() {
		selectJobTitle(TestConfig.JOB_TITLE);
		setJobVacancyName(TestConfig.VACANCY_NAME);
		setHiringManager(TestConfig.HIRING_MANAGER);
		setNoOfPositions(TestConfig.NUMBER_OF_POSITIONS);
		setJobDescription(TestConfig.JOB_DESCRIPTION);
		clickOnPublishedInFeed();
	}
	
	public boolean verifyJobVacancyPresent(String vacancyName) {
		try {
		if(driver.findElement(By.xpath("//a[contains(text(),'"+vacancyName+"')]")).isDisplayed())
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void selectJobVacancy(String vacancyName) {

		try {
		driver.findElement(By.xpath("//a[contains(text(),'"+vacancyName+"')]//parent::td//preceding-sibling::td/input")).click();
		}catch(Exception e) {
			System.out.println(vacancyName+" Job Vacancy is not available");
			e.printStackTrace();
		}
	}
	
	
	public boolean JobvacanciesFilterByJobTitle(String jobTitle) {
		int i=0;
		for(WebElement ele:JobVacancyRecords_JobTitle) {
			if(!ele.getText().equalsIgnoreCase(jobTitle))
				return false;
			i++;
		}
		Log.info("No of records found for "+jobTitle+": "+i);
		return true;
	}
	
	public boolean JobvacanciesFilterByJobVacancyName(String jobVacancyName) {
		int i=0;
		for(WebElement ele:JobVacancyRecords_JobVacancyName) {
			if(!ele.getText().equalsIgnoreCase(jobVacancyName))
				return false;
			i++;
		}
		Log.info("No of records found for "+jobVacancyName+": "+i);
		return true;
		
	}
	
	public boolean CandidateFilterByJobVacancyName(String jobVacancyName) {
		int i=0;
		for(WebElement ele:candidateRecords_JobVacancyName) {
			if(!ele.getText().equalsIgnoreCase(jobVacancyName))
				return false;
			i++;
		}
		Log.info("No of records found for "+jobVacancyName+": "+i);
		return true;
	}
	
	public boolean JobvacanciesFilterByStatus(String status) {
		int i=0;
		for(WebElement ele:JobVacancyRecords_Status) {
			if(!ele.getText().equalsIgnoreCase(status))
				return false;
			i++;
		}
		Log.info("No of records found for "+status+": "+i);
		return true;
	}
	
	public boolean CandidateFilterByStatus(String status) {
		int i=0;
		for(WebElement ele:candidateRecords_Status) {
			if(!ele.getText().equalsIgnoreCase(status))
				return false;
			i++;
		}
		Log.info("No of records found for "+status+": "+i);
		return true;
	}
	
	
	public boolean JobvacanciesFilterByHiringManager(String hiringManager) {
		int i=0;
		for(WebElement ele:JobVacancyRecords_HiringManager) {
			if(!ele.getText().equalsIgnoreCase(hiringManager))
				return false;
			i++;
		}
		Log.info("No of records found for "+hiringManager+": "+i);
		return true;
	}
	
	public boolean CandidateFilterByHiringManager(String hiringManager) {
		int i=0;
		for(WebElement ele:candidateRecords_HiringManager) {
			if(!ele.getText().equalsIgnoreCase(hiringManager))
				return false;
			i++;
		}
		Log.info("No of records found for "+hiringManager+": "+i);
		return true;	
	}
	
	public boolean CandidateFilterByDateofApplication(String dateOfApplication) {
		int i=0;
		for(WebElement ele:candidateRecords_DateofApplication) {
			if(!ele.getText().equalsIgnoreCase(dateOfApplication))
				return false;
			i++;
		}
		Log.info("No of records found for "+dateOfApplication+": "+i);
		return true;
	}
	
	public void clickOnVacancyName(String vacancyName) {
		try {
			driver.findElement(By.xpath("//a[contains(text(),'"+vacancyName+"')]")).click();
		}catch(Exception e) {
			System.out.println(vacancyName+" Job Vacancy is not available");
			e.printStackTrace();
		}
	}
	
	public void clickOnCandidateName(String candidateName) {
		try{
			driver.findElement(By.xpath("//a[contains(text(),'"+candidateName+"')]")).click();
		}catch(Exception e) {
			System.out.println(candidateName+" Job Vacancy is not available");
			e.printStackTrace();
		}
	}
	
	public boolean verifyVacanciesFieldsDefaultValue() {
		try{
		if(getJobTitle_VacancySearch().equalsIgnoreCase("All") && getJobVacancy_VacancySearch().equalsIgnoreCase("All") && getHiringManager_VacancySearch().equalsIgnoreCase("All") && getStatus_VacancySearch().equalsIgnoreCase("All"))
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean verifyCandidatesFieldsDefaultValue() {
		try {
		if(getJobTitle_CandidateSearch().equalsIgnoreCase("All") && getJobVacancy_CandidateSearch().equalsIgnoreCase("All") && getHiringManager_CandidateSearch().equalsIgnoreCase("All") && getStatus_CandidateSearch().equalsIgnoreCase("All"))
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	// Candidate Page Methods
	public String currentDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
		System.out.println(dtf.format(localDate));
		return dtf.format(localDate);
	}
	
	@Step("Adding Candidates Details")
	public void addCandidateDetails() {
		setFirstName(TestConfig.CANDIDATE_FIRST_NAME);
		setMiddleName(TestConfig.CANDIDATE_MIDDDLE_NAME);
		setLastName(TestConfig.CANDIDATE_LAST_NAME);
		setEmail(TestConfig.CANDIDATE_EMAIL);
		setContactNo(TestConfig.CANDIDATE_CONTACT_NUMBER);
		selectJobVacancy_AddCandidate(TestConfig.CANDIDATE_JOBVACANCYNAME);
		sendResume();
		setKeyword(TestConfig.CANDIDATE_KEYWORDS);
		setComment(TestConfig.CANDIDATE_COMMENT);
		//setDateOfApplication(currentDate());
		setDateOfApplication(TestConfig.CANDIDATE_DATE_OF_APPLICATION);
	}
	
	public boolean verifyCandidatePresent(String candidateName) {
		try {
		if(driver.findElement(By.xpath("//a[contains(text(),'"+candidateName+"')]")).isDisplayed())
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void selectCandidate(String candidateName) {
		try{
			driver.findElement(By.xpath("//a[contains(text(),'"+candidateName+"')]//parent::td//preceding-sibling::td/input")).click();
		}catch(Exception e) {
			System.out.println(candidateName+" Candidate is not available");
			e.printStackTrace();
		}
	}
	
	public void selectJobTitle_CandidateSearch(String jobTitle) {
		Select select= new Select(candidateSearchJobTitle);
		select.selectByVisibleText(jobTitle);
	}
	
	public String getJobTitle_CandidateSearch() {
		Select select= new Select(candidateSearchJobTitle);
		return select.getFirstSelectedOption().getText();
	}
	
	public void selectJobVacancy_CandidateSearch(String jobVacancy) {
		Select select= new Select(candidateSearchJobVacancy);
		select.selectByVisibleText(jobVacancy);
	}
	
	public String getJobVacancy_CandidateSearch() {
		Select select= new Select(candidateSearchJobVacancy);
		return select.getFirstSelectedOption().getText();
	}
	
	public void selectHiringManager_CandidateSearch(String hiringManager) {
		Select select= new Select(candidateSearchHiringManager);
		select.selectByVisibleText(hiringManager);
	}
	
	public void selectDateofApplication_CandidateSearch(String dateOfApplicationFrom, String dateOfApplicationTo) {
		clickOnDatePickerImgFrom();
		String date_YYYY_MM_DD_from[]=dateOfApplicationFrom.split("/");
		setYearInDatePicker(date_YYYY_MM_DD_from[0]);
		setMonthInDatePicker(date_YYYY_MM_DD_from[1]);
		setDayInDatePicker(date_YYYY_MM_DD_from[2]);
		
		clickOnDatePickerImgTo();
		String date_YYYY_MM_DD_to[]=dateOfApplicationTo.split("/");
		setYearInDatePicker(date_YYYY_MM_DD_to[0]);
		setMonthInDatePicker(date_YYYY_MM_DD_to[1]);
		setDayInDatePicker(date_YYYY_MM_DD_to[2]);
	}
	
	public String getHiringManager_CandidateSearch() {
		Select select= new Select(candidateSearchHiringManager);
		return select.getFirstSelectedOption().getText();
	}
	
	public void selectStatus_CandidateSearch(String status) {
		Select select= new Select(candidateSearchStatus);
		select.selectByVisibleText(status);
	}
	
	public String getStatus_CandidateSearch() {
		Select select= new Select(candidateSearchStatus);
		return select.getFirstSelectedOption().getText();
	}
	
	public void downloadResume(String candidateName) {
		try{
			driver.findElement(By.xpath("//a[contains(text(),'"+candidateName+"')]//parent::td//following-sibling::td/a[contains(text(),'Download')]")).click();
		}catch(Exception e) {
			System.out.println(candidateName+" Resume link is not available");
			e.printStackTrace();
		}
	}
	
}
