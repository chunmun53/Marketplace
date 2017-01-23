import java.util.Scanner;
import java.util.*;

public class UpdateItem{
	List<String[]> items = new ArrayList<String[]>();
	public void updateItem(String role, String username){
		String option = "1";
		Scanner user_input = new Scanner(System.in); 
		while(option.equalsIgnoreCase("1")){
		String[] item = new String[5];
		System.out.println("Enter item id you wish to update: ");
		item[0] = user_input.nextLine();
		System.out.println("Enter updated item name: ");
		item[1] = user_input.nextLine();
		System.out.println("Enter updated item description: ");
		item[2] = user_input.nextLine();
		System.out.println("Enter updated item quantity: ");
		item[3] = user_input.nextLine();
		System.out.println("Enter updated item price: ");
		item[4] = user_input.nextLine();
		items.add(item);
		System.out.println("Enter 1 to continue adding items or 0 to exit");
		option = user_input.nextLine();
		}
		FrontController frontcontroller = new FrontController();
		frontcontroller.updateItem(items,role);
		AdminWelcome aw = new AdminWelcome();
		aw.welcomePage(role, username);
	}
}