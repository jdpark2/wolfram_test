package testNG;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

import automationFramework.*;

public class LoginFailTest {
	public String baseURL = "http://www.wolframcloud.com";
	public WebDriver driver;
	public IntroPage intro;
	public LoginPage login;
	public HomePage home;
	public DocumentPage doc;
	
	@BeforeTest
	public void setBaseURL() {
		driver = new FirefoxDriver();
		driver.get(baseURL);
		
		intro = new IntroPage(driver);
	}
	
	/**
	 * Test for getting into the first intro page
	 */
	@Test(priority=1)
	public void verifyIntroTitle() {
		String expected = "Wolfram Cloud";
		String intro_title = intro.getTitle();
		Assert.assertEquals(intro_title, expected);
	}
	
	/**
	 * Test for navigating to login page
	 */
	@Test(priority=2)
	public void navigateToLoginPage() {
		driver.switchTo().frame(0);
		login = intro.navigateToLogin("xpath", "//li[@id='wdp-tile']");
		String expected = "Sign In";
		String login_title = login.getTitle();
		Assert.assertEquals(true, login_title.contains(expected));
	}
	
	/**
	 * Test for logging in with wrong credentials
	 */
	@Test(priority=3)
	public void verifyFailure() {
		login = login.loginFail("pawsitiveinu@gmail.com", "test123456");
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("user.wolfram.com/oauth/authorize"));
		Assert.assertTrue(login.loginErrorMessage());
	}
	
	
}