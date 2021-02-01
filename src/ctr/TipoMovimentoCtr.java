package ctr;

import java.sql.SQLException;
import java.util.List;

import javax.jws.WebService;
import javax.naming.NamingException;

import dao.TipoMovimentoDao;
import model.TipoMovimento;
import response.ResponseTipoMovimento;

@WebService
public class TipoMovimentoCtr {

	private TipoMovimentoDao ccd = new TipoMovimentoDao(); 
	private ResponseTipoMovimento rcc;
	
	public ResponseTipoMovimento inserisciTM(TipoMovimento cc) {
		try {
			ccd.inserisciTipoMovimento(cc);
			rcc = new ResponseTipoMovimento("Ok!",200,"Tipo Movimento Creato!",cc,null);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rcc = new ResponseTipoMovimento("Oooops!",1001,"Naming Exception!",cc,null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rcc = new ResponseTipoMovimento("Oooops!",1002,"Eccezione in SQL",cc,null);
		}
		return rcc;
	}
	
	public ResponseTipoMovimento cancellaTM(TipoMovimento cc) {
		try {
			ccd.cancellaTipoMovimento(cc);
			rcc = new ResponseTipoMovimento("Ok!",200,"Tipo movimento Cancellato!",cc,null);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rcc = new ResponseTipoMovimento("Oooops!",1001,"Naming Exception!",cc,null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rcc = new ResponseTipoMovimento("Oooops!",1002,"Eccezione in SQL",cc,null);
		}
		return rcc;
	}
	public ResponseTipoMovimento ritornaListaTM(){
		List<TipoMovimento> l1 = null;
		try {
			l1 = ccd.ritornaListaTipoMovimento();
			if(l1.isEmpty()) {
				rcc = new ResponseTipoMovimento("Oooops!",201,"Lista vuota!",null,l1);
			}else {
			rcc = new ResponseTipoMovimento("Ok!",200,"Lista Tipo Movimento Creata!",null,l1);
			}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			rcc = new ResponseTipoMovimento("Oooops!",1001,"Naming Exception!",null,l1);
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rcc = new ResponseTipoMovimento("Oooops!",1002,"Eccezione in SQL",null,l1);
		}
		return rcc;
	}
	
	public ResponseTipoMovimento ritornaTM(int id) {
		TipoMovimento cc = null;
		try {
			cc = ccd.ritornaTipoMovimento(id);
			if(cc.getDescrizione().isEmpty()) {
				rcc = new ResponseTipoMovimento("Non esiste!",404,"Tipo Movimento non trovato!", cc, null);
			}else {
			rcc = new ResponseTipoMovimento("Ok!",200,"Tipo Movimento trovato!", cc, null);
			}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rcc = new ResponseTipoMovimento("Oooops!",1001,"Naming Exception!",cc,null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rcc = new ResponseTipoMovimento("Oooops!",1002,"Eccezione in SQL",cc,null);
		}
		return rcc;
	}
	
	public ResponseTipoMovimento modificaTM(TipoMovimento cc) {
		try {
			ccd.updateTipoMovimento(cc);
			rcc = new ResponseTipoMovimento("Ok!",200,"Tipo Movimento Modificato!",cc,null);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rcc = new ResponseTipoMovimento("Oooops!",1001,"Naming Exception!",cc,null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rcc = new ResponseTipoMovimento("Oooops!",1002,"Eccezione in SQL",cc,null);
		}
		return rcc;
	}


}
