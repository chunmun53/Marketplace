import java.util.Scanner;

public class AdminWelcome{	
	public void welcomePage(String role, String username){
		int menuitem;
		Scanner user_input = new Scanner(System.in); 
		System.out.println("User: "+username+", Role: "+role);
		System.out.println("Menu:\n1. Add Item\n2. Browse Item\n3. Update Item\n4. Remove Item\n5. Remove User\n6. Exit");
		System.out.println("Enter the menu item number to select: ");
		menuitem = Integer.parseInt(user_input.next());
		if (menuitem >= 1 && menuitem <= 6)
		{
			if(menuitem == 1){
			AddItem additem = new AddItem();
			additem.addItem(role, username);
			}
			else if(menuitem == 2){
				BrowseItem browseitem = new BrowseItem();
				browseitem.browseItem(role, username);
			}
			else if(menuitem == 3){
				BrowseItem browseitem = new BrowseItem();
				browseitem.browseItem(role, username);
				UpdateItem updateitem = new UpdateItem();
				updateitem.updateItem(role, username);
			}
			else if(menuitem == 4){
				BrowseItem browseitem = new BrowseItem();
				browseitem.browseItem(role, username);
				RemoveItem removeitem = new RemoveItem();
				removeitem.removeItem(role, username);
			}
			else if(menuitem == 5){
				RemoveUser removeuser = new RemoveUser();
				removeuser.removeUser(role, username);
			}
			else if(menuitem == 6){
				System.exit(0);
			}
		}
		else
		{
			System.out.println("You have unlisted menu item number");
		}
	}
}