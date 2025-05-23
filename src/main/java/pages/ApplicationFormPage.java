package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ApplicationFormPage extends BasePage {

	// Job Title text field for verification
	@FindBy(xpath = "//h2[normalize-space()='Senior Software Quality Assurance Engineer']")
	private WebElement jobTitleTextField;

	// Checks the Job Title text field is displayed
	public Boolean isJobTitleTextFieldDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(jobTitleTextField));
		return jobTitleTextField.isDisplayed();
	}

}
