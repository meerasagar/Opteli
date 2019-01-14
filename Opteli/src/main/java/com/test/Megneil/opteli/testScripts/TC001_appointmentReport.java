package com.test.Megneil.opteli.testScripts;
import java.io.IOException;
import java.util.List;

import org.testng.Reporter;
import org.testng.annotations.*;

import org.openqa.selenium.*;

public class TC001_appointmentReport extends BaseClass {
//It will open appointment report and check whether appointments are moved to HF

	String date = "01112019";

	

	@Test
	public void testAppointmentReport() throws InterruptedException, IOException {
		try {
			
//driver.findElement(By.cssSelector("span")).click();
			
			

			

			driver.findElement(By.id("txtSearch")).sendKeys("test");

			driver.findElement(By.id("btnSearch")).click();

			Thread.sleep(3000);

			driver.findElement(By.id("cmdInfopatient")).click();

			Thread.sleep(3000);

			driver.findElement(By.cssSelector("a.dashboard.menu>img.bottom"))
					.click();

			driver.findElement(By.cssSelector("#pliReports > span")).click();

			driver.findElement(By.cssSelector("#ulRPTS > li > #pliInsReports"))
					.click();

			driver.findElement(
					By.xpath("(//a[contains(text(),'Appointment Report')])[3]"))
					.click();

			//driver.findElement(By.id("txtAppFrom")).click();
			driver.findElement(By.id("txtAppFrom")).clear();
			Thread.sleep(3000);
			driver.findElement(By.id("txtDOCFrom")).sendKeys(date);
			isAlertPresent();
			//driver.findElement(By.linkText(Day)).click();

			driver.findElement(By.id("btnSearch")).click();
			isAlertPresent();
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

		//captureScreen(driver,"testAppointmentReport");

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

