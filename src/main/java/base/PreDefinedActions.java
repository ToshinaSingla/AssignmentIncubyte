package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.ConstantPath;

//Class containing all the basic functionalities to be performed on the page.
abstract public class PreDefinedActions {

	static public WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	Actions action = new Actions(driver);

	// Initiating the browser with URL
	static public WebDriver start() {
		start(ConstantPath.URL);
		return driver;
	}

	// Initiating the browser
	static public WebDriver start(String url) {
		System.setProperty("webdriver.chrome.driver", ConstantPath.CHROMEDRIVEREXE);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}

	//Opening any URL
	public static void openURL(String url) {
		driver.get(url);
	}
	
	// Adding wait
	protected WebElement wait(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element));
	}	


	// Perform click operation
	protected void click(WebElement element) {
		wait(element).click();
	}

	// Perform data input operation
	protected void enterText(WebElement element, String text) {
		wait(element).sendKeys(text);
	}

	// Perform fetch data operation
	protected String getText(WebElement element) {
		return wait(element).getText();
	}

	// Close the browser
	public static void shutTheBrowser() {
		driver.close();
		driver.quit();
	}

}
