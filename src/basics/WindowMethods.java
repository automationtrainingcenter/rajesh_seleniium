package basics;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.firefox.FirefoxDriver;

import utilities.BrowserUtitlity;

/*
 * Window interface methods or Browser management
 * 
 * public interface WebDriver{
 * 		void close();
 * 		void quit();
 * 
 * 		Options manage();
 * 
 * 
 * 		interface Options{
 * 
 *			Window window();	
 *			
 * 		}
 * 	
 * 		interface Window{
 * 			
 * 			void maximize();
 * 			void fullScreen();
 * 
 * 		}	
 * }
 * 
 * 
 * WebDriver driver = new ChromeDriver();
 * Options opt = driver.manage();
 * Window win = opt.window();
 * win.maximize();
 * 
 * 
 * driver.manage().window().maximize(); // object chaining
 * 
 * 
 * 1. maximize(): is used to maximize the browser window
 * 2. fullScreen(): is used to full screen mode(F11 mode) the browser window.
 * 3. getSize(): is used to retrieve the size of the browser window as a Dimension class object
 * 	  Note: Dimension class contains getWidth() and getHeight() which will return width and height as integers
 * 4. getPosition(): is used to retrieve the position of the browser window from top left corner the screen
 * as a Point class object
 * 	  Note: Point class contains getX() and getY() methods which will return x and y coordinate values of the 
 * 		browser window
 * 5. setSize(Dimension arg): is used to set the browser width and height to the given width and height using
 * Dimension class object
 * 6. setPostion(Point arg): is used to set the position of the browser window from the top left corner using
 * Point class object 
 *
 */

public class WindowMethods {
	
	public static void main(String[] args) throws InterruptedException {
		// launch the browser
		BrowserUtitlity.setDriverPath("geckodriver");
		WebDriver driver = new FirefoxDriver();
		
		// create Window interface object reference to manage browser window
//		Options opt = driver.manage();
//		Window window = opt.window();
		Window window = driver.manage().window();
		
		// getPosition()
		Point position = window.getPosition();
		System.out.println("browser window is at x = "+position.getX()+" and at y = "+position.getY());
		
		
		// getSize()
		Dimension size = window.getSize();
		System.out.println("browse window width is "+size.getWidth()+" and height is "+size.getHeight());
		
		
		// maximize()
		window.maximize();
//		driver.manage().window().maximize();
		Thread.sleep(4000);
		
		// fullscreen()
		window.fullscreen();
		Thread.sleep(4000);
		
		// setSize(Dimension arg)
//		Dimension d = new Dimension(600, 350);
//		window.setSize(d);
		window.setSize(new Dimension(600, 350)); // anonymous object
		Thread.sleep(4000);
		
		// setPosition(Point arg)
//		Point p = new Point(200, 100);
//		window.setPosition(p);
		window.setPosition(new Point(200, 100));
		Thread.sleep(4000);
		
		driver.close();
		
		
	}
	
	

}
