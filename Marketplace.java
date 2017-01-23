import java.util.*;

public interface Marketplace extends java.rmi.Remote {
	
	public Session login(String username,String password);
	
	public List browseItem();
	
	@RequiresRole("Customer")
	public String purchaseItem(String role, int item_index, int item_quantity);
	
	@RequiresRole("Admin")
	public void addItem(String role, List<String[]> items);
	
	@RequiresRole("Admin")
	public void updateItem(String role, List<String[]> items);
	
	@RequiresRole("Admin")
	public void removeItem(String role, List<String[]> items);
	
	@RequiresRole("Admin")
	public void removeUser(String role, List<String[]> items);
}