package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import utilities.BrowserUtitlity;

/*
 * To automate buttons or links we can use click() of WebElement 
 * interface
 */
public class ButtonAndLinkHandling {
	
	public static void main(String[] args) throws InterruptedException {
		// launch browser
		BrowserUtitlity.setDriverPath("chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://facebook.com");
		driver.manage().window().maximize();
		
		// locate signup button and click on it
		WebElement btnSingUp = driver.findElement(By.name("websubmit"));
		btnSingUp.click();
		Thread.sleep(3000);
		
		// locate forgotten account link and click on it
		WebElement lnkForgottenAccout = driver.findElement(By.linkText("Forgotten account?"));
		lnkForgottenAccout.click();
		Thread.sleep(3000);
		
		
		// locate login button and click on it
		WebElement btnLogin = driver.findElement(By.cssSelector("input[value='Log In']"));
		btnLogin.click();
		Thread.sleep(3000);
		
		driver.close();
		
		
	}

}
