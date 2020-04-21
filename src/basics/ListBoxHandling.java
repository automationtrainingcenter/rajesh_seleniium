package basics;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.google.common.util.concurrent.Uninterruptibles;

import utilities.BrowserUtitlity;

public class ListBoxHandling {
	public static void main(String[] args) {
		BrowserUtitlity.setDriverPath("chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://learn.letskodeit.com/p/practice");
		driver.manage().window().maximize();
		
		// locate fruits list box
		WebElement fruitsEle = driver.findElement(By.id("multiple-select-example"));
		
		// create a Select class object
		Select drpdwnFruits = new Select(fruitsEle);
		
		// get all the options and print them on the console
		List<WebElement> fruitOptions = drpdwnFruits.getOptions();
		System.out.println("total fruit options are :: "+fruitOptions.size());
		
		if (drpdwnFruits.isMultiple()) {
			// select a fruit based on index number
			drpdwnFruits.selectByIndex(2); // peach
			Uninterruptibles.sleepUninterruptibly(3000, TimeUnit.MILLISECONDS);
			
			// select a fruit based on value attribute value
			drpdwnFruits.selectByValue("apple");
			Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
			
			// retrieve all the selected options and print on the console
			List<WebElement> allSelectedOptions = drpdwnFruits.getAllSelectedOptions();
			System.out.println("all selected fruit options are :: "+allSelectedOptions.size());
			for (WebElement option : allSelectedOptions) {
				System.out.println(option.getText());
			}
			
			// select a fruit based on visbile text
			drpdwnFruits.selectByVisibleText("Orange");
			Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
			
			
			// deselect all the selected options
//			drpdwnFruits.deselectAll();
//			Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
			
			
			// deselect an option based on index number
			drpdwnFruits.deselectByIndex(0);
			Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
			
			
			// deselect an option based on value attribute value
			drpdwnFruits.deselectByValue("orange");
			Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
			
			
			// deslect an option based on visible text
			drpdwnFruits.deselectByVisibleText("Peach");
			Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
		}
		
		driver.close();
		
	}

}
