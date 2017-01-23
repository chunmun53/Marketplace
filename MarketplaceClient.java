import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.*;

public class MarketplaceClient{
	Marketplace myMarket = null;
	//Gets the username and password and passes to establish connection to server
	public void getCredentials(String username, String password){
		String[] credentials = new String[2];
		credentials[0] = username;
		credentials[1] = password;
		createSession(credentials[0],credentials[1]);
	}

	//create session
	public void createSession(String username, String password)
	{
		Session session = null;
		try{
			FrontController front = new FrontController();
			Connection();
			session = myMarket.login(username, password);
			front.processLogin(session);   
		}
		catch(Exception e)
		{
			System.out.println("Client Exception:" + e.getMessage());
		}
	}

	//get items from the model to display to user
	public List browseItem(){
		List<String[]> items = new ArrayList<String[]>();
		try{
			Connection();
			items = myMarket.browseItem();
		}
		catch(Exception e)
		{
			System.out.println("Client Exception:" + e.getMessage());
		}
		return items;
	}

	//Send the purchase item data to model
	public String purchaseItem(String role, int item_index, int item_quantity){
		String message="";
		try{
			Connection();
			message = myMarket.purchaseItem(role, item_index, item_quantity);
		}
		catch(Exception e)
		{
			System.out.println("Client Exception:" + e.getMessage());
		}
		return message;
	}

	//send the new item to add data to model
	public void addItem(List<String[]> items, String role){
		try{
			Connection();
			myMarket.addItem(role,items);
		}
		catch(Exception e)
		{
			System.out.println("Client Exception:" + e.getMessage());
		}
	}

	//send the updated item to update data to model
	public void updateItem(List<String[]> items, String role){
		try{
			Connection();
			myMarket.updateItem(role,items);
		}
		catch(Exception e)
		{
			System.out.println("Client Exception:" + e.getMessage());
		}
	}

	//send the deleted item to delete data from model
	public void removeItem(List<String[]> items, String role){
		try{
			Connection();
			myMarket.removeItem(role,items);
		}
		catch(Exception e)
		{
			System.out.println("Client Exception:" + e.getMessage());
		}
	}

	//send the deleted user to delete data from model
	public void removeUser(List<String[]> items, String role){
		try{
			Connection();
			myMarket.removeUser(role,items);
		}
		catch(Exception e)
		{
			System.out.println("Client Exception:" + e.getMessage());
		}
	}

	//Connection method to establish connection to server
	public void Connection(){
		System.setSecurityManager(new SecurityManager());
		String name="//in-csci-rrpc02.cs.iupui.edu:3000/ridshah/ridshahA5";
		String message;

		try{
			myMarket = (Marketplace) Naming.lookup(name);
			System.out.println("Connection Established with Server");		    
		}
		catch(Exception e){
			System.out.println("Client Exception:" + e.getMessage());
		}		
	}
}