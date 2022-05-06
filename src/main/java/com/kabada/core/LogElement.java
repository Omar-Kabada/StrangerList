package com.kabada.core;

import org.openqa.selenium.By;

public class LogElement extends ElementDecorator{

    protected LogElement(Element element){
        super(element);
    }

    @Override
    public By getBy() {
        return element.getBy();
    }

    @Override
    public String getText() {
        System.out.println("Element text = " + element.getText());
        return element.getText();
    }

    @Override
    public Boolean isEnabled() {
        System.out.println("Element enabled = " + element.isEnabled());
        return element.isEnabled();
    }

    @Override
    public Boolean isDisplayed() {
        System.out.println("Elemend displayed = " + element.isDisplayed());
        return element.isDisplayed();
    }

    @Override
    public void typeText(String text) throws InterruptedException {
        System.out.println("Type text = " + text);
        element.typeText(text);
    }

    @Override
    public void click() {
        System.out.println("Element clicked");
        element.click();
    }

    @Override
    public String getAttribute(String attributeName) {
        System.out.println("Got attribute = " + attributeName);
        return element.getAttribute(attributeName);
    }

    @Override
    public void clearText() {
        System.out.println("Clearing the text from the textfield.");
        element.clearText();
    }
}
