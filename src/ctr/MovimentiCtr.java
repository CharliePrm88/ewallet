package ctr;

import java.sql.SQLException;
import java.util.List;
import javax.jws.WebService;
import javax.naming.NamingException;
import dao.MovimentiDao;
import model.Movimenti;
import response.ResponseMovimenti;

@WebService
public class MovimentiCtr {
	private MovimentiDao ccd = new MovimentiDao(); 
	private ResponseMovimenti rcc;
	
	public ResponseMovimenti inserisciM(Movimenti cc) {
		try {
			ccd.inserisciMovimenti(cc);
			rcc = new ResponseMovimenti("Ok!",200,"Conto Corrente Creato!",cc,null);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rcc = new ResponseMovimenti("Oooops!",1001,"Naming Exception!",cc,null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rcc = new ResponseMovimenti("Oooops!",1002,"Eccezione in SQL",cc,null);
		}
		return rcc;
	}
	public ResponseMovimenti cancellaM(Movimenti cc) {
		try {
			ccd.cancellaMovimenti(cc);
			rcc = new ResponseMovimenti("Ok!",200,"Conto Corrente Cancellato!",cc,null);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rcc = new ResponseMovimenti("Oooops!",1001,"Naming Exception!",cc,null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rcc = new ResponseMovimenti("Oooops!",1000,"Eccezione in SQL",cc,null);
		}
		return rcc;
	}
	public ResponseMovimenti ritornaListaM(){
		List<Movimenti> l1 = null;
		try {
			l1 = ccd.ritornaListaMovimenti();
			rcc = new ResponseMovimenti("Ok!",200,"Conto Corrente Cancellato!",null,l1);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rcc = new ResponseMovimenti("Oooops!",1001,"Classe non trovata",null,l1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rcc = new ResponseMovimenti("Oooops!",1002,"Eccezione in SQL",null,l1);
		}
		if(l1.isEmpty()) {
			rcc = new ResponseMovimenti("Oooops!",201,"La lista è vuota!",null,l1);
		}
		return rcc;
	}
	
	public ResponseMovimenti ritornaM(int id) {
		Movimenti cc = null;
		try {
			cc = ccd.ritornaMovimenti(id);
			rcc = new ResponseMovimenti("Ok!",200,"Conto Corrente trovato!", cc, null);
		} catch (NamingException e) {
			rcc = new ResponseMovimenti("Oooops!",1001,"Classe non trovata",cc,null);
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rcc = new ResponseMovimenti("Oooops!",1002,"Eccezione in SQL",cc,null);
		}
		return rcc;
	}
	
	public ResponseMovimenti modificaM(Movimenti cc) {
		try {
			ccd.updateMovimenti(cc);
			rcc = new ResponseMovimenti("Ok!",200,"Conto Corrente Modificato!",cc,null);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rcc = new ResponseMovimenti("Oooops!",1001,"Naming Exception!",cc,null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rcc = new ResponseMovimenti("Oooops!",1002,"Eccezione in SQL",cc,null);
		}
		return rcc;
	}

}
