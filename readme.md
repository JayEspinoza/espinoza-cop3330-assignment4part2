# Assignment 4 
The purpose of this program is to store and hold todo lists which contain items. 
The items themselves consist of 3 parts, the description, which also counts as the 
name of the item, a date according to a YYYY-MM-DD format, and the status, which is 
set to either "Complete" or "Incomplete."

# User Interface

The user interface consists of an output screen bounded by two columns of commands. 
These commands will be used to interact with the list and the items within. The left
 column is for item-specific commands while the right column is for commands that affect 
the entire list. The following documentation will explain the commands and how to use them.

## Item Commands

### Add Item

The Add Item button prompts the user to input the description of the item that they want to add, 
followed by a prompt asking for the date in a YYYY-MM-DD format. The description must be between 
1 to 256 characters long. The screen is then updated to display the new item.

### Remove Item

The Remove Item button prompts the user to input the description of the item that they want to 
remove. The item is then removed and the screen is updated.

### Edit Description

The Edit Description button prompts the user input the description of the item that they want to edit 
followed by another prompt asking for the new description. The description is updated along with the screen.

### Edit Date

The Edit Date button prompts the user to input the description of the item that they want to edit 
followed by another prompt asking for the new date. The date is updated along with the screen.

## List Commands

### Show All

The Show All button displays all items in the list to the screen.

### Show Incomplete

The Show Incomplete button displays all items in the list with the status "Incomplete" to the screen.

### Show Complete

The Show Complete button displays all items in the list with the status "Complete" to the screen.

### Save List

The Save List button prompts the user for a file name. The current list is then saved and exported in a 
file with the name.


### Load List

The Load List button prompts the user for a file name. The file is the opened and the list is loaded into the 
program, overwriting the previously contained list.

### Clear List

The Clear List button removes all items in the currently loaded list.

# Special Dedication

Special Thanks to Rey.