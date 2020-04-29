package test_utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.util.concurrent.Uninterruptibles;

import utilities.BrowserUtitlity;
import utilities.CommonUtility;

public class TestDropdownListbox {
	
	public static void main(String[] args) {
		BrowserUtitlity.setDriverPath("chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://learn.letskodeit.com/p/practice");
		driver.manage().window().maximize();
		
		// create an object of CommmonUtility class
		CommonUtility utility = new CommonUtility(driver);
		
		WebElement drpdwnCars = utility.locateElement("id", "carselect");
		utility.selectDropDown(drpdwnCars, "honda");
		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
		
		
		WebElement lstBoxFruits = utility.locateElement("id", "multiple-select-example");
		utility.selectListBox(lstBoxFruits, "apple", "peach");
		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
		
		utility.unSelectListBox(lstBoxFruits, "apple", "orange");
		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
		
		driver.close();
		
		
		
	}

}
