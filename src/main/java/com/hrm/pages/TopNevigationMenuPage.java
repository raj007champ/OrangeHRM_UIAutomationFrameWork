package com.hrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.base.TestBase;

public class TopNevigationMenuPage extends TestBase{
	
	public TopNevigationMenuPage(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="welcome")
	WebElement welcomeMessage;
	
	public void ClickOnUserName(){
		try{
			welcomeMessage.click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//a[text()='Logout']")).click();	
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	

}
