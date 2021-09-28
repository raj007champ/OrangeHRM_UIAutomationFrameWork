package com.hrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.hrm.base.TestBase;
import com.hrm.util.Log;
import com.hrm.util.TestConfig;

public class AddEmployeePage extends TestBase  {

	public AddEmployeePage(){

		PageFactory.initElements(driver, this);
	}

	//Page Elements

	@FindBy(xpath="//input[@id='firstName']")
	WebElement FistName;

	@FindBy(xpath="//input[@id='middleName']")
	WebElement MiddleName;

	@FindBy(xpath="//input[@id='lastName']")
	WebElement Lastname;

	@FindBy(xpath="//input[@id='photofile']")
	WebElement Photograph;

	@FindBy(xpath="//input[@id='chkLogin']")
	WebElement LoginCheckBox;

	@FindBy(xpath="//input[@id='user_name']")
	WebElement UserName;

	@FindBy(xpath="//input[@id='user_password']")
	WebElement Password;

	@FindBy(xpath="//input[@id='re_password']")
	WebElement ConfirmPassword;

	@FindBy(xpath="//select[@id='status']")
	WebElement StatusDropDown;

	@FindBy(xpath="//input[@id='btnSave']")
	WebElement SaveButton;

	public void clickOnSaveButton(){
		try{
			FistName.sendKeys(TestConfig.Frist_Name);
			MiddleName.sendKeys(TestConfig.Middle_Name);
			Lastname.sendKeys(TestConfig.Last_Name);
			String PicturePath=System.getProperty("user.dir")+"\\src\\main\\java\\com\\hrm\\testdata\\Dhoni.jpg" ;
			System.out.println(PicturePath);
			Photograph.sendKeys(PicturePath);
			Thread.sleep(1000);
			LoginCheckBox.click();
			Thread.sleep(1000);
			if(UserName.isDisplayed()){
				UserName.sendKeys(TestConfig.User_Name);
				Password.sendKeys(TestConfig.Password);
				ConfirmPassword.sendKeys(TestConfig.Confirm_Password);
				Select status = new Select(StatusDropDown);
				status.selectByVisibleText("Enabled");
			}
			else{
				Log.info("Login Check box is Not Checked");
			}
			SaveButton.click();	
			Log.info("New Employedd Added");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
