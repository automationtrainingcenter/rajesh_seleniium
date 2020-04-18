package basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import utilities.BrowserUtitlity;

public class RadioAndCheckBoxHandling {

	public static void main(String[] args) throws InterruptedException {
		// launch browser
		BrowserUtitlity.setDriverPath("chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://learn.letskodeit.com/p/practice");
		driver.manage().window().maximize();
		
		// locate BMW radio button and click on it
		WebElement radioBMW = driver.findElement(By.id("bmwradio"));
		radioBMW.click();
		Thread.sleep(3000);
		
		// locate Benz raido button and click on it
		WebElement radioBenz = driver.findElement(By.id("benzradio"));
		radioBenz.click();
		Thread.sleep(3000);
		
		// locate honda radio button and click on it
		WebElement radioHonda = driver.findElement(By.id("hondaradio"));
		radioHonda.click();
		Thread.sleep(3000);
		
		
		// locate BMW check box and check it
		WebElement chkBMW = driver.findElement(By.id("bmwcheck"));
		chkBMW.click();
		Thread.sleep(3000);
		
		// locate Benz check box and check it
		WebElement chkBenz = driver.findElement(By.id("benzcheck"));
		chkBenz.click();
		Thread.sleep(3000);
		
		// locate Honda check box and check it
		WebElement chkHonda = driver.findElement(By.id("hondacheck"));
		chkHonda.click();
		Thread.sleep(3000);
		
		
//		// uncheck all the check boxes which are checked
//		if(chkBMW.isSelected()) {
//			chkBMW.click();
//			Thread.sleep(3000);
//		}
//		
//		if(chkBenz.isSelected()) {
//			chkBenz.click();
//			Thread.sleep(3000);
//		}
//		
//		if(chkHonda.isSelected()) {
//			chkHonda.click();
//			Thread.sleep(3000);
//		}
		
		// uncheck all the check boxes which are selected
		// locate element which contains all the check boxes
		WebElement chkBoxContainer = driver.findElement(By.id("checkbox-example"));
		List<WebElement> chkBoxes = chkBoxContainer.findElements(By.tagName("input"));
		for(WebElement chkBox : chkBoxes) {
			if(chkBox.isSelected()) {
				chkBox.click();
				Thread.sleep(2000);
			}
		}
		
		
		driver.close();
	}
}
