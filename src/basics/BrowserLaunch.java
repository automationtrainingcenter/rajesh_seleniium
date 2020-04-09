package basics;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utilities.BrowserUtitlity;

public class BrowserLaunch {
	public static void main(String[] args) {
		
		// Set the System property to the path of chromedriver executable
//		System.setProperty("webdriver.chrome.driver", "/Users/suryaprakash/Documents/softwares/chromedriver");
		BrowserUtitlity.setDriverPath("chromedriver");

		// Create an object of ChromeDriver class to open Chrome browser
		ChromeDriver cdriver = new ChromeDriver();
		
		
		// set system property to the path of geckodriver executable
//		System.setProperty("webdriver.gecko.driver", "/Users/suryaprakash/Documents/softwares/geckodriver");
		BrowserUtitlity.setDriverPath("geckodriver");
		
		// Create an object of FirefoxDriver class to open firefox browser
		FirefoxDriver fdriver = new FirefoxDriver();
		
	}

}
