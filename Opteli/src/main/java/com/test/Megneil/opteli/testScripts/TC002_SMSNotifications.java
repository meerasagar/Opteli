package com.test.Megneil.opteli.testScripts;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.test.Megneil.opteli.pageobjects.LoginPage;
import com.test.Megneil.opteli.pageobjects.SMSNotificationPage;
import com.test.Megneil.opteli.utilities.ReadConfig;

public class TC002_SMSNotifications extends BaseClass{
	
	
	ReadConfig readconfig = new ReadConfig();
	


	String firstWinHandle;
	public String clientid= readconfig.searchClientID();
	public boolean allCheckboxExpectedvalue;
	public boolean cancelcheckboxes;
	

//@Parameters("browser")
@Test
public void smsNotificationSettings() throws InterruptedException, IOException
{
	
	LoginPage lp = new LoginPage(driver);
	
	lp.clickOutLogin();
	logger.info("Clicked on Login button to enter ClientID");
	
	lp.setClientID(ClientID);
	logger.info("Entered ClientID");

	lp.settxtUsername(Username);
	logger.info("Entered UserName");
	
	lp.settxtPassword(password);
	logger.info("Entered Password");
	
	Thread.sleep(3000);
	
	lp.clickSubmit();
	logger.info("Clicked on Login button");
	
	try {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	} catch (Exception e) {
		System.out.println(e);
	}
	
    System.out.println("Title:"+driver.getTitle());
	
	if(driver.getTitle().contains("Advantrix"))
	{
		Assert.assertTrue(true);
		logger.info("Login successfull");
	}
	else
	{
		captureScreen(driver,"testAppointmentReport");
		Assert.assertTrue(false);
		logger.info("Login Failed");
	}
	Thread.sleep(3000);
	//openNotificationNewTab()
	SMSNotificationPage objsms = new SMSNotificationPage(driver);
	
		
	try{
		//driver.findElement(By.id("txtSearch")).sendKeys("test");
		
		
		objsms.setClientID(clientid);
		logger.info("Entered ClientID to search");
		
		//driver.findElement(By.id("btnSearch")).click();
		objsms.clickClientSearch();
		logger.info("Clicked on Search");

		Thread.sleep(3000);

		//driver.findElement(By.id("cmdInfopatient")).click();
		objsms.clickPatientListIcon();
		logger.info("Clicked on Patient List to go inside the client");
		
		Thread.sleep(3000);
		
		//driver.findElement(By.cssSelector("a.dashboard.menu>img.bottom")).click();
		objsms.clickMainMenu();
		logger.info("Clicked on Main Menu");
		
		//driver.findElement(By.cssSelector("#pliSettings > span")).click();
		
		objsms.clickSettingsLink();
		logger.info("Clicked on Settings Sub Menu");
		
		objsms.clickNotificationLink();
		logger.info("Clicked on Notifications(SMS) link");
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

		
	
try{
	

			
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
		

	

	
		System.out.println("appointmentHeader");
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
		
	
	
		
		/*List<WebElement> checkboxes =driver.findElements(By.xpath("//img[@class='float-right pr-2 mr-5 pl-2']"));
		System.out.println("Total Checkboxes:"+ checkboxes.size());
		
		for(int i=0; i<checkboxes.size();i++)
		{
					
				allCheckboxExpectedvalue=checkboxes.get(i).isSelected();
				System.out.println("All checkbox expected value is: "+allCheckboxExpectedvalue);
				
				if(allCheckboxExpectedvalue==true){
					System.out.println("All sections checkboxes are already checked:");
					
		
				}
				else
				{
					System.out.println("Some check boxes are not checked");
				}
				
		}*/
		
		
		//System.out.println("All sections checkboxes are already checked:");	
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
