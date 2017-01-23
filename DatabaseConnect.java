import java.rmi.RemoteException;
import java.io.Serializable;
import java.util.*;
import java.io.*;
import java.io.IOException;
import java.sql.*;

public class DatabaseConnect{

	public Connection dbConnect() 
	{
		Connection conn = null;
		String hostname = "in-csci-rrpc01.cs.iupui.edu:3306"; 
		String dbName = "ridshah_db";
		String url = "jdbc:mysql://" + hostname + "/" + dbName; 
		String username = "ridshah"; 
		String password = "ridshah";
		System.out.println("Connecting database..."); 

		try 
		{
			conn = (Connection) DriverManager.getConnection(url, username, password);
			System.out.println("Database connected!");
		} 
		catch (SQLException e) 
		{     
			throw new IllegalStateException("Cannot connect the database!",e);
		}
		return conn;
	}	

	public List readProducts(Connection conn){
		List<String[]> catalog = new ArrayList <String[]>();

		if(conn != null) 
		{
			Statement stmt = null; 
			ResultSet rs = null;
			try 
			{
				stmt = (Statement) conn.createStatement(); 

				try 
				{
					rs = stmt.executeQuery( "SELECT * FROM products" );
					if (!rs.isBeforeFirst() ) {    
						System.out.println("No products found"); 
					} 
					else{
						while (rs.next())  
						{
							String[] items = new String[5];

							items[0] = String.valueOf(rs.getInt("product_id"));
							items[1] = rs.getString("product_name"); 
							items[2] = rs.getString("description"); 
							items[3] = String.valueOf(rs.getInt("quantity")); 
							items[4] = String.valueOf(rs.getInt("price"));
							catalog.add(items);
						}
					}
				} 
				catch (SQLException e) 
				{
					System.err.println("Unable execute query!"); 
					e.printStackTrace();
				} 
				stmt.close();
			} 
			catch (SQLException e1) 
			{
				System.err.println("Unable to create SQL statement!"); 
				e1.printStackTrace();
			}
		}
		return catalog;
	}

	public void writeProducts(Connection conn, List<String[]> catalog){
		if(conn != null) 
		{
			Statement stmt = null; 
			try 
			{
				stmt = (Statement) conn.createStatement();
				try{
					Iterator<String[]> it = catalog.iterator();
					while(it.hasNext())
					{
						String[] element = (String[]) it.next();
						System.out.println(element[0]+"	"+element[1]+"	"+element[2]+"	"+element[3]);
						stmt.executeUpdate("INSERT INTO products(`product_name`,`description`,`quantity`,`price`) "
								+ "VALUES ('"+element[0]+"','"+element[1]+"','"+element[2]+"','"+element[3]+"')");
					}
				}
				catch(SQLException e3){
					System.err.println("Unable to update SQL statement!"); 
					e3.printStackTrace();
					System.exit(1);
				}

				stmt.close();
			} 
			catch (SQLException e1) 
			{
				System.err.println("Unable to create SQL statement!"); 
				e1.printStackTrace();
				System.exit(1);
			}
		}
	}

	public void updateProducts(Connection conn, List<String[]> catalog){
		if(conn != null) 
		{
			Statement stmt = null; 
			try 
			{
				stmt = (Statement) conn.createStatement();
				try{
					Iterator<String[]> it = catalog.iterator();
					while(it.hasNext())
					{
						String[] element = (String[]) it.next();
						System.out.println(element[1]+"	"+element[2]+"	"+element[3]+"	"+element[4]);
						stmt.executeUpdate("UPDATE `products` SET `product_name`='"+element[1]+"',`quantity`='"+element[3]+"',"
								+ "`price`='"+element[4]+"',`description`='"+element[2]+"' WHERE `product_id`='"+element[0]+"'");
					}
				}
				catch(SQLException e3){
					System.err.println("Unable to update SQL statement!"); 
					e3.printStackTrace();
					System.exit(1);
				}

				stmt.close();
			} 
			catch (SQLException e1) 
			{
				System.err.println("Unable to create SQL statement!"); 
				e1.printStackTrace();
				System.exit(1);
			}
		}

	}

	public void removeProducts(Connection conn, List<String[]> catalog){
		if(conn != null) 
		{
			Statement stmt = null; 
			ResultSet rs = null;
			try 
			{
				stmt = (Statement) conn.createStatement();
				try{
					Iterator<String[]> it = catalog.iterator();
					while(it.hasNext())
					{
						String[] element = (String[]) it.next();
						stmt.executeUpdate("DELETE FROM products WHERE product_id='"+element[0]+"'");
					}
				}
				catch(SQLException e3){
					System.err.println("Unable to update SQL statement!"); 
					e3.printStackTrace();
					System.exit(1);
				}

				stmt.close();
			} 
			catch (SQLException e1) 
			{
				System.err.println("Unable to create SQL statement!"); 
				e1.printStackTrace();
				System.exit(1);
			}
		}

	}

	public void deleteUser(Connection conn, List<String[]> catalog){
		if(conn != null) 
		{
			Statement stmt = null; 
			ResultSet rs = null;
			try 
			{
				stmt = (Statement) conn.createStatement();
				try{
					Iterator<String[]> it = catalog.iterator();
					while(it.hasNext())
					{
						String[] element = (String[]) it.next();
						stmt.executeUpdate("DELETE FROM users WHERE user_id='"+element[0]+"'");
					}
				}
				catch(SQLException e3){
					System.err.println("Unable to update SQL statement!"); 
					e3.printStackTrace();
					System.exit(1);
				}

				stmt.close();

			} 
			catch (SQLException e1) 
			{
				System.err.println("Unable to create SQL statement!"); 
				e1.printStackTrace();
				System.exit(1);
			}
		}

	}

	public int selectProduct(Connection conn, int product_id){
		int item_quantity = 0;
		if(conn != null) 
		{
			Statement stmt = null; 
			ResultSet rs = null;
			try 
			{
				stmt = (Statement) conn.createStatement();
				try
				{
					rs = stmt.executeQuery( "SELECT `quantity` FROM `products` WHERE `product_id` = '"+product_id+"'");
					if (!rs.isBeforeFirst() ) {    
						System.out.println("No product found!!"); 
					} 
					else{
						while(rs.next())
						{
							item_quantity = rs.getInt("quantity");
						}
					}
				}
				catch(SQLException e3){
					System.err.println("Unable to update SQL statement!"); 
					e3.printStackTrace();
					System.exit(1);
				}

				stmt.close();

			} 
			catch (SQLException e1) 
			{
				System.err.println("Unable to create SQL statement!"); 
				e1.printStackTrace();
				System.exit(1);
			}	
		}
		return item_quantity;
	}

	public void updateQuantity(Connection conn, int item_quantity, int product_id){
		if(conn != null) 
		{
			Statement stmt = null; 
			try 
			{
				stmt = (Statement) conn.createStatement();
				try
				{
					stmt.executeUpdate( "UPDATE `products` SET `quantity`='"+item_quantity+"' WHERE `product_id`='"+product_id+"'" );
				}
				catch(SQLException e3){
					System.err.println("Unable to update SQL statement!"); 
					e3.printStackTrace();
					System.exit(1);
				}

				stmt.close();

			} 
			catch (SQLException e1) 
			{
				System.err.println("Unable to create SQL statement!"); 
				e1.printStackTrace();
				System.exit(1);
			}	
		}
	}

	public String[] getUser(Connection conn, String username, String password){
		String[] user = new String[3];
		if(conn != null) 
		{
			Statement stmt = null; 
			ResultSet rs = null;
			try 
			{
				stmt = (Statement) conn.createStatement(); 
				try 
				{
					rs = stmt.executeQuery( "SELECT Fullname, Role, isauth FROM users "
							+ "where `Username`='"+username+"' and `Password`='"+password+"'" );
					if (!rs.isBeforeFirst() ) {    
						user = null; 
					} 
					else{
						while (rs.next())  
						{
							user[0] = rs.getString("Fullname");
							user[1] = rs.getString("Role");
							user[2] = String.valueOf(rs.getBoolean("isauth"));
						}
					}
				} 
				catch (SQLException e) 
				{
					System.err.println("Unable execute query!");
					user = null;
					e.printStackTrace();
				} 
				stmt.close();

			} 
			catch (SQLException e1) 
			{
				System.err.println("Unable to create SQL statement!"); 
				e1.printStackTrace();
			}
		}
		return user;
	}
}
