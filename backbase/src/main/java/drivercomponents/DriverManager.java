package drivercomponents;

import org.openqa.selenium.WebDriver;

public class DriverManager {

	protected static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<WebDriver>();
	
	/*
	 * singleton pattern
	 */
	private DriverManager() {
		
	}
	
	/*
	 * Method to get the thread instance
	 * 
	 * @return driver instance
	 */
	public static WebDriver getDriver() {
		return DRIVER.get();
	}
	
	/*
	 * Method to set the thread instance
	 * @param driver instance
	 */
	public static void setDriver(WebDriver driver) {
		DRIVER.set(driver);
	}
	
	/*
	 *method to close the driver
	 */
	public static void closeDriver() {
		if(DRIVER.get()!=null) {
			DRIVER.get().quit();
		}
		DRIVER.remove();
		
	}
	
}
