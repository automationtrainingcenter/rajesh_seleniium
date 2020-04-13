package basics;

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
		
		
		Thread.sleep(5000);
		// close(): is used to close the current browser window
		driver.close();

	}

}
