package com.kabada.pages;

import com.kabada.core.Browser;
import com.kabada.core.Driver;
import com.kabada.core.LoggingDriver;
import com.kabada.core.WebCoreDriver;
import org.apache.commons.lang3.Validate;
import org.junit.jupiter.api.*;

public class MainPageTests {
    private Driver driver;
    private static MainPage mainPage;
    private int numberOfEntries = 13;


    @BeforeEach
    public void beforeEach(){
         driver = new LoggingDriver(new WebCoreDriver());
         driver.start(Browser.CHROME);
         mainPage = new MainPage(driver);
    }

    @AfterEach
    public void afterEach(){
        driver.quit();
    }


    @Test
    @DisplayName("Create New Item.")
    public void createNewItemEntry() throws InterruptedException {
        numberOfEntries = mainPage.countNumberOfEntries();
        mainPage.addNewEntry();
        Assertions.assertEquals(numberOfEntries+1, mainPage.countNumberOfEntries());

    }

    @Test
    @DisplayName("Edit First Item Text.")
    public void editFirstItemText() throws InterruptedException{
        mainPage.editFirstItemText();
        Assertions.assertTrue(mainPage.hasFirstEntryTextBeenEdited());
    }

    @Test
    @DisplayName("Create entry and Delete same entry.")
    public void createAndDeleteEntry() throws InterruptedException {
        numberOfEntries = mainPage.countNumberOfEntries();
        mainPage.createAndDeleteItem();
        Assertions.assertEquals(numberOfEntries, mainPage.countNumberOfEntries());
    }

    @Test
    @DisplayName("Create Item button is disabled when text > 300 characters. ")
    public void validateMaxLengthDisableButton() throws  InterruptedException{
        Assertions.assertFalse(mainPage.createButtonDisabledMaxLengthPlusOne()
                , "Button is disabled when max length is surpassed.");
    }

    @Test
    @DisplayName("Check if specific desciption exists.")
    public void checkIfDescriptionTextExists(){
        Assertions.assertTrue(mainPage.textDescriptionExist());
    }

}
