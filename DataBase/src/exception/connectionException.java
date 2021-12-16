package exception;

public class connectionException extends Exception {
	public connectionException(String message) {
        super(message);
    }
	
	@Override
	public String getMessage() {
		String message = super.getMessage();
		return "Unexpcted error in protcol: " + message;
		
	}
}
