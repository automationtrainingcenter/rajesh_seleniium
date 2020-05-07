package auto_suggestions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilities.BrowserUtitlity;

public class AutoSuggestionAmazon extends BrowserUtitlity{
	
	public static void main(String[] args) {
		launchBrowser("chrome", "https://www.amazon.in");
		sleep(5000);
		
		// locate search field
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
		sleep(2000);
		
		// locate div tag which contains all the suggestions
		WebElement suggestionBox = driver.findElement(By.id("suggestions"));
		
		// locate all the div tag (represents one suggestion) in above div tag
		List<WebElement> suggestions = suggestionBox.findElements(By.tagName("div"));
		
		// iterate over every suggestion
		for(WebElement suggestion : suggestions) {
			// retrieve the inner text of the every suggestion and print on the console
			// System.out.println(suggestion.getText());
			
			// compare suggestion text with exp suggestion
			if(suggestion.getText().equals("iphone mobiles")) {
				System.out.println("suggestions contains iphone mobiles");
				// click on the suggestion
				suggestion.click();
				break;
			}
		}
		
		sleep(5000);
		closeBrowsers();
	}

}
