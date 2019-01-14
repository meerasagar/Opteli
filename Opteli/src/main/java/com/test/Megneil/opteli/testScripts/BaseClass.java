package com.test.Megneil.opteli.testScripts;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.test.Megneil.opteli.pageobjects.LoginPage;
import com.test.Megneil.opteli.utilities.ReadConfig;


public class BaseClass {
	
	ReadConfig readconfig = new ReadConfig();
	
	public WebDriver driver;
	public static Logger logger;
	public String baseURL = readconfig.getApplication();
	public String ClientID = readconfig.getClientID();
	public String Username = readconfig.getUsername();
	public String password = readconfig.getPassword();
	
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) throws IOException, InterruptedException {
		
		//System.out.println(System.getProperty("user.dir"));
		//System. setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");

				// Initialize browser.
		//driver=new ChromeDriver();
		logger = Logger.getLogger("BaseClass");
		
		PropertyConfigurator.configure("Log4j.properties");

				
				
				
				
				if(br.equals("firefox"))
				{

                System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxpath());
                driver = new FirefoxDriver();
				}
				else if(br.equals("chrome"))
				{
					System.setProperty("webdriver.chrome.driver",readconfig.getChromepath());
					driver = new ChromeDriver();
				}
				driver.manage().window().maximize();

				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
				driver.get(baseURL);
				
				logger.info("URL is opened");
				
				
				
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
	}

	
	
	@AfterClass
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("li.last > a.dashboard > img.bottom")).click();
		Thread.sleep(3000);
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (Exception e) {	
			System.out.println(e);
		}// TODO Auto-generated method stub
		driver.close();
		}
	public void captureScreen(WebDriver driver, String tname) throws IOException
	{
		
		TakesScreenshot ts = (TakesScreenshot)driver;
    	File source = ts.getScreenshotAs(OutputType.FILE);
    	File target = new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
    	FileUtils.copyFile(source, target);
    	System.out.println("Screenshot Taken");
	}
	
}
