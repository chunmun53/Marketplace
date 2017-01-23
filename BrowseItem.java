import java.util.Scanner;
import java.util.*;

public class BrowseItem{
	List<String[]> items = new ArrayList<String[]>();
	public void browseItem(String role, String username){
		List<String[]> items = new ArrayList<String[]>();
		FrontController frontcontroller = new FrontController();
		items = frontcontroller.browseItem();
		Iterator<String[]> iterator = items.iterator();
		System.out.println("\nItem_ID	Item	Description	Quantity	Price");
		while(iterator.hasNext())
		{
			String[] element = (String[]) iterator.next();
			System.out.println(element[0]+"	"+element[1]+"	"+element[2]+"	"+element[3]+"	"+element[4]);
		}
	}
}