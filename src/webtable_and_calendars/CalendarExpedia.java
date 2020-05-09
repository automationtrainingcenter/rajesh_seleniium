package webtable_and_calendars;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilities.BrowserUtitlity;

public class CalendarExpedia extends BrowserUtitlity {

	public static void main(String[] args) {
		launchBrowser("chrome", "https://www.expedia.co.in/");
		sleep(3000);

		// locate check in date and click on it
		driver.findElement(By.id("hotel-checkout-hp-hotel")).click();
		sleep(1000);

		// locate table body
		WebElement calTable = driver.findElement(By.xpath("(//tbody[@class='datepicker-cal-dates'])[1]"));

		boolean status = false;
		// locate all the rows
		List<WebElement> rows = calTable.findElements(By.tagName("tr"));

		// iterate over the rows
		for (WebElement row : rows) {
			// locate all the cells in every row
			List<WebElement> cells = row.findElements(By.tagName("td"));
			// iterate over every cell
			for (WebElement cell : cells) {
				// compare cell text with desired date
				if (cell.getText().contains("21")) {
					// locate button tag with in that cell and click on it
					WebElement btnDate = cell.findElement(By.tagName("button"));
					if (btnDate.isEnabled()) {
						btnDate.click();
					} else {
						System.out.println("please enter valid date");
					}
					status = true;
					break; // cells loop
				}
			}
			if (status)
				break;
		}

		sleep(3000);
		// close the browser
		closeBrowsers();
	}

}
