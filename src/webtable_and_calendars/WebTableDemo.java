package webtable_and_calendars;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilities.BrowserUtitlity;
/**
 * to handle webtables
 * 1. locate table tbody tag and store in a variable
 * 2. locate all the rows inside the tbody tag using tr tag
 * 3. iterate over every row then locate all the columns in every row using td tag
 * 4. iterate over the columns and automate them
 */
public class WebTableDemo extends BrowserUtitlity{
	public static void main(String[] args) {
		
		// launch the browser
		launchBrowser("chrome", "https://learn.letskodeit.com/p/practice");
		sleep(2000);
		
		// locate table body 
		WebElement table = driver.findElement(By.cssSelector("#product>tbody"));
		
		// locate all the rows with in the table
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		
		// iterate over every row
		for(WebElement row : rows) {
			// locate all the cells or columns with in every row
			List<WebElement> cells = row.findElements(By.tagName("td"));
			// iterate over the cells
			for(WebElement cell : cells) {
				// automate that cell
				System.out.print(cell.getText() + "\t");
			}
			System.out.println();
		}
		
		closeBrowsers();
		
		
		
	}
}
