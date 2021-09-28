package com.hrm.pages;

import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.hrm.base.TestBase;
import com.hrm.util.Log;

public class AdminPage extends TestBase{
	
	    public AdminPage(){
		
		    PageFactory.initElements(driver, this);
	    }

	//1.ADDING USER:
		
//		@FindBy(xpath=".//*[@id='menu_admin_UserManagement']")
//		public static WebElement user_management;
//		
//		@FindBy(xpath=".//*[@id='menu_admin_viewSystemUsers']")
//		public static WebElement users;
		
		@FindBy(xpath=".//*[@id='btnAdd']")
		public static WebElement add_btn;
		
		@FindBy(xpath=".//*[@id='systemUser_userType']")
		public static WebElement user_role;
		
		@FindBy(xpath=".//*[@id='systemUser_userType']/option[1]")
		public static WebElement admin_type;
		
		@FindBy(xpath=".//*[@id='systemUser_employeeName_empName']")
		public static WebElement empName;
		
		@FindBy(xpath=".//*[@id='systemUser_userName']")
		public static WebElement username;
		
		@FindBy(xpath=".//*[@id='systemUser_status']")
		public static WebElement status;
		
		@FindBy(xpath=".//*[@id='systemUser_status']/option[1]")
		public static WebElement enabled;
		
		@FindBy(xpath=".//*[@id='systemUser_password']")
		public static WebElement password;
		
		@FindBy(xpath=".//*[@id='systemUser_confirmPassword']")
		public static WebElement cnfm_Password;
		
		@FindBy(xpath=".//*[@id='btnSave']")
		public static WebElement save_btn;
		
		@FindBy(xpath=".//*[@id='frmList_ohrmListComponent']/div[2]")
		public static WebElement UseraddedSuccessfully;
		
	//2.DELETING USER:
		
		@FindBy(xpath=".//*[@id='resultTable']/tbody/tr/td[2]")
		public static List<WebElement> UserList;
				
		@FindBy(xpath=".//*[@id='btnDelete']")
		public static WebElement delete;
				
		@FindBy(xpath=".//*[@id='dialogDeleteBtn']")
		public static WebElement okBtn;
				
		@FindBy(xpath=".//*[@id='frmList_ohrmListComponent']/div[2]")
		public static WebElement deleteSuccess;
				
	//3.SEARCHING EXISTING USER:
				
		@FindBy(xpath=".//*[@id='searchSystemUser_userName']")
		public static WebElement userName;
				
		@FindBy(xpath=".//*[@id='searchSystemUser_userType']")
		public static WebElement userRole;
				
		@FindBy(xpath=".//*[@id='searchSystemUser_userType']/option[2]")
		public static WebElement admin;
				
		@FindBy(xpath=".//*[@id='searchSystemUser_employeeName_empName']")
		public static WebElement emp_name;
				
		@FindBy(xpath="html/body/div[4]/ul/li[1]")
		public static WebElement name;
				
		@FindBy(xpath=".//*[@id='searchSystemUser_status']")
		public static WebElement staus;
				
		@FindBy(xpath=".//*[@id='searchSystemUser_status']/option[2]")
		public static WebElement Enabled;
				
		@FindBy(xpath=".//*[@id='searchBtn']")
		public static WebElement searchBtn;
		
		@FindBy(xpath=".//*[@id='resultTable']/tbody/tr/td[2]")
		public static WebElement searchedUser;
		
		
	//4.SEARCHING USER WITH INVALID CREDENTIALS:	
		@FindBy(xpath=".//*[@id='resultTable']/tbody/tr/td")
		public static WebElement noRecordFound;
		
		
	//5.RESET BUTTON FUNCTIONALITY:
			
		@FindBy(xpath=".//*[@id='resetBtn']")
		public static WebElement resetBtn;
		
	//6.ADDING JOB CATEGORY:
		@FindBy(xpath=".//*[@id='menu_admin_Job']")
		public static WebElement JobBtn;
		
		@FindBy(xpath=".//*[@id='menu_admin_jobCategory']")
		public static WebElement JobCategories;
		
		//@FindBy(xpath=".//*[@id='btnAdd']")
		//public static WebElement addJob;
		
		@FindBy(xpath=".//*[@id='jobCategory_name']")
		public static WebElement JobName;
		
		@FindBy(xpath=".//*[@id='frmList_ohrmListComponent']/div[2]")
		public static WebElement saveSuccess;
		
	//7.DELETE JOB CATEGORY:
		@FindBy(xpath=".//*[@id='resultTable']/tbody/tr/td[2]")
		public static List<WebElement> jobList;
		
		
	//8.ADDING WORK SHIFT:
		@FindBy(xpath=".//*[@id='menu_admin_workShift']")
		public static WebElement workShifts;
			
		@FindBy(xpath=".//*[@id='workShift_name']")
		public static WebElement shiftName;
			
		@FindBy(xpath=".//*[@id='workShift_workHours_from']")
		public static WebElement workHoursFrom;
			
		@FindBy(xpath=".//*[@id='workShift_workHours_to']")
		public static WebElement workHoursTo;
		
	//9.DELETING WORKSHIFT:
		@FindBy(xpath=".//*[@id='resultTable']/tbody/tr/td[2]")
		public static List<WebElement> ShiftList;	
		
	//10.ASSIGINING WORKSHIFT:
		@FindBy(xpath=".//*[@id='resultTable']/tbody/tr/td[2]/a")
		public static List<WebElement> workshiftToSelect;
		
		@FindBy(id="workShift_availableEmp")
		public static WebElement empList;
		
		@FindBy(xpath=".//*[@id='btnAssignEmployee']")
		public static WebElement assignBtn;
		
		
	//11.ADDING GENERAL INFORMATION OF ORGANIZATION:
		@FindBy(xpath=".//*[@id='menu_admin_Organization']")
		public static WebElement Organiztation_tab;
			
		@FindBy(xpath=".//*[@id='menu_admin_viewOrganizationGeneralInformation']")
		public static WebElement general_Info;
			
		@FindBy(xpath=".//*[@id='btnSaveGenInfo']")
		public static WebElement edit;
			
		@FindBy(xpath=".//*[@id='organization_name']")
		public static WebElement organization_name;
			
		@FindBy(xpath=".//*[@id='organization_phone']")
		public static WebElement phone_no;
			
		@FindBy(xpath=".//*[@id='organization_email']")
		public static WebElement email;
			
		@FindBy(xpath=".//*[@id='organization_street1']")
		public static WebElement street_name;
			
		@FindBy(xpath=".//*[@id='organization_city']")
		public static WebElement city;
			
		@FindBy(xpath=".//*[@id='organization_zipCode']")
		public static WebElement postal_code;
			
		@FindBy(xpath=".//*[@id='general-info']/div[2]/div")
		public static WebElement save_success;
		
	//12.ADDING LOCATION OF ORGANIZATION IN DIFFERENT COUNTRIES:
		@FindBy(xpath=".//*[@id='menu_admin_viewLocations']")
		public static WebElement locations_tab;
		
		@FindBy(xpath=".//*[@id='location_name']")
		public static WebElement location_name;
		
		@FindBy(xpath=".//*[@id='location_country']")
		public static WebElement country_name;
		
		@FindBy(xpath=".//*[@id='frmList_ohrmListComponent']/div[2]")
		public static WebElement operation_success;
		
	//13.DELETING LOCATION OF ORGANIZATION IN DIFFERENT COUNTRIES:
		@FindBy(xpath=".//*[@id='resultTable']/tbody/tr/td[2]")
		public static List<WebElement> location_list;
		
	//14.ADDIND DIFFERENT NATIONALITIES:
		@FindBy(xpath=".//*[@id='menu_admin_nationality']")
		public static WebElement nationalities_Tab;
		
		@FindBy(xpath=".//*[@id='nationality_name']")
		public static WebElement nationality_name;
		
	//15.DELETING NATIONALITY:
		@FindBy(xpath=".//*[@id='resultTable']/tbody/tr/td[2]")
		public static List<WebElement> nationality_list;
		
	//16.ADDING PAY GRADE AND CURRENCY IN JOB SECTION:
		@FindBy(xpath=".//*[@id='menu_admin_viewPayGrades']")
		public static WebElement payGrades;
		
		@FindBy(xpath=".//*[@id='payGrade_name']")
		public static WebElement payGrade_name;
		
		@FindBy(xpath=".//*[@id='btnAddCurrency']")
		public static WebElement addCurrency_btn;
		
		@FindBy(xpath=".//*[@id='payGradeCurrency_currencyName']")
		public static WebElement currency_name;
		
		@FindBy(xpath=".//*[@id='btnSaveCurrency']")
		public static WebElement saveCurrencyBtn;
		
		@FindBy(xpath=".//*[@id='currency']/div[2]/div")
		public static WebElement msgSuccess;
		
	//17.DELETING PAY GRADE IN JOB SECTION:
		@FindBy(xpath=".//*[@id='resultTable']/tbody/tr/td[2]")
		public static List<WebElement> payGradeList;
		
		
	//18.EDITING LOCALIZATION IN CONFIGURATION SECTION:
			@FindBy(xpath=".//*[@id='menu_admin_Configuration']")
			public static WebElement configuration_tab;
			
			@FindBy(xpath=".//*[@id='menu_admin_localization']")
			public static WebElement localization;
			
			@FindBy(xpath=".//*[@value='Edit']")
			public static WebElement Edit_btn;
			
			@FindBy(xpath=".//*[@id='localization_dafault_language']")
			public static WebElement languageList;
			
			@FindBy(xpath=".//*[@id='localization_default_date_format']")
			public static WebElement date_format;
			
			@FindBy(xpath=".//*[@id='localization']/div[2]/div")
			public static WebElement SaveSuccess;
			
	//19.SEARCHING LOCATION IN ORGANIZATION:
			@FindBy(xpath=".//*[@id='searchLocation_name']")
			public static WebElement locationName;
			
			@FindBy(xpath=".//*[@id='btnSearch']")
			public static WebElement SearchBtn;
			
			@FindBy(xpath=".//*[@id='resultTable']/tbody/tr/td[2]")
			public static WebElement searchedLocation;
			
	//20.SEARCHING LOCATION IN ORGANIZATION WITH INVALID DATA:
			@FindBy(xpath=".//*[@id='resultTable']/tbody/tr/td")
			public static WebElement resultMsg;
		
			
	 //1.ADDING USER:
		public void addUser(String empName1,String username1,String password1,String cnfm_Password1) {
//			user_management.click();
//			users.click();
			add_btn.click();
			user_role.click();
			admin_type.click();
			empName.sendKeys(empName1);
			Date d = new Date(System.currentTimeMillis());
			String a = username1+d;
			username.sendKeys(a);
			status.click();
			enabled.click();
			password.sendKeys(password1);
			cnfm_Password.sendKeys(cnfm_Password1);
			save_btn.click();		
		}
		
        public boolean AddUserSuccessText() {
        	 if(UseraddedSuccessfully.isDisplayed()) {
        		 Log.info("Successfully Saved");
        		 return true; 
        	 }
        	 else {
        		 return false; 
        	 }	
		}
		
	
      //2.DELETING USER:
		public void deleteUser(String a) {
//			user_management.click();
//			users.click();
			List <WebElement> list= UserList;
			for(int i=0;i<list.size();i++) {   
				boolean username=(list.get(i).getText().contains(a));
				if(username) {
					WebElement td =  driver.findElement(By.xpath(".//*[@id='resultTable']/tbody/tr["+(i+1)+"]/td[1]/input"));
					td.click();
					break;}
			} 
			delete.click();
			okBtn.click();	
		}
		public boolean DeleteUserSuccessText() {
       	 if(deleteSuccess.isDisplayed()) {
       		System.out.println(deleteSuccess.getText());
       		 return true; 
       	 }
       	 else {
       		 return false; 
       	 }	
		}

		
	//3.SEARCHING EXISTING USER:
			public void searchUser(String username1,String emp_name1) throws InterruptedException {
				Thread.sleep(2000);
				userName.sendKeys(username1);
				emp_name.sendKeys(emp_name1);
				name.click();
				staus.click();
				Enabled.click();
				searchBtn.click();
			}
			public boolean SearchingUserSuccessText() {
		       	 if(searchedUser.isDisplayed()) {
		       		System.out.println("Searched User is : "+searchedUser.getText());
		       		 return true; 
		       	 }
		       	 else {
		       		 return false; 
		       	 }	
				}
			
			
	//4.SEARCHING USER WITH INVALID CREDENTIALS:
			public void invalidSearch(String username1,String emp_name1) throws InterruptedException {
				Thread.sleep(2000);
				userName.sendKeys(username1);
				emp_name.sendKeys(emp_name1);
				name.click();
				staus.click();
				Enabled.click();
				searchBtn.click();
			}
			public boolean SearchingInvalidUserSuccess() {
		       	 if(noRecordFound.isDisplayed()) {
		       		System.out.println(noRecordFound.getText());
		       		 return true; 
		       	 }
		       	 else {
		       		 return false; 
		       	 }	
				}
			
					
	//5.RESET BUTTON FUNCTIONALITY:
			public void resetBtn_Function(String username1) {
				userName.sendKeys(username1);
				resetBtn.click();	
			}
			
    		public boolean verifyResetBtnFunctionality() {
            if(userName.getText().matches("")) {
            	return true;	
			}
            else {
            	return false;
            }
    		}
		
			
	  //6.ADDING JOB CATEGORY:
			public void addJobCategory(String jobName) {
				JobBtn.click();
				JobCategories.click();
				add_btn.click();
				JobName.sendKeys(jobName);
				save_btn.click();	
			}
			public boolean AddingJobCategorySuccess() {
		       	 if(saveSuccess.isDisplayed()) {
		       		System.out.println(saveSuccess.getText());
		       		 return true; 
		       	 }
		       	 else {
		       		 return false; 
		       	 }	
				}
			
			
	//7.DELETE JOB CATEGORY:
			public void deleteJobCategory(String jobToDelete) {
				JobBtn.click();
				JobCategories.click();
				
				List <WebElement> list= jobList;
		        for(int i=0;i<list.size();i++) {   
		        	String username=(list.get(i).getText());
		        	   if (username.equals(jobToDelete)){
		        		   WebElement td =  driver.findElement(By.xpath(".//*[@id='resultTable']/tbody/tr["+(i+1)+"]/td[1]/input"));
		        		     td.click();
		        		     break;
		        		    } 
		        }
				delete.click();
				okBtn.click();	
			}
			public boolean DeleteJobCategorySuccess() {
		       	 if(deleteSuccess.isDisplayed()) {
		       		System.out.println(deleteSuccess.getText());
		       		 return true; 
		       	 }
		       	 else {
		       		 return false; 
		       	 }	
				}
			
			
	  //8.ADDING WORK SHIFT:
			public void addWorkShift(String NameOfShift,String From,String To) {
				JobBtn.click();
				workShifts.click();
				add_btn.click();
				shiftName.sendKeys(NameOfShift);
				
				new Select(workHoursFrom).selectByVisibleText(From);
				
				new Select(workHoursTo).selectByVisibleText(To);
				
				save_btn.click();		
			}
			public boolean AddingWorkshiftSuccess() {
		       	 if(saveSuccess.isDisplayed()) {
		       		System.out.println(saveSuccess.getText());
		       		 return true; 
		       	 }
		       	 else {
		       		 return false; 
		       	 }	
				}
			
			
	  //9.DELETING WORKSHIFT:
			public void dleteWorkShift(String ShiftToDelete) {
				JobBtn.click();
				workShifts.click();
				List <WebElement> list= ShiftList;
		        for(int i=0;i<list.size();i++) {   
		        	String shiftname=(list.get(i).getText());
		        	   if (shiftname.equals(ShiftToDelete)){
		        		   WebElement td =  driver.findElement(By.xpath(".//*[@id='resultTable']/tbody/tr["+(i+1)+"]/td[1]/input"));
		        		     td.click();
		        		     break;
		        		    } 
		        }
				delete.click();
				okBtn.click();
			}
			public boolean DeletingWorkShiftSuccess() {
		       	 if(deleteSuccess.isDisplayed()) {
		       		System.out.println(deleteSuccess.getText());
		       		 return true; 
		       	 }
		       	 else {
		       		 return false; 
		       	 }	
				}
			
		
	  //10.ASSIGINING WORKSHIFT:
			
			public void assignWorkShift(String shift,String Employee) throws InterruptedException {
				JobBtn.click();
				workShifts.click();
				
				List <WebElement> list= workshiftToSelect;
		        System.out.println(list.size());
		        for(int i=0;i<list.size();i++) {   
		        	String shiftname=(list.get(i).getText());
		        	   if (shiftname.equals(shift)){
		        		   list.get(i).click();
		        		   break;
		        		    } 
		        	   }
		        Thread.sleep(1000);
		        new Select(empList).selectByVisibleText(Employee);
		        //Thread.sleep(1000);
				assignBtn.click();
				save_btn.click();
					
			}
			public boolean AssigningWorkShiftSuccess() {
		       	 if(saveSuccess.isDisplayed()) {
		       		System.out.println(saveSuccess.getText());
		       		 return true; 
		       	 }
		       	 else {
		       		 return false; 
		       	 }	
				}
			
			
	  //11.ADDING GENERAL INFORMATION OF ORGANIZATION:
			public void Organization_Info(String orgName,String phoneNo,String eMail,String streetAdd,String cityName,String pinNo) {
				Organiztation_tab.click();
				general_Info.click();
				edit.click();
				organization_name.clear();
				organization_name.sendKeys(orgName);
				phone_no.clear();
				phone_no.sendKeys(phoneNo);
				email.clear();
				email.sendKeys(eMail);
				street_name.clear();
				street_name.sendKeys(streetAdd);
				city.clear();
				city.sendKeys(cityName);
				postal_code.clear();
				postal_code.sendKeys(pinNo);
				edit.click();
			}
			public boolean AddInfoOfOganizationSuccess() {
		       	 if(save_success.isDisplayed()) {
		       		System.out.println(save_success.getText());
		       		 return true; 
		       	 }
		       	 else {
		       		 return false; 
		       	 }	
				}
	
			
	  //12.ADDING LOCATION OF ORGANIZATION IN DIFFERENT COUNTRIES:
			public void adding_OrganizationLocation(String locationName,String country) {
				Organiztation_tab.click();
				locations_tab.click();
				add_btn.click();
				location_name.sendKeys(locationName);
				new Select(country_name).selectByVisibleText(country);
				save_btn.click();
			}
			
			public boolean AddOgranizationLocationSuccess() {
		       	 if(operation_success.isDisplayed()) {
		       		System.out.println(operation_success.getText());
		       		 return true; 
		       	 }
		       	 else {
		       		 return false; 
		       	 }	
				}
		
			
	  //13.DELETING LOCATION OF ORGANIZATION IN DIFFERENT COUNTRIES:
			public void deleting_OrganizationLocation(String LocationToDelete) {
				Organiztation_tab.click();
				locations_tab.click();
				List <WebElement> list= location_list;
		        for(int i=0;i<list.size();i++) {   
		        	String locationname=(list.get(i).getText());
		        	   if (locationname.equals(LocationToDelete)){
		        		   WebElement td =  driver.findElement(By.xpath(".//*[@id='resultTable']/tbody/tr["+(i+1)+"]/td[1]/input"));
		        		     td.click();
		        		     break;
		        		    } 
		        }
				delete.click();
				okBtn.click();
			}
			public boolean DeletingOgranizationLocationSuccess() {
		       	 if(operation_success.isDisplayed()) {
		       		System.out.println(operation_success.getText());
		       		 return true; 
		       	 }
		       	 else {
		       		 return false; 
		       	 }	
				}
			
			
	  //14.ADDIND DIFFERENT NATIONALITIES:
			public void adding_nationalities(String nationality) {
				nationalities_Tab.click();
				add_btn.click();
				nationality_name.sendKeys(nationality);
				save_btn.click();
				System.out.println(operation_success.getText());
			}
			public boolean AddingNationalitySuccess() {
		       	 if(operation_success.isDisplayed()) {
		       		System.out.println(operation_success.getText());
		       		 return true; 
		       	 }
		       	 else {
		       		 return false; 
		       	 }	
				}
		
			
	 //15.DELETING NATIONALITY:
			public void deleting_nationality(String NationalityToDelete) {
				nationalities_Tab.click();
				List <WebElement> list= nationality_list;
		        for(int i=0;i<list.size();i++) {   
		        	String nationalityName=(list.get(i).getText());
		        	   if (nationalityName.equals(NationalityToDelete)){
		        		   WebElement td =  driver.findElement(By.xpath(".//*[@id='resultTable']/tbody/tr["+(i+1)+"]/td[1]/input"));
		        		     td.click();
		        		     break;
		        		    } 
		        }
				delete.click();
				okBtn.click();				
			}
			public boolean DeleteNationalitySuccess() {
		       	 if(operation_success.isDisplayed()) {
		       		System.out.println(operation_success.getText());
		       		 return true; 
		       	 }
		       	 else {
		       		 return false; 
		       	 }	
				}
			
			
	//16.ADDING PAY GRADE AND CURRENCY IN JOB SECTION:
			public void addingPayGrade(String payGrade,String currency) {
				JobBtn.click();
				payGrades.click();
				add_btn.click();
				payGrade_name.sendKeys(payGrade);
				save_btn.click();
				addCurrency_btn.click();
				currency_name.sendKeys(currency);
				saveCurrencyBtn.click();
			}
			public boolean AddingPayGradeSuccess() {
		       	 if(msgSuccess.isDisplayed()) {
		       		System.out.println(msgSuccess.getText());
		       		 return true; 
		       	 }
		       	 else {
		       		 return false; 
		       	 }	
				}
		
			
	 //17.DELETING PAY GRADE IN JOB SECTION:
			public void delete_payGrade(String payGradeToDelete) {
				JobBtn.click();
				payGrades.click();
				List <WebElement> list= payGradeList;
		        for(int i=0;i<list.size();i++) {   
		        	String payGradeName=(list.get(i).getText());
		        	   if (payGradeName.equals(payGradeToDelete)){
		        		   WebElement td =  driver.findElement(By.xpath(".//*[@id='resultTable']/tbody/tr["+(i+1)+"]/td[1]/input"));
		        		     td.click();
		        		     break;
		        		    } 
		        }
				delete.click();
				okBtn.click();
			}
			public boolean DeletePayGradeSuccess() {
		       	 if(operation_success.isDisplayed()) {
		       		System.out.println(operation_success.getText());
		       		 return true; 
		       	 }
		       	 else {
		       		 return false; 
		       	 }	
				}
			
			
	//18.EDITING LOCALIZATION IN CONFIGURATION SECTION:
			public void edit_localization(String languageToSelect,String dateFormat) {
				configuration_tab.click();
				localization.click();
				Edit_btn.click();
				new Select(languageList).selectByVisibleText(languageToSelect);
				
				new Select(date_format).selectByValue(dateFormat);;
				save_btn.click();
			}
			public boolean Edit_LocalizationSuccess() {
		       	 if(SaveSuccess.isDisplayed()) {
		       		System.out.println(SaveSuccess.getText());
		       		 return true; 
		       	 }
		       	 else {
		       		 return false; 
		       	 }	
				}
			
			
	//19.SEARCHING LOCATION IN ORGANIZATION:
			public void search_location(String location1) {
				Organiztation_tab.click();
				locations_tab.click();
				locationName.sendKeys(location1);
				SearchBtn.click();	
			}
			public boolean Search_LocationSuccess() {
		       	 if(searchedLocation.isDisplayed()) {
		       		System.out.println("Searched location is :"+searchedLocation.getText());
		       		 return true; 
		       	 }
		       	 else {
		       		 return false; 
		       	 }	
				}
		
			
	//20.SEARCHING LOCATION IN ORGANIZATION WITH INVALID DATA:
			public void search_invalidLocation(String location2) {
				Organiztation_tab.click();
				locations_tab.click();
				locationName.sendKeys(location2);
				SearchBtn.click();	
			}
			public boolean Search_invalidLocationSuccess() {
		       	 if(resultMsg.isDisplayed()) {
		       		System.out.println(resultMsg.getText());
		       		 return true; 
		       	 }
		       	 else {
		       		 return false; 
		       	 }	
				}
			
	//21.REMOVING ASSIGNED WORKSHIFTS OF EMPLOYEE:
			
			@FindBy(id="workShift_assignedEmp")
			public static WebElement empAssignedList;
			
			@FindBy(xpath=".//*[@id='btnRemoveEmployee']")
			public static WebElement removeBtn;
			
			public void removeAssignedWorkShifOfEmp(String shift,String Employee) throws InterruptedException {
				JobBtn.click();
				workShifts.click();
				
				List <WebElement> list= workshiftToSelect;
		        for(int i=0;i<list.size();i++) {   
		        	String shiftname=(list.get(i).getText());
		        	   if (shiftname.equals(shift)){
		        		   list.get(i).click();
		        		   break;
		        		    } 
		        	   }
		        //Thread.sleep(1000);
		        new Select(empAssignedList).selectByVisibleText(Employee);
		        //Thread.sleep(2000);
				removeBtn.click();
				save_btn.click();
			}
			public boolean RemoveWorkShiftSuccess() {
		       	 if(saveSuccess.isDisplayed()) {
		       		System.out.println(saveSuccess.getText());
		       		 return true; 
		       	 }
		       	 else {
		       		 return false; 
		       	 }	
			}
			
	 //22.ADDING SKILLS IN QUALIFICATION SECTION:
			@FindBy(xpath=".//*[@id='menu_admin_Qualifications']")
			public static WebElement qualificationTab;
			
			@FindBy(xpath=".//*[@id='menu_admin_viewSkills']")
			public static WebElement SkillsTab;
			
			@FindBy(xpath=".//*[@id='skill_name']")
			public static WebElement skillName;
			
			@FindBy(xpath=".//*[@id='recordsListDiv']/div[2]/div")
			public static WebElement skillSaveSuccess;
			
			public void addSkillsToQualification(String skill) {
				qualificationTab.click();
				SkillsTab.click();
				add_btn.click();
				skillName.sendKeys(skill);
				save_btn.click();
			}
			public boolean AddingSkillSuccess() {
		       	 if(skillSaveSuccess.isDisplayed()) {
		       		System.out.println(skillSaveSuccess.getText());
		       		 return true; 
		       	 }
		       	 else {
		       		 return false; 
		       	 }	
			}
			
	//23.DELETING ADDED SKILL IN QUALIFICATION SECTION:
			@FindBy(xpath=".//*[@id='recordsListTable']/tbody/tr/td[2]")
			public static List<WebElement> skillList; 
			
			@FindBy(xpath=".//*[@id='btnDel']")
			public static WebElement Del_btn;
			
			@FindBy(xpath=".//*[@id='recordsListDiv']/div[2]/div")
			public static WebElement skillDeleteSuccess;
			
			public void deleteSkills(String skillToDelete) {
				qualificationTab.click();
				SkillsTab.click();
				List <WebElement> list= skillList;
		        for(int i=0;i<list.size();i++) {   
		        	String SkillName=(list.get(i).getText());
		        	   if (SkillName.equals(skillToDelete)){
		        		   WebElement td =  driver.findElement(By.xpath(".//*[@id='recordsListTable']/tbody/tr["+(i+1)+"]/td[1]/input"));
		        		     td.click();
		        		     break;
		        		    } 
		        	   }
		        Del_btn.click();
			}
			public boolean DeletingSkillSuccess() {
				 if(skillDeleteSuccess.isDisplayed()) {
			       		System.out.println(skillDeleteSuccess.getText());
			       		 return true; 
			       	 }
			       	 else {
			       		 return false; 
			       	 }	
			}
			
	//24.ADDING EDUCATION IN QUALIFICATION SECTION:
			@FindBy(xpath=".//*[@id='menu_admin_viewEducation']")
			public static WebElement educationTab;
			
			@FindBy(xpath=".//*[@id='education_name']")
			public static WebElement educationLevelName;
			
			@FindBy(xpath=".//*[@id='recordsListDiv']/div[2]/div")
			public static WebElement EducationSaveSuccess;
			
			public void addingEducation(String education) {
				qualificationTab.click();
				educationTab.click();
				add_btn.click();
				educationLevelName.sendKeys(education);
				save_btn.click();
			}
			public boolean AddingEducationSuccess() {
		       	 if(EducationSaveSuccess.isDisplayed()) {
		       		System.out.println(EducationSaveSuccess.getText());
		       		 return true; 
		       	 }
		       	 else {
		       		 return false; 
		       	 }	
			}
			
	//25.DELETING EDUCATION IN QUALIFICATION SECTION:
			@FindBy(xpath=".//*[@id='recordsListTable']/tbody/tr/td[2]")
			public static List<WebElement> educationLevelList;
			
			@FindBy(xpath=".//*[@id='recordsListDiv']/div[2]/div")
			public static WebElement EducationDeleteSuccess;
			
			public void deletingEducation(String educationToDelete) {
				qualificationTab.click();
				educationTab.click();
				
				List <WebElement> list= educationLevelList;
		        for(int i=0;i<list.size();i++) {   
		        	String levelName=(list.get(i).getText());
		        	   if (levelName.equals(educationToDelete)){
		        		   WebElement td =  driver.findElement(By.xpath(".//*[@id='recordsListTable']/tbody/tr["+(i+1)+"]/td[1]/input"));
		        		    td.click();
		        		    break;
		        		    } 
		        	   }
		        Del_btn.click();   
			}
			public boolean DeletingEducationSuccess() {
				 if(EducationDeleteSuccess.isDisplayed()) {
			       		System.out.println(EducationDeleteSuccess.getText());
			       		 return true; 
			       	 }
			       	 else {
			       		 return false; 
			       	 }	
			}
			
	//26.ADDING LANGUAGE IN QUALIFICATION SECTION:
			@FindBy(xpath=".//*[@id='menu_admin_viewLanguages']")
			public static WebElement languageTab;
			
			@FindBy(xpath=".//*[@id='language_name']")
			public static WebElement languageName;
			
			@FindBy(xpath=".//*[@id='recordsListDiv']/div[2]/div")
			public static WebElement languageSaveSuccess;
			
			public void addingLanguage(String language) {
				qualificationTab.click();
				languageTab.click();
				add_btn.click();
				languageName.sendKeys(language);
				save_btn.click();
			}
			public boolean AddingLanguageSuccess() {
		       	 if(languageSaveSuccess.isDisplayed()) {
		       		System.out.println(languageSaveSuccess.getText());
		       		 return true; 
		       	 }
		       	 else {
		       		 return false; 
		       	 }	
			}
			
	//27.DELETING LANGUAGE IN QUALIFICATION SECTION:
			@FindBy(xpath=".//*[@id='recordsListTable']/tbody/tr/td[2]")
			public static List<WebElement> languagList;
			
			@FindBy(xpath=".//*[@id='recordsListDiv']/div[2]/div")
			public static WebElement languageDeleteSuccess;
			
			public void deletingLanguage(String languageToDelete) {
				qualificationTab.click();
				languageTab.click();
				
				List <WebElement> list= languagList;
		        for(int i=0;i<list.size();i++) {   
		        	String languageName=(list.get(i).getText());
		        	   if (languageName.equals(languageToDelete)){
		        		   WebElement td =  driver.findElement(By.xpath(".//*[@id='recordsListTable']/tbody/tr["+(i+1)+"]/td[1]/input"));
		        		   td.click();
		        		   break;
		        		    } 
		        	   }
		        Del_btn.click();   
			}

			public boolean DeletingingLanguageSuccess(){
				return languageDeleteSuccess.isDisplayed();
			}
			
	//28.ADDING EMPLOYMENT STATUS IN JOB SECTION:
			@FindBy(xpath=".//*[@id='menu_admin_employmentStatus']")
			public static WebElement employementStatusTab;
			
			@FindBy(xpath=".//*[@id='empStatus_name']")
			public static WebElement empStatusName;
			
			@FindBy(xpath=".//*[@id='frmList_ohrmListComponent']/div[2]")
			public static WebElement AddEmploymentSuccess;
			
			public void addingEmployment(String statusName) {
				JobBtn.click();
				employementStatusTab.click();
				add_btn.click();
				empStatusName.sendKeys(statusName);
				save_btn.click();
			}
			public boolean AddEmploymentSuccess() {
				 if(AddEmploymentSuccess.isDisplayed()) {
			       		System.out.println(AddEmploymentSuccess.getText());
			       		 return true; 
			       	 }
			       	 else {
			       		 return false; 
			       	 }
            }
			
	//29.DELETING EMPLOYMENT STATUS IN JOB SECTION:
			@FindBy(xpath=".//*[@id='resultTable']/tbody/tr/td[2]")
			public static List<WebElement> employStatusList;
			
			@FindBy(xpath=".//*[@id='frmList_ohrmListComponent']/div[2]")
			public static WebElement DeleteEmploymentSuccess;
			
			public void deletingEmployment(String statusToDelete) {
				JobBtn.click();
				employementStatusTab.click();
				
				List <WebElement> list= employStatusList;
		        for(int i=0;i<list.size();i++) {   
		        	String statusName=(list.get(i).getText());
		        	   if (statusName.equals(statusToDelete)){
		        		   WebElement td =  driver.findElement(By.xpath(".//*[@id='resultTable']/tbody/tr["+(i+1)+"]/td[1]/input"));
		        		   td.click();
		        		   break;
		        		    } 
		        	   }
		        delete.click();
		        okBtn.click();
			}
			public boolean DeleteEmploymentSuccess() {
				 if(DeleteEmploymentSuccess.isDisplayed()) {
			       		System.out.println(DeleteEmploymentSuccess.getText());
			       		 return true; 
			       	 }
			       	 else {
			       		 return false; 
			       	 }
           }
			
	//30.ADDING SOCIAL MEDIA AUTHENTICATION IN CONFIGURATION SECTION:
			@FindBy(xpath=".//*[@id='menu_admin_openIdProvider']")
			public static WebElement socialMediaAuthTab;
			
			@FindBy(xpath=".//*[@id='openIdProvider_type']")
			public static WebElement providerType;
			
			@FindBy(xpath=".//*[@id='openIdProvider_name']")
			public static WebElement providerName;
			
			@FindBy(xpath=".//*[@id='openIdProvider_url']")
			public static WebElement providerUrl;
			
			@FindBy(xpath=".//*[@id='frmList_ohrmListComponent']/div[2]")
			public static WebElement MediaAuthenticatedSuccessfully;
			
			public void AddingSocialMediaAuthti(String type,String nameOfProvider,String UrlOfProvider) {
				configuration_tab.click();
				socialMediaAuthTab.click();
				add_btn.click();
				new Select(providerType).selectByVisibleText(type);
				providerName.sendKeys(nameOfProvider);
				providerUrl.sendKeys(UrlOfProvider);
				save_btn.click();
			}
			public boolean AddingMediaAunthenticationSuccess() {
				 if(MediaAuthenticatedSuccessfully.isDisplayed()) {
			       		System.out.println(MediaAuthenticatedSuccessfully.getText());
			       		 return true; 
			       	 }
			       	 else {
			       		 return false; 
			       	 }
          }
	
	//31.DELETING SOCIAL MEDIA AUTHENTICATION IN CONFIGURATION SECTION:		
			@FindBy(xpath=".//*[@id='resultTable']/tbody/tr/td[2]")
			public static List<WebElement> ProviderList;
			
			@FindBy(xpath=".//*[@id='frmList_ohrmListComponent']/div[2]")
			public static WebElement MediaAuthenticationDeleteSuccess;
			
			public void DeletingSocialMediaAuthenti(String providerListToDelete) {
				configuration_tab.click();
				socialMediaAuthTab.click();
				
				List <WebElement> list= ProviderList;
		        for(int i=0;i<list.size();i++) {   
		        	String providerName=(list.get(i).getText());
		        	   if (providerName.equals(providerListToDelete)){
		        		   WebElement td =  driver.findElement(By.xpath(".//*[@id='resultTable']/tbody/tr["+(i+1)+"]/td[1]/input"));
		        		   td.click();
		        		   break;
		        		    } 
		        	   }
		        delete.click();
		        okBtn.click();
			}

			public boolean DeleteMediaAuthenticationSuccess() {
				 if(MediaAuthenticationDeleteSuccess.isDisplayed()) {
			       		System.out.println(MediaAuthenticationDeleteSuccess.getText());
			       		 return true; 
			       	 }
			       	 else {
			       		 return false; 
			       	 }
          }
}


