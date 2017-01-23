import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.io.Serializable;
import java.util.*;
import java.sql.*;

public class ServerImpl implements Marketplace, Serializable{
	//All the server methods are implemented here
	public ServerImpl() throws java.rmi.RemoteException
	{
	}

	public Session login(String username,String password)
	{
		Session session;
		MarketplaceModel model = new MarketplaceModel();
		session = model.login(username,password);
		return session;
	}

	public List browseItem()
	{
		List<String[]> items = new ArrayList<String[]>();
		MarketplaceModel model = new MarketplaceModel();
		items = model.browseItem();
		return items;
	}

	public String purchaseItem(String role, int item_index, int item_quantity)
	{
		MarketplaceModel model = new MarketplaceModel();
		String message = model.purchaseItem(item_index, item_quantity);
		return message;
	}

	public void addItem(String role, List<String[]> items)
	{
		MarketplaceModel model = new MarketplaceModel();
		model.addItem(items);
	}

	public void updateItem(String role, List<String[]> items)
	{
		MarketplaceModel model = new MarketplaceModel();
		model.updateItem(items);
	}

	public void removeItem(String role, List<String[]> items)
	{
		MarketplaceModel model = new MarketplaceModel();
		model.removeItem(items);
	}

	public void removeUser(String role, List<String[]> items)
	{
		MarketplaceModel model = new MarketplaceModel();
		model.removeUser(items);
	}
}