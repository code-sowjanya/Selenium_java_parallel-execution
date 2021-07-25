package pages;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import baseclass.BasePage;
import drivercomponents.DriverManager;

public class NewArticlePage extends BasePage {

	/*
	 * Logger class initialization.
	 */
	private static Logger log = LoggerFactory.getLogger(LoginPage.class);

	/*
	 * Element selectors
	 */
	private final static String TITLE_TEXTBOX = "title";
	private final static String DESCRIPTION = "description";
	private final static String PUBLISH_BUTTON = "publishbtn";
	private final static String BODY_TEXTBOX = "body";
	private final static String TAGS_TEXTBOX = "tags";
	private final static String EDIT_BUTTON = "editbtn";
	private final static String DELETE_BUTTON = "deletebtn";

	/*
	 * Constructor
	 * 
	 * @param driver
	 */
	public NewArticlePage(WebDriver Driver) {
		super(driver,"newarticlepage.properties");
	}

	/*
	 * Method to click on publish button link
	 */
	private void clickOnPublishButton() {
		this.click(PUBLISH_BUTTON);
//		this.waitForElementInVisbility(PUBLISH_BUTTON);

	}

	/*
	 * Method to click on delete button link
	 */
	public void clickOnDeleteButton() {
		this.click(DELETE_BUTTON);
		UserHomePage userHomePage = new UserHomePage(DriverManager.getDriver());
		userHomePage.isReady();

	}

	/*
	 * fill the new article form
	 */
	private void fillForm() {
		this.enterText(TITLE_TEXTBOX, "Test1");
		this.enterText(DESCRIPTION, "Test1");
		this.enterText(BODY_TEXTBOX, "Test1");
		this.enterText(TAGS_TEXTBOX, "Test1");
	}

	/*
	 * Publish the article
	 */
	public void publishArticle() {
		this.fillForm();
		this.clickOnPublishButton();
	}

	/*
	 * Publish the article in parallel
	 */
	public void publishArticle(String title, String desc, String body, String tag) {
		this.fillForm(title, desc, body, tag);
		this.clickOnPublishButton();
	}

	private void fillForm(String title, String desc, String body, String tag) {
		this.enterText(TITLE_TEXTBOX, title);
		this.enterText(DESCRIPTION, desc);
		this.enterText(BODY_TEXTBOX, body);
		this.enterText(TAGS_TEXTBOX, tag);
	}

	/*
	 * Method to check for Edit button
	 */
	public boolean isEditButtonPresent() {
		log.info(this.getClass().getSimpleName() + " starting of isEditButtonPresent method");
		boolean isPresent = false;
		if (this.getElementByXpath(EDIT_BUTTON).isDisplayed()) {
			log.info("Edit button is present");
			isPresent = true;
		} else
			log.error("Edit button is not present.");

		log.info(this.getClass().getSimpleName() + " Ending of isEditButtonPresent method");
		return isPresent;
	}

	/*
	 * check whether the page load is complete
	 */
	@Override
	protected void isLoaded() {
		this.waitForElementVisbility(TITLE_TEXTBOX);
		this.waitForElementVisbility(BODY_TEXTBOX);
	}

	@Override
	public void isReady() {
		this.get();

	}
}
