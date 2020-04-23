package basics;
/*
 * Frames are used to add a web page within another web page
 * 
 * When we launch an application driver instance will point to the body tag of that page
 * if that page contains any frames those frames also contains body tag but our driver
 * instance will point to that body tag
 * 
 * to automate elements which are in frame body tag we have to switch driver focus from main 
 * page body tag to frame body tag
 * 
 * Once we automated frame, then to automate elements in main page body tag we have to use
 * switch driver focus again back to main page body tag from frame body tag.
 * 
 * TargetLocator interface contains method to perform above switch
 * 
 * 1. frame(int index) : is used to switch driver focus from main page or 
 * outer frame to frame or inner frame using frame index number
 * 2. frame(String id or name) : is used to switch driver focus from main page or 
 * outer frame to frame or inner frame using frame name or id attribute of the frame
 * 3. frame(WebElement frameEle) : is used to switch driver focus from main page or 
 * outer frame to frame or inner frame using frame element
 * 4. parentFrame() : is used to switch driver focus from inner frame to outer frame
 * 5. defaultContent() : is used to switch driver focus from any frame to main page
 * 
 * 
 * In WebDriver interface we have switchTo() which will return TargetLocator interface reference
 * we can use this reference to call above methods
 * 
 * WebDriver driver = new ChromeDriver();
 * TargetLocator tl = driver.switchTo();
 * tl.frame(0);
 * 
 * or 
 * 
 * driver.switchTo().frame(0);
 * 
 */

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.util.concurrent.Uninterruptibles;

import utilities.BrowserUtitlity;

public class FramesHandling {
	
	public static void main(String[] args) {
		
		BrowserUtitlity.setDriverPath("chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://learn.letskodeit.com/p/practice");
		driver.manage().window().maximize();
		
		
		// locate enter your name text field and type some data
		driver.findElement(By.id("name")).sendKeys("sunshine");
		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
		
		// now driver focus is in main page
		// switch the driver focus to frame to automate find a course text box
//		TargetLocator tl = driver.switchTo();
//		tl.frame("courses-iframe");
		driver.switchTo().frame("iframe-name");
		
		
		// after the above line driver focus is switched to frame
		// locate find a course text box and type some data
		driver.findElement(By.id("search-courses")).sendKeys("ruby");
		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
		
		
		// now driver focus is in frame
		// switch the driver focus from frame to main page to automate hide or show text box
		driver.switchTo().defaultContent();
		
		// after the above line driver focus is switched to main page
		// locate hide or show text box and type some data
		driver.findElement(By.id("displayed-text")).sendKeys("selenium");
		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
		
		driver.close();
		
		
		
		
		
		
	}

}
