package utilities;

import java.io.File;

public class BrowserUtitlity {
	
	public static void setDriverPath(String driverName) {
		driverName = driverName.toLowerCase();
		
		// verify OS
		if(System.getProperty("os.name").toLowerCase().contains("win")) {
			driverName = driverName+".exe";
		}
		
		// get the resources folder path
		String folderPath = System.getProperty("user.dir") + File.separator + "resources" + File.separator;
		
		// set the system property based on driver name
		if(driverName.contains("chromedriver")) {
			System.setProperty("webdriver.chrome.driver", folderPath+driverName);
		}else if(driverName.contains("geckodriver")) {
			System.setProperty("webdriver.gecko.driver", folderPath+driverName);
		}else {
			throw new RuntimeException("Invalid driver name "+driverName);
		}
	}
}
