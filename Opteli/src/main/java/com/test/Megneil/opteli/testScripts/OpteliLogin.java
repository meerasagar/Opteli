package com.test.Megneil.opteli.testScripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.Megneil.opteli.pageobjects.LoginPage;

public class OpteliLogin{

	WebDriver driver;
	String ClientID;
	String UserID;
	String Password;
	public static Logger logger;
	
	@BeforeClass
	public void setup() throws InterruptedException {
		
		logger = Logger.getLogger("BaseClass");
		
		PropertyConfigurator.configure("Log4j.properties");
		//System.setProperty("webdriver.firefox.marionette","C:\\Users\\MNT026\\workspace\\Opteli\\Drivers\\geckodriver.exe");
		//driver = new FirefoxDriver();
		
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\MNT026\\workspace\\Opteli\\Drivers\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\MNT026\\git\\Opteli\\Opteli\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		logger.info("Browser Opened");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://192.168.1.135/Developer1/Client/frmLogin.aspx");
		
		LoginPage lp = new LoginPage(driver);
		lp.clickOutLogin();
		logger.info("Clicked on Login button to enter ClientID");
		
		lp.setClientID(ClientID);
		logger.info("Entered ClientID");

		lp.settxtUsername(UserID);
		logger.info("Entered UserName");
		
		lp.settxtPassword(Password);
		logger.info("Entered Password");
		
		Thread.sleep(3000);
		
		lp.clickSubmit();
		
		logger.info("Clicked on loggin");
	}

	@Test(dataProvider = "logindata")
	public void loginToOpteli(String ClientID, String UserID, String Password) throws InterruptedException,IOException {
		
		try{
		
	
		isAlertPresent();
		// System.out.println("The page title is: " + driver.getTitle());

		Assert.assertTrue(driver.getTitle().contains("Advantrix Opteli"),
				"User is able to login with Valid Credentials");

		System.out.println("Page Title verified- User is able to login Successfully");

}
	catch(Exception e)
		{
		System.out.println(e);
		}
}
	

	@AfterClass
	public void tearDown() throws InterruptedException 
	{
		//lp.opteliLogout();
		
		driver.findElement(By.cssSelector("li.last > a.dashboard > img.bottom")).click();
		logger.info("Loggedout from Opteli");
		
	Thread.sleep(3000);
		isAlertPresent();
		Thread.sleep(3000);
		driver.quit();
	}

	@DataProvider(name = "logindata")
	public Object[][] passData() {
		ExcelDataConfig config = new ExcelDataConfig("C:\\Users\\MNT026\\git\\Opteli\\Opteli\\OpteliLoginTestData.xlsx");
		int rows = config.getRowCount(0);
		Object[][] data = new Object[rows][3];
		for (int i = 1; i<rows; i++) {
			data[i][0] = config.getData(0, i, 0);
			data[i][1] = config.getData(0, i, 1);
			data[i][2] = config.getData(0, i, 2);

		}

		return data;

	}

	public void isAlertPresent() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
