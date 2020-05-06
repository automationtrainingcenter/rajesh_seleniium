package mouse_events;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilities.BrowserUtitlity;

public class DragAndDropEvent extends BrowserUtitlity{
	
	public static void main(String[] args) {
		launchBrowser("chrome", "https://jqueryui.com/droppable/");
		sleep(3000);
		
		// create an Actions class object
		Actions actions = new Actions(driver);
		
		// driver focus is in main page switch the focus to frame which contains drag and drop elements
		// switching to frame based on index number
		driver.switchTo().frame(0);
		
		// after above line driver focus is in frame
		// locate drag and drop elements
		WebElement dragEle = driver.findElement(By.id("draggable"));
		WebElement dropEle = driver.findElement(By.id("droppable"));
		
		// move drag element to drop element
		// approach 1
//		actions.clickAndHold(dragEle).moveToElement(dropEle).release().build().perform();
		
		// approach 2
		actions.dragAndDrop(dragEle, dropEle).build().perform();
		sleep(3000);
		
		closeBrowsers();
	}

}
