import java.util.Scanner;
import java.util.*;

public class RemoveUser{
	List<String[]> items = new ArrayList<String[]>();
	public void removeUser(String role, String username){
		String option = "1";
		Scanner user_input = new Scanner(System.in); 
		while(option.equalsIgnoreCase("1")){
		String[] item = new String[1];
		System.out.println("Enter the id of user you wish to remove: ");
		item[0] = user_input.nextLine();
		items.add(item);
		System.out.println("Enter 1 to continue adding items or 0 to exit");
		option = user_input.nextLine();
		}
		FrontController frontcontroller = new FrontController();
		frontcontroller.removeUser(items,role);
		AdminWelcome aw = new AdminWelcome();
		aw.welcomePage(role, username);
	}
}