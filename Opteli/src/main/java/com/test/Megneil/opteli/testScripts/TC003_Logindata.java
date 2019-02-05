package com.test.Megneil.opteli.testScripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.Megneil.opteli.pageobjects.LoginPage;
import com.test.Megneil.opteli.utilities.XLUtils;

public class TC003_Logindata extends BaseClass {
	@Test(dataProvider="LoginData")
	public void testLogin(String Clientid, String username, String pwd) throws InterruptedException
	{
LoginPage lp = new LoginPage(driver);
		
		lp.clickOutLogin();
		logger.info("Clicked on Login button to enter ClientID");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//lp.setClientID(ClientID);
		//logger.info("Entered ClientID");

		//lp.settxtUsername(Username);
		//logger.info("Entered UserName");
		
		//lp.settxtPassword(password);
		//logger.info("Entered Password");
		
		Thread.sleep(3000);
		
		//lp.clickSubmit();
		//logger.info("Clicked on Login button");
	}
	@DataProvider(name="LoginData")
	 String[][] getData() throws IOException
	{
		
	String path ="C:\\Users\\MNT026\\git\\Opteli\\Opteli\\OpteliLoginTestData.xlsx";
	int rownum = XLUtils.getRowCount(path, "Sheet1");
	int cellnum = XLUtils.getCellCount(path, "Sheet1", 1);
	
	String logindata[][] = new String [rownum][cellnum];
	
	for(int i=1; i<rownum;i++)
	{
		
		for (int j=0; j<cellnum; j++)
		{
			logindata[i-1][j] = XLUtils.getCellData(path,"Sheet1", i, j);
		}
	}
	return logindata;	
		
		
		
	}
}
