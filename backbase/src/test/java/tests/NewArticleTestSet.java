package tests;

import static org.testng.Assert.assertTrue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseclass.BasePage;
import baseclass.BaseTestSet;
import pages.HomePage;
import pages.LoginPage;

public class NewArticleTestSet extends BaseTestSet {
	/*
	 * Logger object initialization
	 */
	private static final Logger LOG = LoggerFactory.getLogger(NewArticleTestSet.class);

	/*
	 * class components
	 */
	LoginPage loginPage;
	HomePage homePage;

	public NewArticleTestSet() {
		super();
	}

	@BeforeMethod(description = "Startest")
	public void before() throws InterruptedException {
		super.setUp();
	}

	@AfterMethod(description = "endstart")
	public void after() {
		super.afterAllIsDone();
	}

	/*
	 * publish a new article
	 */
	@Test(description = "Check publishing a new article")
	public void publishNewArticle() {
		LOG.info("This is the starting of the test method" + this.getClass().getSimpleName());

		// check home page readiness
		HomePage homePage = new HomePage(driver);
		LOG.info("Checking for home page readiness");
		homePage.isReady();
		LOG.info("Home page is ready to work");

		// click on sign in link
		loginPage = homePage.clickOnSignInLink();

		// Login to the application
		loginPage.login(ADMIN_USER, ADMIN_PASSWORD);
		LOG.info("this is the starting of the  method");
		
		//assert user is navigated to user home page
		//assertTrue("User is not navigated to user home page. Home link is not active", );
		
		// click on new article link

		LOG.info("this is the ending of the test method" + this.getClass().getSimpleName());

	}
}
