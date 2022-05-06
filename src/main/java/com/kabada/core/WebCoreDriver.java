package com.kabada.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class WebCoreDriver extends Driver{
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    @Override
    public void start(Browser browser) {
        switch (browser){
            case CHROME:
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                webDriver = new EdgeDriver();
                break;
            case OPERA:
                WebDriverManager.operadriver().setup();
                webDriver = new OperaDriver();
                break;
            case SAFARI:
                WebDriverManager.safaridriver().setup();
                webDriver = new SafariDriver();
                break;
            default:
                throw new IllegalArgumentException(browser.name());
        }

        webDriverWait = new WebDriverWait(webDriver, 30);
    }

    @Override
    public void quit() {
        webDriver.quit();
    }

    @Override
    public void goToURL(String url) {
        webDriver.navigate().to(url);
    }

    @Override
    public Element findElement(By locator) {
        var nativeElement = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
        Element element = new WebCoreElement(webDriver, nativeElement, locator);

        //If we use decorator
        Element logElement = new LogElement(element);

        return logElement;

    }

    @Override
    public List<Element> findElements(By locator) {
        List<WebElement> nativeElements =
                webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        var elements = new ArrayList<Element>();

        for(WebElement nativeElement : nativeElements){
            Element element = new WebCoreElement(webDriver, nativeElement, locator);
            Element logElement = new LogElement(element);
            elements.add(logElement);
        }

        return elements;
    }

    @Override
    public void maximizeWindow(){
        webDriver.manage().window().maximize();
    }

    @Override
    public void waitUntilPageLoadsCompletely() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
        webDriverWait.until(d -> javascriptExecutor.executeScript("return document.readyState")
            .toString().equals("complete"));
    }

    @Override
    public void refreshPage() {
        webDriver.navigate().refresh();
    }
}
