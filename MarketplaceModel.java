import java.rmi.RemoteException;
import java.io.Serializable;
import java.util.*;
import java.io.*;
import java.io.IOException;
import java.sql.*;


public class MarketplaceModel implements Serializable{
	
	private Connection dbConnect(){
		DatabaseConnect db = new DatabaseConnect();
		Connection conn = db.dbConnect();
		return conn;
	}
	
	private String[] getUser(Connection conn, String username, String password)
	{
		String[] user = new String[3];
		DatabaseConnect db = new DatabaseConnect();
		user = db.getUser(conn, username, password);
		return user;
	}
	
	private List readProducts(Connection conn){
		List<String[]> catalog = new ArrayList <String[]>();
		DatabaseConnect db = new DatabaseConnect();
		catalog = db.readProducts(conn);
		return catalog;
	}
	
	private void writeProducts(Connection conn, List catalog){
		DatabaseConnect db = new DatabaseConnect();
		db.writeProducts(conn, catalog);
	}

	private int selectProduct(Connection conn, int item_index){
		DatabaseConnect db = new DatabaseConnect();
		int item_quantity = db.selectProduct(conn, item_index);
		return item_quantity;
	}

	private void updateQuantity(Connection conn, int item_quantity, int item_index){
		DatabaseConnect db = new DatabaseConnect();
		db.updateQuantity(conn, item_quantity, item_index);
	}

	private void updateProducts(Connection conn, List catalog){
		DatabaseConnect db = new DatabaseConnect();
		db.updateProducts(conn, catalog);
	}
	
	private void deleteUser(Connection conn, List catalog){
		DatabaseConnect db = new DatabaseConnect();
		db.deleteUser(conn, catalog);
	}

	private void removeProducts(Connection conn, List catalog){
		DatabaseConnect db = new DatabaseConnect();
		db.removeProducts(conn, catalog);
	}
	
	//Implementation of login method for the customer.
	public synchronized Session login(String username, String password){
		Session session;
		session = new Session();
		String[] user = new String[3];
		try{
			Connection conn = dbConnect();
			user = getUser(conn, username, password);
			if(user != null){
				session.fullname = user[0];
				session.role = user[1];
				session.isauth = Boolean.getBoolean(user[2]);
			}
			else
			{
				session = null;
			}
			conn.close();
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		return session;
	}

	//This method is for finding items to display.
	public synchronized List browseItem(){
		List<String[]> catalog = new ArrayList <String[]>();
		try{
			Connection conn = dbConnect();
			catalog = readProducts(conn);
			conn.close();
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		return catalog;
	}

	//Add item to database
	public synchronized void addItem(List<String[]> items){
		List<String[]> catalog = new ArrayList <String[]>();
		catalog.addAll(items);
		try{
			Connection conn = dbConnect();
			writeProducts(conn, catalog);
			catalog.clear();
			conn.close();
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
	}
	
	//Purchase Item
	public synchronized String purchaseItem(int item_index, int item_quan){
		String message = null;
		try{
			Connection conn = dbConnect();
			int item_quantity = selectProduct(conn, item_index);
			item_quantity=item_quantity-item_quan;
			if(item_quantity >= 0)
			{
				updateQuantity(conn, item_quantity, item_index);
				message = "\nProduct purchase successful!!";
			}
			else
			{
				message = "\nSorry not enough product left!!";
			}
			conn.close();
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		return message;
	}
	
	//Update Item to database
	public synchronized void updateItem(List<String[]> items){
		List<String[]> catalog = new ArrayList <String[]>();
		catalog.addAll(items);
		try{
			Connection conn = dbConnect();
			updateProducts(conn, catalog);
			catalog.clear();
			conn.close();
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
	}
	
	//Remove item from database
	public synchronized void removeItem(List<String[]> items){
		List<String[]> catalog = new ArrayList <String[]>();
		catalog.addAll(items);	
		try{
			Connection conn = dbConnect();
			removeProducts(conn, catalog);
			catalog.clear();
			conn.close();
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
	}
	
	//Remove user from database
	public synchronized void removeUser(List<String[]> items){
		List<String[]> catalog = new ArrayList <String[]>();
		catalog.addAll(items);
		
		try{
			Connection conn = dbConnect();
			deleteUser(conn, catalog);
			catalog.clear();
			conn.close();
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
	}	
}