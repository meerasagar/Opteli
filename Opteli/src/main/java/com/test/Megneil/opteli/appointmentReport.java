package com.test.Megneil.opteli;
import java.util.List;
import org.testng.Reporter;
import org.testng.annotations.*;

import org.openqa.selenium.*;

public class appointmentReport extends BaseClass {
	//public WebDriver driver;
	// private String baseUrl;

	String Day = "1";

	

	@Test
	public void testAppointmentReport() throws InterruptedException {
		try {
			driver.get("http://192.168.1.135/Developer1/Client/frmLogin.aspx");

			//driver.get("http://opteli.com/Client/frmLogin.aspx");

			driver.findElement(By.cssSelector("span")).click();
			
			Thread.sleep(3000);

			driver.findElement(By.xpath("//input[@id='txtCompanyID']")).clear();
			//JavascriptExecutor webdriver= (JavascriptExecutor)driver;
			//webdriver.executeScript("document.getElementById('txtCompanyID').value='axpamtec';");
			driver.findElement(By.xpath("//input[@id='txtCompanyID']")).sendKeys("axpamtec");

			driver.findElement(By.id("txtUsername")).clear();

			driver.findElement(By.id("txtUsername")).sendKeys("test1");

			driver.findElement(By.id("txtPassword")).clear();

			driver.findElement(By.id("txtPassword")).sendKeys("test@123");

			driver.findElement(By.id("btnLogin")).click();

			Thread.sleep(3000);

			// Alert alert = driver.switchTo().alert();
			// alert.accept();
			isAlertPresent();

			driver.findElement(By.id("txtSearch")).sendKeys("test");

			driver.findElement(By.id("btnSearch")).click();

			Thread.sleep(3000);

			driver.findElement(By.id("cmdInfopatient")).click();

			Thread.sleep(3000);

			// driver.findElement(By.xpath(".//*[@class = 'nav1 left1']/ul/li[8]")).click();

			driver.findElement(By.cssSelector("a.dashboard.menu>img.bottom"))
					.click();

			driver.findElement(By.cssSelector("#pliReports > span")).click();

			driver.findElement(By.cssSelector("#ulRPTS > li > #pliInsReports"))
					.click();

			driver.findElement(
					By.xpath("(//a[contains(text(),'Appointment Report')])[3]"))
					.click();

			driver.findElement(By.id("txtAppFrom")).click();
			driver.findElement(By.id("txtAppFrom")).clear();
			driver.findElement(By.id("txtDOCFrom")).click();
			isAlertPresent();
			driver.findElement(By.linkText(Day)).click();

			driver.findElement(By.id("btnSearch")).click();

			List<WebElement> MovedtoHF = driver.findElements(By
					.xpath(".//*[@id='imgEHR']"));
			System.out.println("No.of Appointments Moved to HF: "
					+ MovedtoHF.size());
			List<WebElement> NotMovedtoHF = driver.findElements(By
					.xpath(".//*[@id='imgNEHR']"));
			System.out.println("No.of Appointments Not Moved to HF: "
					+ NotMovedtoHF.size());
			
			Reporter.log("No.of Appointments Moved to HF:" + MovedtoHF.size());
			Reporter.log("No.of Appointments not Moved to HF: "
					+ NotMovedtoHF.size());
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void isAlertPresent() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	/*@AfterClass
	public void tearDown() throws Exception {
		// driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}*/
}

