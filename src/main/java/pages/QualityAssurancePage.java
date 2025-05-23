package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QualityAssurancePage extends BasePage {

	// See All QA Jobs button
	@FindBy(xpath = "//a[normalize-space()='See all QA jobs']")
	private WebElement seeAllQaJobsButton;

	public QualityAssurancePage() {
	}

	// Clicks on See All QA Jobs button
	public void clickOnSeeAllQaJobsButton() {
		seeAllQaJobsButton.click();
	}

}
