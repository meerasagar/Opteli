package com.test.Megneil.opteli.testScripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
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
	public void setUp(String br) throws IOException {
		
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
	
}
