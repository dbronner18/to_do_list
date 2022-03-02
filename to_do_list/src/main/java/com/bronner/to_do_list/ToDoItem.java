package com.bronner.to_do_list;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="to_do_item")
public class ToDoItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "itemID")
	private int itemID;
	
	@Column(name="description")
	private String itemDesc;
	
	public ToDoItem() {
		
	}
	
	//create an item
	public ToDoItem(String itemDesc){
		//this.itemID = itemID;
		this.itemDesc = itemDesc;
	}

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
}
