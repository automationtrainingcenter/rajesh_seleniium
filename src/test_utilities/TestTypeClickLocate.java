package test_utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.util.concurrent.Uninterruptibles;

import utilities.BrowserUtitlity;
import utilities.CommonUtility;

public class TestTypeClickLocate {

	public static void main(String[] args) {
		// launch the browser
		BrowserUtitlity.setDriverPath("chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();
		
		// create an object of CommonUtlitity class
		CommonUtility utility = new CommonUtility(driver);
		
		WebElement txtEmail = utility.locateElement("id", "email", "Email text box");
		utility.type(txtEmail, "sunshine", "Email text box");
		Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
		
		WebElement dayEle = utility.locateElement("id", "day", "Date drop down");
		utility.selectDropDown(dayEle, "25", "Date drop down");
		Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
		
		WebElement radioFemale = utility.locateElement("cssSelector", "input[value='1']", "Female radio button");
		utility.click(radioFemale, "Female radio button");
		Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
		
		driver.close();
		
		
	}

}
