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


# Project Structure

We have a base structure with the Driver and Locator Abstract classes, where our base methods are described, each has its Decorator and Log classes and theWebCoreDriver and WebVoreElement where the final implementation is done.  

