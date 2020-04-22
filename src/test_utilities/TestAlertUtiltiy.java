package test_utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.util.concurrent.Uninterruptibles;

import utilities.BrowserUtitlity;
import utilities.CommonUtility;

public class TestAlertUtiltiy {
	
	public static void main(String[] args) {
		BrowserUtitlity.setDriverPath("chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://learn.letskodeit.com/p/practice");
		driver.manage().window().maximize();
		
		// create an object CommonUtility class
		CommonUtility utility = new CommonUtility(driver);

		// locate enter your name text box
		WebElement txtName = driver.findElement(By.id("name"));

		// type some data
		txtName.sendKeys("sunshine");
		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);

		// locate alert button and click it
		driver.findElement(By.id("alertbtn")).click();
		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);

		// the above click will open an alert, so switch driver focus to alert
		String alert1Text = utility.alertAccept();
		System.out.println(alert1Text);
		
		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);

		// type some data in enter your name text box
		txtName.sendKeys("sunshine");
		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);

		// locate confirm button and click on it
		driver.findElement(By.id("confirmbtn")).click();
		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);

		// the above click will open an alert, so switch driver focus to alert
		String alert2Text = utility.alertDismiss();
		System.out.println(alert2Text);
		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
		
		driver.close();
	}

}
