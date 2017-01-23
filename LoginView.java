import java.rmi.Naming;
import java.util.Scanner;
import java.io.Console;

public class LoginView{
	public void invalidUser(){
		System.out.println("Invalid username/password. Please enter the correct credentials");
	}
	public static void main (String args[]){
		String username;
		String password;
		Scanner user_input = new Scanner(System.in);  
		System.out.println("Enter your Username: ");
		username = user_input.nextLine();
		System.out.println("Enter your Password: ");
		Console console = System.console();
		char[] passwordArray = console.readPassword();
		password = String.valueOf(passwordArray);
		
		String[] credentials = new String[2];
		credentials[0] = username;
		credentials[1] = password;
		
		FrontController front = new FrontController();
		front.getCredentials(credentials[0],credentials[1]);
	}
}
