package ctr;

import java.util.List;

import javax.jws.WebService;

import dao.MovimentiDao;
import model.Movimenti;
import response.ResponseMovimenti;

@WebService
public class MovimentiCtr {
	private MovimentiDao ccd = new MovimentiDao(); 
	private ResponseMovimenti rcc;
	
	public ResponseMovimenti inserisciM(Movimenti cc) {
		boolean risultato= ccd.inserisciMovimenti(cc);
		if(risultato) {
			rcc = new ResponseMovimenti("Ok!",200,"Conto Corrente Creato!",cc,null);
		}else {
			rcc = new ResponseMovimenti("Oooops!",1000,"Qualcosa è andato storto",cc,null);
		}
		return rcc;
	}
	public ResponseMovimenti cancellaM(Movimenti cc) {
		boolean risultato = ccd.cancellaMovimenti(cc);
		if(risultato) {
			rcc = new ResponseMovimenti("Ok!",200,"Conto Corrente Cancellato!",cc,null);
		}else {
			rcc = new ResponseMovimenti("Oooops!",1000,"Qualcosa è andato storto",cc,null);
		}
		return rcc;
	}
	public ResponseMovimenti ritornaListaM(){
		List<Movimenti> l1 = ccd.ritornaListaMovimenti();
		if(l1.isEmpty()) {
			rcc = new ResponseMovimenti("Oooops!",1000,"Qualcosa è andato storto",null,l1);
		}else {
			rcc = new ResponseMovimenti("Ok!",200,"Conto Corrente Cancellato!",null,l1);
		}
		return rcc;
	}
	
	public ResponseMovimenti ritornaM(int id) {
		Movimenti cc= ccd.ritornaMovimenti(id);
		if(cc.getIban()==0) {
			rcc = new ResponseMovimenti("Non esiste!",404,"Conto Corrente non trovato!", cc, null);
		}else {
		rcc = new ResponseMovimenti("Ok!",200,"Conto Corrente trovato!", cc, null);
		}
		return rcc;
	}
	
	public ResponseMovimenti modificaM(Movimenti cc) {
		boolean risposta=ccd.updateMovimenti(cc);
		if(risposta) {
			rcc = new ResponseMovimenti("Ok!",200,"Conto Corrente Modificato!",cc,null);
		}else {
			rcc = new ResponseMovimenti("Oooops!",1000,"Qualcosa è andato storto",cc,null);
		}
		return rcc;
	}

}
