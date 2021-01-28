package ctr;

import java.util.List;

import javax.jws.WebService;

import dao.TipoMovimentoDao;
import model.TipoMovimento;
import response.ResponseTipoMovimento;

@WebService
public class TipoMovimentoCtr {

	private TipoMovimentoDao ccd = new TipoMovimentoDao(); 
	private ResponseTipoMovimento rcc;
	
	public ResponseTipoMovimento inserisciTM(TipoMovimento cc) {
		boolean risultato= ccd.inserisciTipoMovimento(cc);
		if(risultato) {
			rcc = new ResponseTipoMovimento("Ok!",200,"Conto Corrente Creato!",cc,null);
		}else {
			rcc = new ResponseTipoMovimento("Oooops!",1000,"Qualcosa è andato storto",cc,null);
		}
		return rcc;
	}
	public ResponseTipoMovimento cancellaTM(TipoMovimento cc) {
		boolean risultato = ccd.cancellaTipoMovimento(cc);
		if(risultato) {
			rcc = new ResponseTipoMovimento("Ok!",200,"Conto Corrente Cancellato!",cc,null);
		}else {
			rcc = new ResponseTipoMovimento("Oooops!",1000,"Qualcosa è andato storto",cc,null);
		}
		return rcc;
	}
	public ResponseTipoMovimento ritornaListaTM(){
		List<TipoMovimento> l1 = ccd.ritornaListaTipoMovimento();
		if(l1.isEmpty()) {
			rcc = new ResponseTipoMovimento("Oooops!",1000,"Qualcosa è andato storto",null,l1);
		}else {
			rcc = new ResponseTipoMovimento("Ok!",200,"Conto Corrente Cancellato!",null,l1);
		}
		return rcc;
	}
	
	public ResponseTipoMovimento ritornaTM(int id) {
		TipoMovimento cc= ccd.ritornaTipoMovimento(id);
		if(cc.getDescrizione().isEmpty()) {
			rcc = new ResponseTipoMovimento("Non esiste!",404,"Conto Corrente non trovato!", cc, null);
		}else {
		rcc = new ResponseTipoMovimento("Ok!",200,"Conto Corrente trovato!", cc, null);
		}
		return rcc;
	}
	
	public ResponseTipoMovimento modificaTM(TipoMovimento cc) {
		boolean risposta=ccd.updateTipoMovimento(cc);
		if(risposta) {
			rcc = new ResponseTipoMovimento("Ok!",200,"Conto Corrente Modificato!",cc,null);
		}else {
			rcc = new ResponseTipoMovimento("Oooops!",1000,"Qualcosa è andato storto",cc,null);
		}
		return rcc;
	}


}
