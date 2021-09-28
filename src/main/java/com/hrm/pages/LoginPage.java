package com.hrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.hrm.base.TestBase;

import io.qameta.allure.Step;

public class LoginPage extends TestBase{
		
	public LoginPage(){	
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="txtUsername")
	WebElement LoginUserName;
	
	@FindBy(id="txtPassword")
	WebElement LoginPassword;
	
	@FindBy(id="btnLogin")
	WebElement Loginbutton;
	
	//Enter username in username textbox
	public void setUserName(String userName){
		LoginUserName.sendKeys(userName);
    }
    
	//Set password in password textbox
    public void setPassword(String password){
      LoginPassword.sendKeys(password);
    }

    //Click on login button
	@Step("Login to the application")
    public void clickLogin(){
            Loginbutton.click();
    }
   
    public DashboardPage loginToApp(String username, String password) {
    	setUserName(username);
    	setPassword(password);
    	clickLogin();
    	return new DashboardPage();
	}
}
