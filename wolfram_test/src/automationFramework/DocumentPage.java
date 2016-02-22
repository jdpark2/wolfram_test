package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DocumentPage extends Page {
	
	public DocumentPage(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Function that clicks and checks the file extension
	 */
	public boolean clickAndCheckFileExtension(String extension) {
		// Checks if the extension is .nb and returns a boolean
		clickElement("id", "renameButton");

		if (driver.findElement(By.id("toolbarRenameInputField")).getAttribute("value").equals(extension))
			return true;
		
		return false;
	}
}
