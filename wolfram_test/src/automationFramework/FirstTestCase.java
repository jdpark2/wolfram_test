package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstTestCase {

	public static void main(String[] args) throws InterruptedException {

		// Create a new instance of a Chrome driver
		WebDriver driver = new FirefoxDriver();
		
		// Launch the wolfram alpha website
		driver.get("http://www.wolframcloud.com");
		
		// wait
		Thread.sleep(5);
		
		// Click
		driver.findElement(By.xpath("//nav[@id='product-list']/ul/li[1]")).click();
		
		// Print a log
		System.out.println("Success!");
		
		// wait
		Thread.sleep(5);
		
		// close
		driver.quit();
		
		
	}

}
