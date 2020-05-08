package webtable_and_calendars;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilities.BrowserUtitlity;

public class NSEIndiaDemoTwo extends BrowserUtitlity {

	public static void main(String[] args) {
		// launch the browser
		launchBrowser("firefox",
				"https://www1.nseindia.com/live_market/dynaContent/live_watch/equities_stock_watch.htm");
		sleep(5000);
		
		String companyCode = "lt";

		// locate table body
		WebElement table = driver.findElement(By.cssSelector("#dataTable>tbody"));
		// locate all the rows
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		// iterate over the rows
		for (int i = 2; i < rows.size(); i++) {
			// locate all the columns in every row
			List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
			// compare first cell data with companyCode
			if(cells.get(0).getText().equalsIgnoreCase(companyCode)) {
				// click on the a tag which is inside that cell
				cells.get(0).findElement(By.tagName("a")).click();
				sleep(4000);
				break;
			}
		}
		
		closeBrowsers();
	}

}
