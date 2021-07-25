# Conduit project web automation framework

	This project is a Data driven framework designed to test conduit application with multiple sets of data. 

# Project Details:

 This framework follows page object design pattern which mainly tests Creating, reading and deleteing features with multiple sets of data. 

# Technology stack:
	This project is built using the below tools and frameworks
###### Selenium WebDriver 4
###### Java SE 8 or above
###### Maven 
###### TestNG 
###### LogBack
###### Chrome driver 92.X 

# Pre-requisites
1. Java 8
2. Maven
3. Chrome browser version 92.X (the chrome driver is compatable with this version)  

# Framework structure:
This project contains below packages and files
  1. Baseclass package: Base package contains base page class and base test class which are super classes for all the page classes and test classes respectively. The base page class also contains the driver related reusable methods.

  2. Driver components package: This package contains a DriverFactory class which creates driver instance based on the browser parameter. DriverManager class is used to set and get the created driver instance.
     
  3. pages: This package contains all the page classes. Each page class contains all the methods that are needed to perform actions in that respective page.  

  4. tests: this Package contains all the tests classes(one test set is created for each page).

  5. utilities: This package contains the test data provider class that is used by the tests.

  6. selectors: This folder contains property files for respective page classes. Each of these files contain locators which will be read by the page classes to identify the elements(for easy identification these property files are named after their respective page classes).

 7. Config.properties: This file contains the AUT url, browser and login details.

8. TestNG test suites: There are 2 suites. one is smoke.xml to test single test cases. Second one is DataDriventest.xml suite for testing with multiple sets of data. 

 9. Logs: All the generated logs will be saved in this folder.
 
 11. logback.xml file is incorporated for logging in consoule and log files. 
	
# Execution details:
Tests can be executed in the following ways

 1. Running the testng xml files from eclipse IDE - by right clicking and running as "TestNG suite".

 2. Running from command prompt using maven test goal - by using Smoke profile for single test and DataDriventest profile for data driven tests.


# Other componemts:
 1. Manual test cases file 
 2. test - output folder contains the testNG output file.
 3. target/surfile-reports contains the surefire report
