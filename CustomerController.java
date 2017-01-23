public class CustomerController{
	public void customerWelcome(String role, String username){
		CustomerWelcome customerwelcome = new CustomerWelcome();
		customerwelcome.welcomePage(role, username);
	}
}