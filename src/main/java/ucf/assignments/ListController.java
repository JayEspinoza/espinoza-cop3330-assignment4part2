package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.input.ScrollEvent;

public class ListController {
    private TextArea textArea;

    @FXML
    public String userInputEntered(ActionEvent actionEvent) {
        // Return user input as a string
        return "Hello";
    }

    @FXML
    public void textAreaScroll(ScrollEvent scrollEvent) {
        // Allow the user to move the window
        // To see printed contents
    }

    @FXML
    public void addListClick(ActionEvent actionEvent) {
        // Prompt user for list information
        // Create list with the specified parameters
        // Add the list to the map
    }

    @FXML
    public void removeListClick(ActionEvent actionEvent) {
        // Prompt user for the list name
        // Remove the list from the map
    }

    @FXML
    public void loadListClick(ActionEvent actionEvent) {
        // Prompt the user to select single or multi mode
        // Prompt the user for the file name
        // Utilize the file output to load the list
        // Add the list(s) to the map
    }

    @FXML
    public void saveAllClick(ActionEvent actionEvent) {
        // Prompt the user for the file name
        // Translate all lists to a readable format
        // Output the lists to the file
    }

    @FXML
    public void editListClick(ActionEvent actionEvent) {
        // Prompt user for the list to be changed
        // Prompt user for the new name
        // Create copy of the original list with a new name
        // Add the new list to the map
        // Replace the old list
    }

    @FXML
    public void addItemClick(ActionEvent actionEvent) {
        // Create a new item
        // Prompt user for item parameters and the list to add
        // the item to
        // Add the item to the list
    }

    @FXML
    public void printCompClick(ActionEvent actionEvent) {
        // Prompt the user for the list they want to print
        // Output the list to the text area
    }

    @FXML
    public void saveListClick(ActionEvent actionEvent) {
        // Prompt the user for the list they want to save
        // Prompt the user for the file name
        // Open a file
        // Write the list to the file
    }

    @FXML
    public void removeItemClick(ActionEvent actionEvent) {
        // Prompt the user for the item and the list
        // the item resides in
        // Remove the item from the list
    }

    @FXML
    public void printIncompClick(ActionEvent actionEvent) {
        // Prompt the user for the list they want to print
        // Output the list to the text area
    }

    @FXML
    public void editItemClick(ActionEvent actionEvent) {
        // Prompt the user for the item they want to change
        // and the list it resides in.
        // Prompt user for edit
        // Edit the item
    }

    @FXML
    public void completeItemClick(ActionEvent actionEvent) {
        // Prompt user for item and list
        // Change item status to complete
    }

    @FXML
    public void printAllClick(ActionEvent actionEvent) {
        // Prompt the user for the list they want to print
        // Output the list to the text area
    }
}
