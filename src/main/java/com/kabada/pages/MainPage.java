package com.kabada.pages;

import com.kabada.core.Driver;
import com.kabada.core.Element;
import com.kabada.core.WebCoreElement;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Random;

public class MainPage {
    private final Driver driver;
    private final String url  = "http://immense-hollows-74271.herokuapp.com/";
    private final String text = "There are two means of refuge from the misery of life — music and cats.";
    private final String editedText = "Test Edit First Element";
    private final String entryText  = "Creators: Matt Duffer, Ross Duffer";
    private int descriptionMaxLength = 300;



    //Change this to your current path
    private final String validImageAbsolutePath = "C:\\Source\\StrangerList\\images\\320px_square.png";

    public MainPage(Driver driver){
        this.driver = driver;
    }

    private Element descriptionField(){
        return driver.findElement(By.name("text"));
    }

    private Element chooseFileButton(){
        return driver.findElement(By.id("inputImage"));
    }

    private Element createItemButton(){
        return driver.findElement(By.xpath("//button[contains(.,'Create Item')]"));
    }

    private List<Element> allItems(){
        return driver.findElements(By.xpath("//div[@class='media-left']"));
    }

    private List<Element> allItemsDescriptions(){
        return driver.findElements(By.xpath("//div/p"));
    }

    private Element editButtonFirstEntry(){
        return driver.findElement(By.xpath("(//div[@class='media-left'])[1]//button[1]"));
    }

    private Element updateButton(){
        return driver.findElement(By.xpath("//button[contains(.,'Update Item')]"));
    }

    private Element lastElementDeleteButton(){
        return driver.findElement(By.xpath("(//button[contains(.,'Delete')])[last()]"));
    }

    private Element cancelEditButton(){
        return driver.findElement(By.xpath("//button[contains(.,'Cancel')]"));
    }

    private Element firsEntryText(){
        return driver.findElement(By.xpath("(//p)[1]"));
    }

    private Element confirmDeleteButton(){
        return driver.findElement(By.xpath("//button[contains(.,'Yes, delete it!')]"));
    }

    public void addNewEntry() throws InterruptedException{
        driver.goToURL(url);
        driver.waitUntilPageLoadsCompletely();
        driver.maximizeWindow();
        chooseFileButton().typeText(validImageAbsolutePath);
        descriptionField().typeText(text);
        createItemButton().click();
    }

    public int countNumberOfEntries(){
        driver.goToURL(url);
        System.out.println("Number of elements: " + allItems().size());
        return allItems().size();
    }


    public void editFirstItemText() throws InterruptedException {
        driver.goToURL(url);
        driver.maximizeWindow();
        driver.waitUntilPageLoadsCompletely();
        editButtonFirstEntry().click();
        descriptionField().clearText();
        descriptionField().clearText();
        descriptionField().typeText(editedText);
        updateButton().click();
    }

    public boolean hasFirstEntryTextBeenEdited(){
        driver.goToURL(url);
        if(firsEntryText().getText().equals(editedText))
            return true;
        else
            return false;
    }

    public void createAndDeleteItem() throws InterruptedException {
        addNewEntry();
        driver.refreshPage();
        driver.waitUntilPageLoadsCompletely();
        lastElementDeleteButton().click();
        confirmDeleteButton().click();
    }

    public boolean createButtonDisabledMaxLengthPlusOne() throws InterruptedException{
        driver.goToURL(url);
        driver.waitUntilPageLoadsCompletely();
        driver.maximizeWindow();
        descriptionField().click();
        descriptionField().typeText(generateRandomChars(descriptionMaxLength) +"1");
        return createItemButton().isEnabled();
    }

    public boolean textDescriptionExist(){
        driver.goToURL(url);
        driver.waitUntilPageLoadsCompletely();
        driver.maximizeWindow();
        for (int i = 0; i < allItemsDescriptions().size(); i++){
            if(allItemsDescriptions().get(i).getText().equals(entryText)) {
                return true;
            }
        }
        return false;
    }

    /*This is not related to the main page and could exist somewhere else (like utils), but I will use
    it here for the time being.
    * */
    public static String generateRandomChars(int lenght) {
        String candidateChars = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for(int i= 0; i < lenght; i++)
            sb.append(candidateChars.charAt(random.nextInt(candidateChars.length())));
        return sb.toString();
    }

}
