/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 first_name last_name
 */

package ucf.assignments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class itemTest {

    @Test
    void editDescription() {
        // Create new item object
        item testItem = new item("Hello", "2002-02-21");
        // Call editDescription
        testItem.editDescription("Helloz");
        // Assert that item description is "Helloz"
        assertEquals("Helloz", testItem.getDescription());
    }

    @Test
    void editDate() {
        // Create new item object
        item testItem = new item("Hello", "2002-02-21");
        // Call editDate
        testItem.editDate("2002-02-24");
        // Assert that item date is "2002-02-24"
        assertEquals("2002-02-24", testItem.getDate());
    }

    @Test
    void completion() {
        // Create new item object
        item testItem = new item("Hello", "2002-02-21");
        // Call completion
        testItem.completion();
        // Assert that status is "Complete"
        assertEquals("Complete", testItem.getStatus());
    }
}