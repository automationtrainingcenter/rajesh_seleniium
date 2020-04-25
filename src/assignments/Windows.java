package assignments;

import java.util.ArrayList;
import java.util.List;

/*
 * Open any browser
 * navigate to FramesDemo page url
 * click on open Windows button
 * get all window handles and convert to List
 * 
 * Hint:
 * 	List<String> windowIds = new ArrayList<>(windowHandles);
 * 	for(int i = 0; i < windowIds.size(); i++) {
			driver.switchTo().window(windowIds.get(i));
			System.out.println("at index "+i+" window is "+driver.getTitle());
	}
	After writing code until this step run the program
	to get the index numbers of the windows after that commet the above for loop code and 
	write code for following steps
	 
 * 
 * switch to facebook window and type email field
 * switch to youtube window and type something in search field
 * switch to google window and type something in search field
 * switch to main window and click open tabs button
 * close all the browser windows
 * 
 */
public class Windows {

}
