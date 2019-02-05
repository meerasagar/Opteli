package com.test.Megneil.opteli.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatePatientPage {
	public WebDriver driver;
	public CreatePatientPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath=".//*[@id='txtLastName']")
	@CacheLookup
	WebElement txtPatientLastName;
	
	@FindBy(xpath=".//*[@id='txtFirstName']")
	@CacheLookup
	WebElement txtPatientFirstName;
	
	@FindBy(xpath=".//*[@id='ddlGender']")
	@CacheLookup
	WebElement txtPatientGender;
	
	@FindBy(xpath=".//*[@id='txtDOB']")
	@CacheLookup
	WebElement clickDOB;
	

	@FindBy(xpath=".//*[@id='ui-datepicker-div']/table/tbody/tr[3]/td[5]/a")
	@CacheLookup
	WebElement selectDate;
	

	@FindBy(xpath=".//*[@id='txtAddress1']")
	@CacheLookup
	WebElement txtAddress1;
	
	@FindBy(xpath=".//*[@id='txtZipCode']")
	@CacheLookup
	WebElement txtZipCode;
	

	@FindBy(xpath=".//*[@id='txtPhone1']")
	@CacheLookup
	WebElement txtPhone1;
	
	@FindBy(xpath=".//*[@id='btnTopSubmit']")
	@CacheLookup
	WebElement clickSave;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
