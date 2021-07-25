package pages;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import baseclass.BasePage;
import drivercomponents.DriverManager;

public class LoginPage extends BasePage {
	/*
	 * Logger class initialization.
	 */
	private static Logger log = LoggerFactory.getLogger(LoginPage.class);

	/*
	 * Element selectors
	 */
	private final static String EMAIL_TEXTBOX = "emailtxtbox";
	private final static String PASSWORD_TEXTBOX = "passwordtxtbox";
	private final static String SIGNIN_BUTTON = "signinbtn";

	/*
	 * Constructor class name
	 * 
	 * @param driver instance
	 */
	public LoginPage(WebDriver driver) {
		super(driver,"loginpage.properties");
	}

	/*
	 * method to login to the application
	 */
	public UserHomePage login(String username, String password) {
		log.info(this.getClass().getSimpleName() + " starting of login method");

		UserHomePage userHomePage = null;

		this.waitForElementVisbility(EMAIL_TEXTBOX);
		log.info("Username text box is enable, entering the data.");
		this.getElementByXpath(EMAIL_TEXTBOX).sendKeys(username);
		this.waitForElementVisbility(PASSWORD_TEXTBOX);
		log.info("Password text box is enable, entering the data.");
		this.getElementByXpath(PASSWORD_TEXTBOX).sendKeys(password);
		this.click(SIGNIN_BUTTON);

		// Create user home page object
		log.info("Checking for user home page readiness");
		userHomePage = new UserHomePage(DriverManager.getDriver());
		userHomePage.isReady();

		log.info(this.getClass().getSimpleName() + " Ending of login Method");
		return userHomePage;
	}

	// the sing in method will return the home page object
	// Assert user is navigated to your feed is active
	/*
	 * Method to check the readiness of the page
	 */
	@Override
	public void isReady() {
		this.get();
	}

	/*
	 * check whether the page load is complete
	 */
	@Override
	protected void isLoaded() {
		this.waitForElementVisbility(EMAIL_TEXTBOX);
		this.waitForElementVisbility(PASSWORD_TEXTBOX);
	}

}
