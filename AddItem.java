import java.util.Scanner;
import java.util.*;

public class AddItem{
	List<String[]> items = new ArrayList<String[]>();
	public void addItem(String role, String username){
		String option = "1";
		Scanner user_input = new Scanner(System.in); 
		while(option.equalsIgnoreCase("1")){
		String[] item = new String[4];
		System.out.println("Enter item name: ");
		item[0] = user_input.nextLine();
		System.out.println("Enter item description: ");
		item[1] = user_input.nextLine();
		System.out.println("Enter item quantity: ");
		item[2] = user_input.nextLine();
		System.out.println("Enter item price: ");
		item[3] = user_input.nextLine();
		items.add(item);
		System.out.println("Enter 1 to continue adding items or 0 to exit");
		option = user_input.nextLine();
		}
		FrontController frontcontroller = new FrontController();
		frontcontroller.addItem(items,role);
		AdminWelcome aw = new AdminWelcome();
		aw.welcomePage(role, username);
	}
}