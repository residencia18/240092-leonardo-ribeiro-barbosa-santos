package Security.SpringSecurity.dto;

public class ResetPasswordResponse {
	private String message;

	public ResetPasswordResponse(String message) {
		this.setMessage(message);
	}

	
	
	
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
