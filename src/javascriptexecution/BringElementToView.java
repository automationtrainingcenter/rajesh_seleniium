package javascriptexecution;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import utilities.BrowserUtitlity;

public class BringElementToView extends BrowserUtitlity{
	
	public static void main(String[] args) {
		launchBrowser("firefox", "https://learn.letskodeit.com/p/practice");
		sleep(5000);
		
		
		// locate bakc to top link
		WebElement lnkMouseHover = driver.findElement(By.id("mousehover"));
		
		// create JavascriptExecutor interface reference
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", lnkMouseHover);
		
		sleep(10000);
		
	
		
		closeBrowsers();
	}

}
