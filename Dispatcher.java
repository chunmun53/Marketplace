/**
 * Dispatcher Class
 */
public class Dispatcher {
	// Concrete Views...
	private CustomerController customercontroller;
	private AdminController admincontroller;
	private Session session;

	/**
	 * Dispatcher Constructor
	 */
	public Dispatcher() {
		customercontroller = new CustomerController();
		admincontroller = new AdminController();
		session = new Session();
	}

	/**
	 * Based upon the request - dispatch the view.
	 * 
	 * 
	 */
	public void dispatch(Session session) {
		// Customer or Student Views...
		if(session.role.equalsIgnoreCase("customer")) {
			customercontroller.customerWelcome(session.role, session.fullname);
	    }
		else if(session.role.equalsIgnoreCase("admin")){
			admincontroller.adminWelcome(session.role, session.fullname);
		}
	}
}