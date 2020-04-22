package utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

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
			System.out.println("alert accept is failed due to exception "+e);
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
			System.out.println("alert accept is failed due to exception "+e);
		}
		return alertText;
	}
	
	

}
