package test_utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.common.util.concurrent.Uninterruptibles;

import utilities.BrowserUtitlity;
import utilities.CommonUtility;

public class TestWindowHandling {
	public static void main(String[] args) {
		BrowserUtitlity.setDriverPath("geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://learn.letskodeit.com/p/practice");
		driver.manage().window().maximize();
		CommonUtility utility = new CommonUtility(driver);
		
		// locate open window button and click on it
		utility.click(utility.locateElement("id", "opentab", "Open tab button"), "Open tab button");
		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
		
		// the driver focus is in main window and switch that focus to child window using index 1
		utility.switchToWindow("Let's Kode It");
		// After the above line driver focus switched to child window
		// locate search course text field and type some data
		utility.type(utility.locateElement("id", "search-courses", "Search Courses text box"), "ruby", "Search Courses text box");
		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
		
		
		
		// now driver focus is in child window and switch that focus to main window using index 0
		utility.switchToWindow("Practice | Let's Kode It");
		// after the above line driver focus switched to main window
		// locate open tab button and click on it
		utility.click(utility.locateElement("id", "openwindow", "Open window button"), "Open window button");
		Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
		
		// close all the browser windows opened by the driver instance
		driver.quit();
	}

}
