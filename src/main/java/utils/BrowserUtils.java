package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class BrowserUtils {

	/**
	 * Captures a screenshot of the current browser window and saves it with a unique
	 * name.
	 * @param name the name of the screenshot
	 * @return the file path of the captured screenshot
	 */

	/**
	 * Moves the mouse pointer to the specified web element.
	 * @param element the web element to move the mouse pointer to
	 */
	public static void moveToElement(WebElement element) {
		Actions actions = new Actions(DriverManager.getDriver());
		actions.moveToElement(element).build().perform();
	}

	/**
	 * Navigates to a browser window with the specified title.
	 */
	public static void switchToNewWindow() {
		WebDriver driver = DriverManager.getDriver();
		String originalWindow = driver.getWindowHandle();

		Set<String> allWindows = driver.getWindowHandles();

		for (String handle : allWindows) {
			if (!handle.equals(originalWindow)) {
				driver.switchTo().window(handle);
				new WebDriverWait(driver, Duration.ofSeconds(10)).until(d -> !d.getTitle().isEmpty()); // Yeni
																										// pencere
																										// yüklendi
																										// mi?
				return;
			}
		}
	}

	/**
	 * Switches to a grandchild window.
	 */
	public static void switchToGrandChildWindow() {
		Set<String> windows = DriverManager.getDriver().getWindowHandles();
		Iterator<String> iterations = windows.iterator();
		String parentWindow = iterations.next();
		String childWindow = iterations.next();
		String grandChildindow = iterations.next();
		DriverManager.getDriver().switchTo().window(grandChildindow);
	}

	/**
	 * Switches to a popup window.
	 */
	public static void switchToPopUpWindow() {
		Set<String> windows = DriverManager.getDriver().getWindowHandles();
		Iterator<String> iterations = windows.iterator();
		String parentWindow = iterations.next();
		String childWindow = iterations.next();
		DriverManager.getDriver().switchTo().window(childWindow);
	}

	/**
	 * Pauses the execution for the specified number of seconds.
	 * @param secs the number of seconds to wait
	 */
	public static void wait(double secs) {
		try {
			Thread.sleep(1000 * (long) secs);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void waitInSeconds(int secs) {
		try {
			Thread.sleep(1000 * (long) secs);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void scrollDownWithPageDownButton(int times) {
		Actions actions = new Actions(DriverManager.getDriver());
		for (int i = 0; i < times; i++) {
			actions.keyDown(Keys.PAGE_DOWN).build().perform();
			waitInSeconds(1);
		}
	}

	public static void scrollUpWithPageUpButton(int times) {
		Actions actions = new Actions(DriverManager.getDriver());
		for (int i = 0; i < times; i++) {
			actions.keyDown(Keys.PAGE_UP).build().perform();
			waitInSeconds(1);
		}
	}

	public static void scrollDownWithJavaScript(int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		js.executeScript("window.scrollBy(" + x + "," + y + ");");
		waitInSeconds(2);
	}

	public static void clickOnElement(WebElement element) {
		Actions actions = new Actions(DriverManager.getDriver());
		actions.moveToElement(element).click().perform();
	}

	public static void executeJavaScript(String script, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		js.executeScript(script, element);
	}

	public static void scrollToElement(WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) DriverManager.getDriver();
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", element);
		waitInSeconds(2);
	}

	public static void setElementValueByLocator(String locator, String value) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) DriverManager.getDriver();
		jsExecutor.executeScript("document.querySelector('" + locator + "').value='" + value + "'");
	}

	public static void clickOnElementUsingJS(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public static void goToTheExpectedUrl(String url) {
		DriverManager.getDriver().get(url);
	}

}
