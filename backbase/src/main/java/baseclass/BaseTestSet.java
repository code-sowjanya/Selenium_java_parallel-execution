package baseclass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import drivercomponents.*;

public abstract class BaseTestSet {
	/*
	 * Element key selectors
	 */
	protected String SEARCH_STRING = "text";

	/*
	 * class components
	 */
	public static WebDriver driver;
	String confiPath = System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties";
	private static final Properties PROPERTIES = new Properties();
	FileInputStream loader = null;
	protected String URL = null;
	protected String AUTH_USERNAME = null;
	protected String AUTH_PASSWORD = null;
	protected String PROTOCOL = null;
	protected String ADMIN_USER=null;
	protected String ADMIN_PASSWORD=null;

	
	/*
	 * Default constructor
	 */
	public BaseTestSet() {
		this.loadProperties();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		if (driver == null) {
			driver = DriverFactory.createInstance(PROPERTIES.getProperty("browser"));
			DriverManager.setDriver(driver);
			System.out.println("The selected browser is - " + PROPERTIES.getProperty("browser"));
			PROTOCOL = PROPERTIES.getProperty("protocol");
			AUTH_USERNAME = PROPERTIES.getProperty("readonlyusername");
			AUTH_PASSWORD = PROPERTIES.getProperty("readonlypassword");
			URL = PROTOCOL + AUTH_USERNAME + ":" + AUTH_PASSWORD + "@" + PROPERTIES.getProperty("url");
			System.out.println("The AUT is - " + URL);
			ADMIN_USER = PROPERTIES.getProperty("adminusername");
			ADMIN_PASSWORD = PROPERTIES.getProperty("adminpassword");
			
			driver.navigate().to(URL);
		}
	}

	/*
	 * Method to launch the AUT 
	 * 
	 */
	//@BeforeMethod
	public void get() {
		DriverManager.getDriver().navigate().to(this.URL);
	}
	
	@AfterMethod
	public void afterAllIsDone() {
		DriverManager.closeDriver();
	}

	/*
	 * Method to load the properties file
	 */
	private void loadProperties() {
		try {
			PROPERTIES.load(new FileInputStream(confiPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



}
