package cookie_handling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver.Options;

import utilities.BrowserUtitlity;

public class CookieHandling extends BrowserUtitlity{
	
	public static void loadCookies() {
		File fi = new File(".//resources//cookies//cookieData.txt");
		try {
			FileReader fr = new FileReader(fi);
			BufferedReader reader = new BufferedReader(fr);
			String line = reader.readLine();;
			while(line != null) {
				String[] values = line.split(";");
				String name = values[0];
				String value = values[1];
				String domain = values[2];
				String path = values[3];
				String expiryStr = values[4];
				// Wed Jun 03 09:29:30 IST 2020 E MMM dd HH:mm:ss z yyyy
				DateFormat df = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy");
				Date expiry = df.parse(expiryStr);
				Cookie cookie = new Cookie(name, value, domain, path, expiry);
				driver.manage().addCookie(cookie);	
				line = reader.readLine();
			}
		} catch (Exception e) {
			System.out.println("failed to read the data from the given file due to exception "+e);
		}
		
	}
	
	
	public static void storeCookieDetails() {
		File fi = new File(".//resources//cookies//cookieData.txt");
		Set<Cookie> cookies = driver.manage().getCookies();
		for(Cookie cookie : cookies) {
			String name = cookie.getName();
			String value = cookie.getValue();
			String domain = cookie.getDomain();
			String path = cookie.getPath();
			Date expiry = cookie.getExpiry();
			String cookieData = name+";"+value+";"+domain+";"+path+";"+expiry+"\n";
			try {
				FileWriter fw = new FileWriter(fi);
				BufferedWriter writer = new BufferedWriter(fw);
				writer.write(cookieData);
				writer.flush();
				writer.close();
			} catch (Exception e) {
				System.out.println("failed to write the data into the given file due to exception "+e);
			}
		}
	}
	
	// login
	public static void login() {
		driver.findElement(By.partialLinkText("Sign in")).click();
		sleep(2000);
		driver.findElement(By.id("email")).sendKeys("test@sunshine.com");
		driver.findElement(By.id("passwd")).sendKeys("selenium");
		driver.findElement(By.id("SubmitLogin")).click();
		sleep(4000);
		storeCookieDetails();
	}
	
	public static void main(String[] args) {
		launchBrowser("chrome", "http://automationpractice.com/index.php");
		sleep(5000);
//		login();
		loadCookies();
		driver.get("http://automationpractice.com/");
		sleep(5000);
		driver.manage().deleteAllCookies();
		driver.get("http://automationpractice.com/");
		sleep(5000);
		closeBrowsers();
		
		
	}

}
