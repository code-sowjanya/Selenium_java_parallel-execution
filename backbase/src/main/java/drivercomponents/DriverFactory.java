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
		WebDriver driver = null;

		if (driver == null) {
			if (browser.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") 
						+ "\\src\\test\\resources\\drivers\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
			} else if(browser == "firefox") {
				driver = new FirefoxDriver();
			}
		}
		return driver;
	}
}
