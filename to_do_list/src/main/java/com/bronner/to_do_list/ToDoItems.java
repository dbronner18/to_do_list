package com.bronner.to_do_list;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ToDoItems {
	private Configuration config = new Configuration().configure().addAnnotatedClass(ToDoItem.class);
    private SessionFactory sessionF = config.buildSessionFactory();
    private Session session = sessionF.openSession();
    private Transaction trans = null;
	
	public ToDoItems(){
	}
	
	//add item to list
	public boolean addItem (String itemDesc) {
		if (itemDesc != null) {
			ToDoItem item = new ToDoItem(itemDesc);
			trans = session.beginTransaction();
		    session.save(item);
		    trans.commit();
		    return true;
		}
		else {
			return false;
		}
	}
	
	//delete item from list
	public boolean deleteItem (int itemID) {
		if(itemID >= 1) {
			trans = session.beginTransaction();
			List items = session.createQuery("FROM com.bronner.to_do_list.ToDoItem to_do_item").list();
			trans.commit();
			for(Iterator iterator = items.iterator(); iterator.hasNext();) {
				ToDoItem item = (ToDoItem) iterator.next();
				if(item.getItemID() == itemID) {
					trans = session.beginTransaction();
				    session.remove(item);
				    trans.commit();
				    break;
				}
			}
			return true;
		}
		else {
			return false;
		}
	}
	
	//display list
	public boolean listItems() {
		trans = session.beginTransaction();
		List items = session.createQuery("FROM com.bronner.to_do_list.ToDoItem to_do_item").list();
		if(items == null) {
			return false;
		}
		for(Iterator iterator = items.iterator(); iterator.hasNext();) {
			ToDoItem item = (ToDoItem) iterator.next();
			System.out.print(item.getItemID() + " - ");
			System.out.println(item.getItemDesc());
		}
		trans.commit();
		return true;
	}
}
