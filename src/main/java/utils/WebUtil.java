package utils;
import java.util.List;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import base.Base;

public class WebUtil extends Base {

	WebDriver driver;
	public WebUtil(WebDriver driver) {
		this.driver = driver;
	}

	public List<WebElement> getElements(By locator) {
		List<WebElement> elementsList = driver.findElements(locator);
		return elementsList;
	}

	public WebElement getelement(By locator) {
		WebElement temp = null;
		try {
			temp = driver.findElement(locator);
			// System.out.println("Element has been located "+locator.toString());

			// test.log(Status.INFO, "element located");
		} catch (Exception e) {
			System.out.println("Error While Locating the webelement :" + locator.toString());
			Assert.fail();
		}
		return temp;

	}

	public WebElement waitForElementPresent(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return element;
	}

	/**
	 * Not only element is present in DOM but also height and width of element>0
	 * 
	 * @param locator
	 * @param timeout
	 * @return
	 */

	public WebElement waitForElementVisibility(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return element;
	}

	
	public String waitForTitleToBePresent(String title, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.titleContains(title));
		return driver.getTitle();
	}
	public void objectType(By ment) {

	}

	/**
	 * Waits for element after getting StaleElementReferenceException
	 * 
	 * @param bylocator
	 * @param timeout
	 * @param maxRetry
	 * @return
	 */

	public WebElement waitForStaleElement(By locator, int timeout, int maxRetry) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		WebElement element = null;
		int count = 0;
		boolean retry = false;
		do {
			try {
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			} catch (StaleElementReferenceException e) {
				retry = true;
				count++;
				if (count < maxRetry) {
					Assert.fail("Exception while locating the element");
					break;
				}
			}
		} while (retry);
		return element;

	}

	public void doSendKeys(By by, String textToEnter, String description) {
		waitForElementPresent(by, 10);
		WebElement temp = getelement(by);
		try {
			temp.sendKeys(textToEnter);
			System.out.println("Entering " + textToEnter + " in textbox");
			test.log(Status.INFO, "<b>" + textToEnter + "</b>"+" has been entered");

		} catch (Exception e) {
			System.out.println("Error while entering " + textToEnter + " in textbox " + by.toString());
			test.log(Status.FAIL, "<b>" + textToEnter + "</b>"+" could not be entered");
			Assert.fail("<b>" + textToEnter + "</b>"+" could not be entered");
		}
	}

	public void doClick(By by) {
		waitForElementPresent(by, Constants.EXPLICIT_WAIT_TIMEOUT);
		WebElement temp = getelement(by);
		try {
			temp.click();
			System.out.println("Clicked on " + by.toString());
			test.log(Status.INFO, "Clicked on "+by.toString());

		}

		catch (Exception e) {
			System.out.println("Error while clicking " + by.toString());
			test.log(Status.FAIL, "Error while clicking  on "+by.toString());
			Assert.fail();

		}
	}

	public void doSubmit(By by) {
		waitForElementPresent(by, Constants.EXPLICIT_WAIT_TIMEOUT);
		WebElement temp = getelement(by);
		try {
			temp.submit();
			System.out.println("Submit action performed on  " + by.toString());
			test.log(Status.INFO, "Submit action performed on "+by.toString());

		}

		catch (Exception e) {
			System.out.println("Error while performing Submit action " + by.toString());
			test.log(Status.FAIL, "Could not perform Submit action performed on "+by.toString());
			Assert.fail();

		}
	}

	public WebElement doCheckVisibility(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT_TIMEOUT);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return element;
	}

	public boolean doIsDisplayed(By locator) {
		waitForElementPresent(locator, Constants.EXPLICIT_WAIT_TIMEOUT);
		return getelement(locator).isDisplayed();
	}

	public static String createRandomString(int lengthofString) {
		// RandomStringUtils random=new RandomStringUtils();
		return RandomStringUtils.randomAlphabetic(lengthofString);

	}

	public static void main(String[] args) {
		System.out.println(createRandomString(4));// yZzQ
	}

}
