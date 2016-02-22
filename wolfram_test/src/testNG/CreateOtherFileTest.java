package testNG;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import automationFramework.*;

public class CreateOtherFileTest {
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
	 * Test for logging in with correct credentials
	 */
	@Test(priority=3)
	public void enterCredentials() {
		home = login.loginAs("pawsitiveinu@gmail.com", "test123");
		String url = driver.getCurrentUrl();
		String text = driver.findElement(By.xpath("//*[@id='wdp-main']/section[1]/h1")).getAttribute("tite");
		Assert.assertEquals(url, "https://develop.wolframcloud.com/app/");
		Assert.assertEquals(text, "Wolfram Development Platform");
	}
	
	/**
	 * Test for creating new document and it's extension
	 * @throws InterruptedException 
	 */
	@Test(priority=4)
	public void createNewDocumentTest() {
		doc = home.createNewFile("xpath", "//*[@id='newNotebookBtn']/div[2]", "Text");
		Assert.assertTrue(doc.clickAndCheckFileExtension(".txt"));
	}
	
	/**
	 * Function for closing the session
	 */
	@AfterTest
	public void endSession() {
		driver.quit();
	}
}
