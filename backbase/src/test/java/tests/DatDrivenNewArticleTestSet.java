package tests;

import static org.testng.Assert.assertTrue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import baseclass.BasePage;
import baseclass.BaseTestSet;
import drivercomponents.DriverManager;
import pages.HomePage;
import pages.LoginPage;
import pages.NewArticlePage;
import pages.UserHomePage;

public class DatDrivenNewArticleTestSet extends BaseTestSet {
	/*
	 * Logger object initialization
	 */
	private static final Logger LOG = LoggerFactory.getLogger(DatDrivenNewArticleTestSet.class);

	/*
	 * class components
	 */
	LoginPage loginPage;
	HomePage homePage;
	NewArticlePage newArticlePage;
	UserHomePage userHomePage;

	public DatDrivenNewArticleTestSet() {
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
	 * Scenario: publish a new article
	 * 
	 * Steps 1. Login to conduit using read only user 2. Login as admin user 3.
	 * Navigate to New Article link 4. Enter the details and publish the article 5.
	 * Assert publishing of the article 6. Delete the article 7. Log out
	 */
	@Test(description = "Test to create and delete multiple articles", dataProvider="newarticledata", dataProviderClass=utilities.TestDataProvider.class)
	public void publishNewTestingArticle(String title,String desc,String body,String tag) {
		LOG.info("This is the starting of the test method" + this.getClass().getSimpleName());

		// check home page readiness
		homePage = new HomePage(DriverManager.getDriver());
		LOG.info("Checking for home page readiness");
		homePage.isReady();
		LOG.info("Home page is ready to work");

		// click on sign in link
		LOG.info("Clicking on sign in link in the header");
		loginPage = homePage.clickOnSignInLink();
		LOG.info("Clicked on sign in link in the header");

		// Login to the application
		userHomePage = loginPage.login(ADMIN_USER, ADMIN_PASSWORD);
		LOG.info("Logged in to the applciation with admin user");

		// assert user is navigated to user home page
		assertTrue(userHomePage.isHomeLinkActive(), "User is not navigated to user home page. Home link is not active");

		// click on new article link LOG.info("clicking on new article link");
		newArticlePage = userHomePage.clickOnNewArticle();

		// assert new article link is active
		LOG.info("Checking whether new article link is active");
		assertTrue(userHomePage.isNewArticleLinkActive(), "New Article link is not active");
		LOG.info("New article link is active");

		// publish article LOG.info("Publishing the Article");
		newArticlePage.publishArticle(title, desc, body, tag);
		LOG.info("Article is published");

		// assert page navigated to article home page
		LOG.info("asserting page navigated to article home page");
		assertTrue(newArticlePage.isEditButtonPresent(), "Control is in new article page even after publish");

		LOG.info("Deleting the article");
		newArticlePage.clickOnDeleteButton();

		LOG.info("Assert article is deleted and the user is navigated to homepage");
		assertTrue(userHomePage.isHomeLinkActive(), "User is not navigated to user home page. Home link is not active");

		LOG.info("Clicking on Logout button");
		homePage.logout();

		LOG.info("this is the ending of the test method" + this.getClass().getSimpleName());

	}

	
	
	
}
