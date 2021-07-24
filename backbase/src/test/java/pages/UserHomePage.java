package pages;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import baseclass.BasePage;

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
		super(driver, "userhomepage.properties");
	}
	
	public boolean isHomeLinkActive() {
		log.info(this.getClass().getSimpleName() + " starting of isHomeLinkActive method");
		boolean isPresent = false;
		log.info("Checking if home link is active in header");
		if(this.getElementByXpath(HOME_LINK).getAttribute("class").contains("active")) {
			log.info("Home link is active in header");
			isPresent = true;	
		}
		
		log.info(this.getClass().getSimpleName() + " Ending of isHomeLinkActive method");
		return isPresent;
	}

	/*
	 * check whether the page load is complete
	 */
	@Override
	protected void isLoaded() {
		this.waitForElementVisbility(HOME_LINK);
	}
}
