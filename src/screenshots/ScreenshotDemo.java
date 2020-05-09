package screenshots;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import utilities.BrowserUtitlity;

/*
 * Selenium provides TakesScreenshot interface which contains
 * getScreenshotAs() to capture the screenshot of the current web page.
 * 
 * TakesScreenshot interface is implemented by all our browser driver classes
 * 
 * to call TakesScreenshot interface methods we have to type cast existing 
 * driver object to the TakesScreenshot interface object
 * 
 */

public class ScreenshotDemo extends BrowserUtitlity{
	
	public static void main(String[] args) {
		launchBrowser("chrome", "https://learn.letskodeit.com/p/practice");
		sleep(2000);
		
		// create an object reference of TakesScreenshot interface
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcImg = ts.getScreenshotAs(OutputType.FILE);
		File destImg = new File(".//screenshots//practice.png");
		try {
			FileHandler.copy(srcImg, destImg);
		} catch (IOException e) {
			System.out.println("unable to copy the file due to exception "+e);
		}
		
		closeBrowsers();
		
	}

}
