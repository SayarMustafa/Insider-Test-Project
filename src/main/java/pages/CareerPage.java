package pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.BrowserUtils;

public class CareerPage extends BasePage {

	// Career Page Text Field for verifying
	@FindBy(xpath = "//h1[normalize-space()='Ready to disrupt?']")
	private WebElement careerPageTextField;

	// See All Teams button
	@FindBy(xpath = "//div[contains(@class, 'row')]//a[contains(text(), 'See all teams')]\n")
	private WebElement seeAllTeamsButton;

	// Locations text field
	@FindBy(xpath = "//p[@class='mt-5 mb-0 mt-lg-0 mx-auto pl-0']")
	private WebElement ourLocationsTextField;

	// Life At Insider text field
	@FindBy(xpath = "//p[contains(text(),'We’re here to grow and drive growth—as none of us ')]")
	private WebElement lifeAtInsiderTextField;

	// All Teams section
	@FindBy(xpath = "//div[contains(@class, 'career-load-more')]")
	private WebElement seeAllTeamsSection;

	public CareerPage() {

	}

	// Verifies the User is on Careers Page
	public String checkTheUserIsOnCareersPage() {
		wait.until(ExpectedConditions.visibilityOf(careerPageTextField));
		return careerPageTextField.getText();
	}

	// Checks See All Teams Button is displayed
	public Boolean isSeeAllTeamsButtonDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(seeAllTeamsButton));
		BrowserUtils.scrollToElement(seeAllTeamsButton);
		return seeAllTeamsButton.isDisplayed();

	}

	// Clicks on See All Teams Button
	public void clickOnSeeAllTeamsButton() throws InterruptedException {
		seeAllTeamsButton.click();
		Thread.sleep(3000);
	}

	// Checks All Teams are displayed
	public Boolean isSeeAllTeamsSectionDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(seeAllTeamsSection));
		BrowserUtils.scrollToElement(seeAllTeamsSection);
		return seeAllTeamsSection.isDisplayed();

	}

	// Checks Locations section is displayed
	public Boolean isOurLocationsTextFieldDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(ourLocationsTextField));
		BrowserUtils.scrollToElement(ourLocationsTextField);
		return ourLocationsTextField.isDisplayed();
	}

	// Checks Life At Insider section is displayed
	public Boolean isLifeAtInsiderTextFieldDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(lifeAtInsiderTextField));
		BrowserUtils.scrollToElement(lifeAtInsiderTextField);
		return lifeAtInsiderTextField.isDisplayed();
	}

}
