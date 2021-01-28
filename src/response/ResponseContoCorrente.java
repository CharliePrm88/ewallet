package response;

import java.util.List;

import model.ContoCorrente;

public class ResponseContoCorrente extends Response {
	ContoCorrente cc;
	List<ContoCorrente> l1;
	
	public ResponseContoCorrente(String result, int errorCode, String description, ContoCorrente cc,
			List<ContoCorrente> l1) {
		super(result, errorCode, description);
		this.cc = cc;
		this.l1 = l1;
	}

	public ContoCorrente getCc() {
		return cc;
	}

	public void setCc(ContoCorrente cc) {
		this.cc = cc;
	}

	public List<ContoCorrente> getL1() {
		return l1;
	}

	public void setL1(List<ContoCorrente> l1) {
		this.l1 = l1;
	}
	
	
	

}
