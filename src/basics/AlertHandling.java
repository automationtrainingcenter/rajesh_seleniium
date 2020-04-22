package basics;
/*
 * Alert is also know as a Javascript popup
 * we have 3 types of alerts in javascript
 * 1. alert with only OK button
 * 2. alert with OK and Cancel buttons
 * 3. alert with OK, Cancel buttons and some text box
 * 
 * These alerts are browser specific.
 * 
 * To handle alerts Selenium provides an Alert interface.
 * Alert interface methods
 * 1. accept() is used to click OK button of the alert.
 * 2. dismiss() is used to click Cancel button of the alert if it contains else it will click Ok button.
 * 3. getText() is used to retrieve the alert text.
 * 4. sendKeys(String arg) is used to type some data inside alert text box.
 * 
 * 
 * WebDriver interface contains switchTo() which will return TargetLocator interface reference.
 * In TargetLocator interface we have alert(), which will return Alert interface reference.
 * TargetLocator tl = driver.switchTo();
 * Alert alert = tl.alert();
 * or
 * Alert alert = driver.switchTo().alert();
 * 
 * Note: Until and unless we handle the alerts we can not automate anything on the browser.
 * 
 */

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.util.concurrent.Uninterruptibles;

import utilities.BrowserUtitlity;

public class AlertHandling {

	public static void main(String[] args) {
		BrowserUtitlity.setDriverPath("chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://learn.letskodeit.com/p/practice");
		driver.manage().window().maximize();

		// locate enter your name text box
		WebElement txtName = driver.findElement(By.id("name"));

		// type some data
		txtName.sendKeys("sunshine");
		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);

		// locate alert button and click it
		driver.findElement(By.id("alertbtn")).click();
		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);

		// the above click will open an alert, so switch driver focus to alert
		Alert alert1 = driver.switchTo().alert();
		// retrieve alert text and print on the console
		System.out.println(alert1.getText());
		// click Ok button of the alert using accept() of Alert interface
		alert1.accept();
		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);

		// type some data in enter your name text box
		txtName.sendKeys("sunshine");
		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);

		// locate confirm button and click on it
		driver.findElement(By.id("confirmbtn")).click();
		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);

		// the above click will open an alert, so switch driver focus to alert
		Alert alert2 = driver.switchTo().alert();
		// retrieve alert text and print on the console
		System.out.println(alert2.getText());
		// click on Cancel button of alert using dismiss() of Alert interface
		alert2.dismiss();
		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
		
		driver.close();

	}

}
