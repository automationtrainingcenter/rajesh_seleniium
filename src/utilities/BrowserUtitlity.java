package utilities;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserUtitlity {
	protected static WebDriver driver;
	
	public static void setDriverPath(String driverName) {
		driverName = driverName.toLowerCase();
		
		// verify OS
		if(System.getProperty("os.name").toLowerCase().contains("win")) {
			driverName = driverName+".exe";
		}
		
		// get the resources folder path
		String folderPath = System.getProperty("user.dir") + File.separator + "resources" + File.separator;
		
		// set the system property based on driver name
		if(driverName.contains("chromedriver")) {
			System.setProperty("webdriver.chrome.driver", folderPath+driverName);
		}else if(driverName.contains("geckodriver")) {
			System.setProperty("webdriver.gecko.driver", folderPath+driverName);
		}else {
			throw new RuntimeException("Invalid driver name "+driverName);
		}
	}
	
	/**
	 * launch the browser based on the browser name
	 * @param browserName - name of the browser to launch
	 * @param url - url of the AUT to navigate
	 */
	public static void launchBrowser(String browserName, String url) {
		try {
			if(browserName.equalsIgnoreCase("chrome")) {
				// launch chrome browser
				setDriverPath("chromedriver");
				driver = new ChromeDriver();
			}else if(browserName.equalsIgnoreCase("firefox")) {
				// launch firefox browser
				setDriverPath("geckodriver");
				driver = new FirefoxDriver();
			}else {
				System.out.println("Invalid browser name, browser name must be either chrome or firefox");
			}
			
			// navigate to url 
			driver.get(url);
			driver.manage().window().maximize();
		} catch (Exception e) {
			System.out.println("Unable to launch the browser due to exception  "+e);
		}
	}
	
	
	/**
	 * closes all the browser windows either single or multiple opened by driver instance
	 */
	public static void closeBrowsers() {
		if(driver.getWindowHandles().size() > 1) {
			driver.quit();
		}else {
			driver.close();
		}
	}
	
	/**
	 * sleep method
	 */
	public static void sleep(long timeInMillis) {
		try {
			Thread.sleep(timeInMillis);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
}
