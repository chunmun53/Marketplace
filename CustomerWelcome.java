import java.util.Scanner;

public class CustomerWelcome{	
	public void welcomePage(String role, String username){
		int menuitem;
		Scanner user_input = new Scanner(System.in); 
		System.out.println("User: "+username+", Role: "+role);
		System.out.println("Menu:\n1. Purchase Item\n2. Browse Item\n3. Exit");
		System.out.println("Enter the menu item number to select: ");
		menuitem = Integer.parseInt(user_input.next());
		if (menuitem >= 1 && menuitem <= 3)
		{
			if (menuitem == 1)
			{
				BrowseItem browseitem = new BrowseItem();
				browseitem.browseItem(role, username);
				PurchaseItems purchaseitem = new PurchaseItems();
				purchaseitem.displayItems(role, username);
			}
			else if(menuitem == 2){
				BrowseItem browseitem = new BrowseItem();
				browseitem.browseItem(role, username);
			}
			else if(menuitem == 3){
				System.exit(0);
			}
		}
		else
		{
			System.out.println("You have unlisted menu item number");
		}
	}
}