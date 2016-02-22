package automationFramework;

import org.openqa.selenium.WebDriver;

/**
 * I made this class to navigate to the Login page. 
 * @author GD
 *
 */
public class IntroPage extends Page {
	
	/**
	 * Constructor for the IntroPage
	 * @param driver
	 */
	public IntroPage(WebDriver driver) {
		super(driver);
		
		// First check if we are on the correct page
		// If not, navigate to that page
		if (!(driver.getTitle()).equals("Wolfram Cloud"))
			driver.get("http://www.wolframcloud.com");
	}
	
	/**
	 * Function for navigating to the Login Page
	 * @param method, path
	 * @return LoginPage
	 */
	public LoginPage navigateToLogin(String method, String path) {
		// Find the element to click by a method and click
		clickElement(method, path);
		
		return new LoginPage(driver);
	}
	
}
