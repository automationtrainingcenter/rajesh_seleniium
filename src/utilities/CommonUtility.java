package utilities;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CommonUtility {

	private WebDriver driver;

	public CommonUtility(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * clicks on OK button of the alert on the screen and returns alert text
	 */
	public String alertAccept() {
		String alertText = "";
		try {
			Alert alert = driver.switchTo().alert();
			alertText = alert.getText();
			alert.accept();
		} catch (Exception e) {
			System.out.println("alert accept is failed due to exception " + e);
		}
		return alertText;
	}

	/**
	 * clicks on Cancel button of the alert on the screen and returns alert text
	 */
	public String alertDismiss() {
		String alertText = "";
		try {
			Alert alert = driver.switchTo().alert();
			alertText = alert.getText();
			alert.dismiss();
		} catch (Exception e) {
			System.out.println("alert accept is failed due to exception " + e);
		}
		return alertText;
	}

	/**
	 * locate an element with given locator type and locator value and returns that
	 * element
	 * 
	 * @param locType
	 * @param locValue
	 * @return WebElement
	 */
	public WebElement locateElement(String locType, String locValue) {
		locType = locType.toLowerCase();
		WebElement ele = null;
		try {
			switch (locType) {
			case "id":
				ele = driver.findElement(By.id(locValue));
				break;
			case "name":
				ele = driver.findElement(By.name(locValue));
				break;
			case "linktext":
				ele = driver.findElement(By.linkText(locValue));
				break;
			case "partaillinktext":
				ele = driver.findElement(By.partialLinkText(locValue));
				break;
			case "cssselector":
				ele = driver.findElement(By.cssSelector(locValue));
				break;
			case "xpath":
				ele = driver.findElement(By.xpath(locValue));
				break;
			default:
				System.out.println("invalid locator type");
				break;
			}
			System.out.println("element located successfully with " + locType + " = " + locValue);
		} catch (Exception e) {
			System.out.println("unable to locate element with " + locType + " = " + locValue);
			System.out.println("element location failed due to exception " + e);
		}
		return ele;
	}

	/**
	 * this method is used to type some data on an element
	 * 
	 * @param element in which you want to type
	 * @param data    to type in given element
	 */
	public void type(WebElement element, String data) {
		try {
			element.clear();
			element.sendKeys(data);
			System.out.println(data + " typed in " + element);
		} catch (Exception e) {
			System.out.println("unable to type data in " + element + " due to exception " + e);
		}
	}

	/**
	 * click on a given element
	 * 
	 * @param element on which you want to click
	 */
	public void click(WebElement element) {
		try {
			element.click();
			System.out.println("click on " + element);
		} catch (Exception e) {
			System.out.println("unable to click on " + element + " due to exception " + e);
		}
	}

	/**
	 * Select an option in a given drop down list based visible text
	 * 
	 * @param dropdown list element
	 * @param option   text to select
	 */
	public void selectDropDown(WebElement element, String optionText) {
		try {
			Select selectEle = new Select(element);
			List<WebElement> options = selectEle.getOptions();
			for (WebElement option : options) {
				String text = option.getText().toLowerCase();
				if (text.contains(optionText.toLowerCase())) {
					option.click();
					break;
				}
			}
			System.out.println(optionText + " selected in " + element);
		} catch (Exception e) {
			System.out.println("unable to select " + optionText + " in " + element + " due to exception " + e);
		}
	}

	/**
	 * select a single or multiple options of a list box
	 * 
	 * @param list    box element
	 * @param options text to select
	 */
	public void selectListBox(WebElement element, String... options) {
		try {
			if (options.length != 0) {
				for (String option : options) {
					selectDropDown(element, option);
				}
			} else {
				System.out.println("no options provided");
			}
		} catch (Exception e) {
			System.out.println("unable to select multiple options due to exception " + e);
		}
	}

	/**
	 * unselect a single or multiple options of a list box
	 * 
	 * @param list    box element
	 * @param options text to select
	 */
	public void unSelectListBox(WebElement element, String... options) {
		try {
			if (options.length != 0) {
				Select selectEle = new Select(element);
				List<WebElement> optnEles = selectEle.getOptions();
				for (String option : options) {
					for (WebElement optEle : optnEles) {
						String text = optEle.getText().toLowerCase();
						if (text.contains(option.toLowerCase())) {
							if (optEle.isSelected()) {
								optEle.click();
								System.out.println(option + " unselected in " + element);
							}else {
								System.out.println(option + " is not selected to unselect in " + element);
							}
							break;
						}
					}
					
				}
			} else {
				System.out.println("no options provided");
			}
		} catch (Exception e) {
			System.out.println("unable to unselect multiple options due to exception " + e);
		}
	}

}
