package baseclass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;

import drivercomponents.*;

public abstract class BaseTest {
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
    protected String PROTOCOL=null;
    /*
     * Default constructor
     */
    public BaseTest() {
    //    this.loadProperties();
    }
    
    //@Test
    
    
    }
