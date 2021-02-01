package ctr;

import java.sql.SQLException;
import java.util.List;
import javax.jws.WebService;
import javax.naming.NamingException;

import dao.ContoCorrenteDao;
import model.ContoCorrente;
import response.ResponseContoCorrente;

@WebService
public class ContoCorrenteCtr {
	private ContoCorrenteDao ccd = new ContoCorrenteDao(); 
	private ResponseContoCorrente rcc;
	
	public ResponseContoCorrente inserisciCC(ContoCorrente cc) {
		try {
			ccd.inserisciContoCorrente(cc);
			rcc = new ResponseContoCorrente("Ok!",200,"Conto Corrente Creato!",cc,null);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rcc = new ResponseContoCorrente("Oooops!",1001,"Naming Exception!",cc,null);
		} catch (SQLException e) {
			e.printStackTrace();
			rcc = new ResponseContoCorrente("Oooops!",1002,"Eccezione in SQL",cc,null);
		}
		return rcc;
	}
	public ResponseContoCorrente cancellaCC(ContoCorrente cc) {
		try {
			ccd.cancellaContoCorrente(cc);
			rcc = new ResponseContoCorrente("Ok!",200,"Conto Corrente Cancellato!",cc,null);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rcc = new ResponseContoCorrente("Oooops!",1001,"Naming Exception!",cc,null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rcc = new ResponseContoCorrente("Oooops!",1002,"Eccezione in SQL",cc,null);
		}
		return rcc;
	}
	public ResponseContoCorrente ritornaListaCC(){
		List<ContoCorrente> l1;
		try {
			l1 = ccd.ritornaListaContoCorrente();
			rcc = new ResponseContoCorrente("Ok!",200,"Lista dei conto Correnti ritornata!",null,l1);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rcc = new ResponseContoCorrente("Oooops!",1001,"Naming Exception!",null,null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rcc = new ResponseContoCorrente("Oooops!",1002,"Eccezione in SQL",null,null);
		}
		return rcc;
	}
	
	public ResponseContoCorrente ritornaCC(int id) {
		try {
			ContoCorrente cc= ccd.ritornaContoCorrente(id);
			rcc = new ResponseContoCorrente("Ok!",200,"Conto Corrente trovato!", cc, null);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rcc = new ResponseContoCorrente("Oooops!",1001,"Naming Exception!",null,null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rcc = new ResponseContoCorrente("Oooops!",1002,"Eccezione in SQL",null,null);
		}
		return rcc;
	}
	
	public ResponseContoCorrente modificaCC(ContoCorrente cc) {
		try {
			ccd.updateContoCorrente(cc);
			rcc = new ResponseContoCorrente("Ok!",200,"Conto Corrente Modificato!",cc,null);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rcc = new ResponseContoCorrente("Oooops!",1001,"Naming Exception!",cc,null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			rcc = new ResponseContoCorrente("Oooops!",1002,"Eccezione in SQL",cc,null);
			e.printStackTrace();
		}
		return rcc;
	}
}
