package basics;
/*
 * WebDriver is an interface in Selenium which is main interface of the entire
 * Selenium tool.
 * 
 * This interface is implemented by RemoteWebDriver class. All the browser driver classes
 * are child classes of RemoteWebDriver class.
 * 
 * 
 * 
 */

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utilities.BrowserUtitlity;

public class WebDriverIntro {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = null;
		// get the browser name from the console
		Scanner sc = new Scanner(System.in);
		System.out.println("enter browser name");
		String browserName = sc.next();
		if (browserName.equalsIgnoreCase("chrome")) {
			BrowserUtitlity.setDriverPath("chromedriver");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			BrowserUtitlity.setDriverPath("geckodriver");
			driver = new FirefoxDriver();
		} else {
			System.out.println("invalid browserName");
		}
		
		Thread.sleep(5000);
		
		// close the browser
		driver.close();
	}

}
