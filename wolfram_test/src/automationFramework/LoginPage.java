package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Page {
	
    public LoginPage(WebDriver driver) {
		super(driver);
	}

    // Define the HTML objects of Email, Password input fields and login button
    By emailLocator = By.id("email");
    By passwordLocator = By.id("password");
    By loginButtonLocator = By.id("signIn");

    /**
     * Function for typing in email into the email input field
     * @param email
     * @return LoginPage
     */
    public LoginPage typeEmail(String email) {
        // This is the only place that "knows" how to enter an email
        this.driver.findElement(emailLocator).sendKeys(email);

        // Return the current page object as this action doesn't navigate to a page represented by another PageObject
        return this;    
    }

    /**
     * Function for typing in password into the password input field
     * @param password
     * @return LoginPage
     */
    public LoginPage typePassword(String password) {
        // This is the only place that "knows" how to enter a password
        driver.findElement(passwordLocator).sendKeys(password);

        // Return the current page object as this action doesn't navigate to a page represented by another PageObject
        return this;
    }

    /**
     * Function for clicking the submit button and navigating to HomePage
     * @return HomePage
     */
    public HomePage submitLogin() {
        // Submits the login information and navigates to HomePage
        driver.findElement(loginButtonLocator).submit();

        // Returns the HomePage
        return new HomePage(driver);    
    }

    /**
     * Function for checking invalid login credentials
     * @return LoginFailPage
     */
    public LoginPage submitLoginExpectingFailure() {
        // Submit the wrong login credentials
        driver.findElement(loginButtonLocator).submit();

        // Check if the error message is present
        driver.findElement(By.xpath("//div[@class='error']"));
        
        return this;
    }

    /**
     * Wrapper class to do all the steps at once
     * @param email
     * @param password
     * @return HomePage
     */
    public HomePage loginAs(String email, String password) {
        // Do all the needed functions at once
        typeEmail(email);
        typePassword(password);
        return submitLogin();
    }
    
    /**
     * Wrapper class to enter the wrong credentials
     * @param email
     * @param password
     * @return LoginPage
     */
    public LoginPage loginFail(String email, String password) {
    	typeEmail(email);
    	typePassword(password);
    	driver.findElement(loginButtonLocator).submit();
    	return this;
    }
    
    public boolean loginErrorMessage() {
    	if (driver.findElement(By.xpath("//*/div[@class='error']")).isDisplayed())
    		return true;
    	return false;
    }
}