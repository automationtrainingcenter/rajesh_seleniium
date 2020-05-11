package screenshots;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;

import utilities.BrowserUtitlity;

public class AlertScreenshotDemo extends BrowserUtitlity{
	
	public static void main(String[] args) {
		launchBrowser("chrome", "https://learn.letskodeit.com/p/practice");
		sleep(2000);
		
		// locate alert button and click on it
		driver.findElement(By.id("alertbtn")).click();
		sleep(1000);
		
		
		// capture the screenshot of webpage with alert
		// create an object of Robot class
		try {
			Robot r = new Robot();
			// retrieves size of the screen as a Dimension class object
			Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
			Rectangle rect = new Rectangle(d);
			BufferedImage bi = r.createScreenCapture(rect);
			File destImg = new File(".//screenshots//alert.png");
			ImageIO.write(bi, "png", destImg);
//			r.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));			
			
		} catch (Exception e) {
			System.out.println("alert screen caputre failed due to exception "+e);
		}
		
		// handle the alert
		driver.switchTo().alert().accept();
		
		// close browser
		closeBrowsers();
		
	}

}
