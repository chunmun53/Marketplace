import java.util.*;

public class FrontController{
	private Dispatcher dispatcher;
	private Session session;

	public FrontController() {
		dispatcher = new Dispatcher();
		session = new Session();
	}

	//Takes credentials from user and passes to client controller
	public void getCredentials(String username, String password){
		MarketplaceClient client = new MarketplaceClient();
		client.getCredentials(username, password);
	}

	//Method to send new item data to client
	public void addItem(List<String[]> items, String role){
		MarketplaceClient client = new MarketplaceClient();
		client.addItem(items,role);
	}

	//Method to send update item data to client
	public void updateItem(List<String[]> items, String role){
		MarketplaceClient client = new MarketplaceClient();
		client.updateItem(items,role);
	}

	//Method to send deleted item data to client
	public void removeItem(List<String[]> items, String role){
		MarketplaceClient client = new MarketplaceClient();
		client.removeItem(items,role);
	}

	//Method to send deleted user data to client
	public void removeUser(List<String[]> items, String role){
		MarketplaceClient client = new MarketplaceClient();
		client.removeUser(items,role);
	}

	//Method to get items list from client
	public List browseItem(){
		List <String[]> items = new ArrayList<String[]>();
		MarketplaceClient client = new MarketplaceClient();
		items = client.browseItem();
		return items;
	}

	//Method to send purchased item information to client
	public String purchaseItem(String role, int item_index, int item_quantity){
		MarketplaceClient client = new MarketplaceClient();
		String message = client.purchaseItem(role, item_index, item_quantity);
		return message;
	}

	//Process login for checking valid credentials
	public void processLogin(Session session){
		if(session == null){
			failedAuthentication();
			System.exit(0);
		}
		else
		{
			authenticate(session);
		}
	}

	//Authenticate user based on session
	public void authenticate(Session session){	
		dispatchRequest(session);
	}

	//Dispatches request to the correct user controller
	public void dispatchRequest(Session session) {		
		dispatcher.dispatch(session);
	}

	//Incase the authentication fails this method returns to the login view stating the login failed
	public void failedAuthentication(){
		LoginView view = new LoginView();
		view.invalidUser();
	}
}