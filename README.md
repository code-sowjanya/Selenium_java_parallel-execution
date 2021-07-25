# Conduit project web automation framework

	This project is a Data driven framework designed to test conduit application with multiple sets of data. 

# Project Details:

 This project followed page object design pattern. Project is built using selenium webdriver with java, TestNG, Maven, logback. This is framwork is designed for testing Create, read and delete options of an article with multiple sets of data. 
 
# Technology stack:
Selenium WebDriver 4
Java SE 8 or above
Maven 
TestNG 
LogBack
Chrome driver 92.X 


# Framework structure:
This project contains below packages and files
  1. Baseclass package: Base package contains the  abstract class for page object and test sets which are the super classes for all the page classes and test classes respectively. This page also contains all the driver related resuable methods like getIdByXpath and wait.

  2. Driver components package: This package contains a DriverFactory class which creates driver instance based on the browser parameter. DriverManager class to set and get the created driver instance.
  
  3. logback.xml file for logging in consoule and in log files. 
   
  4. pages: This package contains all the pages classes. Each page class contains all the action methods that are needed to perform actions in a particular page.  

  5. tests: this Package contains all the tests classes. One test set for each page.

  6. utilities: This package contains the test data provider that are used by the tests.

  7. selectors: This folder contains locators of a specific page stored in properties file. These files are named same as respective page class for easy identification. These locators will be read by the page classes to identify the objects.

  8. Logs: All the generated logs will be saved in this folder.
 
 9. Config.properties: This file contains the AUT url, browser and login details.

10. TestNG test suits: 2 suites, one is smoke.xml to test single test cases another one is DataDriventest.xml suite 

# Execution details:
Tests can be executed in the below ways

 1. Running the testng xml files seperately from eclipse by right clicking and running as "TestNG suite"

 2. Running from command line using maven test command.
        mvn test -pSmoke or mvn test -pDataDrivenTest


# Other information:
 1. Manual test cases folder 
 2. test - output folder contains the testNG output file.
 3. target/surfile-reports contains the surefire report
