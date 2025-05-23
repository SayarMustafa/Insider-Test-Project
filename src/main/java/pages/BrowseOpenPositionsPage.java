package pages;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utils.BrowserUtils;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BrowseOpenPositionsPage extends BasePage {

	// Browse Open Positions text field
	@FindBy(xpath = "//h3[contains(text(),'Browse')]")
	private WebElement browseOpenPositionsTextField;

	// Locations Dropdown
	@FindBy(id = "//span[@aria-labelledby='select2-filter-by-location-container']")
	private WebElement locationDropdown;

	// Locations Dropdown SubMenu
	@FindBy(xpath = "//div[@id='jobs-list']//div[contains(@class, 'position-list-item')]")
	private List<WebElement> jobList;

	// Position Title fields
	@FindBy(xpath = "//p[contains(@class, 'position-title') and contains(text(), 'Quality Assurance')]")
	private List<WebElement> positionTitleFields;

	// Position Department fields
	@FindBy(xpath = "//span[contains(@class, 'position-department') and text()='Quality Assurance']")
	private List<WebElement> positionDepartmentFields;

	// Position Location fields
	@FindBy(xpath = "//div[contains(@class, 'position-location') and text()='Istanbul, Turkiye']")
	private List<WebElement> positionLocationFields;

	// View Role button
	@FindBy(xpath = "//a[contains(text(),'View Role')]")
	private List<WebElement> viewRoleButtons;

	// Checks Browse Open Positions text field is displayed for verification
	public Boolean isBrowseOpenPositionsTextFieldDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(browseOpenPositionsTextField));
		return browseOpenPositionsTextField.isDisplayed();
	}

	// Filters jobs by Location
	public void selectComboBox() {
		Select locationSelect = new Select(DRIVER.findElement(By.id("filter-by-location")));
		locationSelect.selectByVisibleText("Istanbul, Turkiye");
	}

	// Checks the Job List is displayed
	public Boolean isJoblistDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(jobList.get(0)));
		BrowserUtils.scrollToElement(jobList.get(0));
		return jobList.get(0).isDisplayed();
	}

	// Verifies that Jobs are filtered correctly
	public void verifyJobs() {
		wait.until(ExpectedConditions.visibilityOf(jobList.get(0)));
		for (WebElement job : jobList) {
			String title = job.findElement(By.xpath(".//p[contains(@class,'position-title')]")).getText();
			String dept = job.findElement(By.xpath(".//span[contains(@class,'position-department')]")).getText();
			String loc = job.findElement(By.xpath(".//div[contains(@class,'position-location')]")).getText();

			Assertions.assertThat(title).withFailMessage("Title hata: " + title).contains("Quality Assurance");

			Assertions.assertThat(dept).withFailMessage("Departman hata: " + dept).isEqualTo("Quality Assurance");

			Assertions.assertThat(loc).withFailMessage("Lokasyon hata: " + loc).isEqualTo("Istanbul, Turkiye");
		}
	}

	// Clicks on View Role button and verifies the User is redirected to Application Form
	// Page
	public void clickViewRoleAndSwitchToNewWindow() {
		String originalWindow = DRIVER.getWindowHandle();

		viewRoleButtons.get(0).click();

		wait.until(ExpectedConditions.numberOfWindowsToBe(2));

		for (String windowHandle : DRIVER.getWindowHandles()) {
			if (!windowHandle.equals(originalWindow)) {
				DRIVER.switchTo().window(windowHandle);
				break;
			}
		}

		// Verify Apllication Fom Page is displayed as expected after switching to the new
		// window
		wait.until(ExpectedConditions.urlContains("lever.co"));

		String currentUrl = DRIVER.getCurrentUrl();
		String pageTitle = DRIVER.getTitle();

		assertThat(currentUrl).as("URL 'lever.co' must contain").contains("lever.co");

		assertThat(pageTitle).as("Page Title mustn't be empty").isNotEmpty();
	}

}
