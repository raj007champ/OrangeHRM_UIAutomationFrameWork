package com.hrm.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.hrm.base.TestBase;

public class MyInfoPage extends TestBase{
	
	public MyInfoPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="employee-details")
	WebElement EmployeeInfoBox;
	
	public boolean CheckPresenceofEmplyeeInfoBox() {
		return EmployeeInfoBox.isDisplayed();
	}
	
	@FindBy(xpath="(//div/h1)[1]")
	WebElement EmployeeName;
	
	public String checkEmployeeName() {
		return EmployeeName.getText();
	}
	
	@FindBy(id="empPic")
	WebElement ProfilePic;
	
	
	public void ChangeProfilePicClick() {
		ProfilePic.click();
	}
	
	@FindBy(id="photofile")
	WebElement ChosePhoto;
	
	@FindBy(id="btnSave")
	WebElement UploadPhotoButton;
	
	public String ChangeProfilePic() {
		//driver.findElement(By.id("photofile")).sendKeys("C:\\fakepath\\steveJobs.jpg");
		String PicturePath=System.getProperty("user.dir")+"\\src\\main\\java\\com\\hrm\\testdata\\steveJobs.jpg" ;
		System.out.println(PicturePath);
		ChosePhoto.sendKeys(PicturePath);
		//ChosePhoto.sendKeys("C:\\Users\\msys\\Desktop\\steveJobs.jpg");
		UploadPhotoButton.click();
		return ProfilePic.getAttribute("width");
	}
	
	@FindBy(id="personal_txtEmpFirstName")
	WebElement EmpFirstName ;
	
	@FindBy(id="personal_txtEmpMiddleName")
	WebElement EmpMiddleName;
	
	@FindBy(id="personal_txtEmpLastName")
	WebElement EmpLastName;
	
	@FindBy(id="personal_txtEmployeeId")
	WebElement EmployeeId;
	
	@FindBy(id="personal_txtOtherID")
	WebElement OtherID;
	
	@FindBy(id="personal_txtLicenNo")
	WebElement LicenNo;
	
	@FindBy(id="personal_optGender_1")
	WebElement Gender_Male;
	
	@FindBy(id="personal_optGender_2")
	WebElement Gender_Female;
	
	@FindBy(id="personal_cmbMarital")
	WebElement MaritalStatus;
	
	@FindBy(id="personal_cmbNation")
	WebElement Nationality;
	
	@FindBy(id="btnSave")
	WebElement PersonalDetailsSaveButton;

	public void editPersonalDetails(String fname,String mname,String lname,
			String empid,String oid,String licid,String gender,String martial,String nation) {
		PersonalDetailsSaveButton.click();
		EmpFirstName.clear();
		EmpFirstName.sendKeys(fname);
		EmpMiddleName.clear();
		EmpMiddleName.sendKeys(mname);
		EmpLastName.clear();
		EmpLastName.sendKeys(lname);
		EmployeeId.clear();
		EmployeeId.sendKeys(empid);
	    OtherID.clear();
	    OtherID.sendKeys(oid);
	    LicenNo.clear();
		LicenNo.sendKeys(licid);
		
		if(gender.toLowerCase().contains("male")) {
			Gender_Male.click();
		}else if(gender.toLowerCase().contains("female")){
			Gender_Female.click();
		}else {
			System.out.println("Please mention your correct Gender");
		}
		
		MaritalStatus.click();
	    new Select(MaritalStatus).selectByVisibleText(martial);

		Nationality.click();
		new Select(Nationality).selectByVisibleText(nation);
		
		PersonalDetailsSaveButton.click();
		
	}
	
	public boolean personalDetailsChangeSuccessMessage(){
		
		return driver.findElement(By.xpath(".//*[@id='pdMainContainer']//div[@class='message success fadable']")).isDisplayed();
	}
	
	@FindBy(linkText="Contact Details")
	WebElement ContactDetailstab ;
	
	@FindBy(id="btnSave")
	WebElement ContactDetailsEditButton;
	
	@FindBy(id="contact_street1")
	WebElement Address;
	
	@FindBy(id="contact_city")
	WebElement City;
	
	@FindBy(id="contact_province")
	WebElement State;
	
	@FindBy(id="contact_emp_zipcode")
	WebElement Zipcode;
	
	@FindBy(id="contact_country")
	WebElement Country;
	
	@FindBy(id="contact_emp_hm_telephone")
	WebElement HomeTelephone;
	
	@FindBy(id="contact_emp_mobile")
	WebElement MobileNo;
	
	
	@FindBy(id="contact_emp_work_email")
	WebElement WorkEmail;
	
	public void NavigateToContactDetails() {
		ContactDetailstab.click();
	}

	public void editContactDetails(String address, String city, String state, String zip, String country,
			String mobile) {
		
		ContactDetailsEditButton.click();
		Address.clear();
		Address.sendKeys(address);
		City.clear();
		City.sendKeys(city);
		State.clear();
		State.sendKeys(state);
		Zipcode.clear();
		Zipcode.sendKeys(zip);
		Country.click();
		new Select(Country).selectByVisibleText(country);
		MobileNo.clear();
		System.out.println(mobile);
		MobileNo.sendKeys(mobile.toString());
		ContactDetailsEditButton.click();
	}
	
public String ContactDetailsChangeSuccessCheck(){
		
		return ContactDetailsEditButton.getAttribute("value");
	}

@FindBy(linkText="Emergency Contacts")
WebElement EmergencyContactsLink;

@FindBy(id="btnAddContact")
WebElement AddNewEgcontactsButton;

@FindBy(id="emgcontacts_name")
WebElement EmgcontactsName;

@FindBy(id="emgcontacts_relationship")
WebElement EmgcontactsRelationship;

@FindBy(id="emgcontacts_mobilePhone")
WebElement Emgcontacts_mobilePhone;

@FindBy(id="emgcontacts_workPhone")
WebElement EmgcontactsWorkPhone;

@FindBy(id="btnSaveEContact")
WebElement SaveEmergencyContactButton;


public void NavigateToEmergencyContactDetails() {
	EmergencyContactsLink.click();
	
}

public void addEmergencyContact(String name, String relation, String mobno, String workTel) {
	AddNewEgcontactsButton.click();
EmgcontactsName.clear();
EmgcontactsName.sendKeys(name);
EmgcontactsRelationship.clear();
EmgcontactsRelationship.sendKeys(relation);
EmgcontactsWorkPhone.clear();
EmgcontactsWorkPhone.sendKeys(workTel);
Emgcontacts_mobilePhone.clear();
Emgcontacts_mobilePhone.sendKeys(mobno);
SaveEmergencyContactButton.click();
}



public boolean AddEmergencyContactSuccess(String name) {
	
	List<WebElement> EmergencyContactNamesList = driver.findElements(By.xpath("//td[@class='emgContactName']/a"));
	
	for(WebElement Egname:EmergencyContactNamesList)
	{
		if(Egname.getText().equals(name))
		{
			return true;
		}
	}
	return false;

}

@FindBy(id="delContactsBtn")
WebElement DeleteEmergencyContactButton;

public void deletEmergencyContact(String name) 
{
driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]/parent::td/preceding-sibling::td/input")).click();	
DeleteEmergencyContactButton.click();
}

public boolean EmergencyContactDeleteSuccessMessage(){
	
	return driver.findElement(By.xpath(".//div[@class='message success fadable']")).isDisplayed();
}

@FindBy(linkText="Dependents")
WebElement Dependents;

@FindBy(id="btnAddDependent")
WebElement AddDependentButton;

@FindBy(id="dependent_name")
WebElement DependentName;

@FindBy(id="dependent_relationshipType")
WebElement Dependent_relationshipType;

@FindBy(id="dependent_relationship")
WebElement Dependent_relationship;

@FindBy(id="dependent_dateOfBirth")
WebElement DependentDOB;

@FindBy(id="btnSaveDependent")
WebElement SaveDependentButton;

@FindBy(className="ui-datepicker-year")
WebElement DOBYear;

@FindBy(className="ui-datepicker-month")
WebElement DOBMonth;

@FindBy(className="ui-state-default")
WebElement DOBday;


public void NavigateToDependentsLinks() {
	Dependents.click();
	
}

public void addDependent(String name, String relationship, String dob) throws InterruptedException {
	AddDependentButton.click();
	DependentName.clear();
	DependentName.sendKeys(name);
	Dependent_relationshipType.click();
    new Select(Dependent_relationshipType).selectByVisibleText("Other");
    Thread.sleep(3000);
    Dependent_relationship.sendKeys(relationship);
    
    DependentDOB.clear();
    System.out.println(dob);
    DependentDOB.click();
    String[] dobs=dob.split("/");
    String day=dobs[0];
    String month=dobs[1];
    String year=dobs[2];
    DOBYear.click();
    new Select(DOBYear).selectByValue(year);
    DOBMonth.click();
    new Select(DOBMonth).selectByValue(month);   
     List<WebElement> dates = driver.findElements(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr/td/a"));
     
    for(WebElement dobdate:dates)
    {
    	if(dobdate.getText().equals(day))
    		dobdate.click();
    }
    
    SaveDependentButton.click();
}


public boolean AddDependentSuccess() {
	return driver.findElement(By.xpath(".//div[@class='message success fadable']")).isDisplayed();

}

@FindBy(id="delDependentBtn")
WebElement DeleteDependent;

public void deleteDependent(String name) {
	driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]/parent::td/preceding-sibling::td/input")).click();	
	DeleteDependent.click();
	
}

public boolean DependentDeleteSuccessMessage() {
	return driver.findElement(By.xpath(".//div[@class='message success fadable']")).isDisplayed();
}

@FindBy(linkText="Immigration")
WebElement ImmigrationLink;
@FindBy(id="btnAdd")
WebElement AddImmigrationButton;
@FindBy(id="immigration_number")
WebElement ImmigrationNumber;
@FindBy(id="immigration_i9_status")
WebElement immigrationStatus;
@FindBy(id="immigration_country")
WebElement immigrationCountry;
@FindBy(id="btnSave")
WebElement SaveImmigrationDetailsButton;
@FindBy(id="immigration_type_flag_1")
WebElement Passport;
@FindBy(id="immigration_type_flag_2")
WebElement Visa;

public void NavigateToImmigrationLink() {

	ImmigrationLink.click();
}

public void addImmigration(String doctype, String docno, String Status, String country2) {
	AddImmigrationButton.click();
	if(doctype.toLowerCase().equals("passport"))
	{
		Passport.click();
	}
	if(doctype.toLowerCase().equals("visa"))
	{
		Visa.click();
	}
	
	ImmigrationNumber.clear();
	ImmigrationNumber.sendKeys(docno);
	immigrationStatus.clear();
	immigrationStatus.sendKeys(Status);
	immigrationCountry.click();
	new Select(immigrationCountry).selectByVisibleText(country2);
	SaveImmigrationDetailsButton.click();
	
}

public boolean AddImmigrationSuccess() {
	return driver.findElement(By.xpath(".//div[@class='message success fadable']")).isDisplayed();
	
}

@FindBy(id="btnDelete")
WebElement DeleteImmigrationButton;
public void deleteImmigrationDetails(String docType) {
	driver.findElement(By.xpath("//a[contains(text(),'"+docType+"')]/parent::td/preceding-sibling::td/input")).click();	
	DeleteImmigrationButton.click();
	
}

public boolean DeleteImmigrationSuccessMessage() {
	return driver.findElement(By.xpath(".//div[@class='message success fadable']")).isDisplayed();
}

@FindBy(linkText="Memberships")
WebElement MembershipLink;
@FindBy(id="btnAddMembershipDetail")
WebElement AddMembershipDetail;
@FindBy(id="membership_membership")
WebElement membershipType;
@FindBy(id="membership_subscriptionPaidBy")
WebElement subscriptionPaidBy;
@FindBy(id="membership_subscriptionAmount")
WebElement subscriptionAmount;
@FindBy(id="membership_currency")
WebElement membership_currency;
@FindBy(id="btnSaveMembership")
WebElement SaveMembershipButton;
@FindBy(id="delMemsBtn")
WebElement DeleteMembersbutton;


public void NavigateToMembershipLink() {
MembershipLink.click();
	
}

public void addMembership(String membership, String paidBy, String amount, String currency) {

	AddMembershipDetail.click();
	membershipType.click();
	new Select(membershipType).selectByVisibleText(membership);
	subscriptionPaidBy.click();
	new Select(subscriptionPaidBy).selectByVisibleText(paidBy);
	subscriptionAmount.sendKeys(amount);
	membership_currency.click();
	new Select(membership_currency).selectByVisibleText(currency);
	SaveMembershipButton.click();	
}


public boolean AddMembershipSuccess() {
	return driver.findElement(By.xpath(".//div[@class='message success fadable']")).isDisplayed();

}

public void deleteMembership(String membershipType) {
	driver.findElement(By.xpath("//a[contains(text(),'"+membershipType+"')]/parent::td/preceding-sibling::td/input")).click();	
	DeleteMembersbutton.click();
	
}

public boolean MembershipDeleteSuccessMessage() {
	return driver.findElement(By.xpath(".//div[@class='message success fadable']")).isDisplayed();
}


@FindBy(linkText="Job")
WebElement JobLink;

@FindBy(id="job_job_title")
WebElement JobTitleDropdown;

@FindBy(id="job_emp_status")
WebElement EmploymentStatus;

@FindBy(id="job_location")
WebElement JobLocation;



public void NavigateToJobSection() {
	
	JobLink.click();
}

public boolean checkJobDetails() {
	
	if(JobLink.isDisplayed() && JobLocation.isDisplayed() && EmploymentStatus.isDisplayed()) {
		return  true;
	}
	else return false;
	
}

@FindBy(linkText="Salary")
WebElement Salary;

@FindBy(xpath="//*[@id=\"tblSalary\"]/tbody/tr/td[1]")
WebElement SalaryRecord;

public void NavigateToSalarySection() {
	Salary.click();
	
}

public boolean checkSalaryDetails() {
	
	if(SalaryRecord.getText().equals("No Records Found"))
	return true;
	
	else return false;
}


@FindBy(linkText="Report-to")
WebElement ReportToLink;

@FindBy(xpath="//*[@id=\"sup_list\"]/tbody/tr/td[2]")
WebElement AssignedSupervisorsSection;

public void NavigateToReportsToSection() {
	ReportToLink.click();
	
}

public boolean checkReportsToDetails() {

	if(AssignedSupervisorsSection.getText().equals("No Records Found"))
	return true;
	
	else return false;
	
}


@FindBy(linkText="Qualifications")
WebElement Qualifications;

@FindBy(id="addWorkExperience")
WebElement addWorkExperience;

@FindBy(id="experience_employer")
WebElement Employer;

@FindBy(id="experience_jobtitle")
WebElement JobTitle;

@FindBy(id="btnWorkExpSave")
WebElement btnWorkExpSave;


public void NavigateToQualificationsSection() {
	
	Qualifications.click();
}

public void addWorkExperience(String company, String jobtitle) {
	addWorkExperience.click();
	Employer.clear();
	Employer.sendKeys(company);
	JobTitle.clear();
	JobTitle.sendKeys(jobtitle);
	btnWorkExpSave.click();
	
}

public boolean AddWorkExperienceSuccess() {
	return driver.findElement(By.xpath(".//div[@class='message success fadable']")).isDisplayed();
}

@FindBy(id="delWorkExperience")
WebElement deleteWorkExperienceButton;

public void deleteWorkExperience(String company) {
	
driver.findElement(By.xpath("//a[contains(text(),'"+company+"')]/parent::td/preceding-sibling::td/input[6]")).click();	
deleteWorkExperienceButton.click();
}
public boolean WorkExperienceDeleteSuccessMessage() {
	return driver.findElement(By.xpath(".//div[@class='message success fadable']")).isDisplayed();
}

@FindBy(id="addLanguage")
WebElement AddLanguageeButton;
@FindBy(id="language_code")
WebElement SelectLanguage;
@FindBy(id="language_lang_type")
WebElement Fluency;
@FindBy(id="language_competency")
WebElement Competency;
@FindBy(id="btnLanguageSave")
WebElement LanguageSaveButton;

public void addLanguage(String language, String fluency, String competency) {
	AddLanguageeButton.click();
	SelectLanguage.click();
	new Select(SelectLanguage).selectByVisibleText(language);
	Fluency.click();
	new Select(Fluency).selectByVisibleText(fluency);
	Competency.click();
	new Select(Competency).selectByVisibleText(competency);
	LanguageSaveButton.click();
}

public boolean AddLanguageDetailsSuccess() {
	return driver.findElement(By.xpath(".//div[@class='message success fadable']")).isDisplayed();

}

@FindBy(id="delLanguage")
WebElement DeleteLanguageButton;

public void deleteLanguage(String language) {
	driver.findElement(By.xpath("//a[contains(text(),'"+language+"')]/parent::td/preceding-sibling::td/input[5]")).click();	
	DeleteLanguageButton.click();	
}

public boolean LanguageDeleteSuccessMessage() {
	return driver.findElement(By.xpath(".//div[@class='message success fadable']")).isDisplayed();

}



}


