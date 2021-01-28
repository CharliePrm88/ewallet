package response;

public class Response {
	private String result;
	private int errorCode;
	private String Description;
	
	public Response(String result, int errorCode, String description) {
		this.result = result;
		this.errorCode = errorCode;
		Description = description;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
	
}
