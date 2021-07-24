package drivercomponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

	// singleton pattern
	private DriverFactory() {
	}

	/*
	 * create webDriver instance
	 */
	public static WebDriver createInstance(String browser) {
		WebDriver DRIVER = null;

		if (DRIVER == null) {
			if (browser.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") 
						+ "\\src\\test\\resources\\drivers\\chromedriver.exe");
				DRIVER = new ChromeDriver();
				DRIVER.manage().window().maximize();
			} else if(browser == "firefox") {
				DRIVER = new FirefoxDriver();
			}
		}
		return DRIVER;
	}
}
