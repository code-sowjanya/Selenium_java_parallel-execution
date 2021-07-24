package baseclass;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BasePage extends LoadableComponent<BasePage> {
	/*
	 * Logger object initialization
	 */
	private static Logger log = LoggerFactory.getLogger(BasePage.class);
	/*
	 * Base page components
	 */
	public static WebDriver driver;
	private static final Properties PROPERTIES = new Properties();
	public static String browser;
	private static final String LOCATOR_DIR = "\\src\\test\\resources\\selectors";
	private static final String locatorFilePath = System.getProperty("user.dir") + LOCATOR_DIR;

	/*
	 * constructor method to load the locator file
	 * 
	 * @param driver and locator file path
	 */
	public BasePage(WebDriver driver, String locatorFile) {
		this.driver = driver;
		this.loadFile(locatorFile);
	}

	public void loadFile(String locatorFile) {
		File file = new File(locatorFilePath, locatorFile);
		String fileName = file.getAbsolutePath();

		assertTrue(file.exists(), "The locater file is not found - " + file.getName());

		if (file.exists()) {
			log.info("Locater file exists");
			try {
				// load the locator file
				FileInputStream fileInput = new FileInputStream(file);
				PROPERTIES.load(fileInput);
			} catch (IOException e) {
				log.error("Locator file is not loaded properly " + locatorFilePath);
				e.printStackTrace();
			}
		}

	}

	/*
	 * Method to interact with selenium to retrieve the needed element by Xpath
	 * 
	 * @parm key of item
	 * 
	 * @return the web element
	 * 
	 */
	public WebElement getElementByXpath(String key) {

		String value = PROPERTIES.getProperty(key + ".xpath");

		if (value.isBlank())
			throw new RuntimeException("The locator key is not found");

		WebElement webElement = driver.findElement(By.xpath(value));

		return webElement;
	}

	/*
	 * Method to get the xpath value for the given locater key
	 * 
	 * @return locater value
	 */
	private String getLocaterValue(String key) {

		String locatorType = key + ".xpath";
		String locatorValue = PROPERTIES.getProperty(locatorType);

		return locatorValue;
	}

	/*
	 * Method to click on element
	 * 
	 * @param web element string
	 */
	public void click(String element) {
		log.info(this.getClass().getSimpleName() + " starting of click method");

		WebElement button = this.getElementByXpath(element);
		if (button.isEnabled()) {
			log.info(button.getText() + "element and is being clicked.");
			button.click();
			log.info(button.getText() + "element is clicked.");
		} else
			log.error("element is ready." + element);

		log.info(this.getClass().getSimpleName() + " Ending of click method");
	}

	public void waitForElementVisbility(String element) {

		String locaterValue = PROPERTIES.getProperty(element + ".xpath");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locaterValue)));
	}

	public void waitForElementClickable(String element) {

		String locaterValue = PROPERTIES.getProperty(element);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locaterValue)));
	}

	/*
	 * check whether the page load is complete
	 */
	@Override
	protected void isLoaded() {
		boolean isReady = false;
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		isReady = executor.executeScript("return document.readystate") == "complete";
		assertTrue(isReady, "Page load is not complete");
	}

	@Override
	protected void load() {
		// driver.navigate().refresh();
		try {
			this.wait(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}