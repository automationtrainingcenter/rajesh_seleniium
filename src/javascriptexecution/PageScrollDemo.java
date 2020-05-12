package javascriptexecution;

import org.openqa.selenium.JavascriptExecutor;

import utilities.BrowserUtitlity;

public class PageScrollDemo extends BrowserUtitlity{
	
	public static void main(String[] args) {
		launchBrowser("chrome", "https://amazon.in");
		sleep(4000);
		
		// create JavascriptExecutor object reference
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// scroll the web page down
		js.executeScript("document.documentElement.scrollBy(arguments[0], arguments[1])", 0, 1000);
		
		sleep(3000);
		
		// scroll the web page up
		js.executeScript("document.documentElement.scrollBy(arguments[0], arguments[1])", 0, -500);
		sleep(3000);
		closeBrowsers();
		
	}

}
