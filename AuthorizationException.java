import java.lang.RuntimeException;

public class AuthorizationException extends RuntimeException { 
		public AuthorizationException(String methodName) {
			super("Invalid Authorization - Access Denined to " + methodName + "() function!");
		} 
	}