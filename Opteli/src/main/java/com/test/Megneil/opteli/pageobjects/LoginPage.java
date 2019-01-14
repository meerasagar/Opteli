package com.test.Megneil.opteli.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='txtCompanyID']")
	@CacheLookup
	WebElement txtclientID;
	
	@FindBy(id="txtUsername")
	@CacheLookup
	WebElement txtUsername;
	
	@FindBy(id="txtPassword")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(id="btnLogin")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(css="span")
	@CacheLookup
	WebElement btnOutLogin;
	
	@FindBy(id="txtSearch")
	@CacheLookup
	WebElement txtSearch;
	
	public void setClientID(String ClientID)
	{
		txtclientID.sendKeys(ClientID);
	}
	
	public void settxtUsername(String Username)
	{
		txtUsername.sendKeys(Username);
	}
	
	public void settxtPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void clickSubmit()
	{
		btnLogin.click();
	}
	
	public void clickOutLogin()
	{
		btnOutLogin.click();
	}
	
	
	
	
	
	

}
