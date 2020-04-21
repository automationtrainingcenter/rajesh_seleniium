package basics;
/*
 * Select class methdos

	Select is a class in Selenium which is used to automate drop down list
or list boxes which are implmented using <select> tag

<select name="cars">
	<option value="car1">Audi</option>  index = 0
	<option value="car2">Benz</option>  index = 1
	<option value="car3">BMW</option>  index =2
	<option value="car4">Suziki</option>  index = 3
	<option value="car5">Honda</option>  index = 4
</select>

1. selectByIndex(int index): is used to select an option based on index number
of the option tag and this index starts from 0

2. selectByValue(String valueAttrValue): is used to select an option based on the
value of the value attribute of the option tag

3. selectByVisibleText(String innerTextOptionTag): is used to select an option based 
on the inner text of the option tag

4. getOptions() returns a List<WebElement>: this method returns all option tags of
the select tag as List of type web element

5. getFirstSelectedOption() returns WebElement: this is returns an option tag which
was selected by default.

6. isMultiple() returns true if given select class object is a list box i.e. which
allows multiple option selection

7. getAllSelectedOptions() returns a List<WebElement>: this method returns all option tags
which are selected

8. deselectByIndex(int index) is used to deselect an option based on index number

9. deselectByValue(String valueAttrValue) is used to deselect an option based on value
of the value attribute

10. deselectByVisibleText(String innerTextOptionTag) is used to deselect an 
option based on the inner text of the option tag

11. deselectAll() is used to deselect all the selected options of a list box

All these are instance methods so we have create an object of the Select class to call these
methods
Syntax to create an object of Select class
	Select selectObj = new Select(WebElemnet select_tag_ele)
by above syntax first we have to locate Select tag and store in a WebElement reference
then pass that reference to the Select class constructor.

In above methods first 7 methods we can use on both list box and drop down list
but remaining 4 methods we can only use for list box.
 */

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.google.common.util.concurrent.Uninterruptibles;

import utilities.BrowserUtitlity;

public class DropdownListHandling{
	
	public static void main(String[] args) throws InterruptedException {
		BrowserUtitlity.setDriverPath("chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();
		
		
		// locate date dropdown
		WebElement dateEle = driver.findElement(By.id("day"));
		
		//create Select class object
		Select drpdwnDate = new Select(dateEle);
		
		// retrieve the default date and print on the console
		WebElement defaultDateEle = drpdwnDate.getFirstSelectedOption();
		System.out.println("default date is :: "+ defaultDateEle.getText());
		
		// select an option based on index number
		drpdwnDate.selectByIndex(10);
		Thread.sleep(3000);
		
		
		
		// locate month drop down
		WebElement monthEle = driver.findElement(By.id("month"));
		
		// create Select class object for month ele
		Select drpdwnMonth = new Select(monthEle);
		
		// retrieve the default month and print on the console
		WebElement defaultMonthEle = drpdwnMonth.getFirstSelectedOption();
		System.out.println("default month is :: "+defaultMonthEle.getText());
		
		// select a month based on value attribute value
		drpdwnMonth.selectByValue("8");
		Thread.sleep(3000);
		
		
		
		
		// locate year drop down
		WebElement yearEle = driver.findElement(By.id("year"));
		
		// create a Select class object for year ele
		Select drpdwnYear = new Select(yearEle);
		
		// retrieve default year and print on the console
		String defaultYear = drpdwnYear.getFirstSelectedOption().getText();
		System.out.println("default year is :: "+defaultYear);
		
		// retrieve all the options of year drop down
		List<WebElement> yearOptions = drpdwnYear.getOptions();
		System.out.println("total number of option in year drop down is :: "+yearOptions.size());
		
		// select a year based on visible text i.e. inner text
		drpdwnYear.selectByVisibleText("2017");
		Thread.sleep(3000);
		
		
		// selecting a year option in single line
//		new Select(driver.findElement(By.id("year"))).selectByVisibleText("2012");
//		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
		
		
		
		driver.close();
		
		
		
		
		
		
		
	}

}
