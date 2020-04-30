package utilities;

import java.util.List;
import java.util.Set;

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
	 * @param locType     id or name or cssselector or xpath or linktext or
	 *                    partiallinktext
	 * @param locValue    value of the given locator
	 * @param elementName name of the element you are locating
	 * @return WebElement
	 * 
	 */
	public WebElement locateElement(String locType, String locValue, String elementName) {
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
			System.out.println(elementName + " located successfully with " + locType + " = " + locValue);
		} catch (Exception e) {
			System.out.println("unable to locate " + elementName + " with " + locType + " = " + locValue);
			System.out.println("element location failed due to exception " + e);
		}
		return ele;
	}

	/**
	 * this method is used to type some data on an element
	 * 
	 * @param element     in which you want to type
	 * @param data        to type in given element
	 * @param elementName name of the element in which you want to type data
	 */
	public void type(WebElement element, String data, String elementName) {
		try {
			element.clear();
			element.sendKeys(data);
			System.out.println(data + " typed in " + elementName);
		} catch (Exception e) {
			System.out.println("unable to type data in " + elementName + " due to exception " + e);
		}
	}

	/**
	 * click on a given element
	 * 
	 * @param element on which you want to click
	 * @elementName name of the element you want to click
	 */
	public void click(WebElement element, String elementName) {
		try {
			element.click();
			System.out.println("clicked on " + elementName);
		} catch (Exception e) {
			System.out.println("unable to click on " + elementName + " due to exception " + e);
		}
	}

	/**
	 * Select an option in a given drop down list based visible text
	 * 
	 * @param dropdown    list element
	 * @param option      text to select
	 * @param elementName name of the drop down list
	 */
	public void selectDropDown(WebElement element, String optionText, String elementName) {
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
			System.out.println(optionText + " option selected in " + elementName);
		} catch (Exception e) {
			System.out
					.println("unable to select " + optionText + " option in " + elementName + " due to exception " + e);
		}
	}

	/**
	 * select a single or multiple options of a list box
	 * 
	 * @param list        box element
	 * @param elementName name of the list box
	 * @param options     text to select
	 */
	public void selectListBox(WebElement element, String elementName, String... options) {
		try {
			if (options.length != 0) {
				for (String option : options) {
					selectDropDown(element, option, elementName);
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
	 * @param list        box element
	 * @param elementName name of the list box
	 * @param options     text to select
	 */
	public void unSelectListBox(WebElement element, String elementName, String... options) {
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
								System.out.println(option + " option unselected in " + elementName);
							} else {
								System.out.println(option + " option is not selected to unselect in " + elementName);
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

	/**
	 * switch to the frame based on frame id or name or any other attribute and
	 * value using xpath or css
	 * 
	 * @param locType   either id or name or xpath or cssSelector
	 * @param locValue  value of the given locator type
	 * @param frameName name of the frame you want to switch to
	 */
	public void switchToFrame(String locType, String locValue, String frameName) {
		try {
			locType = locType.toLowerCase();
			if (locType.equals("id") || locType.equals("name")) {
				driver.switchTo().frame(locValue);
			} else if (locType.equals("xpath") || locType.equals("cssselector")) {
				WebElement frameEle = locateElement(locType, locValue, frameName);
				driver.switchTo().frame(frameEle);
			}
			System.out.println("driver focus switched to frame " + frameName);
		} catch (Exception e) {
			System.out.println("unable to switch driver focus to the frame " + frameName + " due to exception " + e);
		}
	}
	
	/**
	 * Switch to main page from any frame
	 * @param frameName name of frame from which you switching the focus
	 */
	public void switchToMainPage(String frameName) {
		try {
			driver.switchTo().defaultContent();
			System.out.println("driver focus switched to main page from frame "+frameName);
		} catch (Exception e) {
			System.out.println("switch to main page from frame "+frameName+" is failed due to exception "+e);
		}
	}
	
	/**
	 * switch to parent frame from inner frame 
	 * @param frameName name of the frame to which you switching the focus
	 */
	public void switchToParentFrame(String frameName) {
		try {
			driver.switchTo().parentFrame();
			System.out.println("driver focus switched to parent frame "+frameName);
		} catch (Exception e) {
			System.out.println("switch to parent frame "+frameName+" failed due to exception "+e);
		}
	}
	
	/**
	 * switch in between the windows
	 * @param windowTitle complete or part of the window title
	 */
	public void switchToWindow(String windowTitle) {
		try {
			// retrieve the current window title
			String currentWindowTitle = driver.getTitle();
			windowTitle = windowTitle.toLowerCase();
			// retrieve all the window handles or window ids
			Set<String> windows = driver.getWindowHandles();
			for(String window : windows) {
				driver.switchTo().window(window);
				String title = driver.getTitle().toLowerCase();
				if(title.equals(windowTitle)) {
					break;
				}
			}
			System.out.println("driver focus switched to "+windowTitle+" from "+currentWindowTitle);
		} catch (Exception e) {
			System.out.println("switch to window "+windowTitle+" failed due to exception "+e);
		}
	}
	

}
