# StrangerList
Practice Automation with a Stranger Things List.



I used the following technologies:

WebDriver Manager.
Selenium 4.
jUnit 5.
Maven.
Java 11.


### Running the project 
To run it just use mvn clean install if it is the first time running it or mvn test if not.

Also you will need to change the value of variable "validImageAbsolutePath" located in com.kabada.pages/MainPage.java file to match the absolute path in you machine for the images/320px_square.png" file.

Alternatively you can import the project to IntelliJ and run the tests individually or as a group in the UI.

# Project Structure

We have a base structure with the Driver and Locator Abstract classes, where our base methods are described, each has its Decorator and Log classes and the WebCoreDriver and WebCoreElement where the final implementation is done.  

Driver -> DriverDecorator -> LoggingDriver -> WebCoreDriver
Element -> ElementDecorator -> LogElement -> WebCoreElement

Driver manages all the actions that the webdriver usually have, we can add actions here as we expand our framework.
Element manages all the actions that can be performed in our elements, like interactions or getting information from them.
Browser is an enum with the browser name, it is used to pass the info to the webdrivermanager.


