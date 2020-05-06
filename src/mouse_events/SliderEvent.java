package mouse_events;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilities.BrowserUtitlity;

public class SliderEvent extends BrowserUtitlity{
	
	public static void main(String[] args) {
		launchBrowser("chrome", "https://jqueryui.com/slider/");
		
		sleep(3000);
		
		// create an object of Actions class
		Actions actions = new Actions(driver);
		
		// switch to frame which contains slider from main page
		// switch to frame based on index number
		driver.switchTo().frame(0);
		
		// locate slider head
		WebElement sliderHead = driver.findElement(By.cssSelector("#slider>span"));
		
		// move slider head right  (forward)
		actions.clickAndHold(sliderHead).moveByOffset(150, 0).release().build().perform();
		
		sleep(2000);
		
		// move slider head left (backward)
		actions.dragAndDropBy(sliderHead, -100, 0).build().perform();
		
		sleep(3000);
		
		closeBrowsers();
	}

}
