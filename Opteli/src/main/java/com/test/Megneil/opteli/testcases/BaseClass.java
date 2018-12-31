package com.test.Megneil.opteli.testcases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	public WebDriver driver;
	public static Logger logger;
	public String baseURL ="http://192.168.1.135//Developer1//Client/frmLogin.aspx";
	@BeforeClass
	public void setUp() throws Exception {
		
		//System.out.println(System.getProperty("user.dir"));

System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/Drivers/geckodriver.exe");
driver = new FirefoxDriver();
		
//System. setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");

		// Initialize browser.
//driver=new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		logger = Logger.getLogger("BaseClass");
		
		PropertyConfigurator.configure("Log4j.properties");
	}
}
