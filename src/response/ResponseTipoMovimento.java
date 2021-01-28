package response;

import java.util.List;

import model.TipoMovimento;

public class ResponseTipoMovimento extends Response{
	TipoMovimento tm;
	List<TipoMovimento> l1;
	
	public ResponseTipoMovimento(String result, int errorCode, String description, TipoMovimento tm,
			List<TipoMovimento> l1) {
		super(result, errorCode, description);
		this.tm = tm;
		this.l1 = l1;
	}

	public TipoMovimento getTm() {
		return tm;
	}

	public void setTm(TipoMovimento tm) {
		this.tm = tm;
	}

	public List<TipoMovimento> getL1() {
		return l1;
	}

	public void setL1(List<TipoMovimento> l1) {
		this.l1 = l1;
	}
	
	
}
