package basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import utilities.BrowserUtitlity;

/*
 * To automate a text box or text area we have to use sendKeys(CharSequence... arg) to type
 * some data within the text box and to remove existing data with in the text box or text area field we 
 * have to clear().
 * 
 * both sendKeys() and clear() are methods WebElement interface.
 * 
 */
public class TextBoxHandling {

	public static void main(String[] args) throws InterruptedException {
		// launch the browser
		BrowserUtitlity.setDriverPath("chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();

		// locate first name text field and type some data
		WebElement txtFirstName = driver.findElement(By.name("firstname"));
		txtFirstName.sendKeys("surya");
		Thread.sleep(3000);

		// locate surname text field and type some data
		WebElement txtSurname = driver.findElement(By.name("lastname"));
		txtSurname.sendKeys("prakash");
		Thread.sleep(3000);
//		driver.findElement(By.name("lastname")).sendKeys("prakash");

		// locate email address text box and type some data
		WebElement txtEmail = driver.findElement(By.name("reg_email__"));
		txtEmail.sendKeys("surya@gmail.com");
		Thread.sleep(3000);

		// locate reenter email address text box
		WebElement txtEmail2 = driver.findElement(By.name("reg_email_confirmation__"));
		// verify reenter email address text box is visible
		if (txtEmail2.isDisplayed()) {
			// type some data in that text box
			txtEmail2.sendKeys("surya@gmail.com");
			Thread.sleep(3000);
		}

		// locate password text box and type some data
		WebElement txtPass = driver.findElement(By.name("reg_passwd__"));
		txtPass.sendKeys("password");
		Thread.sleep(3000);

		// locate registration form
		WebElement form = driver.findElement(By.id("reg"));
		// locate all the text fields within that form using class name
		List<WebElement> inputFields = form.findElements(By.className("inputtext"));
		// iterate over every element
		for (WebElement inputField : inputFields) {
			// verify element is visible or not
			if (inputField.isDisplayed()) {
				// clear the data within that text box
				inputField.clear();
				Thread.sleep(2000);
			}
		}
 
		driver.close();

	}

}
