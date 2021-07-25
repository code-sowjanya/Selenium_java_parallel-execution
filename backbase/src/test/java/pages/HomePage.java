package pages;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import baseclass.BasePage;
import drivercomponents.DriverManager;

public class HomePage extends BasePage {
	/*
	 * Logger class initialization.
	 */
	private static Logger log = LoggerFactory.getLogger(HomePage.class);

	/*
	 * class components
	 */
	public LoginPage loginPage;
	/*
	 * Locater elements
	 */
	public static WebDriver driver;
	private final static String SIGNIN_LINK = "signinlnk";
	private final static String SETTINGS_LINK = "settingsLnk";
	private final static String LOGOUT_BUTTON = "logout";

	// change at 1.53 public HomePage(WebDriver driver) {

	public HomePage(WebDriver driver) {
		super(driver,"homepage.properties");
	}

	/*
	 * Method to check if homepage ready
	 */
	public void isReady() {
		this.get();
	}

	/*
	 * Method to click on sign in link in the header
	 * 
	 * @return Login page object
	 */
	public synchronized LoginPage clickOnSignInLink() {
		log.info(this.getClass().getSimpleName() + " starting of clickOnSignInButton method");
		this.click(SIGNIN_LINK);

		// Initialize login page and check for ready
		log.info("Creating login Object");
		loginPage = new LoginPage(DriverManager.getDriver());
		log.info("Checking for login page readiness");
		loginPage.isReady();

		log.info(this.getClass().getSimpleName() + " Ending of clickOnSignInButton method");

		return loginPage;
	}

	/*
	 * Method to click on settings link in the header
	 * 
	 */
	public void logout() {
		log.info(this.getClass().getSimpleName() + " starting of clickOnSettingsLink method");
		log.info("click on settings link");
		this.click(SETTINGS_LINK);

		// Scroll down
		log.info("Scrolling down to log out button");
		this.scrollDown();
		log.info("Scrolled down to log out button");

		log.info("click on logout link");
		this.click(LOGOUT_BUTTON);

		log.info(this.getClass().getSimpleName() + " Ending of clickOnSettingsLink method");

	}

	/*
	 * check whether the page load is complete
	 */
	@Override
	protected void isLoaded() {
		this.waitForElementClickable(SIGNIN_LINK);
	}

}
