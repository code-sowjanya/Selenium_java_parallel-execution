package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import baseclass.BasePage;

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
	private final static String SIGNIN_LINK = "signinlnk";

	public HomePage(WebDriver driver) {
		super(driver, "homepage.properties");
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
	public LoginPage clickOnSignInLink() {
		log.info(this.getClass().getSimpleName() + " starting of clickOnSignInButton method");
		this.click(SIGNIN_LINK);

		// Initialize login page and check for ready
		log.info("Creating login Object");
		loginPage = new LoginPage(driver);
		log.info("Checking for login page readiness");
		loginPage.isReady();

		log.info(this.getClass().getSimpleName() + " Ending of clickOnSignInButton method");

		return loginPage;
	}

	public boolean isElementActive(String class_name) {
		boolean isActive = false;

		return isActive;
	}

	/*
	 * check whether the page load is complete
	 */
	@Override
	protected void isLoaded() {
		String SIGNIN_LINK = this.SIGNIN_LINK + ".xpath";
		this.waitForElementClickable(SIGNIN_LINK);
	}
	
}
