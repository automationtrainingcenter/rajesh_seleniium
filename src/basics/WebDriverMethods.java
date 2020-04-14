package basics;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import utilities.BrowserUtitlity;

public class WebDriverMethods {
	public static void main(String[] args) throws InterruptedException {
		// launch chrome browser
		BrowserUtitlity.setDriverPath("chromedriver");
		WebDriver driver = new ChromeDriver();

		// get(String url): is used to navigate to the url provided as string argument
		/* Note: url must have http:// protocol */
		driver.get("http://www.facebook.com");

		// getTitle(): is used to retrieve the title (innertext of the title tag) of the
		// current web page
		// Note: inner text means the text in between opening and closing tag
		String title = driver.getTitle();
		System.out.println("title of the page is " + title);

		// getCurrentUrl(): is used to retrieve the url of the current web page
		String currentUrl = driver.getCurrentUrl();
		System.out.println("current url of the page is " + currentUrl);

		// getPageSource(): is used to retrieve the entire source code of the current
		// page
		String pageSource = driver.getPageSource();
		System.out.println("page source contains the given text "
				+ pageSource.contains("Facebook helps you connect and share with the people in your life."));

		/* findElement(By arg): is used to locate an element with in the current web page using
		 * given locator information. This method returns a WebElement interface reference if element
		 * located with given locator information else it returns NoSuchElementException.
 		 */
		By btnLoginLoc = By.id("u_0_b");
		WebElement btnLogin = driver.findElement(btnLoginLoc);
//		WebElement btnLogin = driver.findElement(By.id("u_0_b"));
		
		/* findElements(By arg): is used to locate one or more elements within the current web page
		 * using given locator information. This method returns a List<WebElement> reference. With given 
		 * locator information if no element is located then this method will return a List of size 0.
		 * It does not throw any exception.
		 */
		List<WebElement> images = driver.findElements(By.tagName("a"));
		System.out.println("number of links in the page are "+images.size());
		
		// getWindowHandle(): is used to retrieve unique id of the current browser window or tab as a String
		String windowId = driver.getWindowHandle();
		System.out.println("window id is "+windowId);
		
		
		// getWindowHandles(): is used to retrieve windows ids of all the browser windows or tabs opened by
		// the driver instance
		Set<String> windowIds = driver.getWindowHandles();
		System.out.println("window ids are "+windowIds);
		
		Thread.sleep(5000);
		// close(): is used to close the current browser window
//		driver.close();
		
		// quit(): is used to close all the browser windows opened by driver instance
		driver.quit();

	}

}
