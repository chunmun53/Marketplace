import java.io.Serializable;
public class Session implements Serializable{
	String fullname;
	String role;
	boolean isauth;
	
	//Creates a user session
	public Session(){}
	
	public Session(String fullname, String role, boolean isauth){
		this.fullname = fullname;
		this.role = role;
		this.isauth = isauth;
	}
}