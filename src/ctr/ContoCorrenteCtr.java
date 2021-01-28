package ctr;

import java.util.List;

import javax.jws.WebService;
import dao.ContoCorrenteDao;
import model.ContoCorrente;
import response.ResponseContoCorrente;

@WebService
public class ContoCorrenteCtr {
	private ContoCorrenteDao ccd = new ContoCorrenteDao(); 
	private ResponseContoCorrente rcc;
	
	public ResponseContoCorrente inserisciCC(ContoCorrente cc) {
		boolean risultato= ccd.inserisciContoCorrente(cc);
		if(risultato) {
			rcc = new ResponseContoCorrente("Ok!",200,"Conto Corrente Creato!",cc,null);
		}else {
			rcc = new ResponseContoCorrente("Oooops!",1000,"Qualcosa è andato storto",cc,null);
		}
		return rcc;
	}
	public ResponseContoCorrente cancellaCC(ContoCorrente cc) {
		boolean risultato = ccd.cancellaContoCorrente(cc);
		if(risultato) {
			rcc = new ResponseContoCorrente("Ok!",200,"Conto Corrente Cancellato!",cc,null);
		}else {
			rcc = new ResponseContoCorrente("Oooops!",1000,"Qualcosa è andato storto",cc,null);
		}
		return rcc;
	}
	public ResponseContoCorrente ritornaListaCC(){
		List<ContoCorrente> l1 = ccd.ritornaListaContoCorrente();
		if(l1.isEmpty()) {
			rcc = new ResponseContoCorrente("Oooops!",1000,"Qualcosa è andato storto",null,l1);
		}else {
			rcc = new ResponseContoCorrente("Ok!",200,"Conto Corrente Cancellato!",null,l1);
		}
		return rcc;
	}
	
	public ResponseContoCorrente ritornaCC(int id) {
		ContoCorrente cc= ccd.ritornaContoCorrente(id);
		if(cc.getIban()==0) {
			rcc = new ResponseContoCorrente("Non esiste!",404,"Conto Corrente non trovato!", cc, null);
		}else {
		rcc = new ResponseContoCorrente("Ok!",200,"Conto Corrente trovato!", cc, null);
		}
		return rcc;
	}
	
	public ResponseContoCorrente modificaCC(ContoCorrente cc) {
		boolean risposta=ccd.updateContoCorrente(cc);
		if(risposta) {
			rcc = new ResponseContoCorrente("Ok!",200,"Conto Corrente Modificato!",cc,null);
		}else {
			rcc = new ResponseContoCorrente("Oooops!",1000,"Qualcosa è andato storto",cc,null);
		}
		return rcc;
	}
}
