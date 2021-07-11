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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


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

class list{
    ArrayList<item> todoList = new ArrayList<>();

    // Method getItem gets a specific item from a list
    public item getItem(String name, ArrayList<item> list){
        item placeHolder = new item("1aJ", "2002-02-20");
        // Get item from list by loop
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getDescription().equals(name)){
                return list.get(i);
            }
        }
        // Return item
        return list.get(0);
    }

    // Method displayAll displays all items in the list
    public String displayAll(ArrayList<item> list){
        String returnString = "";
        // For loop through the list for the length of the list
        for(int i = 0; i < list.size(); i++) {
            // Store all items completely in a grid format string
            // using getter functions
            returnString += String.format("%.261s %.15s %s\n", list.get(i).getDescription(), list.get(i).getDate(), list.get(i).getStatus());
        }
        // end loop
        return returnString;
    }

    // Method display incomplete displays all incomplete items
    public String displayIncomplete(ArrayList<item> list){
        String returnString = "";
        // For loop through the list for the length of the list
        for(int i = 0; i < list.size(); i++) {
            // If item status is incomplete, store item in string
            if(list.get(i).getStatus().equals("Incomplete"))
                returnString += String.format("%.261s %.15s %s\n", list.get(i).getDescription(), list.get(i).getDate(), list.get(i).getStatus());
        }
        // end loop
        return returnString;
    }

    // Method displayComplete displays all incomplete items
    public String displayComplete(ArrayList<item> list){
        String returnString = "";
        // For loop through the list for the length of the list
        for(int i = 0; i < list.size(); i++){
            // If item status is Complete, store item in String
            if(list.get(i).getStatus().equals("Complete"))
                returnString += String.format("%.261s %.15s %s\n", list.get(i).getDescription(), list.get(i).getDate(), list.get(i).getStatus());
        }
        // end loop
        return returnString;
    }

    // Method saveList saves a list to external storage
    public void saveList(ArrayList<item> list, File file){
        // Create a new scanner based on name
        try {
            FileWriter writer = new FileWriter(file);
            // For loop through the list for the length of the list
            for(int i = 0; i < list.size(); i++){
                // Output each item to the newly created file
                writer.write(list.get(i).getDescription() + "\n");
                writer.write(list.get(i).getDate() + "\n");
                writer.write(list.get(i).getStatus() + "\n");
            }
            // Close file
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // Method addItem adds an item to a specific list
    public void addItem(ArrayList<item> list, String description, String date){
        // Create new item
        item newItem = new item(description, date);
        // Add item to the list
        list.add(newItem);
    }

    // Method removeItem removes an item from a specific list
    public void removeItem(ArrayList<item> list, String name){
        // Remove item specified by name from the list
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getDescription().equals(name)){
                list.remove(i);
                return;
            }
        }
    }

    // Method getTodo returns an Array List
    public ArrayList<item> getTodo(){
        return todoList;
    }

    // Method loadList loads in a list and adds it to the map
    public void loadList(String file, ArrayList<item> itemList){
        clearList(itemList);
        // Open a file
        int i = 1;
        item fill = new item("1", "2002-02-20");;
        File loadedFile = new File(file);
        try {
            Scanner reader = new Scanner(loadedFile);
            // While loop through the file until a blank line is reached
            while(reader.hasNextLine()) {
                // Add the results of each line to the list
                if(i % 3 == 0){
                    fill.editStat(reader.nextLine());
                    itemList.add(fill);
                    fill = new item("1", "2002-02-20");
                    i = 1;
                }else if(i % 2 == 0 && i % 4 != 0){
                    fill.editDate(reader.nextLine());
                    i++;
                }else{
                    fill.editDescription(reader.nextLine());
                    i++;
                }

            }

            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    // Method validateDate checks to see if a date is
    // valid according to YYYY-MM-DD
    public boolean validateDate(String date){
        // Split date into an array
        String [] seperatedDate = date.split("-");

        // Check to see if the array is the right size
        if (seperatedDate.length != 3)
            return false;

        // Check validity at each index
        try{
            if(Integer.parseInt(seperatedDate[0]) < 1000)
                return false;
            if(Integer.parseInt(seperatedDate[1]) > 12 || Integer.parseInt(seperatedDate[1]) < 1)
                return false;

            if((Integer.parseInt(seperatedDate[2]) > 28 || Integer.parseInt(seperatedDate[2]) < 1) && Integer.parseInt(seperatedDate[1]) == 2)
                return false;
            else if((Integer.parseInt(seperatedDate[2]) > 30 || Integer.parseInt(seperatedDate[2]) < 1) && (Integer.parseInt(seperatedDate[1]) == 4 || Integer.parseInt(seperatedDate[1]) ==  6 || Integer.parseInt(seperatedDate[1]) == 9))
                return false;
            else if((Integer.parseInt(seperatedDate[2]) > 30 || Integer.parseInt(seperatedDate[2]) < 1))
                return false;

        }
        catch(NumberFormatException exception){
            exception.printStackTrace();
            return false;
        }

        return true;
    }

    // Method clearList removes all items from the list
    public void clearList(ArrayList<item> list){
        list.clear();
    }
}

class item{
    // Create private variables "description," "dueDate," and "status"
    private String description, dueDate, status;
    public item(String des, String due){
        // Set description, dueDate, and status using
        description = des;
        dueDate = due;
        status = "Incomplete";
        // des, due, and "incomplete" respectively
    }

    // Method editDescription edits item descriptions
    public void editDescription(String newDescription){
        // Set description to new description
        description = newDescription;
    }

    // Method editDate edits item dates
    public void editDate(String newDate){
        // Set dueDate to newDate
        dueDate = newDate;
    }

    // Method completion changes status to "complete"
    public void completion(){
        // Set status to "complete"
        status = "Complete";
    }

    // Method editStat edits item status
    public void editStat(String newStat){
        // Set status to newStat
        status = newStat;
    }

    // Method getDescription returns description
    public String getDescription(){
        // Return description
        return description;
    }

    // Method getDate returns date
    public String getDate(){
        // Return dueDate
        return dueDate;
    }

    // Method getStatus returns status
    public String getStatus(){
        // Return status
        return status;
    }
}