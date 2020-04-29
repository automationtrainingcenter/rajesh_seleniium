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
		
		WebElement txtEmail = utility.locateElement("id", "email");
		utility.type(txtEmail, "sunshine");
		Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
		
		WebElement dayEle = utility.locateElement("id", "day");
		utility.selectDropDown(dayEle, "25");
		Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
		
		WebElement radioFemale = utility.locateElement("cssSelector", "input[value='1']");
		utility.click(radioFemale);
		Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
		
		driver.close();
		
		
	}

}
