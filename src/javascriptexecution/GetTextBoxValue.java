package javascriptexecution;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import utilities.BrowserUtitlity;
/*
 * Selenium provides JavaScriptExecutor interface to execute any 
 * javascript code using executeScript()
 * 
 * JavaScriptExecutor interface is implemented by browsr driver classes
 * 
 * to call the executeScript() we have to type cast webdriver reference to 
 * the JavaScriptExecutor reference
 */

public class GetTextBoxValue extends BrowserUtitlity{
	
	public static void main(String[] args) {
		launchBrowser("chrome", "https://learn.letskodeit.com/p/practice");
		sleep(2000);
		
		// locate enter yourname text box
		WebElement txtName = driver.findElement(By.id("name"));
		
		// type some data
		txtName.sendKeys("selenium");
		sleep(2000);
		
		// retrieve the data in name text box and print on the console
//		String value = txtName.getAttribute("value");
		
		// using JavaScriptExecutor interface
		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].value = arguments[1]", txtName, "surya");
		
		String value = js.executeScript("return arguments[0].value", txtName).toString();
		System.out.println("value of name text box is :: "+value);
		
		closeBrowsers();
		
		
		
	}

}
