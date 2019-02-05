package com.test.Megneil.opteli.testScripts;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreatePatient {
	
	
	
		WebDriver driver;
		String ClientID;
		String UserID;
		String Password;
		String viewPatient;
		public static Logger logger;
		
		//Before class
		@BeforeClass
		public void setup() throws InterruptedException {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\MNT026\\workspace\\Opteli\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("http://opteli.com/Client/frmLogin.aspx");
			//driver.get("http://192.168.1.135/Developer1/Client/frmLogin.aspx");
			driver.findElement(By.cssSelector("span")).click();
			driver.findElement(By.id("txtCompanyID")).clear();
			driver.findElement(By.id("txtCompanyID")).sendKeys("axpamtec");
			driver.findElement(By.id("txtUsername")).clear();
			driver.findElement(By.id("txtUsername")).sendKeys("test1");
			driver.findElement(By.id("txtPassword")).clear();
			driver.findElement(By.id("txtPassword")).sendKeys("test@123");
			driver.findElement(By.id("btnLogin")).click();
			Thread.sleep(1500);
			isAlertPresent();
			driver.findElement(By.id("txtSearch")).sendKeys("test");
			driver.findElement(By.id("btnSearch")).click();
			Thread.sleep(1500);
			driver.findElement(By.xpath(".//*[@id='cmdInfopatient']")).click();
			Thread.sleep(1500);
			driver.findElement(By.xpath(".//*[@id='btnCreate']")).click();
			Thread.sleep(1500);
			}
		
	//String DOB
		@Test(dataProvider = "patientdata")
		public void createPatientChart(String LastName, String FirstName, String Gender, String Address1, String zipcode, String phone1)
				throws InterruptedException {
			
			try{
				driver.findElement(By.xpath(".//*[@id='txtLastName']")).sendKeys(LastName);
				driver.findElement(By.xpath(".//*[@id='txtFirstName']")).sendKeys(FirstName);
				Select oselect = new Select(driver.findElement(By.xpath(".//*[@id='ddlGender']")));
				oselect.selectByIndex(1);
				driver.findElement(By.xpath(".//*[@id='txtDOB']")).click();
				driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/table/tbody/tr[3]/td[5]/a")).click();
				driver.findElement(By.xpath(".//*[@id='txtAddress1']")).sendKeys(Address1);
				driver.findElement(By.xpath(".//*[@id='txtZipCode']")).sendKeys(zipcode);
				driver.findElement(By.xpath(".//*[@id='txtZipCode']")).sendKeys(Keys.TAB);
				driver.findElement(By.xpath(".//*[@id='txtPhone1']")).sendKeys(phone1);

				Actions action = new Actions(driver);
				
				WebElement element = driver.findElement(By.xpath("//*[@id='ctl00_CP_Menu1_0']/nobr"));
				
				action.moveToElement(element).build().perform();
				
				driver.findElement(By.xpath("//*[@id='ctl00_CP_Menu1_6']/nobr")).click();
				
				
				driver.findElement(By.xpath(".//*[@id='btnTopSubmit']")).click();
				Thread.sleep(1500);
				
				//isAlertPresent();
				
				
				String SaveAlert = driver.findElement(By.xpath("//span[@id='lblSuccessMsg']")).getText();
				String duplicatealert = driver.findElement(By.xpath("//span[@id='lblDuplicateMsg']")).getText();
				
				//String RecordMatching = driver.findElement(By.xpath("//span[@id='Span1']")).getText();
				//String duplicateConfirm = driver.findElement(By.xpath("//span[@id='Label2']")).getText();
				
				if(SaveAlert.equalsIgnoreCase("Patient Added Successfully."))
				{
					driver.findElement(By.xpath("//input[@id='btnSuccessOK']")).click();
					Thread.sleep(1000);
					viewPatient = driver.findElement(By.xpath("//*[@id='lblCliBan']")).getText();
					if(viewPatient.contains("View Patient"))
					{
						driver.findElement(By.cssSelector("a.dashboard.menu>img.bottom")).click();
						driver.findElement(By.xpath("//a[@id='pliDemographics']")).click();
						driver.findElement(By.xpath("//a[@id='liPatientListN'][1]")).click();
						driver.findElement(By.xpath(".//*[@id='btnCreate']")).click();
					}
				}
		
				else if(duplicatealert.contains("Few matching records to"))
				{
					driver.findElement(By.xpath("//input[@id='btnDuplicateOK']")).click();
					driver.findElement(By.xpath("//input[@id='btnSaveOK']")).click();
					driver.findElement(By.xpath("//input[@id='btnSuccessOK']")).click();
					Thread.sleep(1000);
					driver.findElement(By.cssSelector("a.dashboard.menu>img.bottom")).click();
					driver.findElement(By.xpath("//a[@id='pliDemographics']")).click();
					driver.findElement(By.xpath("//a[@id='liPatientListN'][1]")).click();
					driver.findElement(By.xpath(".//*[@id='btnCreate']")).click();
				}
				else
				{
					driver.findElement(By.xpath("//input[@id='btnDuplicateNotAllowedOk'][@name='ctl00$CP$btnDuplicateNotAllowedOk']")).click();
				}
				
				}
				
				
		
		catch(Exception e){

			e.printStackTrace();
		}
		}
		

		@AfterClass
		public void tearDown() throws InterruptedException {
			Thread.sleep(1500);
			driver.findElement(By.cssSelector("li.last > a.dashboard > img.bottom")).click();
			Thread.sleep(1000);
			try {
				Alert alert = driver.switchTo().alert();
				alert.accept();
			} catch (Exception e) {	
				System.out.println(e);
			}// TODO Auto-generated method stub
			driver.close();
			
		}

		@DataProvider(name = "patientdata")
		public Object[][] passData() {
			ExcelDataConfig config = new ExcelDataConfig(
					"D:\\Selenium\\Createpatientchart.xlsx");
			int rows = config.getRowCount(0);
			Object[][] data = new Object[rows][6];
			for (int i = 0; i<rows; i++) {
				data[i][0] = config.getData(0, i, 0);
				data[i][1] = config.getData(0, i, 1);
				data[i][2] = config.getData(0, i, 2);
				data[i][3] = config.getData(0, i, 3);
				data[i][4] = config.getData(0, i, 4);
				data[i][5] = config.getData(0, i, 5);
				//data[i][5] = config.getData(0, i, 5);
				//data[i][6] = config.getData(0, i, 6);
				

			}

			return data;

		}

		public boolean isAlertPresent() {
			try {
				Alert alert = driver.switchTo().alert();
				alert.accept();
				return true;
			} catch (Exception e) {
				System.out.println(e);
				return false;
			}
		

		}

	
}
