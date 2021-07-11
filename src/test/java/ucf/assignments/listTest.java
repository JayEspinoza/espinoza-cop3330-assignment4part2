/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 first_name last_name
 */

package ucf.assignments;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class listTest {

    @Test
    void displayAll() {
        // Create new list object
        list testList = new list();
        // Create new Items
        item a = new item("1", "2002-02-20");
        // Populate ArrayList
        testList.getTodo().add(a);
        // Call displayAll
        String testString = testList.displayAll(testList.getTodo());
        // Assert that displayAll returns the expected output
        assertEquals(String.format("%.261s %.15s %s\n", testList.getTodo().get(0).getDescription(), testList.getTodo().get(0).getDate(), testList.getTodo().get(0).getStatus()), testString);
    }

    @Test
    void displayIncomplete() {
        // Create new list object
        list testList = new list();
        // Create new Items
        item a = new item("1", "2002-02-20");
        // Populate ArrayList
        testList.getTodo().add(a);
        // Call displayIncomplete
        String testString = testList.displayIncomplete(testList.getTodo());
        // Assert that Incomplete returns the expected output
        assertEquals(String.format("%.261s %.15s %s\n", testList.getTodo().get(0).getDescription(), testList.getTodo().get(0).getDate(), testList.getTodo().get(0).getStatus()), testString);
    }

    @Test
    void displayComplete() {
        // Create new list object
        list testList = new list();
        // Create new Items
        item a = new item("1", "2002-02-20");
        // Populate ArrayList
        testList.getTodo().add(a);
        testList.getTodo().get(0).completion();
        // Call displayComplete
        String testString = testList.displayComplete(testList.getTodo());
        // Assert that displayComplete returns the expected output
        assertEquals(String.format("%.261s %.15s %s\n", testList.getTodo().get(0).getDescription(), testList.getTodo().get(0).getDate(), testList.getTodo().get(0).getStatus()), testString);
    }

    @Test
    void saveList() {
        // Create new list object
        list testList = new list();
        // Create new Items
        item a = new item("1", "2002-02-20");
        // Populate ArrayList
        testList.getTodo().add(a);
        // Call saveList
        File testFile = new File("testFile.txt");
        testList.saveList(testList.getTodo(), testFile);
        // Assert that the list has been created
        try {
            FileWriter newFile = new FileWriter(testFile);
            newFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void addItem() {
        // Create new list object
        list testList = new list();
        // Create new Items
        item a = new item("1", "2002-02-20");
        // Populate ArrayList
        testList.getTodo().add(a);
        // Call addItem
        testList.addItem(testList.getTodo(),"2", "2002-02-20");
        // Assert that the item has been added
        assertEquals("2", testList.getTodo().get(1).getDescription());
    }

    @Test
    void removeItem() {
        // Create new list object
        list testList = new list();
        // Create new Items
        item a = new item("1", "2002-02-20");
        // Populate ArrayList
        testList.getTodo().add(a);
        // Call addItem
        testList.addItem(testList.getTodo(),"2", "2002-02-20");
        // Call removeItem
        testList.removeItem(testList.getTodo(), "2");
        // Assert that the item has been removed
        assertEquals(1, testList.getTodo().size());
    }

    @Test
    void clearList() {
        // Create new list object
        list testList = new list();
        // Create new Items
        item a = new item("1", "2002-02-20");
        // Populate ArrayList
        testList.getTodo().add(a);
        // Call clearList
        testList.clearList(testList.getTodo());
        // Assert that all items have been removed
        assertEquals(0, testList.getTodo().size());
    }
}