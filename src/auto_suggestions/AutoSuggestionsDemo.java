package auto_suggestions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilities.BrowserUtitlity;

public class AutoSuggestionsDemo extends BrowserUtitlity{
	
	public static void main(String[] args) {
		launchBrowser("chrome", "https://www.google.com/");
		sleep(3000);
		String keyword = "selenium";
		String expSuggestion = "selenium grid";
		// locate search field and type keyword variable 
		driver.findElement(By.name("q")).sendKeys(keyword);
		sleep(2000);
		
		// locate ul tag which contains all the suggestions
		WebElement suggestionBox = driver.findElement(By.cssSelector(".erkvQe"));
		
		// locate all the li tags inside the above ul tag. every li tag represents one suggestion
		List<WebElement> suggestions = suggestionBox.findElements(By.tagName("li"));
		
		// iterate over every li tag (suggestion) 
		for(WebElement suggestion : suggestions) {
			// print the suggestion
//			System.out.println(suggestion.getText());
			
			// verify suggestion with exp suggestion
			if(suggestion.getText().equals(expSuggestion)) {
				System.out.println("suggestions contains "+expSuggestion);
				// click on the suggestion
				suggestion.click();
				break;
			}
		}
		
		sleep(2000);
		
		closeBrowsers();
		
		
		
	}

}
