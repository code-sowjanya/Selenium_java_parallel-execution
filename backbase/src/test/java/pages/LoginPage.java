package pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import baseclass.BasePage;

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
	 *  @param driver instance
	 */
	public LoginPage(WebDriver driver) {
		super(driver, "loginpage.properties");
	}
	
	/*
	 * method to login to the application 
	 */
	public void login(String username, String password) {
		log.info(this.getClass().getSimpleName() + " starting of login method");
		
		try{
			this.waitForElementVisbility(EMAIL_TEXTBOX);
			this.getElementByXpath(EMAIL_TEXTBOX).sendKeys(username);
			this.waitForElementVisbility(PASSWORD_TEXTBOX);
			this.getElementByXpath(PASSWORD_TEXTBOX).sendKeys(password);
			this.click(SIGNIN_BUTTON);
			
			//Create user home page object
			UserHomePage userHomePage = new UserHomePage(driver);
			
		} catch(NoSuchElementException e) {
			e.printStackTrace();
		}
		
		
		log.info(this.getClass().getSimpleName() + " Ending of login Method");
		
	}

		// the sing in method will return the home page object
		// Assert user is navigated to your feed is active

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
