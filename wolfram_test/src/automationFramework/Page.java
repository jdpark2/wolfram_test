package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {
	protected final WebDriver driver;
	protected WebDriverWait wait;

	/**
	 * Page parent object. Every page inherits the common functions
	 * @param driver
	 */
    public Page(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 5);
	}
    
    /**
     * Function for clicking an element (waits until clickable)
     * @param method
     * @param path
     */
    public void clickElement(String method, String path) {
    	if (method.equals("id")) {
    		wait.until(ExpectedConditions.elementToBeClickable(By.id(path)));
    		driver.findElement(By.id(path)).click(); 
    	}
    		
    	else if (method.equals("xpath")) {
    		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(path)));
    		driver.findElement(By.xpath(path)).click(); 
    	}
    	
    	else if (method.equals("classname")) {
    		wait.until(ExpectedConditions.elementToBeClickable(By.className(path)));
    		driver.findElement(By.className(path)).click(); 
    	}
    	
    	else if (method.equals("name")) {
    		wait.until(ExpectedConditions.elementToBeClickable(By.name(path)));
    		driver.findElement(By.name(path)).click(); 
    	}
    	
    	else if (method.equals("linktext")) {
    		wait.until(ExpectedConditions.elementToBeClickable(By.linkText(path)));
    		driver.findElement(By.linkText(path)).click(); 
    	}
    }
    
    /**
     * Function that returns the page title
     * @return title
     */
    public String getTitle() {
		return driver.getTitle();
	}
    
}
