package mouse_events;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilities.BrowserUtitlity;
/*
 * To perform any mouse event selenium provides Actions class
 * These Actions class contains several methods to perform mouse events, to call these
 * method we have to create an object of Actions class.
 * whatever the event we are performing we have to call build() and perform() methods
 * of Actions class after the event related method. 
 */
// To perform move hover event on an element, we have to use moveToElement(WebElement ele) of Actions class
public class MouseHoverEvent extends BrowserUtitlity{
	
	public static void main(String[] args) {
		launchBrowser("chrome", "https://www.firstcry.com/");
		sleep(3000);
		// locate All Categories link
		WebElement lnkAllCat = driver.findElement(By.cssSelector(".menu-container a[href='/']"));
		
		// create Actions class object by providing WebDriver reference
		Actions actions = new Actions(driver);
		
		// move mouse to the All Categories link
		actions.moveToElement(lnkAllCat).build().perform();
		sleep(2000);
		
		// locate Girl Fashion link
		WebElement lnkGirlFashion = driver.findElement(By.xpath("//span[@id='allmenu2']/preceding-sibling::a"));
		
		// move mouse to Girl Fashion link
		actions.moveToElement(lnkGirlFashion).build().perform();
		sleep(2000);
		
		// locate Party wear link
		WebElement lnkGirlPartyWear = driver.findElement(By.cssSelector(".allmenu2 a[title = 'Party Wear']"));
		
		// move mouse to Party wear link and click on it
		actions.moveToElement(lnkGirlPartyWear).click().build().perform();
		sleep(4000);

		closeBrowsers();
		
		
	}

}
