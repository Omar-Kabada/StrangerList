package com.kabada.core;

import org.openqa.selenium.By;

import java.util.List;

public class LoggingDriver extends DriverDecorator{

    public LoggingDriver(Driver driver) {
        super(driver);
    }

    @Override
    public void start(Browser browser) {
        System.out.println("Start browser = " + browser.name());
        driver.start(browser);
    }

    @Override
    public void quit() {
        System.out.println("Close browser");
        driver.quit();
    }

    @Override
    public void goToURL(String url) {
        System.out.println("Go to url = " + url);
        driver.goToURL(url);
    }

    @Override
    public Element findElement(By locator) {
        System.out.println("Find Element");
        return driver.findElement(locator);
    }

    @Override
    public List<Element> findElements(By locator) {
        System.out.println("Find Elements");
        return driver.findElements(locator);
    }

    @Override
    public void refreshPage() {
        System.out.println("Refreshing the Page");
        driver.refreshPage();
    }
}
