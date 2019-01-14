package com.test.Megneil.opteli.testScripts;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.test.Megneil.opteli.pageobjects.SMSNotificationPage;
import com.test.Megneil.opteli.utilities.ReadConfig;

public class TC002_SMSNotifications extends BaseClass{
	
	
	ReadConfig readconfig = new ReadConfig();
	


	String firstWinHandle;
	public String clientid= readconfig.searchClientID();
	
	

//@Parameters("browser")
@Test(priority=1)
public void openNotificationNewTab()
{
	SMSNotificationPage objsms = new SMSNotificationPage(driver);
	
	System.out.println("Search ClientID info: "+clientid);
	
	
	
	try{
		//driver.findElement(By.id("txtSearch")).sendKeys("test");
		
		
		objsms.setClientID(clientid);

		//driver.findElement(By.id("btnSearch")).click();
		objsms.clickClientSearch();

		Thread.sleep(3000);

		//driver.findElement(By.id("cmdInfopatient")).click();
		objsms.clickPatientListIcon();
		
		Thread.sleep(3000);
		
		//driver.findElement(By.cssSelector("a.dashboard.menu>img.bottom")).click();
		objsms.clickMainMenu();
		
		//driver.findElement(By.cssSelector("#pliSettings > span")).click();
		
		objsms.clickSettingsLink();
		
		objsms.clickNotificationLink();
		
		//driver.findElement(By.xpath("//ul[@id='ulTop']/li[2]")).click();
		
			
			 //String winHandle=(String) handles.iterator().next();
			 
			 
		
		}
			catch(Exception e)
			{
				System.out.println(e);
				
			}
	
	Set<String> handles = driver.getWindowHandles();
	
	Iterator<String> itr = handles.iterator();
	 
	 firstWinHandle = driver.getWindowHandle(); //handles.remove(firstWinHandle);
	 
	 int handlescount = handles.size();
	 for (int i=0; i<handlescount;i++)
	 {
		 
		 String childwindow = itr.next();
		 
		 if(!firstWinHandle.equals(childwindow))
		 {
			 driver.switchTo().window(childwindow);
		 }
		 
	 }
	 
	 
}
	
	
	@Test(priority=2)
	public void clickUpSaveButton()
	{
		SMSNotificationPage objsms = new SMSNotificationPage(driver);
		try{
			//driver.findElement(By.xpath("//input[@id='btnSaveUp']")).click();
			objsms.clickBtnSaveUp();
			String alerttext = driver.switchTo().alert().getText();
			Alert alert =driver.switchTo().alert();
			Thread.sleep(3000);
			alert.accept();
			//assert.assertEquals(alerttext, "Data Saved Successfully");
			if(alerttext.equals("Data saved successfully"))
			{
				System.out.println("Upper save button is working fine");
				Reporter.log("PASS");
				
			}
			else
				System.out.println("Upper save button is not working fine");
			Reporter.log("FAIL");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
}
		@Test(priority=3)
	public void clickDownSaveButton()
	{
try{SMSNotificationPage objsms = new SMSNotificationPage(driver);
			
			//driver.findElement(By.xpath("//input[@id='btnSaveDown']")).click();
	
			objsms.clickBtnSaveDown();
			
			String alerttext = driver.switchTo().alert().getText();
			Alert alert =driver.switchTo().alert();
			Thread.sleep(3000);
			alert.accept();
			//assert.assertEquals(alerttext, "Data Saved Successfully");
			if(alerttext.equals("Data saved successfully"))
			{    
				//assert.assertTrue();
				System.out.println("Bottom save button is working fine");
				
			}
			else{
				System.out.println("Bottom save button is not working fine");
			
		}
			}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	
	@Test(priority=4)
	public void appointmentHeader()
	{
		System.out.println("appointmentHeader");
	}
	
	@Test(priority=5)
	public void appointmentConfirmation() throws InterruptedException
	{SMSNotificationPage objsms = new SMSNotificationPage(driver);
	
	//driver.findElement(By.xpath("//i[@id='arrowAPPT_CNFRM']")).click();
		
	objsms.apptConfirmUpArrow();
	
	Thread.sleep(3000);
	try{
	//if(!driver.findElement(By.xpath("//textarea[@id='5']")).isDisplayed())
		if(!objsms.apptConfirmMsgTemplate())
	   
	{
		System.out.println("APPOINTMENT CONFIRMATION:"
				+ "Appointment Confirmation collapse is working");
	}
	else
	{
		System.out.println("APPOINTMENT CONFIRMATION:"
				+ "Appointment Confirmation collapse is not working");
	}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	//driver.findElement(By.xpath("//i[@id='arrowAPPT_CNFRM' and @class='fas fa-arrow-down']")).click();
	
	objsms.apptConfirmDownArrow();
	
	Thread.sleep(3000);
	try{
	//if(driver.findElement(By.xpath("//textarea[@id='5']")).isDisplayed())
		if(objsms.apptConfirmMsgTemplate())
	{
		System.out.println("APPOINTMENT CONFIRMATION:"
				+ "Appointment Confirmation Expand is working");
	}
	else
	{
		System.out.println("APPOINTMENT CONFIRMATION:"
				+ "Appointment Confirmation Expand is not working");
	}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		
		
	}
	@Test(priority=6)
	public void appointmentCancellation() throws InterruptedException
	{
		SMSNotificationPage objsms = new SMSNotificationPage(driver);
		//driver.findElement(By.xpath("//i[@id='arrowAPPT_CNCL' and @class='fas fa-arrow-up']")).click();
		
		objsms.apptCancelUpArrow();
		
		Thread.sleep(3000);
		try{
		if(!driver.findElement(By.xpath("//textarea[@id='4']")).isDisplayed())
		{
			System.out.println("APPOINTMENT CANCELLATION:"
					+ "Appointment Cancellation collapse is working");
		}
		else
		{
			System.out.println("APPOINTMENT CANCELLATION:"
					+ "Appointment Cancellation collapse is not working");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//i[@id='arrowAPPT_CNCL' and @class='fas fa-arrow-down']")).click();
		Thread.sleep(3000);
		try{
		if(driver.findElement(By.xpath("//textarea[@id='4']")).isDisplayed())
		{
			System.out.println("APPOINTMENT CANCELLATION:"
					+ "Appointment Cancellation Expand is working");
		}
		else
		{
			System.out.println("APPOINTMENT CANCELLATION:"
					+ "Appointment Cancellation Expand is not working");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	@Test(priority=7)
	public void appointmentNoShow() throws InterruptedException
	{
		driver.findElement(By.xpath("//i[@id='arrowAPPT_NOSW' and @class='fas fa-arrow-up']")).click();
		Thread.sleep(3000);
		try{
		if(!driver.findElement(By.xpath("//textarea[@id='10']")).isDisplayed())
		{
			System.out.println("APPOINTMENT NO-SHOW:"
					+ "Appointment No-show collapse is working");
		}
		else
		{
			System.out.println("APPOINTMENT NO-SHOW:"
					+ "Appointment No-show collapse is not working");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		driver.findElement(By.cssSelector("#arrowAPPT_NOSW")).click();
		Thread.sleep(3000);
		try{
		if(driver.findElement(By.xpath("//textarea[@id='10']")).isDisplayed())
		{
			System.out.println("APPOINTMENT NO-SHOW:"
					+ "Appointment No-show Expand is working");
		}
		else
		{
			System.out.println("APPOINTMENT NO-SHOW:"
					+ "Appointment No-show Expand is not working");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	@Test(priority=8)
	public void appointmentReminder() throws InterruptedException
	{
		driver.findElement(By.cssSelector("#arrowAPPT_RMD")).click();
		Thread.sleep(3000);
		try{
		if(!driver.findElement(By.xpath("//textarea[@id='8']")).isDisplayed())
		{
			System.out.println("APPOINTMENT REMINDER:"
					+ "Appointment Reminder collapse is working");
		}
		else
		{
			System.out.println("APPOINTMENT REMINDER:"
					+ "Appointment Reminder collapse is not working");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		driver.findElement(By.cssSelector("#arrowAPPT_RMD")).click();
		Thread.sleep(3000);
		try{
		if(driver.findElement(By.xpath("//textarea[@id='8']")).isDisplayed())
		{
			System.out.println("APPOINTMENT REMINDER:"
					+ "Appointment Reminder Expand is working");
		}
		else
		{
			System.out.println("APPOINTMENT REMINDER:"
					+ "Appointment Reminder Expand is not working");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	@Test(priority=9)
	public void appointmentReschedule() throws InterruptedException
	{
		driver.findElement(By.cssSelector("#arrowAPPT_RSD")).click();
		Thread.sleep(3000);
		try{
		if(!driver.findElement(By.xpath("//textarea[@id='11']")).isDisplayed())
		{
			System.out.println("APPOINTMENT RESCHEDULE:"
					+ "Appointment Reschedule collapse is working");
		}
		else
		{
			System.out.println("APPOINTMENT RESCHEDULE:"
					+ "Appointment Reschedule collapse is not working");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		driver.findElement(By.cssSelector("#arrowAPPT_RSD")).click();
		Thread.sleep(3000);
		try{
		if(driver.findElement(By.xpath("//textarea[@id='11']")).isDisplayed())
		{
			System.out.println("APPOINTMENT RESCHEDULE:"
					+ "Appointment Reschedule Expand is working");
		}
		else
		{
			System.out.println("APPOINTMENT RESCHEDULE:"
					+ "Appointment Reschedule Expand is not working");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	@Test(priority=10)
	public void postAppointmentThankYou() throws InterruptedException
	{
		driver.findElement(By.cssSelector("#arrowAPPT_PSTTHK")).click();
		Thread.sleep(3000);
		try{
		if(!driver.findElement(By.xpath("//textarea[@id='12']")).isDisplayed())
		{
			System.out.println("POST APPOINTMENT THANK YOU:"
					+ "Post Appointment Thank You collapse is working");
		}
		else
		{
			System.out.println("POST APPOINTMENT THANK YOU:"
					+ "Post Appointment Thank You collapse is not working");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		driver.findElement(By.cssSelector("#arrowAPPT_PSTTHK")).click();
		Thread.sleep(3000);
		try{
		if(driver.findElement(By.xpath("//textarea[@id='12']")).isDisplayed())
		{
			System.out.println("POST APPOINTMENT THANK YOU:"
					+ "Post Appointment Thank You Expand is working");
		}
		else
		{
			System.out.println("POST APPOINTMENT THANK YOU:"
					+ "Post Appointment Thank You Expand is not working");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	@Test(priority=11)
	public void toVerifyCheckboxEnabledorDisabled()
	{
		
		List<WebElement> checkboxes =driver.findElements(By.xpath("//img[@class='float-right pr-2 mr-5 pl-2']"));
		System.out.println("Total Checkboxes:"+ checkboxes.size());
		//boolean firststcheckbox = driver.findElement(By.cssSelector("img[id='optionsel2']")).isSelected();
		
		String firstcheckboxExpectedvalue=driver.findElement(By.cssSelector("img[id='optionsel2']")).getAttribute("src");
		System.out.println("image text is:"+ firstcheckboxExpectedvalue);
		
		if(firstcheckboxExpectedvalue.contains("checked-box"))
		{
			System.out.println("1st Checkbox is already checked");
		}
		else{
			System.out.println("1st Checkbox is not checked");
		}
		
		for(int i=0; i<checkboxes.size();i++)
				{
					
				String allCheckboxExpectedvalue=checkboxes.get(i).getAttribute("src");
				
				if(allCheckboxExpectedvalue.contains("checked-box"))
				{
					System.out.println("All sections checkboxes are already checked:");
					
				}
				
				else
				{
					System.out.println("Checkboxes are not checked");
					
				}
					
					}
		driver.close();
		 driver.switchTo().window(firstWinHandle);
				}
	
	public boolean isAlertPresent() 
	{ 
	    try 
	    { 
	        Alert alert =driver.switchTo().alert();
	        alert.accept();
	        
	        return true; 
	    }   
	    catch (NoAlertPresentException Ex) 
	    { 
	        return false; 
	    }
	}   
	
}
