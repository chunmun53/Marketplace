public class AdminController{	
	public void adminWelcome(String role, String username){
		AdminWelcome adminwelcome = new AdminWelcome();
		adminwelcome.welcomePage(role, username);
	}
}