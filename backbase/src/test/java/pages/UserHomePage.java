package pages;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import baseclass.BasePage;
import drivercomponents.DriverManager;

public class UserHomePage extends BasePage {

	/*
	 * Logger class initialization.
	 */
	private static Logger log = LoggerFactory.getLogger(LoginPage.class);

	/*
	 * Element selectors
	 */
	private final static String HOME_LINK = "homelink";
	private final static String NEWARTICLE_LINK = "newarticle";
	private final static String SIGNIN_BUTTON = "signinbtn";

	public UserHomePage(WebDriver driver) {
		super(driver,"userhomepage.properties");
	}

	public boolean isHomeLinkActive() {
		log.info(this.getClass().getSimpleName() + " starting of isHomeLinkActive method");
		boolean isPresent = false;
		this.waitUntilAttributeActice(HOME_LINK);
		//this.waitForElementVisbility(HOME_LINK);
		log.info("Checking if home link is active in header");
		if (this.getElementByXpath(HOME_LINK).getAttribute("class").contains("active")) {
			log.info("Home link is active in header");
			isPresent = true;
		} else
			log.error("Home link in header is not active");

		log.info(this.getClass().getSimpleName() + " Ending of isHomeLinkActive method");
		return isPresent;
	}

	public boolean isNewArticleLinkActive() {
		log.info(this.getClass().getSimpleName() + " starting of isNewArticleLinkActive method");
		// this.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		this.waitForElementVisbility(NEWARTICLE_LINK);
		boolean isActive = this.isLinkActive(NEWARTICLE_LINK);
		log.info("The status of the new article link is ==== " + isActive);
		log.info(this.getClass().getSimpleName() + " Ending of isNewArticleLinkActive method");
		return isActive;
	}

	/*
	 * Method to click on new article link
	 */
	public NewArticlePage clickOnNewArticle() {
		log.info(this.getClass().getSimpleName() + " starting of clickOnNewArticle method");
		this.click(NEWARTICLE_LINK);

		log.info("creating new article page object");
		NewArticlePage newArticlePage = new NewArticlePage(DriverManager.getDriver());
		newArticlePage.isReady();
		log.info(this.getClass().getSimpleName() + " starting of clickOnNewArticle method");
		return newArticlePage;
	}

	/*
	 * check whether the page load is complete
	 */
	@Override
	protected void isLoaded() {
		this.waitForElementVisbility(HOME_LINK);
	}

	@Override
	public void isReady() {
		this.get();

	}

}
