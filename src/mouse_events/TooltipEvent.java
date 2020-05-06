package mouse_events;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilities.BrowserUtitlity;

public class TooltipEvent extends BrowserUtitlity {
	/*
	 * When you hover the element with your mouse, the title attribute is displayed
	 * in a little box next to the element is nothing but tooltip.
	 * 
	 * tooltip will be displayed as a new element.
	 * 
	 * Validate tooltip element is displayed or not and also validate the title
	 * attribute value of main element is equal to the inner text of tooltip element
	 * 
	 * 
	 * Note: To locate the tool tip element, once tool tip is displayed in web page
	 * then press Control + / and then press Control+Shift+C and then move the mouse to 
	 * tool tip which will highlight tool tip element in source code (HTML code)
	 */

	public static void main(String[] args) {
		launchBrowser("chrome", "https://jqueryui.com/tooltip/");

		sleep(3000);

		// create an object of the Actions class
		Actions actions = new Actions(driver);

		// switch to frame which contains elements to automate
		driver.switchTo().frame(0);

		// locate your age text box
		WebElement txtYourAge = driver.findElement(By.id("age"));
		String title = txtYourAge.getAttribute("title");
		System.out.println("exp tooltip text :: " + title);

		// move to your age text box
		actions.moveToElement(txtYourAge).build().perform();

		sleep(2000);

		// locate tooltip element
		WebElement tooltipEle = driver.findElement(By.cssSelector("div[role='tooltip']"));
		if (tooltipEle.isDisplayed()) {
			System.out.println("tooltip is displayed");
			String tooltipText = tooltipEle.getText();
			System.out.println("act tooltip text :: " + tooltipText);

			if (title.equals(tooltipText)) {
				System.out.println("valid tool tip displayed");
			}
		}

		sleep(1000);

		closeBrowsers();

	}

}
