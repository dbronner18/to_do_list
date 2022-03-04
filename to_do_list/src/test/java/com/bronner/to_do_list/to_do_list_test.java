package com.bronner.to_do_list;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import junit.framework.TestCase;

@TestInstance(Lifecycle.PER_CLASS)
public class to_do_list_test extends TestCase {
	ToDoItems items;
	ToDoItem item = new ToDoItem("JUnit Test");
	
	@BeforeAll
	public void startUp(){
		System.out.println("Starting Tests");
	}
	
	@BeforeEach
	public void setup() {
		items = new ToDoItems();
	}
	
	@Test
	@DisplayName("Add Item Test")
	public void testAddItem() {
		Assertions.assertEquals(true, items.addItem("JUnit Add Item Test"));
		Assertions.assertFalse(items.addItem(null));
	}
	
	@Test
	@DisplayName("Delete Item Test")
	public void testDeleteItem() {
		Assertions.assertFalse(items.deleteItem(-1));
	}
	
	@Test
	@DisplayName("Show Items Test")
	public void testShowItems() {
		Assertions.assertTrue(items.listItems());
	}
	
	@Test
	@DisplayName("Get Desc Test")
	public void getItemDescTest() {
		Assertions.assertEquals("JUnit Test", item.getItemDesc());
	}
	
	@AfterEach
	public void endTest() {
		System.out.println("Test Passed");
	}
	
	@AfterAll
	public void endTesting() {
		System.out.println("Testing Complete");
	}
}
