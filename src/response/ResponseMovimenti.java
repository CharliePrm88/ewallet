package response;

import java.util.List;

import model.Movimenti;

public class ResponseMovimenti extends Response {
	Movimenti m;
	List<Movimenti> l1;
	
	public ResponseMovimenti(String result, int errorCode, String description, Movimenti m, List<Movimenti> l1) {
		super(result, errorCode, description);
		this.m = m;
		this.l1 = l1;
	}

	public Movimenti getM() {
		return m;
	}

	public void setM(Movimenti m) {
		this.m = m;
	}

	public List<Movimenti> getL1() {
		return l1;
	}

	public void setL1(List<Movimenti> l1) {
		this.l1 = l1;
	}
	
}
