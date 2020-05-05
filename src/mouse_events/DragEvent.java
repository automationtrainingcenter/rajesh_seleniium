package mouse_events;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilities.BrowserUtitlity;

public class DragEvent extends BrowserUtitlity{
	
	public static void main(String[] args) {
		launchBrowser("chrome", "https://jqueryui.com/draggable/");
		sleep(3000);
		
		// create an object of Actions class
		Actions actions = new Actions(driver);
		
		// perform drag event
		// switch to frame which contains dragMeAround element
		// locate the frame
		WebElement frameEle = driver.findElement(By.cssSelector("iframe[src *= 'draggable']"));
		driver.switchTo().frame(frameEle);
		
		// after the above line driver focus is in frame
		// locate drag me around element
		WebElement dragEle = driver.findElement(By.id("draggable"));
		
		// drag the element to some location
		// approach 1
//		actions.clickAndHold(dragEle).moveByOffset(100, 0).release().build().perform();
		
		// approach 2
		actions.dragAndDropBy(dragEle, 150, 150).build().perform();
		sleep(3000);
		
		closeBrowsers();
	}

}
