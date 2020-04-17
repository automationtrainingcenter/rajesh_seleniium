package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import utilities.BrowserUtitlity;

/*WebElement interface methods
This interface contains methods to perform common actions on the element

1. click() is used to click on an element 

2. sendKeys(CharSequence... arg) is used to type some data in a text field and text
area. This method will send data character by character.

3. clear() is used to clear existing data in the text field or text area.

4. getText() returns String value which is an inner text of the given element if any

5. submit() is used to submit a form to the server if that form submit button is
implemented using <input> tag

6. getAttribute(String att_name) returns a String which is attribute value of the given 
attribute name

7. getCssValue(String css_property_name) returns a String which is value of the 
given css property name

8. getSize() returns Dimension class object which is height and width of the given element

9. getLocation() returns Point class object which is x and y coordinate values of the element
in the web page from top left cornor

10. getTagName() returns name of the tag of given element

11. findElement(By arg) returns WebElement interface reference this method will
locate an element in the GIVEN ELEMENT based on the locating technique we
specified using 'By' class and stores in a WebElement reference. If no
element is present in the page with locating technique then this method will
throw NoSuchElementException

12. findElements(By arg) returns a java.util.List of WebElement type this method
will locate either zero or more elements in the GIVEN ELEMENT based on the
locating technique we specified using 'By' class and store in
List<WebElement>. if no element is present in the page with locating
technique then this method will return a List of size 0.

13. isDisplayed() returns true if given element is displayed in the web page

14. isEnabled() returns true if given element is in active mode or enabled mode

15. isSelected() returns true if given option of either dropdown list or list box or 
radio button or check box is selected.
*/
public class WebElementMethods {

	public static void main(String[] args) throws InterruptedException {
		
		// launch the browser
		BrowserUtitlity.setDriverPath("chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://facebook.com");
		driver.manage().window().maximize();
		
		// click()
//		WebElement femaleRadioEle = driver.findElement(By.xpath("//input[@value = '1']"));
//		femaleRadioEle.click();
		WebElement femaleRadioEle = driver.findElement(By.xpath("//input[@value='1']"));
		femaleRadioEle.click();
		Thread.sleep(2000);
		
		
		// sendKeys(CharSequence... arg)
		WebElement firstNameEle = driver.findElement(By.name("firstname"));
		firstNameEle.sendKeys("sunshine");
		Thread.sleep(3000);
		
		// clear()
		firstNameEle.clear();
		Thread.sleep(3000);
		
		// submit()
//		driver.findElement(By.id("email")).submit();
		
		// getText()
		WebElement signUpEle = driver.findElement(By.name("websubmit"));
		String signUpText = signUpEle.getText();
		System.out.println("sing up button text is "+signUpText);
			
		// getTagName()
		String signUpTagName = signUpEle.getTagName();
		System.out.println("sing up button tag name is "+signUpTagName);
		
		// getAttribute(String att_name)
		String firstNameEleType = firstNameEle.getAttribute("type");
		System.out.println("first name element type attribute value is "+firstNameEleType);
		
		// getCssValue(String cssPropertyName)
		String firstNameEleWidth = firstNameEle.getCssValue("width");
		System.out.println("width of the first name element is "+firstNameEleWidth);
		
		// getSize() 
		Dimension size = signUpEle.getSize();
		System.out.println("sign up button width is "+size.getWidth()+" and height is "+size.getHeight());
		
		// getLocation()
		Point location = signUpEle.getLocation();
		System.out.println("sing up button is at x = "+location.getX()+" and at y = "+location.getY());
		
		// isDisplayed()
		boolean reTypeEmailDisplayed = driver.findElement(By.name("reg_email_confirmation__")).isDisplayed();
		System.out.println("re enter email address text box is dispalyed "+reTypeEmailDisplayed);
		
		// isEnabled()
		boolean singUpBtnEnabled = signUpEle.isEnabled();
		System.out.println("sign up button is enabled "+singUpBtnEnabled);
		
		// isSelected()
		boolean femaleRadioBtnSelected = femaleRadioEle.isSelected();
		System.out.println("female radio button is selected "+femaleRadioBtnSelected);
			
		// close the browser
		Thread.sleep(5000);
		driver.close();
		

	}

	private static void click() {
		// TODO Auto-generated method stub
		
	}

}
