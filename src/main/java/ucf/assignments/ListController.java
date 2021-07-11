/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Julian Espinoza
 */


package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.ScrollEvent;
import javafx.concurrent.Task;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ListController {
    list myList = new list();
    String ui = "";

    @FXML
    public TextField userInput;

    @FXML
    private TextArea textArea;

    @FXML
    public void loadListClick(ActionEvent actionEvent) {
        // Prompt the user for the file name
        TextInputDialog dialog = new TextInputDialog("list");

        dialog.setTitle("Load List");
        dialog.setHeaderText("What is the name of the file? (I.E name.txt)");
        dialog.setContentText("Name:");

        ui = dialog.showAndWait().get();

        // Utilize the file output to load the list
        myList.loadList(ui, myList.getTodo());
        textArea.setText(myList.displayAll(myList.getTodo()));
    }

    @FXML
    public void addItemClick(ActionEvent actionEvent) {
        // Prompt user for item parameters
        String ui1, ui2;
        ui1 = "";
        ui2 = "1";

        TextInputDialog dialog = new TextInputDialog("list");

        dialog.setTitle("Item Description");
        dialog.setHeaderText("Enter an item description.");
        dialog.setContentText("Description:");

        while(!(ui1.length() > 0 && ui1.length() < 257)) {
            ui1 = dialog.showAndWait().get();
        }

        dialog.setTitle("Item Date");
        dialog.setHeaderText("Enter an item date (YYYY-MM-DD).");
        dialog.setContentText("Date:");

        while(!myList.validateDate(ui2)){
            ui2 = dialog.showAndWait().get();
        }

        // Create new item and add the item to the list
        myList.addItem(myList.getTodo(), ui1, ui2);
        textArea.setText(myList.displayAll(myList.getTodo()));
    }

    @FXML
    public void printCompClick(ActionEvent actionEvent) {
        textArea.setText(myList.displayComplete(myList.getTodo()));
    }

    @FXML
    public void saveListClick(ActionEvent actionEvent) {
        // Prompt the user for the file name
        TextInputDialog dialog = new TextInputDialog("list");

        dialog.setTitle("File Name");
        dialog.setHeaderText("What is the name of the file? (I.E name.txt)");
        dialog.setContentText("Name:");

        // Open a file
        File newFile = new File(dialog.showAndWait().get());
        // Write the list to the file
        myList.saveList(myList.getTodo(), newFile);
    }

    @FXML
    public void removeItemClick(ActionEvent actionEvent) {
        // Prompt the user for the item
        TextInputDialog dialog = new TextInputDialog("list");

        dialog.setTitle("Item Description");
        dialog.setHeaderText("Enter the item you want to remove.");
        dialog.setContentText("Description:");

        // Remove the item from the list
        myList.removeItem(myList.getTodo(), dialog.showAndWait().get());
        textArea.setText(myList.displayAll(myList.getTodo()));
    }

    @FXML
    public void printIncompClick(ActionEvent actionEvent) {
        // Output the list to the text area
        textArea.setText(myList.displayIncomplete(myList.getTodo()));
    }


    @FXML
    public void completeItemClick(ActionEvent actionEvent) {
        // Prompt user for item
        TextInputDialog dialog = new TextInputDialog("list");

        dialog.setTitle("Item Description");
        dialog.setHeaderText("Enter the item you want to complete.");
        dialog.setContentText("Item:");

        // Change item status to complete
        myList.getItem(dialog.showAndWait().get(), myList.getTodo()).completion();
        textArea.setText(myList.displayAll(myList.getTodo()));
    }

    @FXML
    public void printAllClick(ActionEvent actionEvent) {
        // Output the list to the text area
        textArea.setText(myList.displayAll(myList.getTodo()));
    }

    public void editDescriptionClick(ActionEvent actionEvent) {
        // Prompt user for item
        TextInputDialog dialog = new TextInputDialog("list");

        dialog.setTitle("Item Description");
        dialog.setHeaderText("Enter the item you want to change.");
        dialog.setContentText("Item:");
        String editItem = dialog.showAndWait().get();

        // Prompt user for new Description
        dialog.setTitle("Item Description");
        dialog.setHeaderText("Enter the new description.");
        dialog.setContentText("Item:");
        // Change item description
        myList.getItem(editItem, myList.getTodo()).editDescription(dialog.showAndWait().get());
        textArea.setText(myList.displayAll(myList.getTodo()));
    }


    public void editDateClick(ActionEvent actionEvent) {
        String newDate = "";
        // Prompt user for item
        TextInputDialog dialog = new TextInputDialog("list");

        dialog.setTitle("Item Description");
        dialog.setHeaderText("Enter the item you want to change.");
        dialog.setContentText("Item:");
        String editItem = dialog.showAndWait().get();

        // Prompt user for new date
        dialog.setTitle("Item Date");
        dialog.setHeaderText("Enter the new date.");
        dialog.setContentText("Date:");

        while(!myList.validateDate(newDate)){
            newDate = dialog.showAndWait().get();
        }
        // Change item description
        myList.getItem(editItem, myList.getTodo()).editDate(newDate);
        textArea.setText(myList.displayAll(myList.getTodo()));
    }

    public void clearListClick(ActionEvent actionEvent) {
        myList.clearList(myList.getTodo());
        textArea.setText(myList.displayAll(myList.getTodo()));
    }
}
