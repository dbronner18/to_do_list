package com.bronner.to_do_list;

import java.util.Scanner;


public class ToDoItemDriver {
	
	public static Scanner keyboard = new Scanner(System.in);

    public static void main( String[] args ){
		ToDoItems itemList = new ToDoItems();
        
		//show menu get input
		int input = Menu();
		
		//WHILE(input is not quit)
		while(input != 0) {
			//IF(user wants to Add item)
			if(input == 1) {
				itemList.addItem(getItem());
				
			}
			//ELSE IF(user wants to Delete item)
			else if(input == 2) {
				itemList.deleteItem(getItemID());
			}
			//ELSE IF(user wants to list items)
			else if(input ==3) {
				itemList.listItems();
				System.out.println();
			}
			//show menu get input
			input = Menu();
		}
		System.out.println("Thank you for using my program!!!!");
		keyboard.close();
    }
    public static int Menu() {
		int input;
		
		//Display Menu
		System.out.println("1 - Add To Do Item");
		System.out.println("2 - Delete To Do Item");
		System.out.println("3 - List To Do Items");
		System.out.println("0 - To Exit Program");
		System.out.println();
		
		//Get Input
		System.out.print("Please select an option: ");
		input = Integer.parseInt(keyboard.nextLine());
		System.out.println();
		return input;
	}
	
	public static String getItem() {
		String itemDesc;
		
		//Get item Description
		System.out.print("Enter Item Description: ");
		itemDesc = keyboard.nextLine();
		System.out.println();

		return itemDesc;
	}
	
	public static int getItemID() {
		int itemID;
		
		//Get item ID of item to be deleted
		System.out.print("Select Item ID of item you want to delete: ");
		itemID = Integer.parseInt(keyboard.nextLine());
		System.out.println();
		return itemID;
	}	
}
