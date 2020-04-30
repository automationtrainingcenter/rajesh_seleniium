package test_utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.util.concurrent.Uninterruptibles;

import utilities.BrowserUtitlity;
import utilities.CommonUtility;

public class TestFrames {
public static void main(String[] args) {
		
		BrowserUtitlity.setDriverPath("chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://learn.letskodeit.com/p/practice");
		driver.manage().window().maximize();
		CommonUtility utility = new CommonUtility(driver);
		
		
		// locate enter your name text field and type some data
		utility.type(utility.locateElement("id", "name", "Name text box"), "sunshine", "Name text box");
		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
		
		// now driver focus is in main page
		// switch the driver focus to frame to automate find a course text box
		utility.switchToFrame("name", "iframe-name", "Search Courses Page");
		
		// after the above line driver focus is switched to frame
		// locate find a course text box and type some data
		utility.type(utility.locateElement("id", "search-courses", "Search courses txt box"), "ruby", "Search courses txt box");
		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
		
		
		// now driver focus is in frame
		// switch the driver focus from frame to main page to automate hide or show text box
		utility.switchToMainPage("Search course page");
		// after the above line driver focus is switched to main page
		// locate hide or show text box and type some data
		utility.type(utility.locateElement("id", "displayed-text", "hide or show text box"), "selenium", "hide or show text box");
		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
		
		driver.close();
		
		
		
		
		
		
	}

}
