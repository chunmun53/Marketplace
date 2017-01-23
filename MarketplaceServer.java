import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.lang.reflect.Proxy;
import java.sql.*;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.mysql.jdbc.Driver;

public class MarketplaceServer{
	public static Connection connectionstatement;
	public static void main(String args[]) {
		
		//Creates the server connection
		System.setSecurityManager(new SecurityManager());
		try {
			System.out.println("Creating a Marketplace Server!");
			String name = "//in-csci-rrpc02.cs.iupui.edu:3000/ridshah/ridshahA5";
			System.out.println("MarketplaceServer: binding it to name: " + name);
			
			
			//Goes to the AuthorizationInvocationHandler to authenticate method call based on user
			Marketplace assignment = (Marketplace) 
				Proxy.newProxyInstance(Marketplace.class.getClassLoader(), 
				new Class<?>[] {Marketplace.class}, 
				new AuthorizationInvocationHandler(new ServerImpl()));
						
			Naming.rebind(name, assignment);
			
			System.out.println("MarketplaceServer Ready!");

		} 
		catch (Exception e){
			System.out.println("Exception: " + e.getMessage());	
			e.printStackTrace();
		}
	}
}