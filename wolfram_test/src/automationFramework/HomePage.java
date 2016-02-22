package automationFramework;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

/**
 * If I were to write a more robust test framework, I would add more functions to do other things.
 * @author GD
 *
 */
public class HomePage extends Page {
	protected String windowBefore;
	private ArrayList<String> tabs;
	
    public HomePage(WebDriver driver) {
		super(driver);
		
		// Store this window handle
		windowBefore = driver.getWindowHandle();
	}
    
    /**
     * Function that clicks the red 'New' button at the right hand side to create a new document
     * @param method
     * @param path
     * @param type
     * @return Document
     */
    
    public DocumentPage createNewFile(String method, String buttonPath, String type) {
    	// Clicks the button dropdown
    	clickElement(method, buttonPath);
    	
    	// Clicks the type of document to be created
    	clickElement(method, "//div[@id='newFileMenu']/div[contains(text(),'" + type + "' )]");
    	
    	tabs = new ArrayList<String> (driver.getWindowHandles());
    	
    	// Switch to the new window
    	driver.switchTo().window(tabs.get(1));
    
    	// Returns the DocumentPage
    	return new DocumentPage(driver);
    }
    
    
    /**
     * returns to the current window again (HomePage)
     */
    public void returnWindowHandle() {
    	driver.close();
    	driver.switchTo().window(tabs.get(0));
    }
}
