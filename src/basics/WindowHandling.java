package basics;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.common.util.concurrent.Uninterruptibles;

import utilities.BrowserUtitlity;
/*
 * To switch driver focus from one window another window we have to use switchTo() of WebDriver interface
 * The TargetLocator interface contains window(String windowID)
 * 
 * Note: to retrieve the window ids of all the windows opened by the driver instance we cane use
 * getWindowHandles() of the WebDriver interface.
 * 
 * WebDriver driver = new ChromeDriver();
 * TargetLocator tl = driver.switchTo();
 * tl.window("windowID");
 * 
 * 
 */

public class WindowHandling {
	
	public static void main(String[] args) {
		BrowserUtitlity.setDriverPath("geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://learn.letskodeit.com/p/practice");
		driver.manage().window().maximize();
		
		
		// locate open window button and click on it
		driver.findElement(By.id("opentab")).click();
		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
		
		// the above will open new window, so get all the window handles (ids of windows)
		Set<String> windowHandles = driver.getWindowHandles();
		// convert the set to list, so that we can switch in between windows using index numbers
		List<String> windowIds = new ArrayList<>(windowHandles);
		for(int i = 0; i < windowIds.size(); i++) {
			driver.switchTo().window(windowIds.get(i));
			System.out.println("at index "+i+" window is "+driver.getTitle());
		}
		System.out.println(windowIds);
		/*
		 * The above list contains window id of the main window in index 0, first child window id in index 1
		 * second child window id in index 2 .. etc.
		 */
		// the driver focus is in main window and switch that focus to child window using index 1
		driver.switchTo().window(windowIds.get(1));
		
		// After the above line driver focus switched to child window
		// locate search course text field and type some data
		driver.findElement(By.id("search-courses")).sendKeys("ruby");
		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
		
		
		
		// now driver focus is in child window and switch that focus to main window using index 0
		driver.switchTo().window(windowIds.get(0));
	
		// after the above line driver focus switched to main window
		// locate open tab button and click on it
		driver.findElement(By.id("openwindow")).click();
		Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
		
		// close all the browser windows opened by the driver instance
		driver.quit();
		
		
		
		
	}

}
