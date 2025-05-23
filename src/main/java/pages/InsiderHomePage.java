package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class InsiderHomePage extends BasePage {

	// Accept cookies
	@FindBy(xpath = "//a[@id='wt-cli-accept-all-btn']")
	private WebElement acceptCookiesButton;

	// Login button for verifying the HomePage
	@FindBy(xpath = "//a[normalize-space()='Login']")
	private WebElement loginButton;

	// NavBar on HomePage
	@FindBy(xpath = "//ul[@class='navbar-nav']/li/a")
	private List<WebElement> navigationBarItems;

	// Carreer button on NavBar
	@FindBy(xpath = "//a[text()='Careers']")
	private WebElement careerButton;

	public InsiderHomePage() {
	}

	// Accepts cookies
	public void acceptCookies() {
		try {
			acceptCookiesButton.click();
		}
		catch (NoSuchElementException e) {
			System.out.println("Cookies already accepted");
		}
	}

	// Gets Login Button Text for verifying the Home Page
	public String getTextOfLoginButton() {
		return loginButton.getText();
	}

	// Checks the user is on Home Page
	public void checkTheUserIsOnHomePage() {
		wait.until(ExpectedConditions.visibilityOf(loginButton));
		getTextOfLoginButton();

	}

	// Clicks on Career Button
	public void clickOnCareerButton() {
		actions.moveToElement(navigationBarItems.get(5)).build().perform();
		wait.until(ExpectedConditions.visibilityOf(careerButton));
		careerButton.click();

	}

}
