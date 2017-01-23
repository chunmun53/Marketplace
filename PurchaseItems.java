import java.util.*;
public class PurchaseItems{
	//Method to display items and get item number to purchase. Implementation of this method will change when database is used.
	public void displayItems(String role, String username){
		String option = "1";
		while(option.equalsIgnoreCase("1"))
		{
			Scanner user_input = new Scanner(System.in);
			int i=0;
			int item_sno;
			int item_quantity;
			FrontController frontcontroller = new FrontController();
			System.out.println("Enter item_id to purchase item: ");
			item_sno = Integer.parseInt(user_input.nextLine());
			System.out.println("Enter the quantity: ");
			item_quantity = Integer.parseInt(user_input.nextLine());		
			int item_index = item_sno;
			String message = frontcontroller.purchaseItem(role, item_index, item_quantity);
			System.out.println(message);
			
			System.out.println("\nEnter 1 to continue purchasing items or 0 to exit");
			option = user_input.nextLine();
		}
		CustomerWelcome cw = new CustomerWelcome();
		cw.welcomePage(role,username);
	}
}