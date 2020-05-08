package webtable_and_calendars;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilities.BrowserUtitlity;

public class CalendarRedbus extends BrowserUtitlity {

	public static void main(String[] args) {
		launchBrowser("chrome", "https://www.redbus.in/");
		sleep(3000);
		String date = "5";

		// locate onward data filed and click on it
		driver.findElement(By.xpath("//input[@id='onward_cal']/following-sibling::label")).click();
		sleep(2000);

		// locate calendar table body
		WebElement calTable = driver.findElement(By.cssSelector("#rb-calendar_onward_cal tbody"));

		// locate all the rows
		List<WebElement> rows = calTable.findElements(By.tagName("tr"));
		boolean flag = false;
		// iterate over every row from 3rd row
		for (int i = 2; i < rows.size(); i++) {
			// locate all the columns or cells in every row
			List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
			// iterate over every cell
			for (WebElement cell : cells) {
				if (cell.getText().equals(date)) {
					if (cell.isEnabled()) {
						cell.click();
					}else {
						System.out.println("please select valid date");
					}
					flag = true;
					// break the cells iteration
					break;
				}
			}
			if (flag)
				break; // rows loop
		}

		sleep(3000);
		closeBrowsers();

	}

}
