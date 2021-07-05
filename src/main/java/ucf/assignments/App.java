/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Julian Espinoza
 */

package ucf.assignments;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;


public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("list.fxml"));

            Scene scene = new Scene(root);

            primaryStage.setScene(scene);
            primaryStage.setTitle("Assignment 4");
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class listManager{
    // Create todoLists HashMap variable
    // Create currentList ArrayList variable

    // Method getTodo gets a specific list based on
    // the name input
    public ArrayList<item> getTodo(String name){
        ArrayList<item> currentList = new ArrayList<item>();
        // Access needed ArrayList using name
        // as the key
        // Set currentList to the list
        // Return currentList
        return currentList;
    }

    // Method addTodo adds a new list to the
    // Map manager
    public void addTodo(String name){
        // Add a new list to the Map using
        // name as a key
    }

    // Method removeList removes the list given
    // by name from todoLists
    public void removeList(String name){
        // Remove the list specified by name from todoLists
    }

    // Method ediLists changes the title of the list
    // based on the name input
    public void editList(String nameOld, String nameNew){
        // Create new list equal to the one at name
        // Remove nameOld list
        // Add new list
    }

    // Method saveListAll saves all lists to external storage
    public void saveList(ArrayList<item> list, String name){
        // Create a new file based on name
        // Iterate through the map
        // For loop through the current list for the length of the list
        // Output each item to the newly created file
        // Close file
    }

    // Method loadList loads in a list and adds it to the map
    public void loadList(String file){
        // Open a file
        // For loop through the file until a blank line is reached
        // Add the results of each line to a new list
        // Add the list to the map using file as its key
    }
}

class list{
    // Method getItem gets a specific item from a list
    public item getItem(String number, ArrayList<item> list){
        item placeholderItem = new item("1", "2");
        // Get item from list
        // Return item
        return placeholderItem;
    }

    // Method displayAll displays all items in the list
    public void displayAll(ArrayList<item> list){
        // For loop through the list for the length of the list
        // Print all items completely in a grid format
        // using getting functions
        // end loop
    }

    // Method display incomplete displays all incomplete items
    public void displayIncomplete(ArrayList<item> list){
        // For loop through the list for the length of the list
        // If item status is incomplete, print item
        // end loop
    }

    // Method display complete displays all incomplete items
    public void displayComplete(ArrayList<item> list){
        // For loop through the list for the length of the list
        // If item status is Complete, print item
        // end loop
    }

    // Method saveList saves a list to external storage
    public void saveList(ArrayList<item> list, String name){
        // Create a new file based on name
        // For loop through the list for the length of the list
        // Output each item to the newly created file
        // Close file
    }

}

class item{
    // Create private variables "description," "dueDate," and "status"
    public item(String des, String due){
        // Set description, dueDate, and status using
        // des, due, and "incomplete" respectively
    }

    // Method editDescription edits item descriptions
    public void editDescription(String newDescription){
        // Set description to new description
    }

    // Method editDescription edits item descriptions
    public void editDate(String newDate){
        // Set date to newDate
    }

    // Method completion changes status to "complete"
    public void completion(){
        // Set status to "complete"
    }

    // Method getDescription returns description
    public String getDescription(){
        // Return description
        return "placeholder";
    }

    // Method getDate returns date
    public String getDate(){
        // Return date
        return "placeholder";
    }

    // Method getStatus returns status
    public String getStatus(){
        // Return status
        return "placeholder";
    }
}