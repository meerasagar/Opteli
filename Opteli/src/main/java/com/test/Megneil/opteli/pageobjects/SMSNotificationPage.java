package com.test.Megneil.opteli.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SMSNotificationPage {
	public WebDriver driver;
	
	public SMSNotificationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="txtSearch")
	@CacheLookup
	WebElement txtSearch;
	
	@FindBy(id="btnSearch")
	@CacheLookup
	WebElement btnSearch;
	
	@FindBy(id="cmdInfopatient")
	@CacheLookup
	WebElement patientInfo;
	
	@FindBy(css="a.dashboard.menu>img.bottom")
	@CacheLookup
	WebElement mainMenuImg;
	
	@FindBy(css="#pliSettings > span")
	@CacheLookup
	WebElement settings;
	
	@FindBy(xpath="//ul[@id='ulTop']/li[2]")
	@CacheLookup
	WebElement notificationLink;
	
	@FindBy(xpath="//input[@id='btnSaveUp']")
	@CacheLookup
	WebElement btnSaveUp;
	
	@FindBy(xpath="//input[@id='btnSaveDown']")
	@CacheLookup
	WebElement btnSaveDown;
	
	@FindBy(xpath="//i[@id='arrowAPPT_CNFRM']")
	@CacheLookup
	WebElement apptConfirmUpArrow;
	
	@FindBy(xpath="//textarea[@id='5']")
	@CacheLookup
	WebElement apptConfirmMsgTemplate;
	
	@FindBy(xpath="//i[@id='arrowAPPT_CNFRM' and @class='fas fa-arrow-down']")
	@CacheLookup
	WebElement apptConfirmDownArrow;
	
	@FindBy(xpath="//i[@id='arrowAPPT_CNCL' and @class='fas fa-arrow-up']")
	@CacheLookup
	WebElement apptCancelUpArrow;
	
	@FindBy(xpath="//textarea[@id='4']")
	@CacheLookup
	WebElement apptCancelMsgTemplate;
	
	@FindBy(xpath="//i[@id='arrowAPPT_CNCL' and @class='fas fa-arrow-down']")
	@CacheLookup
	WebElement apptCancelDownArrow;
	
	@FindBy(xpath="//i[@id='arrowAPPT_NOSW' and @class='fas fa-arrow-up']")
	@CacheLookup
	WebElement apptNoShowUpArrow;
	
	@FindBy(xpath="//textarea[@id='10']")
	@CacheLookup
	WebElement apptNoShowMsgTemplate;
	
	@FindBy(css="#arrowAPPT_NOSW")
	@CacheLookup
	WebElement apptNoShowDownArrow;
	
	@FindBy(css="#arrowAPPT_RMD")
	@CacheLookup
	WebElement reminderUpArrow;
	
	@FindBy(xpath="//textarea[@id='8']")
	@CacheLookup
	WebElement reminderMsgTemplate;
	
	@FindBy(css="#arrowAPPT_RMD")
	@CacheLookup
	WebElement reminderDownArrow;
	
	@FindBy(css="#arrowAPPT_RSD")
	@CacheLookup
	WebElement rescheduleUpArrow;
	
	@FindBy(xpath="//textarea[@id='11']")
	@CacheLookup
	WebElement rescheduleMsgTemplate;
	
	@FindBy(css="#arrowAPPT_RSD")
	@CacheLookup
	WebElement rescheduleDownArrow;
	
	@FindBy(css="#arrowAPPT_PSTTHK")
	@CacheLookup
	WebElement postApptThankYouUpArrow;
	
	@FindBy(xpath="//textarea[@id='12']")
	@CacheLookup
	WebElement postApptThankYouMsgTemplate;
	
	@FindBy(css="#arrowAPPT_PSTTHK")
	@CacheLookup
	WebElement postApptThankYouDownArrow;
	
	@FindBy(xpath="//img[@class='float-right pr-2 mr-5 pl-2']")
	@CacheLookup
	WebElement findCheckBoxes;
	
	@FindBy(css="img[id='optionsel2']")
	@CacheLookup
	WebElement apptConfirmCheckBox;
	
	public void setClientID(String clientid)
	{
		txtSearch.sendKeys(clientid);
	}
	
	public void clickClientSearch()
	{
		btnSearch.click();
	}
	
	public void clickPatientListIcon()
	{
		patientInfo.click();
	}
	
	public void clickMainMenu()
	{
		mainMenuImg.click();
	}
	
	public void clickSettingsLink()
	{
	settings.click();
	}
	
	public void clickNotificationLink()
	{
		notificationLink.click();
	}
	
	public void clickBtnSaveUp()
	{
		btnSaveUp.click();
	}
	
	public void clickBtnSaveDown()
	{
		btnSaveDown.click();
	}
	
	public void apptConfirmUpArrow()
	{
		apptConfirmUpArrow.click();
	}
	
	public boolean apptConfirmMsgTemplate()
	{
		return apptConfirmMsgTemplate.isDisplayed();
	}
	
	public void apptConfirmDownArrow()
	{
		apptConfirmDownArrow.click();
	}
	
	public void apptCancelUpArrow()
	{
		apptCancelUpArrow.click();
	}
	
	public void apptCancelMsgTemplate()
	{
		apptCancelMsgTemplate.isDisplayed();
	}
	
	public void apptCancelDownArrow()
	{
		apptCancelDownArrow.click();
	}
	
	public void apptNoShowUpArrow()
	{
		apptNoShowUpArrow.click();
	}
	
	public void apptNoShowMsgTemplate()
	{
		apptNoShowMsgTemplate.isDisplayed();
	}
	
	public void apptNoShowDownArrow()
	{
		apptNoShowDownArrow.click();
	}
	
	public void reminderUpArrow()
	{
		reminderUpArrow.click();
	}
	
	public void reminderMsgTemplate()
	{
		reminderMsgTemplate.isDisplayed();
	}
	
	public void reminderDownArrow()
	{
		reminderDownArrow.click();
	}
	
	public void rescheduleUpArrow()
	{
		rescheduleUpArrow.click();
	}
	
	public void rescheduleMsgTemplate()
	{
		rescheduleMsgTemplate.isDisplayed();
	}
	
	public void rescheduleDownArrow()
	{
		rescheduleDownArrow.click();
	}
	
	public void postApptThankYouUpArrow()
	{
		postApptThankYouUpArrow.click();
	}
	
	public void postApptThankYouMsgTemplate()
	{
		postApptThankYouMsgTemplate.isDisplayed();
	}
	
	public void postApptThankYouDownArrow()
	{
		postApptThankYouDownArrow.click();
	}
	
	public void findCheckBoxes()
	{
		
	}
	
	public void apptConfirmCheckBox()
	{
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
